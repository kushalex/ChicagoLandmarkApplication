package com.example.mp3_a1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LandmarkWebFragment extends Fragment {

    private WebView webView;
    private String webpage;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    // pass webpage to fragment
    // webView works in web_fragment id XML

    public static LandmarkWebFragment newInstance(String webpage) {

        Bundle args = new Bundle();
        args.putString("webpage", webpage);
        LandmarkWebFragment fragment = new LandmarkWebFragment();
        fragment.setArguments(args);
        return fragment;
    }

    // display WebView in application

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webview, container, false);
        webView = view.findViewById(R.id.fragmentWebView);
        webView.setWebViewClient(new WebViewClient());
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        Bundle args = getArguments();
        if (args != null) {
            webpage = args.getString("webpage");
            if (webpage != null) {
                webView.loadUrl(webpage);
            }
        }
        return view;
    }
}
