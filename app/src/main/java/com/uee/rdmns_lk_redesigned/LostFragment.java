package com.uee.rdmns_lk_redesigned;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class LostFragment  extends Fragment {

    GridView gridView;
    ArrayList<LostModel> list;
    LostAdapter adapter = null;
    Button btnAdd;
    int position;

    public static LostFoundDBHelper sqLiteHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lost, container, false);
        gridView = (GridView) view.findViewById(R.id.gridView);
        btnAdd = view.findViewById(R.id.btnAdd);
        list = new ArrayList<>();
        adapter = new LostAdapter(this.getContext(), R.layout.lost_item,list);
        gridView.setAdapter(adapter);

        /*LostModel obj = new LostModel(1,"Lost Phone","A Samsung S20 was lost");
        LostModel obj2 = new LostModel(1,"Lost Bag","A Samsung S20 was lost");
        LostModel obj3 = new LostModel(1,"Lost Purse","A Samsung S20 was lost");

        list.add(obj);
        list.add(obj2);
        list.add(obj3);*/

        sqLiteHelper = new LostFoundDBHelper(this.getContext(),"LiteUP.db",null,1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS LOST (id INTEGER PRIMARY KEY AUTOINCREMENT,title VARCHAR,details VARCHAR) ");


        Cursor cursor = sqLiteHelper.getLost("SELECT * FROM LOST ORDER BY ID DESC");
        list.clear();
        while(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String title =  cursor.getString(1);
            String details = cursor.getString(2);

            list.add(new LostModel(id,title,details));
        }
        adapter.notifyDataSetChanged();

        return view;//inflater.inflate(R.layout.fragment_lost,container,false);
    }

    @Override
    public void onResume() {
        super.onResume();
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textViewItem = ((TextView) view.findViewById(R.id.txtTitle));
                TextView textViewDetail = ((TextView) view.findViewById(R.id.txtDetail));

                ViewLostItemFragment ldf = new ViewLostItemFragment ();
                Bundle args = new Bundle();

                String test = (String) textViewItem.getText();

                args.putString("title", (String) textViewItem.getText());
                args.putString("details", (String) textViewDetail.getText());
                ldf.setArguments(args);


                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_main, ldf);
                fragmentTransaction.commit();
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AddLostFragment ldf = new AddLostFragment();
                FragmentManager fragmentManager = getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_main, ldf);
                fragmentTransaction.commit();
            }
        });

    }
}
