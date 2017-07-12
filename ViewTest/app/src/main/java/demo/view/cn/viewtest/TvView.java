package demo.view.cn.viewtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by zhaohao on 17/4/6.
 */
public class TvView extends TextView {


    public TvView(Context context) {
        super(context);
    }

    public TvView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TvView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(getResources().getColor(android.R.color.holo_green_light));
        paint.setStyle(Paint.Style.FILL);
        Paint mPaint = new Paint();
        mPaint.setColor(Color.GREEN );
        mPaint.setStyle(Paint.Style.FILL);
        //绘制外层矩形
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), paint);
        //绘制内层矩形
        canvas.drawRect(5, 5, getMeasuredWidth() - 5, getMeasuredHeight() - 5, mPaint);
        canvas.save();
        //绘制文字前平移10像素
        canvas.translate(5, 0);
        super.onDraw(canvas);
        canvas.restore();
    }
}
