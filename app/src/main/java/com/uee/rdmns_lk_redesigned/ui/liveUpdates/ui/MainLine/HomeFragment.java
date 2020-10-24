package com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui.MainLine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.uee.rdmns_lk_redesigned.R;
import com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui.NotificationListAdapter;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private ListView notificationListView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        homeViewModel = new HomeViewModel();

        notificationListView = root.findViewById(R.id.MainLineNotificationList);

        NotificationListAdapter customAdapter = new NotificationListAdapter(homeViewModel.getListView(), this.getContext(), requireActivity());

        notificationListView.setAdapter(customAdapter);

        return root;
    }
}