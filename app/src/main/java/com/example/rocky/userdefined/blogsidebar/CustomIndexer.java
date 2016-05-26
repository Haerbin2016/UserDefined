package com.example.rocky.userdefined.blogsidebar;

import android.widget.SectionIndexer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rocky on 2016/5/24.
 */
public class CustomIndexer implements SectionIndexer {
    private String[] mIndexStrings;
    private List<String> mDatas = new ArrayList<>();

    public CustomIndexer(List<String> datas, String[] indexStrings) {
        mDatas = datas;
        mIndexStrings = indexStrings;
    }

    public int getPositionForSection(int section){
        return section * 10;
    }
    //

    @Override
    public Object[] getSections() {
        return mIndexStrings;
    }

    @Override
    public int getSectionForPosition(int position) {
        return 0;
    }
}
