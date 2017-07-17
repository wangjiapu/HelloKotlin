package com.example.com.hellokotlin.Uitls;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xingen.example.utlis.glide.CircularBitmapImageViewTarget;

/**
 * Created by 蒲家旺 on 2017/7/17.
 */

public class GlideUtils{
    public static void loadUrlImage(Context context, String url, ImageView image){
        Glide.with(context)
                .asBitmap()
                .load(url)
                .into(new CircularBitmapImageViewTarget(context,image));

    }
}
