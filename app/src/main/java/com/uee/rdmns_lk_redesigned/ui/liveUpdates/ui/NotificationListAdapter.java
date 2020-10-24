package com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;

import com.uee.rdmns_lk_redesigned.R;
import com.uee.rdmns_lk_redesigned.mainNewsFeed.NewsFeedModel;

import java.util.ArrayList;
import java.util.List;


public class NotificationListAdapter extends BaseAdapter implements Filterable {

    private final List<NewsFeedModel> newsFeedModelList;
    private final Context context;
    private final FragmentActivity currentActivity;
    private List<NewsFeedModel> newsFeedModelListFiltered;

    public NotificationListAdapter(List<NewsFeedModel> newsFeedModelList, Context context, FragmentActivity appCompatActivity) {
        this.newsFeedModelList = newsFeedModelList;
        this.newsFeedModelListFiltered = newsFeedModelList;
        this.context = context;
        this.currentActivity = appCompatActivity;
    }

    @Override
    public int getCount() {
        return newsFeedModelListFiltered.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup viewGroup) {
        @SuppressLint("ViewHolder") View view = currentActivity.getLayoutInflater().inflate(R.layout.row_notification, null);

        //ImageView imageView = view.findViewById(R.id.newsBanner);
        TextView texttopic = view.findViewById(R.id.newsTopic);
        TextView textDes = view.findViewById(R.id.newsDescription);

        TextView textTimeStamp = view.findViewById(R.id.newsTimestamp);
        TextView textDateTime = view.findViewById(R.id.newsDateTime);

        //imageView.setImageResource(newsFeedModelListFiltered.get(position).getImage());
        textTimeStamp.setText(newsFeedModelListFiltered.get(position).getTimestamp().toLocaleString());
        textDateTime.setText(newsFeedModelListFiltered.get(position).getDateTimes());
        texttopic.setText(newsFeedModelListFiltered.get(position).getTopic());
        textDes.setText(newsFeedModelListFiltered.get(position).getDesc());


        return view;
    }

    @Override
    public Filter getFilter() {
        Filter filter = new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence charSequence) {
                FilterResults filterResults = new FilterResults();

                if (charSequence == null || charSequence.length() == 0) {
                    filterResults.count = newsFeedModelList.size();
                    filterResults.values = newsFeedModelList;
                } else {
                    String searchStr = charSequence.toString().toLowerCase();

                    List<NewsFeedModel> resultData = new ArrayList<>();

                    for (NewsFeedModel newsFeedModel : newsFeedModelList) {
                        if (newsFeedModel.getTopic().contains(searchStr) || newsFeedModel.getDesc().contains(searchStr)) {
                            resultData.add(newsFeedModel);
                        }

                        filterResults.count = resultData.size();
                        filterResults.values = resultData;
                    }
                }

                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
                newsFeedModelListFiltered = (List<NewsFeedModel>) filterResults.values;
                notifyDataSetChanged();
            }
        };

        return filter;
    }
}
