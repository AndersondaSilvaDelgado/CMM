package br.com.usinasantafe.cmm.common.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.usinasantafe.cmm.databinding.ItemRowTextBinding

class CustomAdapter(
    private val dataSet: List<String>
) : RecyclerView.Adapter<CustomAdapter.ViewHolder>() {

    var onItemClick: ((text: String) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemBinding = ItemRowTextBinding
            .inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(itemBinding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        viewHolder.bindView(dataSet[position])
    }

    override fun getItemCount() = dataSet.size

    inner class ViewHolder(
        textRowItemBinding: ItemRowTextBinding
    ) : RecyclerView.ViewHolder(textRowItemBinding.root) {

        private val textView: TextView = textRowItemBinding.textView

        fun bindView(text: String) {
            textView.text = text

            itemView.setOnClickListener {
                onItemClick?.invoke(text)
            }

        }

    }

}