package com.example.com.hellokotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val view=Fragment2list.NewInstance
        MovieListPresenter(view)
        supportFragmentManager.beginTransaction()
                .add(R.id.context,view,Fragment2list.Tag)
                .commit()
    }
}
