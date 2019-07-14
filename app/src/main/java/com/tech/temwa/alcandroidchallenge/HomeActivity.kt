package com.tech.temwa.alcandroidchallenge

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        btnALC.setOnClickListener { _ ->
            startActivity(Intent(this,ALCDetailActivity::class.java))
        }

        btnProfile.setOnClickListener { _ ->
            startActivity(Intent(this,ProfileActivity::class.java) )
        }
    }
}
