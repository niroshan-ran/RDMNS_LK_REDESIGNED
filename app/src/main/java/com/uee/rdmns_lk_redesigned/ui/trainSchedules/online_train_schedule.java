package com.uee.rdmns_lk_redesigned.ui.trainSchedules;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.uee.rdmns_lk_redesigned.R;

public class online_train_schedule extends Fragment {

    private ProgressDialog progDailog;
    Activity activity;

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        progDailog = ProgressDialog.show(getContext(), "Loading","Please wait...", true);
        progDailog.setCancelable(false);

        View root = inflater.inflate(R.layout.online_train_schedule, container, false);
        WebView webView = root.findViewById(R.id.online_schedule_form);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                progDailog.show();
                view.loadUrl(url);

                return true;
            }
            @Override
            public void onPageFinished(WebView view, final String url) {
                progDailog.dismiss();
            }
        });

        webView.loadUrl("https://eservices.railway.gov.lk/schedule/searchTrain/");


//        webView.setWebViewClient(new WebViewClient());
//        webView.loadUrl("https://eservices.railway.gov.lk/schedule/searchTrain/");
        return root;
    }
}
