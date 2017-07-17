package com.example.com.hellokotlin.rxjava_retrofit


import com.example.com.hellokotlin.MovieList
import com.xingen.example.utlis.OkHttpProvider
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import rx.Observable
import rx.Subscriber
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers


object RemoteDataSource{
    val baseUrl="https://api.douban.com/v2/movie/"
    val retrofit:Retrofit by lazy {
        Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(OkHttpProvider.createOkHttpClient())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }

    var douBanService= retrofit.create(DouBanService::class.java)
    fun moviewList(subscriber:Subscriber<List<MovieList.Movie>>):Subscription{
        val url="search"
        val map= hashMapOf("q" to "张艺谋")
        val result= douBanService.movieList(url,map).flatMap{
            item:MovieList->Observable.just(item.sub)
        }
        .subscribeOn(Schedulers.io())
        .unsubscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(subscriber)

        return result
    }
}