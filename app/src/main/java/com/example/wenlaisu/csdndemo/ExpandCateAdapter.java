package com.example.wenlaisu.csdndemo;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by wenlaisu on 2018/4/17.
 */
public class ExpandCateAdapter extends BaseExpandableListAdapter {
    private Context context;
    public String[] groupStrings = {"西游记", "水浒传", "三国演义", "红楼梦"};
    public String[][] childStrings = {
            {"唐三藏", "孙悟空", "猪八戒", "沙和尚"},
            {"宋江", "林冲", "李逵", "鲁智深"},
            {"曹操", "刘备", "孙权", "诸葛亮", "周瑜","曹操", "刘备", "孙权"},
            {"贾宝玉", "林黛玉", "薛宝钗", "王熙凤","曹操", "刘备", "孙权", "诸葛亮", "周瑜","曹操", "刘备", "孙权", "诸葛亮", "周瑜"}
    };

    public ExpandCateAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return groupStrings.length;
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return 1;
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groupStrings[groupPosition];
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childStrings[groupPosition][childPosition];
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupViewHolder groupViewHolder;
        if (convertView == null) {
            groupViewHolder = new GroupViewHolder();
            convertView = View.inflate(context, R.layout.item_group, null);
            groupViewHolder.sort_tv_name = convertView.findViewById(R.id.sort_tv_name);
            groupViewHolder.iv_color = convertView.findViewById(R.id.iv_color);
            convertView.setTag(groupViewHolder);
        } else {
            groupViewHolder = (GroupViewHolder) convertView.getTag();
        }
        groupViewHolder.sort_tv_name.setText(groupStrings[groupPosition]);

        if (groupPosition %3 == 0){
            groupViewHolder.iv_color.setBackgroundColor(Color.RED);
        }else if (groupPosition %3 == 1){
            groupViewHolder.iv_color.setBackgroundColor(Color.BLUE);
        }else if (groupPosition %3 == 2){
            groupViewHolder.iv_color.setBackgroundColor(Color.YELLOW);
        }
        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildViewHolder childViewHolder;
        if (convertView == null) {
            childViewHolder = new ChildViewHolder();
            convertView = View.inflate(context, R.layout.item_child, null);
            childViewHolder.sort_grid = convertView.findViewById(R.id.sort_grid);
            convertView.setTag(childViewHolder);
        } else {
            childViewHolder = (ChildViewHolder) convertView.getTag();
        }

        ExpandChildAdapter childAdapter=new ExpandChildAdapter(context,childStrings[groupPosition]);
        childViewHolder.sort_grid.setAdapter(childAdapter);
        childAdapter.notifyDataSetChanged();
        childViewHolder.sort_grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(view.getContext(), "click", Toast.LENGTH_SHORT).show();
            }
        });

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

    class GroupViewHolder {
        private TextView sort_tv_name;
        private ImageView iv_color;
    }

    class ChildViewHolder {
        private MyGridView sort_grid;
    }

}