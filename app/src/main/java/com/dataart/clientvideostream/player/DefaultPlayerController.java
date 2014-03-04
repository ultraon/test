package com.dataart.clientvideostream.player;

import android.media.MediaPlayer;
import android.util.Log;
import android.widget.VideoView;

/**
 * Created by vpopov on 3/4/14.
 */
public class DefaultPlayerController implements IPlayerController {
    private static final String TAG =  DefaultPlayerController.class.getSimpleName();

    private boolean isPlayed;

    private VideoView vView;

    @Override
    public void startPlay() {
        Log.d(TAG, "start playing");
        isPlayed = true;
    }

    private void doPlay() {
        if (null != vView) {
            //vView.setVideoPath();
        }
    }

    private void doStop() {

    }

    @Override
    public void stopPlay() {
        Log.d(TAG, "stop playing");
        isPlayed = false;
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
    }
}
