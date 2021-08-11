package bruno_brabosa.convidados.house_purchases.presentation.view.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import bruno_brabosa.convidados.house_purchases.R
import bruno_brabosa.convidados.house_purchases.presentation.model.ProductPresentation

class HomeAdapter(
    private val list: List<ProductPresentation>,
    private val deleteProduct: (product: ProductPresentation) -> Unit,
    private val deleteAllProducts: (product: ProductPresentation) -> Unit,
): RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.layout_item_product_home,
            parent,
            false
        )
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val item = list[position]

        holder.layoutName?.text = item.name
        holder.quantity?.text = item.quantity.toString()

        holder.mainLayout?.setOnClickListener {
            deleteProduct.invoke(
                ProductPresentation(
                    item.identifier,
                    item.name,
                    item.quantity
                )
            )
        }

        holder.mainLayout?.setOnLongClickListener {
            deleteAllProducts.invoke(
                ProductPresentation(
                    item.identifier,
                    item.name,
                    item.quantity
                )
            )
            return@setOnLongClickListener true
        }

    }

    override fun getItemCount(): Int {
        return list.size
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        var layoutName: TextView? = null
        var quantity: TextView? = null
        var mainLayout: ConstraintLayout? = null

        init {
            layoutName = view.findViewById(R.id.tv_product_name_home)
            quantity = view.findViewById(R.id.tv_product_quantity_home)
            mainLayout = view.findViewById(R.id.cl_main_layout_product)
        }
    }
}