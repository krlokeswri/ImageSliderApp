package com.tcs.imageslider.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.tcs.imageslider.R
import com.tcs.imageslider.callback.NavigateFragment
import com.tcs.imageslider.fragment.ReelsFragment

class MainActivity : AppCompatActivity(),NavigateFragment{

    var bottomNavigationView:BottomNavigationView?= null



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNavigationView?.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        onShowFragment(ReelsFragment(), ReelsFragment()::class.java.name, true, false, false)




    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { menuItem ->
        when (menuItem.itemId) {
            R.id.user -> {
                onShowFragment(UserFragment(), UserFragment()::class.java.name, true, true, false)
                return@OnNavigationItemSelectedListener true
            }
            R.id.list -> {
                    onShowFragment(ReelsFragment(), ReelsFragment()::class.java.name, true, false, false)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onShowFragment(
        fragment: Fragment,
        name: String,
        addTobackStack: Boolean,
        clearToBackStack: Boolean,
        showAnimation: Boolean
    ) {

        val manager = supportFragmentManager
        val transaction = manager.beginTransaction()
        val fragmentByTag = manager.findFragmentByTag(name)

        if (fragmentByTag != null && fragmentByTag.isVisible) {
            manager.popBackStack(name, 0)
            return
        }

        if (clearToBackStack) {
            supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
        if (addTobackStack) {
            transaction.replace(R.id.container, fragment, name).addToBackStack(name)
        } else {
            transaction.replace(R.id.container, fragment)
        }
        transaction.commit()


    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount == 1) {
            finish()
        }else
            super.onBackPressed()

    }

}