package f.nouar.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import static f.nouar.musicplayer.Song.playing_status;

// List of songs depends on the caller activity "all songs", "songs of specific album" and "songs of specific artists"
public class ListSongs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_songs);

        TextView typeOfList = findViewById(R.id.title_songsList);
        Intent intent = getIntent();
        typeOfList.setText(intent.getStringExtra("type"));

        ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Title1", 0, "Album1", "Artist1", "all_music2"));
        songs.add(new Song("Title2", 0, "Album1", "Artist1", "all_music2"));
        songs.add(new Song("Title3", 0, "Album1", "Artist1", "all_music2"));
        songs.add(new Song("Title1", 0, "Album2", "Artist2", "all_music2"));
        songs.add(new Song("Title2", 0, "Album2", "Artist2", "all_music2"));
        songs.add(new Song("Title1", 0, "Album3", "Artist3", "all_music2"));
        songs.add(new Song("Title2", 0, "Album3", "Artist3", "all_music2"));
        songs.add(new Song("Title1", 0, "Album4", "Artist4", "all_music2"));

        final ListView listView = findViewById(R.id.list);


        String filter = intent.getStringExtra("filter");


        if (filter != null && !filter.isEmpty()) {
            Log.i("the filter equal =", filter);
            if (filter.contains("Album")) {
                ArrayList<Song> songsOfAlbum = new ArrayList<Song>();
                for (Song song : songs) {
                    if (song.getAlbum().equals(filter))
                        songsOfAlbum.add(song);
                }
                SongAdapter adapter = new SongAdapter(this, songsOfAlbum);
                listView.setAdapter(adapter);
                Log.i("filter=" + filter, Boolean.toString(filter.contains("Album")));
            } else if (filter.contains("Artist")) {
                ArrayList<Song> songsOfArtist = new ArrayList<Song>();
                for (Song song : songs) {
                    if (song.getArtist().equals(filter))
                        songsOfArtist.add(song);
                }
                SongAdapter adapter = new SongAdapter(this, songsOfArtist);
                listView.setAdapter(adapter);
                Log.i("filter=" + filter, Boolean.toString(filter.contains("Artist")));
            }
        } else {
            SongAdapter adapter = new SongAdapter(this, songs);
            listView.setAdapter(adapter);
        }


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("song clicked position:", Integer.toString(position));
                Song msong = (Song) parent.getItemAtPosition(position);
                playing_status[0]=msong.getAlbum();
                playing_status[1]=msong.getArtist();
                playing_status[2]=msong.getTitle();
                Log.i("status:",playing_status[0]+" "+playing_status[1]+" "+playing_status[2]);

            }
        });

        ImageView back_previous = findViewById(R.id.back_previous);
        back_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
