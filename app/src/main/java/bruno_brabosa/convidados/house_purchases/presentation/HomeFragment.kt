package bruno_brabosa.convidados.house_purchases.presentation

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import bruno_brabosa.convidados.house_purchases.databinding.FragmentHomeBinding
import bruno_brabosa.convidados.house_purchases.util.extensions.onPressedControl
import bruno_brabosa.convidados.house_purchases.util.extensions.visibilityControl

class HomeFragment : Fragment() {

    private lateinit var _binding: FragmentHomeBinding
    private val binding get() = _binding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        setUpLayout()
        return binding.root
    }

    private fun setUpLayout() {
        binding.apply {
            btnAddProductHome.setOnClickListener {
                clAddNewProductsHome.visibilityControl()
                restartControl(btnValue1, btnValue2, btnValue3, btnValue4, btnValue5)
            }

            btnValue1.apply {
                setOnClickListener {
                    onPressedControl(btnValue2, btnValue3, btnValue4, btnValue5, activity)
                }
            }

            btnValue2.apply {
                setOnClickListener {
                    onPressedControl(btnValue1, btnValue3, btnValue4, btnValue5, activity)
                }
            }

            btnValue3.apply {
                setOnClickListener {
                    onPressedControl(btnValue2, btnValue1, btnValue4, btnValue5, activity)
                }
            }

            btnValue4.apply {
                setOnClickListener {
                    onPressedControl(btnValue2, btnValue3, btnValue1, btnValue5, activity)
                }
            }

            btnValue5.apply {
                setOnClickListener {
                    onPressedControl(btnValue2, btnValue3, btnValue4, btnValue1, activity)
                }
            }

            btnValue6.apply {
                setOnClickListener {
                    plusControl(btnValue1, btnValue2, btnValue3, btnValue4, btnValue5)
                }
            }

        }
    }

    @SuppressLint("SetTextI18n")
    private fun plusControl(btnValue1: Button, btnValue2: Button, btnValue3: Button, btnValue4: Button, btnValue5: Button){
        btnValue1.text = "${btnValue1.text.toString().toInt() + 5}"
        btnValue2.text = "${btnValue2.text.toString().toInt() + 5}"
        btnValue3.text = "${btnValue3.text.toString().toInt() + 5}"
        btnValue4.text = "${btnValue4.text.toString().toInt() + 5}"
        btnValue5.text = "${btnValue5.text.toString().toInt() + 5}"
    }

    private fun restartControl(btnValue1: Button, btnValue2: Button, btnValue3: Button, btnValue4: Button, btnValue5: Button){
        btnValue1.text = "1"
        btnValue2.text = "2"
        btnValue3.text = "3"
        btnValue4.text = "4"
        btnValue5.text = "5"
    }
}