package com.photowalking;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.Window;

import com.photowalking.receiver.MyReceiver;
import com.photowalking.utils.LocalBroadcastManager;
import com.photowalking.utils.UserInfoSharedPreference;
import com.photowalking.viewUtils.StatusBarUtil;

import cn.jpush.android.api.JPushInterface;

/**
 * Created by liujinxu on 17/7/5.
 */

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        StatusBarUtil.setTransparent(this);

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String uid = UserInfoSharedPreference.getUid(this);
        String uname = UserInfoSharedPreference.getUname(this);
        if(uid == null || uname == null){
            startActivity(new Intent(this,MainActivity.class));
            finish();
            overridePendingTransition(0,R.anim.bottom_out);
        }else{
            Intent intent = new Intent(this, FragmentsActity.class);
            intent.putExtra("me",uid);
            intent.putExtra("uname",uname);
            startActivity(intent);
            finish();
            overridePendingTransition(0,R.anim.bottom_out);
        }
    }


}