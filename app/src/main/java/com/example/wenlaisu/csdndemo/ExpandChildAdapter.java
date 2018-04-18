package com.example.wenlaisu.csdndemo;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by wenlaisu on 2018/4/17.
 */
public class ExpandChildAdapter extends BaseAdapter {
    private Context context;
    private final String[] data;

    public ExpandChildAdapter(Context context, String[] childString) {
        this.data = childString;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.length;
    }

    @Override
    public Object getItem(int position) {
        return data[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = View.inflate(context, R.layout.item_sort_gridview, null);
            holder.tv_sorp_name = convertView.findViewById(R.id.tv_sorp_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_sorp_name.setText(data[position]);
        return convertView;
    }

    class ViewHolder {
        private ImageView iv_sorp;
        private TextView tv_sorp_name;
    }

}