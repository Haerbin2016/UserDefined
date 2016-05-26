package com.example.rocky.userdefined.blogsidebar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rocky.userdefined.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BlogSideActivity extends AppCompatActivity {

    @BindView(R.id.index_list)
    ListView mListView;
    @BindView(R.id.index_slide_bar)
    IndexSideBar mIndexSideBar;
    @BindView(R.id.index_slide_dialog)
    TextView mIndexBlockDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_blog_side);
        ButterKnife.bind(this);
        //
        /*
        mIndexSideBar.setIndicatorTv(mIndexBlockDialog);
        mIndexSideBar.setChooseListener(new IndexSideBar.ChooseListener() {
            @Override
            public void onChoosed(int pos, String text) {
                Log.d("sam--","pos:"+pos+" text:"+text);
            }
        });*/
        List<String> datas = getData();
        mListView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,datas));
        //
        final CustomIndexer indexer = new CustomIndexer(datas,IndexSideBar.B);
        mIndexSideBar.setIndicatorTv(mIndexBlockDialog);
        mIndexSideBar.setChooseListener(new IndexSideBar.ChooseListener() {
            @Override
            public void onChoosed(int pos, String text) {
                int itemPos = indexer.getPositionForSection(pos);
                Log.d("sam","pos="+pos+" itemPos="+itemPos);
                mListView.setSelection(itemPos);
            }
        });
    }

    private List<String> getData(){
        String[] indexStrs = IndexSideBar.B;

        List<String> data = new ArrayList<>();
        for(String str:indexStrs){
            for(int i=1;i<=10;i++){
                data.add(str + i);
            }
        }
        return data;
    }
}
