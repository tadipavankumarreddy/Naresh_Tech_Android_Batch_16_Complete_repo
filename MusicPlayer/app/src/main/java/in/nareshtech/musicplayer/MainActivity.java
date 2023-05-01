package in.nareshtech.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /*private MediaPlayer player;*/

    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  player = MediaPlayer.create(this,R.raw.audio);*/

        i = new Intent(this, MusicService.class);
    }

    public void startMusic(View view) {
        // We should start the music here
        /*player.start();*/
        startService(i);
    }

    public void stopMusic(View view) {
        // we should stop the music here
        /*player.stop();*/
        stopService(i);
    }
}