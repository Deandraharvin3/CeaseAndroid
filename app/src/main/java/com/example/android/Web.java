package com.example.android;

import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web {
    private String startWeb, endWeb;

    public String getStartWeb() {
        return startWeb;
    }

    public void setStartWeb(String startWeb) {
        this.startWeb = startWeb;
    }

    public String getEndWeb() {
        return endWeb;
    }

    public void setEndWeb(String endWeb) {
        this.endWeb = endWeb;
    }

    public void showWeb(WebView site) {
        site.getSettings().setLoadsImagesAutomatically(true);
        site.getSettings().setJavaScriptEnabled(true);
        site.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        // Configure the client to use when opening URLs
        site.setWebViewClient(new WebViewClient());
        // Load the initial URL
        site.loadUrl(getStartWeb());
        // Enable responsive layout
        site.getSettings().setUseWideViewPort(true);
// Zoom out if the content width is greater than the width of the viewport
        site.getSettings().setLoadWithOverviewMode(true);
        site.getSettings().setSupportZoom(true);
        site.getSettings().setBuiltInZoomControls(true); // allow pinch to zoom
        site.getSettings().setDisplayZoomControls(false);
    }

}
