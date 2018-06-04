package com.commondemo.xiaoyu.commondemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.commondemo.xiaoyu.uilibrary.multilevellinkagemenu.OnLinkageItemClickListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var close: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onResume() {
        super.onResume()

        val list:MutableList<String> = mutableListOf()
        for (i in 1..10){
            list.add("item " + i)
        }
        test.addList(list)
//        test.addList(list)
//        test.addList(list)
        test.setOnLinkageItemClickListener(object:OnLinkageItemClickListener{
            override fun onLinkageItemClickListener(linkagePosition: Int, listPosition: Int, data: String) {
                var linkageCount = test.linkageCount
                if (linkagePosition ==  linkageCount - 1){
                    test.addList(list)
                }

                if (linkagePosition < linkageCount - 1 && listPosition == 0) {
                    test.removeList(linkagePosition + 1)
                }
            }
        })


        button2.setOnClickListener({

            if (close) {
                close = false
                test.open()
            }else{
                close = true
                test.close()
            }
        })
    }
}
