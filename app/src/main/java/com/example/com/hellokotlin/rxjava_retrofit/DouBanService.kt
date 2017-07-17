package com.example.com.hellokotlin.rxjava_retrofit


import com.example.com.hellokotlin.MovieList
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.QueryMap
import rx.Observable


interface DouBanService{
    @GET("{path}")
    fun movieList(@Path("path") path
                  :String,@QueryMap options:Map<String,String>): Observable<MovieList>
}