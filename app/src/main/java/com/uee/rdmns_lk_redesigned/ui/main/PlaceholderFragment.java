package com.uee.rdmns_lk_redesigned.ui.main;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.uee.rdmns_lk_redesigned.R;
import com.uee.rdmns_lk_redesigned.mainNewsFeed.NewsFeedModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

    private static final String ARG_SECTION_NUMBER = "section_number";

    private PageViewModel pageViewModel;

    public static PlaceholderFragment newInstance(int index) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(ARG_SECTION_NUMBER, index);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        pageViewModel = ViewModelProviders.of(this).get(PageViewModel.class);
        int index = 1;
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_SECTION_NUMBER);
        }
        pageViewModel.setIndex(index);
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        final View root = inflater.inflate(R.layout.fragment_live_updates_and_notifications, container, false);
        final TextView textView = root.findViewById(R.id.section_label);
        final ListView listView = root.findViewById(R.id.notification_list);
        pageViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        pageViewModel.getListView().observe(getViewLifecycleOwner(), new Observer<List<NewsFeedModel>>() {
            @Override
            public void onChanged(final List<NewsFeedModel> list) {

                CustomAdapter customAdapter = new CustomAdapter(list, root.getContext());

                listView.setAdapter(customAdapter);
            }
        });

        return root;
    }

    public class CustomAdapter extends BaseAdapter implements Filterable {

        private List<NewsFeedModel> newsFeedModelList;
        private List<NewsFeedModel> newsFeedModelListFiltered;
        private Context context;

        public CustomAdapter(List<NewsFeedModel> newsFeedModelList, Context context) {
            this.newsFeedModelList = newsFeedModelList;
            this.newsFeedModelListFiltered = newsFeedModelList;
            this.context = context;
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
            @SuppressLint("ViewHolder") View view = getLayoutInflater().inflate(R.layout.row_news_feed, null);

            ImageView imageView = view.findViewById(R.id.newsBanner);
            TextView texttopic = view.findViewById(R.id.newsTopic);
            TextView textDes = view.findViewById(R.id.newsDescription);

            imageView.setImageResource(newsFeedModelListFiltered.get(position).getImage());
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
}