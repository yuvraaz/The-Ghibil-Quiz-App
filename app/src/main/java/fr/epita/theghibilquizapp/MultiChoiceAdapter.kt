package fr.epita.theghibilquizapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MultiChoiceAdapter(items: ArrayList<Film>) :
    RecyclerView.Adapter<MultiChoiceAdapter.CategoryViewHolder>() {
    var catItems = items

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.single_item_choice, parent, false)
        return CategoryViewHolder(itemView = view)
    }

    override fun getItemCount(): Int {
        return catItems.count()
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        var choice: Film = catItems[position]
        holder.title.text = choice.title

        //event
        holder.title.setOnClickListener {
            onListItemClickListener?.onItemClicked(choice)
        }
    }

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.lbl_title)

    }

    //Interface for item click listener

    fun setOnItemClickListener(listener: OnListItemClickListener) {
        this.onListItemClickListener = listener
    }

    var onListItemClickListener: OnListItemClickListener? = null

    interface OnListItemClickListener {
        fun onItemClicked(choice: Film)
    }
}