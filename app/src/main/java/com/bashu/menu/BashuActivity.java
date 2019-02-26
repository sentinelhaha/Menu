package com.bashu.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.bashu.dao.SysUserDao;

public class BashuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bashu);

        ToLoginThread toLoginThread = new ToLoginThread();
        toLoginThread.start();
    }

    class ToLoginThread extends Thread {
        @Override
        public void run() {
            try {
                SysUserDao sysUserDao = new SysUserDao();
                int count =  sysUserDao.query(BashuActivity.this);
                if(count<=0){
                    Intent intent = new Intent(BashuActivity.this, LoginActivity.class);
                    startActivity(intent);
                }else {
                    Intent intent = new Intent(BashuActivity.this,FragmentsActivity.class);
                    startActivity(intent);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
