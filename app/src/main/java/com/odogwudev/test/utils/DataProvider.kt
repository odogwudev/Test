package com.odogwudev.test.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.odogwudev.test.R
import com.odogwudev.test.datamodel.CategoriesItem
import com.odogwudev.test.datamodel.TrendingProductItem
import java.util.ArrayList

object DataProvider {

    private var listCategoryImages = arrayOf(
        R.drawable.ic_bedrooms,
        R.drawable.ic_livingrooms,
        R.drawable.ic_dslr_camera,
        R.drawable.ic_appliances,
        R.drawable.ic_storage,
        R.drawable.ic_resource_package
    )
    private var listCategoryName =
        arrayOf("Bed Rooms", "Living Rooms", "DSLR Camera", "Appliances", "Storage", "Packages")

    fun categoryList(): ArrayList<CategoriesItem> {
        val mCategoryList: ArrayList<CategoriesItem> = ArrayList()
        for (index in listCategoryName.indices) {
            mCategoryList.add(CategoriesItem(listCategoryImages[index], listCategoryName[index]))
        }

        return mCategoryList
    }

    fun trendingProductList(): ArrayList<TrendingProductItem> {
        val mTrendingProductList: ArrayList<TrendingProductItem> = ArrayList()

        mTrendingProductList.add(
            TrendingProductItem(
                R.drawable.product_image1,
                "Dining Table",
                4.5F,
                145,
                167,
                400,
                700
            )
        )

        mTrendingProductList.add(
            TrendingProductItem(
                R.drawable.product_image2,
                "Bed Sofa",
                4.5F,
                145,
                167,
                450,
                700
            )
        )

        mTrendingProductList.add(
            TrendingProductItem(
                R.drawable.product_image3,
                "Dining Table",
                4.5F,
                145,
                167,
                500,
                700
            )
        )

        mTrendingProductList.add(
            TrendingProductItem(
                R.drawable.product_image4,
                "Fabric Sofa",
                4.5F,
                145,
                167,
                300,
                700
            )
        )

        mTrendingProductList.add(
            TrendingProductItem(
                R.drawable.product_image5,
                "Dining Table",
                4.5F,
                145,
                167,
                500,
                700
            )
        )

        mTrendingProductList.add(
            TrendingProductItem(
                R.drawable.product_image6,
                "Sofa Bed",
                4.5F,
                145,
                167,
                600,
                700
            )
        )


        return mTrendingProductList
    }

    fun convertObjectToString(dataObject: TrendingProductItem): String {
        val gson = Gson()
        return gson.toJson(dataObject)
    }

    fun convertStringToObject(mData: String): TrendingProductItem {
        val mObject: TrendingProductItem
        val gson = Gson()
        val type = object : TypeToken<TrendingProductItem>() {}.type
        mObject = gson.fromJson(mData, type)
        return mObject
    }
}