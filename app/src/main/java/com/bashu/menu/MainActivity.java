package com.bashu.menu;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2019/2/25.
 */

public class MainActivity extends ActionBarActivity {
  /*  *//*
     * 访问路径
     *//*
    private static final String BASEPATH = "http://222.17.106.37:8080";
    private static final String PATH = "http://222.17.106.37:8080/HouTai/servlet/GetDataServlet";
    // ListView
    private ListView mListView;
    private List<Map<String, String>> list = new ArrayList<Map<String, String>>();
    private Map<String, String> map;
    private RequestQueue queue;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.items);

      /*  mListView =  findViewById(R.id.);
        // 得到一个RequestQueue对象
        queue = Volley.newRequestQueue(this);
        myAsyncTask task = new myAsyncTask();
        task.execute();// 异步线程执行
        MyAdapter adapter = new MyAdapter();
        mListView.setAdapter(adapter);*/
    }

    /**
     * @author Joker_Ya MyAdapter继承BaseAdapter用于listview和数据的绑定
     */
   /* public class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            // TODO Auto-generated method stub
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            // TODO Auto-generated method stub
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup arg2) {
            // TODO Auto-generated method stub
            final Viewholder holder;
            if (convertView == null) {
                convertView = LayoutInflater.from(MainActivity.this).inflate(
                        R.layout.items, null);
                // 获得Viewholder对象避免多次findView
                holder = new Viewholder();
                holder.mImageView = (ImageView) convertView
                        .findViewById(R.id.imageview);
                holder.mTextView = (TextView) convertView
                        .findViewById(R.id.textview);
                convertView.setTag(holder);
            } else {
                holder = (Viewholder) convertView.getTag();
            }
            // 获得图片并显示在mImageView中
            ImageRequest request = new ImageRequest(BASEPATH
                    + list.get(position).get("image"), new Listener<Bitmap>() {

                @Override
                public void onResponse(Bitmap response) {
                    // TODO Auto-generated method stub
                    holder.mImageView.setImageBitmap(response);
                }
            }, 0, 0, Bitmap.Config.ARGB_8888, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError error) {
                    // TODO Auto-generated method stub

                }
            });
            queue.add(request);
            holder.mTextView.setText(list.get(position).get("name"));
            return convertView;
        }

        public class Viewholder {
            ImageView mImageView;
            TextView mTextView;
        }
    }*/

    /**
     * @author Joker_Ya myAsyncTask继承AsyncTask
     */
   /* public class myAsyncTask extends AsyncTask<Void, Void, String> {
        *//**
         * 用于异步下载数据
         *//*
        @Override
        protected String doInBackground(Void... arg0) {
            // TODO Auto-generated method stub
            String result = "";
            try {
                HttpGet get = new HttpGet(new URI(PATH));
                HttpClient client = new DefaultHttpClient();
                HttpResponse response = client.execute(get);
                if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                    result = EntityUtils.toString(response.getEntity());
                    // 从后台获得的数据去掉空格
                    result = result.trim();
                    Log.v("++++++++++++", result);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return result;
        }
*/
        /**
         * 解析result（json格式的字符串）并将之存入到list中
         */
       /* @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            String name = "";
            try {
                JSONArray array = new JSONObject(result).getJSONArray("data");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    Iterator<?> iterator = object.keys();
                    map = new HashMap<String, String>();
                    while (iterator.hasNext()) {
                        name = iterator.next().toString();
                        map.put(name, object.getString(name));
                    }
                    list.add(map);
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            super.onPostExecute(result);
        }
    }*/
}
