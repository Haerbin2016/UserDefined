package com.example.rocky.userdefined.list;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.ListView;

import com.example.rocky.userdefined.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;
import butterknife.OnClick;

/*
    自定义List
* */
public class ListActivity extends AppCompatActivity {

    final List<DataHolder> mDataList = new ArrayList<>();
    private  ListView mListView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_list);
        //
        ButterKnife.bind(this);
        //

        for(int i=0;i<10;i++){
            mDataList.add(new DataHolder("my test"+i,"Sam"));
        }

        ListAdapter listAdapter = new ListAdapter(this,mDataList);
        mListView = (ListView)findViewById(R.id.list);
        mListView.setAdapter(listAdapter);



    }

//    全选
    @OnClick(R.id.all_sel)
    void btn_all_sel(View view){


        for(int i=0;i<mDataList.size();i++){
            mListView.setItemChecked(i,true);
        }

    }
//    全不选
    @OnClick(R.id.all_unsel)
    void btn_all_unsel(View view){
        for(int i=0;i<mDataList.size();i++){
            mListView.setItemChecked(i,false);
        }
    }

}
