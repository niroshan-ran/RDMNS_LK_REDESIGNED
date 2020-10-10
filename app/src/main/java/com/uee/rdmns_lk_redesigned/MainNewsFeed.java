package com.uee.rdmns_lk_redesigned;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.uee.rdmns_lk_redesigned.mainNewsFeed.NewsFeedModel;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainNewsFeed extends AppCompatActivity {

    ListView NewsFeed_listView;
    int newsBanners[] = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    //String newsBanners1[] = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
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
    List<NewsFeedModel> listNewsFeed1 = new ArrayList<>();

    CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_feed);

        initRecycleView();

        NewsFeed_listView = findViewById(R.id.NewsFeedListview);

        for(int i = 0;i < newsTopics.length; i++ ){
            NewsFeedModel newsFeedModel = new NewsFeedModel(newsTopics[i], newsDescription[i],newsBanners[i]);

            listNewsFeed.add(newsFeedModel);
        }

        customAdapter = new CustomAdapter(listNewsFeed, this);
        NewsFeed_listView.setAdapter(customAdapter);

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

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainNewsFeed.this, ViewNewsActivity.class).putExtra("news",newsFeedModelListFiltered.get(position)));
                }
            });

            return view;
        }

        @Override
        public Filter getFilter() {
            Filter filter = new Filter() {
                @Override
                protected FilterResults performFiltering(CharSequence charSequence) {
                    FilterResults filterResults = new FilterResults();

                    if(charSequence == null || charSequence.length() == 0){
                        filterResults.count = newsFeedModelList.size();
                        filterResults.values = newsFeedModelList;
                    }else {
                        String searchStr = charSequence.toString().toLowerCase();

                        List<NewsFeedModel> resultData = new ArrayList<>();

                        for (NewsFeedModel newsFeedModel: newsFeedModelList){
                            if (newsFeedModel.getTopic().contains(searchStr) || newsFeedModel.getDesc().contains(searchStr)){
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



    // load data to horizontal view

    private void initRecycleView(){
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(layoutManager);

        ArrayList<Integer> newsImgArray1 = new ArrayList<>();
        ArrayList<String> newsTopicArray1 = new ArrayList<>();

        for(int i = 0;i < newsTopics.length; i++ ){

            newsImgArray1.add(newsBanners[i]);
            newsTopicArray1.add(newsTopics[i]);

        }

        RecycleViewAdapter adapter = new RecycleViewAdapter(newsTopicArray1, newsImgArray1,this);
        recyclerView.setAdapter(adapter);
    }


    // horizontal adapter view
    public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.ViewHolder> {

        private ArrayList<String> newsTopicsArray = new ArrayList<>();
        private ArrayList<Integer> newsImgArray = new ArrayList<>();
        private Context mContext;


        public RecycleViewAdapter(ArrayList<String> newsTopicsArray, ArrayList<Integer> newsImgArray, Context mContext) {
            this.newsTopicsArray = newsTopicsArray;
            this.newsImgArray = newsImgArray;
            this.mContext = mContext;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_horizontal_news_block, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
//            Glide.with(mContext)
//                    .asBitmap()
//                    .load(newsImgArray.get(position))
//                    .into(holder.circleImageView);

            for(int i = 0;i < newsTopics.length; i++ ){
                NewsFeedModel newsFeedModel2 = new NewsFeedModel(newsTopics[i], newsDescription[i],newsBanners[i]);

                listNewsFeed1.add(newsFeedModel2);
            }

            holder.circleImageView.setImageResource(newsImgArray.get(position));
            holder.textViewTopic.setText(newsTopicsArray.get(position));

            holder.circleImageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    startActivity(new Intent(MainNewsFeed.this, ViewNewsActivity.class).putExtra("news",listNewsFeed1.get(position)));
                }
            });
        }

        @Override
        public int getItemCount() {
            return newsTopicsArray.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder{
            CircleImageView circleImageView;
            TextView textViewTopic;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);

                circleImageView = itemView.findViewById(R.id.roundImageIcon);
                textViewTopic = itemView.findViewById(R.id.NewsTopicRecycleView);


            }

        }

    }


    //search menu


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.news_menu, menu);

        MenuItem menuItem = menu.findItem(R.id.search_news);

        SearchView searchView = (SearchView) menuItem.getActionView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {

                customAdapter.getFilter().filter(s);
                return true;
            }
        });

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.search_news){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
