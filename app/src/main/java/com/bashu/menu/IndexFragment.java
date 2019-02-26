package com.bashu.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.bashu.common.BashuApplication;

import static android.R.attr.finishOnTaskLaunch;
import static android.R.attr.fragment;

/**
 * Created by Administrator on 2019/2/24.
 */

public class IndexFragment extends Fragment {
    private WebView webView;
    private FragmentManager fragmentManager;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_index,null);
        WebView webView = (WebView) view.findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
       /* webView.clearCache(true);*/
      /*  String url ="http://www.baidu.com/";*/

        String url = BashuApplication.serverIP+"/CROWN-BS-SYS-V1/doIndexUI.do";

        webView.loadUrl(url);
        /*webView.loadData(html, "text/html; charset=UTF-8", "utf-8")*/
        WebSettings webSettings  = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);
        webSettings.setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);;
        /*webView.loadDataWithBaseURL(null,html, "text/html; charset=UTF-8", "utf-8",null);*/
        return view;
    }

}
