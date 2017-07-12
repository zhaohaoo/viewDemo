package demo.view.cn.viewtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private View mGroup;
    private View mServer;
    private View mEnum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void init() {
        mGroup = findViewById(R.id.bt_group);
        mGroup.setOnClickListener(clickListener);

        mServer = findViewById(R.id.bt_server);
        mServer.setOnClickListener(clickListener);
        mEnum = findViewById(R.id.enum_bt);
        mEnum.setOnClickListener(clickListener);
    }

    Intent intent = new Intent();
    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.bt_group:
                    intent.setClass(MainActivity.this, GroupActivity.class);
                    startActivity(intent);
                    break;
                case R.id.bt_server:
                    intent.setClass(MainActivity.this, MyServer.class);
                    startActivity(intent);
                    break;
                case R.id.enum_bt:
                    print(Grade.A);

            }
        }
    };

    public void print(Grade v){
        String value = v.LocaleValue();
        Toast.makeText(getApplication(),value,Toast.LENGTH_SHORT).show();
    }


    enum Grade {
        A("1"){
            public String LocaleValue(){
                return "11";
            }
        },
        B("2"){
            public String LocaleValue(){
                return "22";
            }
        },
        C("3"){
            public String LocaleValue(){
                return "33";
            }
        };

        private String Value;

        private Grade(String Value) {
            this.Value = Value;
        }

        public String getValue() {
            return this.Value;
        }

        public abstract String LocaleValue();
    }
}
