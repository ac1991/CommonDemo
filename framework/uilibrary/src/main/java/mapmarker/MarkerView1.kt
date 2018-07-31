package mapmarker

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.commondemo.xiaoyu.uilibrary.R

/**
 * Created by Xiaoyu on 2018/7/30.
 */
class MarkerView1:LinearLayout {
    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        View.inflate(context, R.layout.blank_view_layout, this)
//        initAttrs(attrs)
//        initView()
    }
}