package com.odogwudev.test.ui.home

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.odogwudev.test.R
import com.odogwudev.test.activity.ProductPurchasingActivity
import com.odogwudev.test.adapters.CategoryAdapter
import com.odogwudev.test.adapters.SpinnerAdapter
import com.odogwudev.test.adapters.TrendingProductAdapter
import com.odogwudev.test.datamodel.CategoriesItem
import com.odogwudev.test.datamodel.SpinnerItem
import com.odogwudev.test.datamodel.TrendingProductItem
import com.odogwudev.test.utils.DataProvider
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    private lateinit var spinnerItems: ArrayList<SpinnerItem>
    private lateinit var mAdapter: SpinnerAdapter

    private lateinit var mRecyclerViewCategory: RecyclerView
    private lateinit var mCategoryList: ArrayList<CategoriesItem>
    private lateinit var mLayoutManager: RecyclerView.LayoutManager
    private lateinit var mAdapterCategory: CategoryAdapter

    private lateinit var mRecyclerViewTrendingProduct: RecyclerView
    private lateinit var mTrendingProductList: ArrayList<TrendingProductItem>
    private lateinit var mLayoutManagerTrendingProduct: RecyclerView.LayoutManager
    private lateinit var mAdapterTrendingProduct: TrendingProductAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initListSpinner()

        val spinnerCity: Spinner = view.findViewById(R.id.spinnerCity)

        mAdapter = SpinnerAdapter(view.context, spinnerItems)
        spinnerCity.adapter = mAdapter

        spinnerCity.onItemSelectedListener = object : OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View,
                position: Int,
                id: Long
            ) {
//                val clickedItem = parent.getItemAtPosition(position) as SpinnerItem
//                Toast.makeText(
//                    context,
//                    "${clickedItem.itemName}",
//                    Toast.LENGTH_SHORT
//                ).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        getDataList()
        buildRecyclerView(view)
        buildRecyclerViewTrending(view)
    }

    private fun initListSpinner() {
        val spinnerName = resources.getStringArray(R.array.cityNameList)
        spinnerItems = ArrayList()
        for (i in spinnerName.indices) {
            spinnerItems.add(SpinnerItem(spinnerName[i]))
        }
    }

    private fun buildRecyclerView(view: View) {
        mRecyclerViewCategory = view.findViewById(R.id.recyclerViewCategory)
//        mLayoutManager= LinearLayoutManager(view.context)
        mLayoutManager = GridLayoutManager(view.context, 3)
        mAdapterCategory = CategoryAdapter(mCategoryList)
        mRecyclerViewCategory.layoutManager = mLayoutManager
        mRecyclerViewCategory.adapter = mAdapterCategory


        mAdapterCategory.setOnItemClickListener(object : CategoryAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {
                Toast.makeText(
                    context,
                    mAdapterCategory.getCategoryItem(position).categoryName,
                    Toast.LENGTH_SHORT
                ).show()

            }

        })
    }

    private fun buildRecyclerViewTrending(view: View) {
        mRecyclerViewTrendingProduct = view.findViewById(R.id.recyclerViewTrending)
//        mLayoutManagerTrendingProduct= LinearLayoutManager(view.context)
        mLayoutManagerTrendingProduct =
            GridLayoutManager(view.context, 1, LinearLayoutManager.HORIZONTAL, false)
        mAdapterTrendingProduct = TrendingProductAdapter(mTrendingProductList)
        mRecyclerViewTrendingProduct.layoutManager = mLayoutManagerTrendingProduct
        mRecyclerViewTrendingProduct.adapter = mAdapterTrendingProduct


        mAdapterTrendingProduct.setOnItemClickListener(object :
            TrendingProductAdapter.OnItemClickListener {
            override fun onItemClick(position: Int) {

                val mIntent = Intent(context, ProductPurchasingActivity::class.java)
                mIntent.putExtra(
                    "ProductPurchasing",
                    DataProvider.convertObjectToString(
                        mAdapterTrendingProduct.getTrendingProductItem(position)
                    )
                )
                startActivity(mIntent)

//                Toast.makeText(
//                    context,
//                    mAdapterTrendingProduct.getTrendingProductItem(position).productName,
//                    Toast.LENGTH_SHORT
//                ).show()

            }

        })
    }

    private fun getDataList() {
        mCategoryList = ArrayList()
        mTrendingProductList = ArrayList()
        mCategoryList = DataProvider.categoryList()
        mTrendingProductList = DataProvider.trendingProductList()

    }
}