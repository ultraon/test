package com.dataart.clientvideostream.ui;

import android.app.Activity;
import android.app.Fragment;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.VideoView;

import com.dataart.clientvideostream.player.DefaultPlayerController;
import com.dataart.clientvideostream.player.IPlayerController;
import com.dataart.clientvideostream.R;
import com.dataart.clientvideostream.player.PlayerFactory;

public class MainActivity extends Activity {
    private static final String TAG = MainActivity.class.getSimpleName();

    private IPlayerController player = PlayerFactory.newPlayer();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public void clickAction(View v) {
        Button btn = (Button) v;
        if (player.isPlaying()) {
            player.stopPlay();
            btn.setText(R.string.play);
        } else {
            ((DefaultPlayerController)player).setUri(getVideoUri());
            ((DefaultPlayerController)player).setvView(getVideoView());
            player.startPlay();
            btn.setText(R.string.stop);

        }
    }

    protected Uri getVideoUri() {
        String strUri = "http://www.pocketjourney.com/downloads/pj/video/famous.3gp"; //it works
        //String strUri = "android.resource://" + getPackageName() + "/" + R.raw.famous; //it works
        Log.d(TAG, "strUri: " + strUri);
        Uri uri = Uri.parse(strUri);
        return uri;
    }

    protected VideoView getVideoView() {
        return (VideoView) findViewById(R.id.videoView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            return rootView;
        }
    }

}
