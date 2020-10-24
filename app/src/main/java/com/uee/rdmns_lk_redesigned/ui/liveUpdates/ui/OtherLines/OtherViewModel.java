package com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui.OtherLines;

import androidx.lifecycle.MutableLiveData;

import com.uee.rdmns_lk_redesigned.mainNewsFeed.NewsFeedModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class OtherViewModel {
    private final MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    //int[] newsBanners = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    //String newsBanners1[] = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    Timestamp[] newsTimestamps = {
            new Timestamp(120, 9, 24, 15, 35, 14, 0),
            new Timestamp(120, 9, 22, 19, 10, 53, 0),
            new Timestamp(120, 9, 21, 19, 55, 32, 0),
            new Timestamp(120, 9, 20, 20, 53, 12, 0),
            new Timestamp(120, 9, 19, 18, 42, 51, 0)
    };
    String[] newsDateTimes = {
            "Yesterday",
            "3 days ago",
            "4 days ago",
            "5 days ago",
            "6 days ago"};
    String[] newsTopics = {"ප්\u200Dරමාදයි !", "ප්\u200Dරමාදයි.. !", "ප්\u200Dරමාදයි !", "ප්\u200Dරමාදයි !", "ප්\u200Dරමාදයි !"};
    String[] newsDescription = {"පෙ.ව. 08/45 ට බෙලිඅත්ත සිට පැමිණ කොළඹ කොටුව දුම්රිය ස්ථානයෙන් ප.ව. 01/15 ට වවුනියාව දක්වා ධාවනය වන රජරට රැජිණ සීඝ්\u200Dරගාමී දුම්රිය විනාඩි 13 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
            "\n" +
            "තලවත්තේගෙදර දුම්රිය ස්ථානයෙන් පිටත් වීම ප.ව. 03/18",
            "ප.ව. 06/00 ට කොළඹ කොටුව සිට කුරුණෑගල සහ මහව හන්දිය දක්වා ධාවනය වන (ප.ව. 06/46 ට වේයන්ගොඩ දුම්රිය ස්ථානය පසු කිරීමට නියමිත) සීඝ්\u200Dරගාමී දුම්රිය විනාඩි 15 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
                    "\n" +
                    "වේයන්ගොඩ දුම්රිය ස්ථානය පසු කිරීම රාත්\u200Dරී 07/01",
            "ප.ව. 06/00 ට කොළඹ කොටුව සිට කුරුණෑගල සහ මහව හන්දිය දක්වා ධාවනය වන (අලව්ව දුම්රිය ස්ථානයෙන් රාත්\u200Dරී 07/15 ට පිටත් වීමට නියමිත) සීඝ්\u200Dරගාමී දුම්රිය විනාඩි 33 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
                    "\n" +
                    "අලව්ව දුම්රිය ස්ථානයෙන් පිටත් වීම රාත්\u200Dරී 07/48",
            "රාත්\u200Dරී 07/15 ට කොළඹ කොටුව සිට තලේමන්නාරම් තොට දක්වා ධාවනය වන (අලව්ව දුම්රිය ස්ථානයෙන් රාත්\u200Dරී 08/32 ට පිටත් වීමට නියමිත) සීඝ්\u200Dරගාමී දුම්රිය විනාඩි 14 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
                    "\n" +
                    "අලව්ව දුම්රිය ස්ථානයෙන් පිටත් වීම රාත්\u200Dරී 08/46",
            "ප.ව. 05/15 ට කොළඹ කොටුව සිට කුරුණෑගල සහ ගනේවත්ත දක්වා ධාවනය වන (යත්තල්ගොඩ දුම්රිය ස්ථානයෙන් ප.ව. 06/26 ට පිටත් වීමට නියමිත) සීඝ්\u200Dරගාමී දුම්රිය විනාඩි 12 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
                    "\n" +
                    "යත්තල්ගොඩ දුම්රිය ස්ථානයෙන් පිටත් වීම ප.ව. 06/38"};
    List<NewsFeedModel> listNewsFeed = new ArrayList<>();

    public void setIndex(int index) {
        mIndex.setValue(index);
    }

    public List<NewsFeedModel> getListView() {

        for (int i = 0; i < newsTopics.length; i++) {
            NewsFeedModel newsFeedModel = new NewsFeedModel();

            newsFeedModel.setTopic(newsTopics[i]);
            newsFeedModel.setDesc(newsDescription[i]);
            newsFeedModel.setTimestamp(newsTimestamps[i]);
            newsFeedModel.setDateTimes(newsDateTimes[i]);

            listNewsFeed.add(newsFeedModel);
        }


        return listNewsFeed;
    }


}