package com.uee.rdmns_lk_redesigned;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class LostFragment  extends Fragment {

    GridView gridView;
    ArrayList<LostModel> list;
    LostAdapter adapter = null;
    int position;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lost, container, false);
        gridView = (GridView) view.findViewById(R.id.gridView);
        list = new ArrayList<>();
        adapter = new LostAdapter(this.getContext(), R.layout.lost_item,list);
        gridView.setAdapter(adapter);

        LostModel obj = new LostModel(1,"Lost Phone","A Samsung S20 was lost");
        LostModel obj2 = new LostModel(1,"Lost Bag","A Samsung S20 was lost");
        LostModel obj3 = new LostModel(1,"Lost Purse","A Samsung S20 was lost");

        list.add(obj);
        list.add(obj2);
        list.add(obj3);

        adapter.notifyDataSetChanged();
        return view;//inflater.inflate(R.layout.fragment_lost,container,false);
    }

}
