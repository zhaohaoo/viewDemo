package demo.view.cn.viewtest;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Created by zhaohao on 17/4/13.
 */
public class MyServer extends Activity {

    private TextView mtv;

    private String tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_server);
        mtv = (TextView) findViewById(R.id.textView1);

        init();
    }

    public void init() {
        new Thread() {
            public void run() {
                try {
                    Socket socket = new Socket("http://172.16.20.12", 12222);
                    InputStream is = socket.getInputStream();
                    BufferedReader br = new BufferedReader(new InputStreamReader(is));
                    String info = null;
                    while ((info = br.readLine()) != null) {
                        System.out.println("Hello,我是客户端，服务器说：" + info);
                        tv = info;
                        handler.sendEmptyMessage(1);
                    }

//                    mtv.setText("0");
//                    Socket socket = new Socket("172.16.20.12", );
//                    mtv.setText("1");
//                    InputStream in = socket.getInputStream();
//                    byte[] buffer = new byte[in.available()];
//                    mtv.setText("2");
//                    in.read(buffer);
//                    mtv.setText("3");
//                    String msg = new String(buffer);
//                    mtv.setText(msg);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

            }

        }.start();
    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    // 更新进度情况
                    mtv.setText(tv);
                    break;
                default:
                    break;
            }
        }
    };

}