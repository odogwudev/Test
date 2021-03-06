package com.odogwudev.test.activity

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.odogwudev.test.R
import com.odogwudev.test.datamodel.TrendingProductItem
import com.odogwudev.test.utils.DataProvider

class ProductPurchasingActivity : AppCompatActivity() {
    private lateinit var trendingProductItem: TrendingProductItem

    private lateinit var productImage: ImageView
    private lateinit var productName: TextView
    private lateinit var productRatingStar: TextView
    private lateinit var productCountingRatingReviews: TextView
    private lateinit var productRent: TextView
    private lateinit var productRefund: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_purchasing)

        val mData = intent.getStringExtra("ProductPurchasing")
        trendingProductItem = DataProvider.convertStringToObject(mData!!)

        initViews()
        settingData()

    }

    private fun initViews() {
        productImage = findViewById(R.id.productImage)
        productName = findViewById(R.id.productName)
        productRatingStar = findViewById(R.id.productRatingStar)
        productCountingRatingReviews = findViewById(R.id.productCountingRatingReviews)
        productRent = findViewById(R.id.productRent)
        productRefund = findViewById(R.id.productRefund)

    }

    fun onClickMethod(view: View) {
        when (view.id) {
            R.id.btnBack -> {
                backPressed()
            }
            R.id.btnTenure -> showMessage("Enter Tenure")
            R.id.btnAddCart -> showMessage("Add to Card")
        }
    }

    override fun onBackPressed() {
        backPressed()
    }

    private fun backPressed() {
        super.onBackPressed()
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun settingData() {
        productImage.setImageResource(trendingProductItem.productImage)
        productName.text = trendingProductItem.productName
        productRatingStar.text = "${trendingProductItem.productRatingStar}"
        productCountingRatingReviews.text =
            "${trendingProductItem.productCountingRating} Rating | ${trendingProductItem.productCountingReviews} Revies"
        productRent.text = "${trendingProductItem.productRentPerMonth}$/month"
        productRefund.text = "${trendingProductItem.productRefundableDeposit}$"
    }
}