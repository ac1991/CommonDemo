package com.commondemo.xiaoyu.mapdemo

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Color
import android.location.Geocoder
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.amap.api.maps.AMap
import com.amap.api.maps.model.*
import com.amap.api.services.core.AMapException
import com.amap.api.services.geocoder.GeocodeQuery
import com.amap.api.services.geocoder.GeocodeResult
import com.amap.api.services.geocoder.GeocodeSearch
import com.amap.api.services.geocoder.RegeocodeResult
import kotlinx.android.synthetic.main.activity_marker.*
import kotlinx.android.synthetic.main.marker_view_layout.*
import mapmarker.MarkerCircleView
import java.util.logging.Logger

class MarkerActivity : AppCompatActivity() , AMap.OnMarkerClickListener,
        AMap.OnInfoWindowClickListener, AMap.OnMarkerDragListener, AMap.OnMapLoadedListener,
        View.OnClickListener {

    val addrs = arrayOf("金杨二街坊", "钦州北路1122号", "漕河泾地铁站")
    var geocoderSearch:GeocodeSearch? = null

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
        initAMap()
        initLocation()
        initGeocodeSearch()
        drawMarkers()
//        initMarkerView()
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

    private fun initAMap(){
        if(aMap == null){
            aMap = map.map
        }
    }

    private fun initLocation(){
        if (aMap != null) {
            val myLocationStyle = MyLocationStyle()
            myLocationStyle.myLocationType(MyLocationStyle.LOCATION_TYPE_LOCATE)//只定位一次并且视图移动到中心点
            myLocationStyle.showMyLocation(true)
            myLocationStyle.strokeColor(Color.TRANSPARENT);// 设置圆形的边框颜色
            myLocationStyle.radiusFillColor(Color.argb(0, 0, 0, 0));// 设置圆形的填充颜色

            aMap!!.myLocationStyle = myLocationStyle
            aMap!!.setMyLocationEnabled(true)
        }
    }

    private fun drawMarkers(){
        for (address in addrs){
            geocode(address)
        }
    }

    private fun initGeocodeSearch(){
        if (aMap != null){
            initAMap()
            geocoderSearch = GeocodeSearch(this)
            geocoderSearch!!.setOnGeocodeSearchListener(object :GeocodeSearch.OnGeocodeSearchListener{
                //逆地理编码
                override fun onRegeocodeSearched(p0: RegeocodeResult?, p1: Int) {

                }

                //地理编码
                override fun onGeocodeSearched(result: GeocodeResult?, code: Int) {
                    if (code == AMapException.CODE_AMAP_SUCCESS){
                        if (result != null && result.geocodeAddressList != null && result.geocodeAddressList.size > 0){

                            val address = result.geocodeAddressList[0]
                            if (address != null){
                                initMarkerView(LatLng(address.latLonPoint.latitude, address.latLonPoint.longitude), result.geocodeQuery.locationName)
                                Log.d("地址",  address.formatAddress + "  district" + address.district + " province" + address.province + " adcode" + address.adcode + " township" + address.township + " level" + address.level + " city" + address.city)
                                Log.d("地址", result.geocodeQuery.locationName)
                            }
                        }
                    }
                }

            })

        }
    }

    private fun geocode(addr:String){
        val query = GeocodeQuery(addr, "上海")
        if (geocoderSearch != null) {
            geocoderSearch!!.getFromLocationNameAsyn(query)
        }
    }

    private fun initMarkerView(position:LatLng, addr:String){
        if (aMap != null){

            val option:MarkerOptions = MarkerOptions()

            option.position(position)
            val view = MarkerCircleView(this)
            view.setAddr(addr)
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
