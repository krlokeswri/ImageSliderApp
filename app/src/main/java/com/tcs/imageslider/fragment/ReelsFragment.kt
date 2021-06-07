package com.tcs.imageslider.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.tcs.imageslider.R
import com.tcs.imageslider.adapter.ImageAdapter
import com.tcs.imageslider.callback.VerticalViewPager
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class ReelsFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    var viewPager: VerticalViewPager? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view:View = inflater.inflate(R.layout.fragment_reels, container, false)


        var listOfImgs:List<Int> = listOf<Int>(
            R.drawable.a3,
            R.drawable.a1,
            R.drawable.a2,
            R.drawable.a4,
            R.drawable.a5,
            R.drawable.a6,
            R.drawable.a7,
            R.drawable.a8
            )

        var adapter = ImageAdapter(listOfImgs,requireContext())
        viewPager = view.findViewById(R.id.pager)
        viewPager?.adapter = adapter




        return view
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReelsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}