package com.bashu.menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bashu.common.BashuApplication;

/**
 * Created by Administrator on 2019/2/24.
 */

public class MessageFragment extends Fragment {
    @Override
    @Nullable
    public View onCreateView(LayoutInflater inflater ,
                             @Nullable ViewGroup container,
                             @Nullable Bundle saveInstanceState){
        View view = inflater.inflate(R.layout.fragment_message,null);
        WebView webView = (WebView) view.findViewById(R.id.webView1);
        webView.setWebViewClient(new WebViewClient());
       /* webView.clearCache(true);*/
        String url = "http://192.168.2.2:8001";
        webView.loadUrl(url);
        WebSettings webSettings  = webView.getSettings();
        webSettings.setJavaScriptEnabled(false);
        return view;
    }

}
