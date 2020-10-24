package com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui.MainLine;

import com.uee.rdmns_lk_redesigned.mainNewsFeed.NewsFeedModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class HomeViewModel {

    //int[] newsBanners = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    //String newsBanners1[] = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    Timestamp[] newsTimestamps = {
            new Timestamp(120, 9, 23, 16, 39, 34, 0),
            new Timestamp(120, 9, 23, 12, 9, 56, 0),
            new Timestamp(120, 9, 22, 20, 8, 55, 0),
            new Timestamp(120, 9, 22, 19, 52, 8, 0),
            new Timestamp(120, 9, 22, 19, 10, 35, 0)
    };

    String[] newsDateTimes = {
            "Yesterday",
            "Yesterday",
            "2 days ago",
            "2 days ago",
            "2 days ago"};


    String[] newsTopics = {"දැනුම්දීමයි..", "ප්\u200Dරමාදයි...!", "ප්\u200Dරමාදයි..", "ප්\u200Dරමාදයි..", "ප්\u200Dරමාදයි.."};
    String[] newsDescription = {"ප.ව. 04/50 ට කොළඹ කොටුව සිට රඹුක්කන දක්වා ධාවනය වන පාසල් විභාග සේවා විශේෂ මන්දගාමී දුම්රිය අද දින ප.ව. 05/30 ට කොළඹ කොටුව දුම්රිය ස්ථානයෙන් ගමන් ආරම්භ වේ.\n" +
            "\n" +
            "කොළඹ කොටුව දුම්රිය ස්ථානය.\n" +
            "\n" +
            "එම දුම්රිය කොළඹ කොටුව දුම්රිය ස්ථානයේ 02 වන වේදිකාවේ නවත්වා ඇත.",
            "පෙ.ව. 08/30 ට කොළඹ කොටුව සිට බදුල්ල දක්වා ධාවනය වන (ගම්පොළ දුම්රිය ස්ථානයෙන් පෙ.ව. 11/37 ට පිටත් වීමට නියමිත) උඩරට මැණිකේ සීඝ්\u200Dරගාමී දුම්රිය විනාඩි 23 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
                    "\n" +
                    "ගම්පොළ දුම්රිය ස්ථානයෙන් පිටත් වීම දහවල් 12/00",
            "ප.ව. 06/25 ට මහනුවර සිට පොල්ගහවෙල හන්දිය දක්වා ධාවනය වන (කඩිගමුව දුම්රිය ස්ථානයෙන් රාත්\u200Dරී 07/50 ට පිටත් වීමට නියමිත) මන්දගාමී දුම්රිය විනාඩි 15 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
                    "\n" +
                    "කඩිගමුව දුම්රිය ස්ථානයෙන් පිටත් වීම රාත්\u200Dරී 08/05",
            "ප.ව. 01/40 ට මාතර සිට පැමිණ කොළඹ කොටුව දුම්රිය ස්ථානයෙන් ප.ව. 05/45 ට මහනුවර දක්වා ධාවනය වන (රඹුක්කන දුම්රිය ස්ථානයෙන් රාත්\u200Dරී 07/36 ට පිටත් වීමට නියමිත) සීඝ්\u200Dරගාමී දුම්රිය විනාඩි 14 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
                    "\n" +
                    "රඹුක්කන දුම්රිය ස්ථානයෙන් පිටත් වීම රාත්\u200Dරී 07/50",
            "ප.ව. 06/00 ට කොළඹ කොටුව සිට කුරුණෑගල සහ මහව හන්දිය දක්වා ධාවනය වන (ප.ව. 06/46 ට වේයන්ගොඩ දුම්රිය ස්ථානය පසු කිරීමට නියමිත) සීඝ්\u200Dරගාමී දුම්රිය විනාඩි 15 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
                    "\n" +
                    "වේයන්ගොඩ දුම්රිය ස්ථානය පසු කිරීම රාත්\u200Dරී 07/01"

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