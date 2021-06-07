package com.tcs.imageslider.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.tcs.imageslider.R

class ImageAdapter(var list:List<Int>,var context: Context):PagerAdapter(){

    lateinit var layoutInflater: LayoutInflater


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view.equals(`object`)
    }

    override fun getCount(): Int {
        return list.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        layoutInflater = LayoutInflater.from(context)
        var view = layoutInflater.inflate(R.layout.image_item,container,false)
        val imageView:ImageView = view.findViewById(R.id.image)
        imageView.setImageResource(list.get(position))
        container.addView(view,0)
        return view
    }


    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)
    }
}