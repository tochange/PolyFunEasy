package cn.hugeterry.ployfun.activity;

import android.content.Intent;
import android.graphics.Bitmap;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Handler;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import cn.hugeterry.ployfun.PolyfunKey;
import cn.hugeterry.ployfun.R;
import cn.hugeterry.ployfun.core.StartPolyFun;
//import cn.hugeterry.updatefun.UpdateFunGO;
//import cn.hugeterry.updatefun.config.UpdateKey;

/**
 * Created by hugeterry(http://hugeterry.cn)
 * Date: 16/6/7 13:24
 */
public class MainActivity extends AppCompatActivity {
    private Uri uri;
    private String path;
    public LinearLayout ll_choose;
    public ImageView iv;
    private Toolbar toolbar;
    private SeekBar seekbar;
    private TextView seekbar_count;
    public LinearLayout progressbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUpdate();
        initToolbar();
        initView();
    }

    /**
     * 更新模块
     */
    private void setupUpdate() {
//        UpdateKey.API_TOKEN = "";
//        UpdateKey.APP_ID = "57b14ee3ca87a87c1b0009e6";
        //UpdateKey.DialogOrNotification=UpdateKey.WITH_DIALOG;通过Dialog来进行下载
//        UpdateFunGO.init(this);
    }

    private void initToolbar() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.iv);
        ll_choose = (LinearLayout) findViewById(R.id.ll_choose);
        seekbar = (SeekBar) findViewById(R.id.seekbar);
        seekbar_count = (TextView) findViewById(R.id.seekbar_count);
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 12:
                if (resultCode == RESULT_OK) {
                    uri = data.getData();
                    Log.i("uri", uri + "");
                }
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Bitmap image;
        try {
            image = BitmapFactory.decodeResource(getResources(), R.drawable.aa);
            iv.setImageBitmap(image);
        } catch (Exception e) {
            e.printStackTrace();
        }
//        UpdateFunGO.onResume(this);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                new StartPolyFun(MainActivity.this).start();

            }
        }, 200);
    }

    @Override
    protected void onStop() {
        super.onStop();
//        UpdateFunGO.onStop(this);
    }
}
