package demo.view.cn.viewtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

/**
 * Created by zhaohao on 17/4/6.
 */
public class GroupActivity extends Activity {
    private GroupView mGroupViewBt;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_activity);
        init();
    }

    public void init(){
        mGroupViewBt = (GroupView)findViewById(R.id.group_view_bt);
        mGroupViewBt.setBtLeftListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupActivity.this, "点击了left按钮", Toast.LENGTH_SHORT).show();
            }
        });
        mGroupViewBt.setBtRightListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(GroupActivity.this, "点击了Right按钮", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
