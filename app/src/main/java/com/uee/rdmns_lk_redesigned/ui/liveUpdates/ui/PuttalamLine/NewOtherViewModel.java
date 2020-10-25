package com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui.PuttalamLine;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.uee.rdmns_lk_redesigned.mainNewsFeed.NewsFeedModel;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class NewOtherViewModel extends ViewModel {
    private final MutableLiveData<Integer> mIndex = new MutableLiveData<>();
    //int[] newsBanners = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    //String newsBanners1[] = {R.drawable.news1, R.drawable.news2, R.drawable.news3, R.drawable.news4, R.drawable.news1, R.drawable.news2};
    Timestamp[] newsTimestamps = {
            new Timestamp(120, 9, 24, 16, 10, 25, 0),
            new Timestamp(120, 9, 24, 14, 48, 12, 0),
            new Timestamp(120, 9, 24, 11, 55, 48, 0),
            new Timestamp(120, 9, 23, 16, 41, 57, 0),
            new Timestamp(120, 9, 22, 18, 33, 34, 0)
    };
    String[] newsDateTimes = {
            "Yesterday",
            "Yesterday",
            "Yesterday",
            "2 days ago",
            "3 days ago"};
    String[] newsTopics = {"දැනුම්දීමයි.. !", "ධාවනය නොවේ.. !", "ධාවනය නොවේ.", "දැනුම්දීමයි..", "ප්\u200Dරමාදයි !"};
    String[] newsDescription = {"අද දින ධාවනය නොවේ..!\n" +
            "\n" +
            "ප.ව. 05/02 ට පානදුර සිට පැමිණ කොළඹ කොටුව දුම්රිය ස්ථානයෙන් ප.ව. 06/05 හලාවත දක්වා ධාවනය වන මුතුකුමාරි කාර්යාල දුම්රිය අද දින ධාවනය නොවේ.\n" +
            "\n" +
            "*ප.ව. 04/10 පානදුර සිට පැමිණ කොළඹ කොටුව දුම්රිය ස්ථානයෙන් ප.ව. 05/18 ට පුත්තලම දක්වා ධාවනය වන සීඝ්\u200Dරගාමී දුම්රිය අද දින කොළඹ කොටුව දුම්රිය ස්ථානයෙන් ප.ව.06/05 ගමන් ආරම්භ වේ.",
            "ප.ව. 02/35 ට කොළඹ කොටුව සිට හලාවත දක්වා ධාවනය වන දුම්රිය අද දින ධාවනය නොවන බව කරුණාවෙන් සලකන්න.\n" +
                    "\n" +
                    "කොළඹ කොටුව දුම්රිය ස්ථානය.",
            "දහවල් 12/40 ට හලාවත සිට කොළඹ කොටුව දක්වා ධාවනය වන මන්දගාමී දුම්රිය අද දින ධාවනය නොවන බව කරුණාවෙන් සලකන්න.\n" +
                    "\n" +
                    "හලාවත දුම්රිය ස්ථානය.",
            "ප.ව. 04/30 ට කොළඹ කොටුව සිට හලාවත දක්වා ධාවනය වන පාසල් විභාග සේවා විශේෂ දුම්රිය අද දින ප.ව. 05/30 ට කොළඹ කොටුව දුම්රිය ස්ථානයෙන් ගමන් ආරම්භ වේ.\n" +
                    "\n" +
                    "කොළඹ කොටුව දුම්රිය ස්ථානය.\n" +
                    "\n" +
                    "එම දුම්රිය කොළඹ කොටුව දුම්රිය ස්ථානයේ 01 වන වේදිකාවේ නවත්වා ඇත.",
            "ප.ව. 05/02 ට පානදුර සිට පැමිණ කොළඹ කොටුව දුම්රිය ස්ථානයෙන් ප.ව. 06/05 ට මීගමුව සහ හලාවත දක්වා ධාවනය වන මුතුකුමාරී කාර්යාල දුම්රිය විනාඩි 10 ක ප්\u200Dරමාදයක් සහිතව ධාවනය වේ.\n" +
                    "\n" +
                    "දෙමටගොඩ දුම්රිය ස්ථානයෙන් පිටත් වීම ප.ව. 06/26"};
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