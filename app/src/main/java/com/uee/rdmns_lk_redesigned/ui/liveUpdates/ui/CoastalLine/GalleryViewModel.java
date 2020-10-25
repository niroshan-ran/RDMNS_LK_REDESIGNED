package com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui.CoastalLine;

import com.uee.rdmns_lk_redesigned.mainNewsFeed.NewsFeedModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class GalleryViewModel {

    //int[] newsBanners = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    //String newsBanners1[] = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    Timestamp[] newsTimestamps = {
            new Timestamp(120, 9, 24, 16, 0, 49, 0),
            new Timestamp(120, 9, 24, 14, 44, 55, 0),
            new Timestamp(120, 9, 24, 14, 22, 27, 0),
            new Timestamp(120, 9, 24, 7, 46, 16, 0),
            new Timestamp(120, 9, 23, 15, 19, 55, 0)
    };

    String[] newsDateTimes = {
            "Yesterday",
            "Yesterday",
            "Yesterday",
            "Yesterday",
            "2 days ago"
    };


    String[] newsTopics = {
            "දැනුම්දීමයි.. !",
            "දැනුම්දීමයි.. !",
            "ධාවනය නොවේ.. !",
            "ප්\u200Dරමාදයි.. !",
            "ප්\u200Dරමාදයි.. !"


    };
    String[] newsDescription = {
            "නැවත දැනුම් දෙන තුරු ධාවනය නොවේ.\n" +
                    "\n" +
                    "ප.ව. 04/45 මරදාන - අළුත්ගම මන්දගාමී දුම්රිය\n" +
                    "ප.ව. 06/15 මරදාන - අළුත්ගම මන්දගාමී දුම්රිය\n" +
                    "ප.ව. 06/25 මරදාන - අළුත්ගම මන්දගාමී දුම්රිය\n" +
                    "රාත්\u200Dරී 07/45 මරදාන - පානදුර මන්දගාමී දුම්රිය\n" +
                    "\n" +
                    "ප.ව. 06/15 ට කොළඹ කොටුව සිට බෙලිඅත්ත දක්වා ධාවනය වන සීඝ්\u200Dරගාමී දුම්රිය මොරටුව සිට දකුණු කළුතර දක්වා ඇති සෑම දුම්රිය ස්ථානයකම නවත්වා ධාවනය වේ.",
            "ප.ව. 02/40 ට කොළඹ කොටුව සිට බෙලිඅත්\u200Dත දක්වා ධාවනය වන ගාලු කුමාරි සීඝ්\u200Dරගාමී දුම්රිය අද දින මොරටුව සිට කටුකුරුන්ද දක්වා ඇති සෑම දුම්රිය ස්ථානයකම නවත්වා ධාවනය වේ.\n" +
                    "\n" +
                    "එම දුම්රිය කොළඹ කොටුව දුම්රිය ස්ථානයෙන් පිටත් වීම ප.ව. 02/41",
            "ප.ව. 02/00 ට මරදාන සිට අළුත්ගම දක්වා ධාවනය වන මන්දගාමී දුම්රිය අද දින ධාවනය නොවේ.\n" +
                    "\n" +
                    "කොළඹ කොටුව දුම්රිය ස්ථානය.",
            "පෙ.ව. 06/50 ට කොළඹ කොටුව සිට බෙලිඅත්ත දක්වා ධාවනය වන (පානදුර දුම්රිය ස්ථානයෙන් පෙ.ව. 07/30 ට පිටත් වීමට නියමිත) සීඝ්\u200Dරගාමී දුම්රිය විනාඩි 13 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
                    "\n" +
                    "පානදුර දුම්රිය ස්ථානයෙන් පිටත් වීම පෙ.ව. 07/43",
            "ප.ව. 01/40 ට මාතර සිට මහනුවර දක්වා ධාවනය වන (හික්කඩුව දුම්රිය ස්ථානයෙන් ප.ව. 03/06 ට පිටත් වීමට නියමිත) සීඝ්\u200Dරගාමී දුම්රිය විනාඩි 12 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
                    "\n" +
                    "හික්කඩුව දුම්රිය ස්ථානයෙන් පිටත් වීම ප.ව. 03/18"
    };
    List<NewsFeedModel> listNewsFeed = new ArrayList<>();


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