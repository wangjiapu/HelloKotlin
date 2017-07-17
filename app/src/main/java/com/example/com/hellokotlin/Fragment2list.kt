package com.example.com.hellokotlin

import android.app.ProgressDialog
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.com.hellokotlin.Uitls.MovieListAdapter
import kotlinx.android.synthetic.main.fragment_list.view.*

class Fragment2list:Fragment(),FgConstract.View{
    lateinit var presenters:FgConstract.Presenter
    lateinit var rootView:View
    lateinit var dialog:ProgressDialog

    override fun onCreateView(inflater: LayoutInflater?,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        if (inflater != null) {
            rootView=inflater.inflate(R.layout.fragment_list,container,false)
        }
        return rootView
    }

    override fun onResume() {
        super.onResume()
        presenters.subscribe()
    }

    override fun onPause() {
        super.onPause()
        presenters.unsubscribe()
    }

    override fun canclDialog() {
        if (dialog!=null && dialog.isShowing){
            dialog.cancel()
        }
    }

    override fun showDialog() {
        dialog= ProgressDialog(activity)
        dialog.show()
    }

    override fun loadInfo(list: List<MovieList.Movie>) {
        var recycelerView=rootView.movieList_recyclverView
        recycelerView.layoutManager= LinearLayoutManager(activity)
        Log.e("999999999999","99999999999999999")
        for(i in 0..list.lastIndex){
            Log.e(list.get(i).title,i.toString())
        }
        Log.e("999999999999","99999999999999999")
        recycelerView.adapter= MovieListAdapter(activity,list)
    }

    override fun showToast(msg: String) {
        Log.e("22222222222",msg)
        Toast.makeText(activity.applicationContext,msg,Toast.LENGTH_SHORT).show()
    }

    override fun setPresenter(presenter: FgConstract.Presenter) {
        this.presenters=presenter
    }


    companion object {
        val NewInstance=Fragment2list()
        val Tag = Fragment2list::class.java.javaClass.simpleName
    }

}