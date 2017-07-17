package com.example.com.hellokotlin

import com.example.com.hellokotlin.rxjava_retrofit.RemoteDataSource
import rx.Subscriber
import rx.subscriptions.CompositeSubscription


class MovieListPresenter(var view:FgConstract.View,
                          var compositeSubscription:
                          CompositeSubscription = defaultCompositeSubscription)
    :FgConstract.Presenter{


    init {
        view.setPresenter(this)
    }

    override fun unsubscribe() {
        view.canclDialog()
        compositeSubscription.clear()
    }

    override fun subscribe() {
        view.showDialog()
        excuteTask()
    }

    companion object {
        val defaultCompositeSubscription get() = CompositeSubscription()
    }
    fun excuteTask(){
        var disposable=RemoteDataSource.moviewList(object
            : Subscriber<List<MovieList.Movie>>(){
            override fun onError(e: Throwable) {
                view.showToast(e.toString())
               // view.showToast("123456")
                view.canclDialog()
            }

            override fun onCompleted() {
                view.showToast("加载完成")
                view.canclDialog()
            }

            override fun onNext(t: List<MovieList.Movie>) {
                view.loadInfo(t)
            }
        })
        this.compositeSubscription.add(disposable)
    }
}