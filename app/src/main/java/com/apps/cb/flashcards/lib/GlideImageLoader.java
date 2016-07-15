package com.apps.cb.flashcards.lib;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

import com.apps.cb.flashcards.lib.base.ImageLoader;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class GlideImageLoader implements ImageLoader {
    private RequestManager glideRequestManager;

    public void setLoaderContext(Fragment fragment) {
        this.glideRequestManager = Glide.with(fragment);
    }

    public void setLoaderContext(Activity activity) {
        this.glideRequestManager = Glide.with(activity);
    }

    @Override
    public void load(ImageView imageView, String URL) {
        glideRequestManager
                .load(URL)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .override(800, 800)
                .centerCrop()
                .into(imageView);
    }
}