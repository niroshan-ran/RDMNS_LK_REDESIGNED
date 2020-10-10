package com.uee.rdmns_lk_redesigned.ui.trainSchedules;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.uee.rdmns_lk_redesigned.R;

public class online_train_schedule extends Fragment {

    public static ProgressDialog progDailog;
    String url = "http://eservices.railway.gov.lk/schedule/searchTrain/";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.online_train_schedule, container, false);
        WebView webView = root.findViewById(R.id.online_schedule_form);

//        progDailog = new ProgressDialog(getActivity());

//        webView.setWebViewClient(new Mybrowser(progDailog));
        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
        //progDailog.hide();

        return root;
    }


    public class Mybrowser extends WebViewClient {
        ProgressDialog pd;
        public Mybrowser(ProgressDialog pd) {
            this.pd = pd;
            pd.show(getContext(), "Loading","Please wait...", true);
        }
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return super.shouldOverrideUrlLoading(view, url);
        }
        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            if (pd.isShowing()) {
                pd.dismiss();
            }
        }
        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            Toast.makeText(getActivity(),"Error:" + description, Toast.LENGTH_SHORT).show();

        }
    }

}
