package com.example.com.hellokotlin.Uitls

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.View
import android.view.ViewGroup
import com.example.com.hellokotlin.MovieList
import com.example.com.hellokotlin.R
import kotlinx.android.synthetic.main.movielist_item.view.*


internal class MovieListAdapter(var context:Context,var list:List<MovieList.Movie>)
    :RecyclerView.Adapter<MovieListAdapter.ViewHolder>(){

    override fun getItemCount()=list.size


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int)
            = ViewHolder(View.inflate(parent?.context, R.layout.movielist_item,null))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //绑定
        GlideUtils.loadUrlImage(context,list[position].image.large,holder.imageView)
        holder.title_Tv.text=list[position].title
        Log.e(position.toString(),list[position].title)
    }

    internal class ViewHolder(rootView: View):RecyclerView.ViewHolder(rootView){
        //试图
        var imageView=rootView.movielist_item_iv
        var title_Tv=rootView.movielist_item_tv
    }

}