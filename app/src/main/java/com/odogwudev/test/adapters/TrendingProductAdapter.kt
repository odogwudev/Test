package com.odogwudev.test.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.odogwudev.test.R
import com.odogwudev.test.datamodel.TrendingProductItem
import java.util.*

class TrendingProductAdapter(trendingProductList: ArrayList<TrendingProductItem>) :
    RecyclerView.Adapter<TrendingProductAdapter.TrendingProductViewHolder>() {

    private var mTrendingProductList: ArrayList<TrendingProductItem> = trendingProductList
    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)
    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingProductViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.trending_product_item, parent, false)
        return TrendingProductViewHolder(v, mListener)
    }

    override fun getItemCount(): Int {
        return mTrendingProductList.size
    }


    fun getTrendingProductItem(mPosition: Int): TrendingProductItem {
        return mTrendingProductList[mPosition]
    }

    override fun onBindViewHolder(holder: TrendingProductViewHolder, position: Int) {
        val currentItem: TrendingProductItem = mTrendingProductList[position]
        holder.trendingProductName.text = currentItem.productName
        holder.trendingProductRent.text = "$${currentItem.productRentPerMonth}/month"
        holder.trendingProductImage.setImageResource(currentItem.productImage)
    }

    class TrendingProductViewHolder(itemView: View, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView) {
        var trendingProductName: TextView = itemView.findViewById(R.id.trendingProductName)
        var trendingProductRent: TextView = itemView.findViewById(R.id.trendingProductRent)
        var trendingProductImage: ImageView = itemView.findViewById(R.id.trendingProductImage)

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
