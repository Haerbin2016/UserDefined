package com.example.rocky.userdefined.list;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rocky.userdefined.R;

import java.util.List;

/**
 * Created by Rocky on 2016/5/22.
 */
public class ListAdapter extends BaseAdapter {
    private List<DataHolder> mList = null;
    private Context mContent = null;
    private LayoutInflater mInflater = null;

    public ListAdapter(Context mContent, List<DataHolder> mList) {
        this.mContent = mContent;
        this.mList = mList;
        mInflater = LayoutInflater.from(mContent);
    }

    @Override
    public int getCount() {
        if (null != mList) {
            return mList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        if (null != mList) {
            return mList.get(position);
        }

        return null;
    }

    @Override
    public long getItemId(int position) {
        if (null != mList) {
            return position;
        }
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null == mList) {
            return null;
        }
        ViewHolder viewHolder = null;
        if (null == convertView) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.check_list_item,null);
            viewHolder.mTitle = (TextView)convertView.findViewById(R.id.my_title);
            viewHolder.mSubTitle = (TextView)convertView.findViewById(R.id.sub_title);
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
        }
        viewHolder.mTitle.setText(mList.get(position).getTitle());
        viewHolder.mSubTitle.setText(mList.get(position).getSubTitle());

        return convertView;
    }
}
