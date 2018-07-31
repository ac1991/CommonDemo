package mapmarker;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.commondemo.xiaoyu.uilibrary.R;

/**
 * Created by Xiaoyu on 2018/7/30.
 */

public class MarkerCircleView extends LinearLayout {
    private View view;
    public MarkerCircleView(Context context) {
        this(context, null);
    }

    public MarkerCircleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MarkerCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setOrientation(VERTICAL);
        view =  View.inflate(context, R.layout.marker_view_layout, this);

    }

    public void setAddr(String text){
        TextView textView = view.findViewById(R.id.addr);
        textView.setText(text);
    }

}
