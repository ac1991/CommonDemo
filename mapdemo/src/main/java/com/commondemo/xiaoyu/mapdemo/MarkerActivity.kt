package com.commondemo.xiaoyu.mapdemo

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.amap.api.maps.AMap
import com.amap.api.maps.model.BitmapDescriptorFactory
import com.amap.api.maps.model.LatLng
import com.amap.api.maps.model.Marker
import com.amap.api.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_marker.*
import mapmarker.MarkerCircleView

class MarkerActivity : AppCompatActivity() , AMap.OnMarkerClickListener,
        AMap.OnInfoWindowClickListener, AMap.OnMarkerDragListener, AMap.OnMapLoadedListener,
        View.OnClickListener {
    override fun onMarkerClick(p0: Marker?): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onInfoWindowClick(p0: Marker?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMarkerDragEnd(p0: Marker?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMarkerDragStart(p0: Marker?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMarkerDrag(p0: Marker?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onMapLoaded() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onClick(v: View?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

//    override fun getInfoContents(p0: Marker?): View {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//    override fun getInfoWindow(p0: Marker?): View {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }

    var aMap: AMap? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marker)
        map.onCreate(savedInstanceState)

    }

    override fun onResume() {
        super.onResume()
        map.onResume()
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()

        initMarkerView()
    }

    override fun onPause() {
        super.onPause()
        map.onPause()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        super.onSaveInstanceState(outState)
        map.onSaveInstanceState(outState)
    }

    override fun onDestroy() {
        super.onDestroy()
        map.onDestroy()
    }

    private fun initMarkerView(){
        if (aMap == null){
            aMap = map.map
            val option:MarkerOptions = MarkerOptions()

            option.position(LatLng(31.178937, 121.40333))

            val view = MarkerCircleView(this)
            view.setAddr("吃鸡")
            option.icon(BitmapDescriptorFactory.fromView(view)).draggable(true)//.title("吃鸡鸡").snippet("papapa")
            val marker = aMap!!.addMarker(option)
            marker.showInfoWindow()
        }
    }

    private fun viewToBitmap(view:View): Bitmap {
        view.isDrawingCacheEnabled = true
        view.buildDrawingCache()
        return view.drawingCache
    }

    private fun setUpMap() {
        aMap!!.setOnMarkerDragListener(this)// 设置marker可拖拽事件监听器
        aMap!!.setOnMapLoadedListener(this)// 设置amap加载成功事件监听器
        aMap!!.setOnMarkerClickListener(this)// 设置点击marker事件监听器
        aMap!!.setOnInfoWindowClickListener(this)// 设置点击infoWindow事件监听器
//        aMap!!.setInfoWindowAdapter(this)// 设置自定义InfoWindow样式
//        addMarkersToMap()// 往地图上添加marker
//        initMarkerView()
    }

}
