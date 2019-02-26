package com.bashu.menu;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;


public class FragmentsActivity extends FragmentActivity {
    /*IndexFragment indexFragment;*/
    private BackHandledFragment mBackHandedFragment;
    private boolean hadIntercept;

    Fragment[] fragments= new Fragment[3];

    Button[] buttons = new Button[3];

    int currentFragmentIndex=0;
    int clickBtnIndex=0;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_fragment);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        IndexFragment indexFragment = new IndexFragment();
        transaction.add(R.id.fragment_container,indexFragment);
        transaction.show(indexFragment);
        transaction.commit();

        MessageFragment messageFragment = new MessageFragment();
        MeFragment meFragment = new MeFragment();
        fragments[0]=indexFragment;
        fragments[1]=messageFragment;
        fragments[2]=meFragment;

        buttons[0]= (Button) findViewById(R.id.btn_main_fragment_store);
        buttons[1]= (Button) findViewById(R.id.btn_main_fragment_message);
        buttons[2]= (Button) findViewById(R.id.btn_main_fragment_me);

        MyBtnListener myBtnListener = new MyBtnListener();
        for (Button button:buttons){
            button.setOnClickListener(myBtnListener);

        }
        buttons[currentFragmentIndex].setSelected(true);
    }



    class MyBtnListener implements View.OnClickListener{


        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.btn_main_fragment_store:
                    clickBtnIndex=0;
                    break;
                case R.id.btn_main_fragment_message:
                    clickBtnIndex=1;
                    break;
                case R.id.btn_main_fragment_me:
                    clickBtnIndex=2;
                    break;
            }
            if(currentFragmentIndex!=clickBtnIndex){
                //开始事务
                FragmentManager fragmentManager = getSupportFragmentManager();
               FragmentTransaction transaction= fragmentManager.beginTransaction();
                Fragment hideFragment = fragments[currentFragmentIndex];
                transaction.hide(hideFragment);
                Fragment showFragment = fragments[clickBtnIndex];
                if(showFragment.isAdded()==false){
                    transaction.add(R.id.fragment_container,showFragment);
                }
                transaction.show(showFragment);
                transaction.commit();
                buttons[currentFragmentIndex].setSelected(false);
                buttons[clickBtnIndex].setSelected(true);
                currentFragmentIndex=clickBtnIndex;
            }
        }
    }
}
