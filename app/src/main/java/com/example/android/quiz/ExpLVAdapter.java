package com.example.android.quiz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by Crispy on 10/12/17.
 */

public class ExpLVAdapter extends BaseExpandableListAdapter {

    private ArrayList<String> listRules;
    private Map<String, ArrayList<String>> mapChild;
    private Context context;

    public ExpLVAdapter(Context context, ArrayList<String> listRules, Map<String, ArrayList<String>> mapChild) {
        this.listRules = listRules;
        this.mapChild = mapChild;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return listRules.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return mapChild.get(listRules.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listRules.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return mapChild.get(listRules.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int i) {
        return 0;
    }

    @Override
    public long getChildId(int i, int i1) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String categoryTitle = (String) getGroup(groupPosition);
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_elv_group, null);
        TextView tvGroup = convertView.findViewById(R.id.tvGroup);
        tvGroup.setText(categoryTitle);
        return convertView;

    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String item = (String) getChild(groupPosition, childPosition);
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_elv_child, null);
        TextView tvChild = (TextView) convertView.findViewById(R.id.tvChild);
        tvChild.setText(item);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
