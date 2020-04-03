package com.muni.mykotlintuto

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.recyclerview.widget.RecyclerView
import com.google.android.flexbox.AlignItems
import com.google.android.flexbox.FlexDirection
import com.google.android.flexbox.FlexWrap
import com.google.android.flexbox.FlexboxLayoutManager

class FlexyLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flexy_layout)
        /*val toolbar: Toolbar = findViewById(R.id.toolbar)
        setActionBar(toolbar)*/

        val flexboxLayoutManager = FlexboxLayoutManager(this).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.STRETCH
        }

        val recyclerView: RecyclerView = findViewById(R.id.rec_flex)
        recyclerView.apply {
            layoutManager = flexboxLayoutManager
            adapter = CatAdapter()
        }
    }

}
