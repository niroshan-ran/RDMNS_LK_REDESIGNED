package com.uee.rdmns_lk_redesigned.ui.trainSchedules;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

import com.uee.rdmns_lk_redesigned.R;

public class online_train_schedule extends Fragment {

    Activity activity ;
    private ProgressDialog progDailog;
    String url = "https://eservices.railway.gov.lk/schedule/";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.online_train_schedule, container, false);
        WebView webView = root.findViewById(R.id.online_schedule_form);


//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setLoadWithOverviewMode(true);
//        webView.getSettings().setUseWideViewPort(true);
//        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
//        webView.loadUrl(url);
        activity = this.getActivity();

        progDailog = ProgressDialog.show(activity, "Loading","Please wait...", true);
        progDailog.setCancelable(false);



//        WebSettings settings = webView.getSettings();
//        settings.setJavaScriptEnabled(true);
//        settings.setAllowContentAccess(true);
//        settings.setDomStorageEnabled(true);

        webView.getSettings().setAppCacheEnabled(true);

        webView.getSettings().setLoadsImagesAutomatically(true);




//        webView.setWebViewClient(new WebViewClient(){
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                progDailog.show();
//                view.loadUrl(url);
//
//                return true;
//            }
//            @Override
//            public void onPageFinished(WebView view, final String url) {
//                progDailog.dismiss();
//            }
//        });

        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
//        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDomStorageEnabled(true);
//        webView.getSettings().setLoadWithOverviewMode(true);
//        webView.getSettings().setUseWideViewPort(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        webView.setWebViewClient(
                new SSLTolerentWebViewClient()
        );

        webView.loadUrl("https://eservices.railway.gov.lk/schedule/searchTrain.action?lang=si");
        progDailog.dismiss();

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


    private class SSLTolerentWebViewClient extends WebViewClient {

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // Ignore SSL certificate errors
        }

    }
}
