package com.uee.rdmns_lk_redesigned;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.uee.rdmns_lk_redesigned.mainNewsFeed.NewsFeedModel;

import java.util.ArrayList;
import java.util.List;

public class MainNewsFeed extends AppCompatActivity {

    ListView NewsFeed_listView;
    int newsBanners[] = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    String newsTopics[] = {"දැනුම්දීමයි !","ප්\u200Dරමාදයි !","ප්\u200Dරමාදයි...!","දැනුම්දීමයි..","ප්\u200Dරමාදයි..","ධාවනය නොවේ."};
    String newsDescription[] = {"රාත්\u200Dරී 08/45 ට කොළඹ කොටුව සිට පොල්ගහවෙල හන්දිය දක්වා ධාවනය වන (හුනුපිටිය දුම්රිය ස්ථානයෙන් රාත්\u200Dරී 09/06 ට පිටත් වීමට නියමිත) මන්දගාමී දුම්රිය විනාඩි 19 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.", "පෙ.ව. 06/20 ට මාතලේ සිට පැමිණ මහනුවර දුම්රිය ස්ථානයෙන් පෙ.ව. 08/00 ට කොළඹ කොටුව දක්වා ධාවනය වන සීඝ්\u200Dරගාමී දුම්රිය විනාඩි 28 ක පමණ ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
            "\n" +
            "බලන දුම්රිය ස්ථානයෙන් පිටත් වීම පෙ.ව. 09/11","රාත්\u200Dරී 07/20 ට කොළඹ කොටුව සිට අඹේපුස්ස දක්වා ධාවනය වන මන්දගාමී දුම්රිය විනාඩි 15 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
            "\n" +
            "කොළඹ කොටුව දුම්රිය ස්ථානයෙන් පිටත් වීම රාත්\u200Dරී 07/35","පෙ.ව. 07/00 ට දකුණු කළුතර සිට පැමිණ කොළඹ කොටුව දුම්රිය ස්ථානයෙන් පෙ.ව. 08/02 ට මීගමුව දක්වා ධාවනය වන සීඝ්\u200Dරගාමී දුම්රිය අද දින රාගම හන්දිය දක්වා ඇති සෑම දුම්රිය ස්ථානයකම නවත්වනවා ඇත.\n" +
            "\n" +
            "කොළඹ කොටුව දුම්රිය ස්ථානය.","පෙ.ව. 07/20 ට අඹේපුස්ස සිට කොළඹ කොටුව දක්වා ධාවනය වන (වේයන්ගොඩ දුම්රිය ස්ථානයෙන් පෙ.ව. 07/49 ට පිටත් වීමට නියමිත) මන්දගාමී දුම්රිය විනාඩි 19 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
            "\n" +
            "වේයන්ගොඩ දුම්රිය ස්ථානයෙන් පිටත් වීම පෙ.ව. 08/08","පෙ.ව. 07/35 ට කොළඹ කොටුව සිට මීරිගම දක්වා ධාවනය වන සීඝ්\u200Dරගාමී දුම්රිය අද දින ධාවනය නොවේ.\n" +
            "\n" +
            "කොළඹ කොටුව දුම්රිය ස්ථානය."};

    List<NewsFeedModel> listNewsFeed = new ArrayList<>();

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

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
        public View getView(final int position, View convertView, ViewGroup viewGroup) {
            @SuppressLint("ViewHolder") View view = getLayoutInflater().inflate(R.layout.row_news_feed, null);

            ImageView imageView = view.findViewById(R.id.newsBanner);
            TextView texttopic = view.findViewById(R.id.newsTopic);
            TextView textDes = view.findViewById(R.id.newsDescription);

            imageView.setImageResource(newsFeedModelListFiltered.get(position).getImage());
            texttopic.setText(newsFeedModelListFiltered.get(position).getTopic());
            textDes.setText(newsFeedModelListFiltered.get(position).getDesc());

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainNewsFeed.this, ViewNewsActivity.class).putExtra("news",newsFeedModelListFiltered.get(position)));
                }
            });

            return view;
        }
    }
}
