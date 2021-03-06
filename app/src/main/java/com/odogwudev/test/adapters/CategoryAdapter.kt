package com.odogwudev.test.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.odogwudev.test.R
import com.odogwudev.test.datamodel.CategoriesItem
import java.util.*

class CategoryAdapter(categoriesList: ArrayList<CategoriesItem>) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    private var mCategoriesList: ArrayList<CategoriesItem> = categoriesList
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.category_item, parent, false)
        return CategoryViewHolder(v, mListener)
    }

    override fun getItemCount(): Int {
        return mCategoriesList.size
    }


    fun getCategoryItem(mPosition: Int): CategoriesItem {
        return mCategoriesList[mPosition]
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val currentItem: CategoriesItem = mCategoriesList[position]
        holder.categoryName.text = currentItem.categoryName
        holder.categoryImage.setImageResource(currentItem.categoryImage)
    }

    class CategoryViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        var categoryName: TextView = itemView.findViewById(R.id.categoryName)
        var categoryImage: ImageView = itemView.findViewById(R.id.categoryImage)

        init {

            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position)
                }
            }

        }

    }
}
