package demo.view.cn.viewtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created by zhaohao on 17/4/5.
 */
public class DefineTextView extends View {

    private String mText;
    private int mTextColor;
    private int mTextSize;

    /**
     * 绘制时控制文本绘制的范围
     */
    private Rect mRect;
    private Paint mPaint;

    public DefineTextView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DefineTextView(Context context) {
        this(context, null);
    }

    public DefineTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.DefineTextView, defStyleAttr, 0);

        int indexCount = typedArray.getIndexCount();
        for (int i = 0; i < indexCount; i++) {
            int attr = typedArray.getIndex(i);
            switch (attr) {
                case R.styleable.DefineTextView_text:
                    mText = typedArray.getString(attr);
                    break;
                case R.styleable.DefineTextView_textSize:
                    mTextSize = typedArray.getDimensionPixelSize(attr, (int) TypedValue.applyDimension(
                            TypedValue.COMPLEX_UNIT_SP, 16, getResources().getDisplayMetrics()));
                    break;
                case R.styleable.DefineTextView_textColor:
                    mTextColor = typedArray.getColor(attr, Color.BLACK);
                    break;
            }

        }
        typedArray.recycle();

        /**
         * 获得绘制文本的宽和高
         */
        mPaint = new Paint();
        // mPaint.setColor(mTextColor);
        mPaint.setTextSize(mTextSize);
        mRect = new Rect();
        mPaint.getTextBounds(mText, 0, mText.length(), mRect);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int width;
        int height ;
        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);
        if(widthMode == MeasureSpec.EXACTLY){
            width = widthSize;
        }else{
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mText, 0, mText.length(), mRect);
            float textWidth = mRect.width();
            int desired = (int) (getPaddingLeft() + textWidth + getPaddingRight());
            width = desired;
        }

        if (heightMode == MeasureSpec.EXACTLY)
        {
            height = heightSize;
        } else
        {
            mPaint.setTextSize(mTextSize);
            mPaint.getTextBounds(mText, 0, mText.length(), mRect);
            float textHeight = mRect.height();
            int desired = (int) (getPaddingTop() + textHeight + getPaddingBottom());
            height = desired;
        }



        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        mPaint.setColor(Color.GREEN);
        canvas.drawRect(10, 10, getMeasuredWidth(), getMeasuredHeight(), mPaint);

        mPaint.setColor(mTextColor);
        canvas.drawText(mText, getWidth()/3, getHeight()/3 + mRect.height()/3, mPaint);
    }
}
