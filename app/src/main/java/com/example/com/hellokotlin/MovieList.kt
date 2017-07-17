package com.example.com.hellokotlin

/**
 * Created by 蒲家旺 on 2017/7/15.
 */
data class MovieList(var sub:List<Movie>){
    data class Movie(var year:String,var title:String,var image:Image){
        data class Image(var small:String,var large:String)
    }
}