package com.just.library.agentweb;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    private ListView mListView;

    private Toolbar mToolbar;
    private TextView mTitleTextView;


    public static final String[] datas=new String[]{"Activity 使用","Fragment 使用","文件下载","文件上传","Js 通信"};

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        

        setContentView(R.layout.activity_main);


        mToolbar = (Toolbar) this.findViewById(R.id.toolbar);
        mToolbar.setTitleTextColor(Color.WHITE);
        mToolbar.setTitle("");
        mTitleTextView = (TextView) this.findViewById(R.id.toolbar_title);
        mTitleTextView.setText("AgentWeb 使用指南");
        this.setSupportActionBar(mToolbar);
        if (getSupportActionBar() != null)
            // Enable the Up button
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.this.finish();
            }
        });

        mListView = (ListView) this.findViewById(R.id.listView);
        mListView.setAdapter(new MainAdapter());
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                doClick(position);
            }
        });

    }

    private void doClick(int position){


        switch (position){


            case 0:
                startActivity(new Intent(this,WebActivity.class));
                break;

        }


    }


    public class MainAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return datas.length;
        }

        @Override
        public Object getItem(int position) {
            return datas[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder mViewHolder;
            if(convertView==null){
                mViewHolder=new ViewHolder();
               View mView= MainActivity.this.getLayoutInflater().inflate(R.layout.listview_main,parent,false);
               mViewHolder.mTextView= (TextView) mView.findViewById(R.id.content);
                mView.setTag(mViewHolder);
                convertView=mView;
            }else{
                mViewHolder= (ViewHolder) convertView.getTag();
            }

            mViewHolder.mTextView.setText(datas[position]);
            return convertView;
        }


    }

    class ViewHolder{
        TextView mTextView;
    }





}
