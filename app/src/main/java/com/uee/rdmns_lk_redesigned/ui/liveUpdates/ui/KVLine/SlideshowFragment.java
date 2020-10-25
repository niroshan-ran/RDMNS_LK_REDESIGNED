package com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui.KVLine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.uee.rdmns_lk_redesigned.R;
import com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui.NotificationListAdapter;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private ListView notificationListView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);


        slideshowViewModel = new SlideshowViewModel();

        notificationListView = root.findViewById(R.id.KVLineNotificationList);

        NotificationListAdapter customAdapter = new NotificationListAdapter(slideshowViewModel.getListView(), this.getContext(), requireActivity());
        notificationListView.setAdapter(customAdapter);

        return root;
    }
}