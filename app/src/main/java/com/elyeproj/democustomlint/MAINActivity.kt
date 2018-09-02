package com.elyeproj.democustomlint

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.LayoutRes

class MAINActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val layOUT = R.layout.activity_main
        inFLATElayout(layOUT)
    }

    private fun inFLATElayout(@LayoutRes layout: Int) {
        setContentView(layout)
    }
}
