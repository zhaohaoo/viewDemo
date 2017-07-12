package demo.view.cn.viewtest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.RelativeLayout;

/**
 * Created by zhaohao on 17/4/6.
 */
public class GroupView extends RelativeLayout {

    private Button mBtLeft;
    private Button mBtRight;


    public GroupView(Context context, AttributeSet attrs) {
        super(context, attrs);

        LayoutInflater.from(context).inflate(R.layout.group_view, this);

        mBtLeft = (Button) findViewById(R.id.bt_left);
        mBtRight = (Button) findViewById(R.id.bt_right);
    }

    //为button设置点击事件
    public void setBtLeftListener(OnClickListener leftListener){
        mBtLeft.setOnClickListener(leftListener);
    }

    public void setBtRightListener(OnClickListener rightListener){
        mBtRight.setOnClickListener(rightListener);
    }
}
