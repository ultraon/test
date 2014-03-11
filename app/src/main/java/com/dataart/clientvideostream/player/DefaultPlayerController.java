package com.dataart.clientvideostream.player;

import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.widget.MediaController;
import android.widget.VideoView;

/**
 * Created by vpopov on 3/4/14.
 */
public class DefaultPlayerController implements IPlayerController {
    private static final String TAG =  DefaultPlayerController.class.getSimpleName();

    private boolean isPlayed;
    private VideoView vView;
    private Uri uri;

    @Override
    public void startPlay() {
        Log.d(TAG, "start playing");
        if (isPlayed) return;
        doPlay();
    }

    private void doPlay() {
        if (null != vView && null != uri) {
            //vView.setVideoPath();
            vView.setVideoURI(uri);
            vView.requestFocus();
            vView.start();
            isPlayed = true;
        }
    }

    private void doStop() {
        if (null != vView && vView.isPlaying()) {
            vView.stopPlayback();
        }
        isPlayed = false;
    }

    @Override
    public void stopPlay() {
        Log.d(TAG, "stop playing");
        if (!isPlayed) return;
        doStop();
    }

    @Override
    public boolean isPlaying() {
        return isPlayed;
    }

    public VideoView getvView() {
        return vView;
    }

    public void setvView(VideoView vView) {
        this.vView = vView;
        vView.setMediaController(new MediaController(vView.getContext()));
    }

    public Uri getUri() {
        return uri;
    }

    public void setUri(Uri uri) {
        this.uri = uri;
    }
}
