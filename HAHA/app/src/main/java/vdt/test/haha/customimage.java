package vdt.test.haha;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * Created by Thanh-PC on 10/3/2017.
 */

public class customimage extends ImageView {
    public customimage(Context context) {
        super(context);
    }

    public customimage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public customimage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(getMeasuredWidth(),getMeasuredWidth() ); //Snap to width
    }
}
