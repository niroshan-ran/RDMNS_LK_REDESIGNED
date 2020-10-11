package com.uee.rdmns_lk_redesigned.ui.main;


import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.uee.rdmns_lk_redesigned.R;
import com.uee.rdmns_lk_redesigned.mainNewsFeed.NewsFeedModel;

import java.util.ArrayList;
import java.util.List;

public class PageViewModel extends ViewModel {

    int[] newsBanners = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    //String newsBanners1[] = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    String[] newsTopics = {"දැනුම්දීමයි !", "ප්\u200Dරමාදයි !", "ප්\u200Dරමාදයි...!", "දැනුම්දීමයි..", "ප්\u200Dරමාදයි..", "ධාවනය නොවේ."};
    String[] newsDescription = {"රාත්\u200Dරී 08/45 ට කොළඹ කොටුව සිට පොල්ගහවෙල හන්දිය දක්වා ධාවනය වන (හුනුපිටිය දුම්රිය ස්ථානයෙන් රාත්\u200Dරී 09/06 ට පිටත් වීමට නියමිත) මන්දගාමී දුම්රිය විනාඩි 19 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.", "පෙ.ව. 06/20 ට මාතලේ සිට පැමිණ මහනුවර දුම්රිය ස්ථානයෙන් පෙ.ව. 08/00 ට කොළඹ කොටුව දක්වා ධාවනය වන සීඝ්\u200Dරගාමී දුම්රිය විනාඩි 28 ක පමණ ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
            "\n" +
            "බලන දුම්රිය ස්ථානයෙන් පිටත් වීම පෙ.ව. 09/11", "රාත්\u200Dරී 07/20 ට කොළඹ කොටුව සිට අඹේපුස්ස දක්වා ධාවනය වන මන්දගාමී දුම්රිය විනාඩි 15 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
            "\n" +
            "කොළඹ කොටුව දුම්රිය ස්ථානයෙන් පිටත් වීම රාත්\u200Dරී 07/35", "පෙ.ව. 07/00 ට දකුණු කළුතර සිට පැමිණ කොළඹ කොටුව දුම්රිය ස්ථානයෙන් පෙ.ව. 08/02 ට මීගමුව දක්වා ධාවනය වන සීඝ්\u200Dරගාමී දුම්රිය අද දින රාගම හන්දිය දක්වා ඇති සෑම දුම්රිය ස්ථානයකම නවත්වනවා ඇත.\n" +
            "\n" +
            "කොළඹ කොටුව දුම්රිය ස්ථානය.", "පෙ.ව. 07/20 ට අඹේපුස්ස සිට කොළඹ කොටුව දක්වා ධාවනය වන (වේයන්ගොඩ දුම්රිය ස්ථානයෙන් පෙ.ව. 07/49 ට පිටත් වීමට නියමිත) මන්දගාමී දුම්රිය විනාඩි 19 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
            "\n" +
            "වේයන්ගොඩ දුම්රිය ස්ථානයෙන් පිටත් වීම පෙ.ව. 08/08", "පෙ.ව. 07/35 ට කොළඹ කොටුව සිට මීරිගම දක්වා ධාවනය වන සීඝ්\u200Dරගාමී දුම්රිය අද දින ධාවනය නොවේ.\n" +
            "\n" +
            "කොළඹ කොටුව දුම්රිය ස්ථානය."};
    List<NewsFeedModel> listNewsFeed = new ArrayList<>();
    private MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    private LiveData<String> mText = Transformations.map(mIndex, new Function<Integer, String>() {
        @Override
        public String apply(Integer input) {
            return "Hello world from section: " + input;
        }
    });
    private LiveData<List<NewsFeedModel>> notificationList = Transformations.map(mIndex, new Function<Integer, List<NewsFeedModel>>() {
        @Override
        public List<NewsFeedModel> apply(Integer input) {


            for (int i = 0; i < newsTopics.length; i++) {
                NewsFeedModel newsFeedModel = new NewsFeedModel(newsTopics[i], newsDescription[i], newsBanners[i]);

                listNewsFeed.add(newsFeedModel);
            }


            return listNewsFeed;
        }
    });

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public LiveData<String> getText() {
        return mText;
    }

    public LiveData<List<NewsFeedModel>> getListView() {
        return notificationList;
    }
}