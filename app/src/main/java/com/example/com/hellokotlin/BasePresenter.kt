package com.example.com.hellokotlin


interface  BasePresenter{
    /**
     * 订阅
     */
    fun subscribe()
    /**
     * 取消订阅
     */
     fun unsubscribe()
}
