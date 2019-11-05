package f.nouar.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

// Activity for group type "Albums" or "Artists"
public class ListType extends AppCompatActivity {
    String type;
    ArrayList<Song> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_type);

        TextView title_songsList = findViewById(R.id.title_songsList);

        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        title_songsList.setText(type + " List");

        songs = new ArrayList<Song>();
        songs.add(new Song("Title1", 0, "Album1", "Artist1", "album1"));
        songs.add(new Song("Title1", 0, "Album2", "Artist2", "album1"));
        songs.add(new Song("Title1", 0, "Album3", "Artist1", "album1"));


        final AlbumAdapter adapter = new AlbumAdapter(this, songs);
        ListView listView = findViewById(R.id.list_album);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent list_All_Songs = new Intent(getApplicationContext(), ListSongs.class);
                list_All_Songs.putExtra("type", "Songs of the "+type.substring(0,type.length()-1)+" "+(position+1));
                if (type.equals("albums")) {
                    list_All_Songs.putExtra("filter", adapter.getItem(position).getAlbum());
                    Log.i("xxx: ", (adapter.getItem(position).getAlbum()));
                }
                else if (type.equals("artists")) {
                    list_All_Songs.putExtra("filter", adapter.getItem(position).getArtist());
                    Log.i("xxx: ", (adapter.getItem(position).getArtist()));
                }

                startActivity(list_All_Songs);
            }
        });
        listView.setAdapter(adapter);

        Log.i("the type is: Albums: ", type);
    }
}
