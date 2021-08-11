package bruno_brabosa.convidados.house_purchases.presentation.view.home

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import bruno_brabosa.convidados.house_purchases.R
import bruno_brabosa.convidados.house_purchases.databinding.FragmentHomeBinding
import bruno_brabosa.convidados.house_purchases.presentation.model.ProductPresentation
import bruno_brabosa.convidados.house_purchases.presentation.view_model.ProductsViewModel
import bruno_brabosa.convidados.house_purchases.util.extensions.getSelected
import bruno_brabosa.convidados.house_purchases.util.extensions.onPressedControl
import bruno_brabosa.convidados.house_purchases.util.extensions.visibilityControl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding

    private lateinit var mLayoutManager: RecyclerView.LayoutManager
    private lateinit var productsAdapter: HomeAdapter

    private val viewModel: ProductsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setUpLayout()
        setUpAdapter(arrayListOf())
        observeViewModel()
        getProducts()

        return binding.root
    }

    private fun getProducts() {
        viewModel.getAllProducts()
    }

    private fun observeViewModel() {

        viewModel.productsList.observe(viewLifecycleOwner) { productList ->
            setUpAdapter(productList.reversed())
        }

        viewModel.onError.observe(viewLifecycleOwner) { isError ->
            if (isError) Toast.makeText(requireContext(), getString(R.string.toast_generic_error), Toast.LENGTH_LONG).show()
        }

        viewModel.onLoading.observe(viewLifecycleOwner) { isLoading ->
            if (isLoading) showLoading()
            else hideLoading()
        }
    }

    private fun setUpAdapter(list: List<ProductPresentation>) {

        binding.apply {

            mLayoutManager = GridLayoutManager(context, 2)
            productsAdapter = HomeAdapter(list, deleteProduct, deleteAllProducts)
            rvListProductsHome.layoutManager = mLayoutManager
            rvListProductsHome.adapter = productsAdapter
        }
    }

    private val deleteProduct: (product: ProductPresentation) -> Unit = { product ->

        AlertDialog.Builder(context).apply {
            setTitle(getString(R.string.dialog_delete_title))
            setMessage(getString(R.string.remove_dialog_question) + product.name + "\"?")
            setPositiveButton(getString(R.string.yes)) { _, _ ->
                viewModel.removeProduct(
                    product.name,
                    product.quantity,
                    product.identifier
                )

                if(product.quantity <= 1)
                    viewModel.removeAllProducts(
                        product.name,
                        product.quantity,
                        product.identifier
                    )

                viewModel.getAllProducts()
            }
            setNegativeButton(getString(R.string.no)) { _, _ -> }
            show()
        }
    }

    private val deleteAllProducts: (product: ProductPresentation) -> Unit = { product ->
        AlertDialog.Builder(context).apply {
            setTitle(getString(R.string.dialog_delete_title))
            setMessage(getString(R.string.remove_all_dialog_question) + product.name + "\"?")
            setPositiveButton(getString(R.string.yes)) { _, _ ->
                viewModel.removeAllProducts(
                    product.name,
                    product.quantity,
                    product.identifier
                )
                viewModel.getAllProducts()
            }
            setNegativeButton(getString(R.string.no)) { _, _ -> }
            show()
        }
    }

    private fun setUpLayout() {
        binding.apply {
            btnAddProductHome.setOnClickListener {
                clAddNewProductsHome.visibilityControl()
                restartControl(btnValue1, btnValue2, btnValue3, btnValue4, btnValue5)
            }

            btnValue1.apply {
                setOnClickListener {
                    hideKeyboard(this)
                    onPressedControl(btnValue2, btnValue3, btnValue4, btnValue5, activity)
                }
            }

            btnValue2.apply {
                setOnClickListener {
                    hideKeyboard(this)
                    onPressedControl(btnValue1, btnValue3, btnValue4, btnValue5, activity)
                }
            }

            btnValue3.apply {
                setOnClickListener {
                    hideKeyboard(this)
                    onPressedControl(btnValue2, btnValue1, btnValue4, btnValue5, activity)
                }
            }

            btnValue4.apply {
                setOnClickListener {
                    hideKeyboard(this)
                    onPressedControl(btnValue2, btnValue3, btnValue1, btnValue5, activity)
                }
            }

            btnValue5.apply {
                setOnClickListener {
                    hideKeyboard(this)
                    onPressedControl(btnValue2, btnValue3, btnValue4, btnValue1, activity)
                }
            }

            btnValue6.apply {
                setOnClickListener {
                    plusControl(btnValue1, btnValue2, btnValue3, btnValue4, btnValue5)
                }
            }

            btnAddProduct.setOnClickListener{
                viewModel.createProduct(
                    etProductToBeAddHome.text.toString(),
                    btnValue1.getSelected(btnValue2, btnValue3, btnValue4, btnValue5, activity)
                )

                clAddNewProductsHome.visibilityControl()
                btnValue1.onPressedControl(btnValue2, btnValue3, btnValue1, btnValue5, activity)
                restartControl(btnValue1, btnValue2, btnValue3, btnValue4, btnValue5)

                etProductToBeAddHome.text.clear()
                viewModel.getAllProducts()
            }
        }
    }

    private fun hideKeyboard(button: Button) {
        val inputMethodManager = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(button.windowToken, 0)

    }

    private fun showLoading () {
        binding.apply {
            btnAddProduct.text = ""
            laProgressAddHome.visibility = View.VISIBLE
            laProgressAddHome.playAnimation()
        }
    }

    private fun hideLoading () {
        binding.apply {
            btnAddProduct.text = getString(R.string.btn_home_add_title)
            laProgressAddHome.visibility = View.GONE
        }
    }

    @SuppressLint("SetTextI18n")
    private fun plusControl(
        btnValue1: Button,
        btnValue2: Button,
        btnValue3: Button,
        btnValue4: Button,
        btnValue5: Button
    ) {
        btnValue1.text = "${btnValue1.text.toString().toInt() + 5}"
        btnValue2.text = "${btnValue2.text.toString().toInt() + 5}"
        btnValue3.text = "${btnValue3.text.toString().toInt() + 5}"
        btnValue4.text = "${btnValue4.text.toString().toInt() + 5}"
        btnValue5.text = "${btnValue5.text.toString().toInt() + 5}"
    }

    private fun restartControl(
        btnValue1: Button,
        btnValue2: Button,
        btnValue3: Button,
        btnValue4: Button,
        btnValue5: Button
    ) {
        btnValue1.text = "1"
        btnValue2.text = "2"
        btnValue3.text = "3"
        btnValue4.text = "4"
        btnValue5.text = "5"
    }
}