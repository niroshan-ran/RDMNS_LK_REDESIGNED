package com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui.KVLine;

import com.uee.rdmns_lk_redesigned.mainNewsFeed.NewsFeedModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class SlideshowViewModel {

    //int[] newsBanners = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    //String newsBanners1[] = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    Timestamp[] newsTimestamps = {
            new Timestamp(120, 9, 24, 16, 15, 50, 0),
            new Timestamp(120, 9, 23, 10, 39, 07, 0),
            new Timestamp(120, 9, 21, 18, 41, 2, 0),
            new Timestamp(120, 9, 19, 20, 57, 21, 0),
            new Timestamp(120, 9, 19, 20, 42, 32, 0)
    };

    String[] newsDateTimes = {
            "Yesterday",
            "2 days ago",
            "4 days ago",
            "6 days ago",
            "6 days ago"
    };


    String[] newsTopics = {
            "දැනුම්දීමයි.. !",
            "ප්\u200Dරමාදයි..!",
            "ප්\u200Dරමාදයි.. !",
            "දැනුම්දීමයි !",
            "ප්\u200Dරමාද වී ධාවනය වේ."
    };
    String[] newsDescription = {
            "අද දින ධාවනය නොවේ.\n" +
                    "\n" +
                    "9262 - ප.ව. 04/25 කොළඹ කොටුව - අවිස්සාවේල්ල සීඝ්\u200Dරගාමී දුම්රිය\n" +
                    "\n" +
                    "9269 - ප.ව. 06/30 කොළඹ කොටුව - කොස්ගම මන්දගාමී දුම්රිය",
            "පෙ.ව. 08/30 ට කොළඹ කොටුව සිට අවිස්සාවේල්ල දක්වා ධාවනය වන (පනාගොඩ දුම්රිය ස්ථානයෙන් පෙ.ව. 09/55 ට පිටත් වීමට නියමිත) මන්දගාමී දුම්රිය විනාඩි 36 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
                    "\n" +
                    "පනාගොඩ දුම්රිය ස්ථානයෙන් පිටත් වීම පෙ.ව. 10/29",
            "රාත්\u200Dරී 07/15 ට කොළඹ කොටුව සිට පාදුක්ක දක්වා ධාවනය වන මන්දගාමී දුම්රිය අද දින ධාවනය නොවේ.\n" +
                    "\n" +
                    "කොළඹ කොටුව දුම්රිය ස්ථානය.",
            "රාත්\u200Dරී 07/15 ට කොළඹ කොටුව සිට පාදුක්ක දක්වා ධාවනය වන (හෝමාගම දුම්රිය ස්ථානයෙන් රාත්\u200Dරී 08/21 ට පිටත් වීමට නියමිත) මන්දගාමී දුම්රිය විනාඩි 32 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
                    "\n" +
                    "හෝමාගම දුම්රිය ස්ථානයෙන් පිටත් වීම රාත්\u200Dරී 08/53",
            "රාත්\u200Dරී 07/15 ට කොළඹ කොටුව සිට පාදුක්ක දක්වා ධාවනය වන (හෝමාගම දුම්රිය ස්ථානයෙන් රාත්\u200Dරී 08/21 ට පිටත් වීමට නියමිත) මන්දගාමී දුම්රිය හෝමාගම දුම්රිය ස්ථානයේදී ස්වල්ප වේලාවක් ප්\u200Dරමාද වී ධාවනය වේ.\n" +
                    "\n" +
                    "හෝමාගම දුම්රිය ස්ථානය."
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