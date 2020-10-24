package com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui.CoastalLine;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.uee.rdmns_lk_redesigned.R;
import com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui.NotificationListAdapter;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    private ListView notificationListView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        galleryViewModel = new GalleryViewModel();

        notificationListView = root.findViewById(R.id.CoastalLineNotificationList);

        NotificationListAdapter customAdapter = new NotificationListAdapter(galleryViewModel.getListView(), this.getContext(), requireActivity());
        notificationListView.setAdapter(customAdapter);


        return root;
    }


}