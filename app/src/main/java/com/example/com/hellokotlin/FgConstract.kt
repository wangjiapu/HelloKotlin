package com.example.com.hellokotlin

/**
 * Created by 蒲家旺 on 2017/7/15.
 */
interface FgConstract{

    interface Presenter:BasePresenter

    interface View:BaseView<Presenter>{
        fun showToast(msg:String)
        fun loadInfo(list:List<MovieList.Movie>)
        fun showDialog()
        fun canclDialog()
    }
}