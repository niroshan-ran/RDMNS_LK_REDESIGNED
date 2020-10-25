package com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui.OtherLines;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.uee.rdmns_lk_redesigned.R;
import com.uee.rdmns_lk_redesigned.ui.liveUpdates.ui.NotificationListAdapter;

public class OtherFragment extends Fragment {

    private OtherViewModel mViewModel;
    private ListView notificationListView;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {


        View root = inflater.inflate(R.layout.other_fragment, container, false);

        mViewModel = new OtherViewModel();

        notificationListView = root.findViewById(R.id.OtherLineNotificationList);

        NotificationListAdapter customAdapter = new NotificationListAdapter(mViewModel.getListView(), this.getContext(), requireActivity());
        notificationListView.setAdapter(customAdapter);

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

}