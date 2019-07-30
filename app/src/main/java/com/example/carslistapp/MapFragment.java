package com.example.carslistapp;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;


public class MapFragment extends Fragment {

    public MapFragment (){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_map, container, false);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        displayMap(getActivity().findViewById(R.id.webView));
        super.onActivityCreated(savedInstanceState);

    }

    public void displayMap(View view){
        WebView viewWeb = (WebView) getActivity().findViewById(R.id.webView);
        WebSettings webSettings = viewWeb.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setAllowUniversalAccessFromFileURLs(true);
        viewWeb.setWebViewClient(new WebViewClient());
        viewWeb.loadUrl("file:///android_asset/index.html");

    }

}
