package blankview
import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import android.text.TextUtils
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import com.commondemo.xiaoyu.uilibrary.R
import kotlinx.android.synthetic.main.blank_view_layout.view.*

/**
 * Created by sqwu on 2018/5/11.
 */
class BlankView:LinearLayout {

    private var mIcon:Drawable? = null
    private var mTitle:String? = ""
    private var mDescribe:String? = ""
    private var mButtonText:String? = ""
    private var buttonOnClickListener:OnClickListener? = null

    constructor(context: Context?) : this(context, null)
    constructor(context: Context?, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        View.inflate(context, R.layout.blank_view_layout, this)
        initAttrs(attrs)
        initView()
    }

    private fun initAttrs(attrs: AttributeSet?){
        val typedArray = context!!.obtainStyledAttributes(attrs, R.styleable.BlankView)
        with(typedArray){
            mIcon = getDrawable(R.styleable.BlankView_blank_icon)
            mTitle = getString(R.styleable.BlankView_blank_title)
            mDescribe = getString(R.styleable.BlankView_blank_describe)
            mButtonText = getString(R.styleable.BlankView_blank_button_text)
        }
        typedArray.recycle()
    }

    private fun initView(){
        if (mIcon != null){
            blank_iv_img.setImageDrawable(mIcon)
        }else{
            blank_iv_img.visibility = View.GONE
        }

        if (!TextUtils.isEmpty(mTitle)){
            blank_tv_title.setText(mTitle)
        }else{
            blank_tv_title.visibility = View.GONE
        }

        if (!TextUtils.isEmpty(mDescribe)){
            blank_tv_describe.setText(mDescribe)
        }else{
            blank_tv_describe.visibility = View.GONE
        }

        if (!TextUtils.isEmpty(mButtonText)){
            blank_btn.setText(mButtonText)
        }else{
            blank_btn.visibility = View.GONE
        }
    }

    fun setTitle(title:String){
        if (!TextUtils.isEmpty(title)){
            blank_tv_title.visibility = View.VISIBLE
            blank_tv_title.setText(title)
        }else{
            blank_tv_title.visibility = View.GONE
        }
    }

    fun setDescribe(describe:String){
        if (!TextUtils.isEmpty(describe)){
            blank_tv_describe.visibility = View.VISIBLE
            blank_tv_describe.setText(describe)
        }else{
            blank_tv_describe.visibility = View.GONE
        }
    }

    fun setButtonText(buttonText:String){
        if (!TextUtils.isEmpty(buttonText)){
            blank_btn.visibility = View.VISIBLE
            blank_btn.setText(buttonText)
        }else{
            blank_btn.visibility = View.GONE
        }
    }

    fun setIcon(icon:Int){
        var img: Drawable?
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            img = (resources.getDrawable(icon, null))
        }else{
           img = (resources.getDrawable(icon))
        }

        if (img != null){
            blank_iv_img.visibility = View.VISIBLE
            blank_iv_img.setImageDrawable(img)
        }else{
            blank_iv_img.visibility = View.GONE
        }
    }

    fun setButtonClickListener(onClickListener: OnClickListener){
        blank_btn.setOnClickListener(onClickListener)
    }
}