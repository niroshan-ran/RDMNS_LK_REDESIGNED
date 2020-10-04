package com.uee.rdmns_lk_redesigned;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AddFoundFragment extends Fragment {

    Button btnSubmit;
    EditText editTitle,editDetails;

    public static LostFoundDBHelper sqLiteHelper;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_add_found, container, false);
        sqLiteHelper = new LostFoundDBHelper(this.getContext(),"LiteUP.db",null,1);
        sqLiteHelper.queryData("CREATE TABLE IF NOT EXISTS FOUND (id INTEGER PRIMARY KEY AUTOINCREMENT,title VARCHAR,details VARCHAR) ");

        btnSubmit = view.findViewById(R.id.btnSubmit);
        editTitle = view.findViewById(R.id.editTitle);
        editDetails = view.findViewById(R.id.editDetails);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String title = editTitle.getText().toString();
                String details =  editDetails.getText().toString();

                if(title.isEmpty()){
                    editTitle.setError("This field cannot be empty");
                }
                else if(details.isEmpty()){
                    editDetails.setError("This field cannot be empty");
                }
                else {
                    try {
                        sqLiteHelper.insertFound(
                                editTitle.getText().toString().trim(),
                                editDetails.getText().toString().trim()
                        );

                        Toast.makeText(getContext(), "Details Submitted !", Toast.LENGTH_SHORT).show();
                        editDetails.setText("");
                        editTitle.setText("");

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }
}
