package com.uee.rdmns_lk_redesigned;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class ViewFoundItemFragment extends Fragment {

    TextView textTitle;
    TextView textDetails;
    Button btnBack;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        String title;
        String details ;

        View view = inflater.inflate(R.layout.view_found_item_fragment, container, false);

        title = getArguments().getString("title");
        details = getArguments().getString("details");


        textTitle = view.findViewById(R.id.txtTitle);
        textDetails = view.findViewById(R.id.txtDetails);
        btnBack = view.findViewById(R.id.btnBack);

        textTitle.setText(title);
        textDetails.setText(details);

        return view;//inflater.inflate(R.layout.fragment_lost,container,false);
    }

    @Override
    public void onResume() {
        super.onResume();
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FoundFragment ldf = new FoundFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_main, ldf);
                fragmentTransaction.commit();
            }
        });
    }
}
