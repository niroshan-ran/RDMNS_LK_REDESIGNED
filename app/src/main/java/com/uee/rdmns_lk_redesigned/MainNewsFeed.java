package com.uee.rdmns_lk_redesigned;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.uee.rdmns_lk_redesigned.mainNewsFeed.NewsFeedModel;

import java.util.ArrayList;
import java.util.List;

public class MainNewsFeed extends AppCompatActivity {

    ListView NewsFeed_listView;
    int newsBanners[] = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4};
    String newsTopics[] = {"News 1","News 2","News 3","News 4"};
    String newsDescription[] = {"This is Description 1", "This is Description 2","This is Description 3","This is Description 4"};

    List<NewsFeedModel> listNewsFeed = new ArrayList<>();

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_feed);

        NewsFeed_listView = findViewById(R.id.NewsFeedListview);

        for(int i = 0;i < newsTopics.length; i++ ){
            NewsFeedModel newsFeedModel = new NewsFeedModel(newsTopics[i], newsDescription[i],newsBanners[i]);

            listNewsFeed.add(newsFeedModel);
        }

        customAdapter = new CustomAdapter(listNewsFeed, this);

        NewsFeed_listView.setAdapter(customAdapter);

    }

    public class CustomAdapter extends BaseAdapter{

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
        public View getView(int position, View convertView, ViewGroup viewGroup) {
            View view = getLayoutInflater().inflate(R.layout.row_news_feed, null);

            ImageView imageView = view.findViewById(R.id.newsBanner);
            TextView texttopic = view.findViewById(R.id.newsTopic);
            TextView textDes = view.findViewById(R.id.newsDescription);

            imageView.setImageResource(newsFeedModelListFiltered.get(position).getImage());
            texttopic.setText(newsFeedModelListFiltered.get(position).getTopic());
            textDes.setText(newsFeedModelListFiltered.get(position).getDesc());


            return view;
        }
    }
}
