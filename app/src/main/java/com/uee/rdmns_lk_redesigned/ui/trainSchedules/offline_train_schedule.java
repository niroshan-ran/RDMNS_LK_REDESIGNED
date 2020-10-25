package com.uee.rdmns_lk_redesigned.ui.trainSchedules;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.net.http.SslError;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.uee.rdmns_lk_redesigned.R;

public class offline_train_schedule extends Fragment {
    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
            return inflater.inflate(R.layout.offline_train_schedule, container, false);
//        WebView webView = root.findViewById(R.id.offline_schedule_form);
//        webView.getSettings().setJavaScriptEnabled(true);
//        webView.getSettings().setDomStorageEnabled(true);
//        webView.setWebViewClient(new WebViewClient() {@Override public void onReceivedSslError(WebView v, SslErrorHandler handler, SslError er){ handler.proceed(); }});
////        webView.setWebViewClient(new WebViewClient());
//        webView.loadUrl("https://eservices.railway.gov.lk/");
//        return root;
    }
}
