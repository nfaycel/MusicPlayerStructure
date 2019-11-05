package f.nouar.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class SongDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);
        TextView txtSongTitle = findViewById(R.id.songTitle);
        TextView txtSongAlbum = findViewById(R.id.songAlbum);
        TextView txtSongArtist = findViewById(R.id.songArtist);
        TextView currentPlayingTitle = findViewById(R.id.currentPlaying);

        currentPlayingTitle.setText("Playing: "+Song.playing_status[2]);
        txtSongTitle.setText(Song.playing_status[2]);
        txtSongAlbum.setText(Song.playing_status[1]);
        txtSongArtist.setText(Song.playing_status[0]);
        ImageView back_previous = findViewById(R.id.back_previous);
        back_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
