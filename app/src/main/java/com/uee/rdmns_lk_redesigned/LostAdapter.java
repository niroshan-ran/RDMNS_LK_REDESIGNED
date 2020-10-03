package com.uee.rdmns_lk_redesigned;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class LostAdapter extends BaseAdapter {

    private Context context;
    private int layout;
    private ArrayList<LostModel> lostList;

    public LostAdapter(Context context, int layout, ArrayList<LostModel> lostList) {
        this.context = context;
        this.layout = layout;
        this.lostList = lostList;
    }

    @Override
    public int getCount() {
        return lostList.size();
    }

    @Override
    public Object getItem(int position) {
        return lostList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    private class ViewHolder{
        TextView txtTitle, txtDetail;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        View row = view;
        ViewHolder holder = new ViewHolder();

        if(row == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(layout, null);

            holder.txtTitle = (TextView) row.findViewById(R.id.txtTitle);
            holder.txtDetail = (TextView) row.findViewById(R.id.txtDetail);
            row.setTag(holder);

        }
        else{
            holder = (ViewHolder) row.getTag();
        }

        LostModel lost = lostList.get(position);

        holder.txtTitle.setText(lost.getTitle());
        holder.txtDetail.setText(lost.getDetail());

        return row;
    }
}
