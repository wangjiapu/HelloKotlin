package com.example.com.hellokotlin

/**
 * Created by 蒲家旺 on 2017/7/15.
 */
interface BaseView<T>{
    fun setPresenter(presenter :T)
}