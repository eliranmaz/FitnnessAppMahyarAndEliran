package com.example.userregister;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.PlayerConstants;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

public class YoutubeMainActivity extends AppCompatActivity {
    String video_id;
    String Eqp_name_video;
    String video_level;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_main);
        Button finish_button=findViewById(R.id.button_Finish);
        SharedPreferences sharedPreferencesReg = getSharedPreferences("youtube", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferencesReg.edit();
        video_id=sharedPreferencesReg.getString("video_link","");
        editor.putString("video_link","");
        editor.apply();
        SharedPreferences sharedPreferencesReg1 = getSharedPreferences("LevelActive", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor1 = sharedPreferencesReg1.edit();
        Eqp_name_video=sharedPreferencesReg1.getString("video_eqp","");
        video_level=sharedPreferencesReg1.getString("video_level","");
        finish_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferencesReg1 = getSharedPreferences("LevelActive", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor1 = sharedPreferencesReg1.edit();
                String corect_level;
                if (Eqp_name_video.equals("Weights")){
                    int r = Integer.parseInt(video_level);
                    r=r+1;
                    corect_level=String.valueOf(r);
                    editor1.putString("LevelWheights",corect_level);

                }
                if (Eqp_name_video.equals("Jumprope")){
                    int r = Integer.parseInt(video_level);
                    r=r+1;
                    corect_level=String.valueOf(r);
                    editor1.putString("LevelJumprope",corect_level);
                }
                if (Eqp_name_video.equals("step")){
                    int r = Integer.parseInt(video_level);
                    r=r+1;
                    corect_level=String.valueOf(r);
                    editor1.putString("Levelstep",corect_level);
                }
                if (Eqp_name_video.equals("Fitness sofa")){
                    int r = Integer.parseInt(video_level);
                    r=r+1;
                    corect_level=String.valueOf(r);
                    editor1.putString("LevelFitness",corect_level);
                }
                if (Eqp_name_video.equals("mattress")){
                    int r = Integer.parseInt(video_level);
                    r=r+1;
                    corect_level=String.valueOf(r);
                    editor1.putString("Levelmattress",corect_level);
                }
                if (Eqp_name_video.equals("treadmill")){
                    int r = Integer.parseInt(video_level);
                    r=r+1;
                    corect_level=String.valueOf(r);
                    editor1.putString("Leveltreadmill",corect_level);
                }
                editor1.apply();
                Intent intent = new Intent(YoutubeMainActivity.this,ChooseEquipmentActivity.class);
                startActivity(intent);

            }
        });




        // below two lines are used to set our
        // screen orientation in landscape mode.
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);



        // below line of code is
        // to hide our action bar.
        getSupportActionBar().hide();

        // declaring variable for youtubeplayer view
        final YouTubePlayerView youTubePlayerView = findViewById(R.id.videoPlayer);

        // below line is to place your youtube player in a full screen mode (i.e landscape mode)
        //youTubePlayerView.enterFullScreen();
        //youTubePlayerView.toggleFullScreen();

        // here we are adding observer to our youtubeplayerview.
        getLifecycle().addObserver(youTubePlayerView);


        // adding listener for our youtube player view.
        youTubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                // loading the selected video into the YouTube Player
                youTubePlayer.loadVideo(video_id, 0);
            }

            @Override
            public void onStateChange(@NonNull YouTubePlayer youTubePlayer,
                                      @NonNull PlayerConstants.PlayerState state) {
                // this method is called if video has ended,
                super.onStateChange(youTubePlayer, state);
            }

        });
    }
    public void goToFitnessSofaActivity(View view){
        Intent intent = new Intent(this,ChooseEquipmentActivity.class);
        startActivity(intent);

    }
}
