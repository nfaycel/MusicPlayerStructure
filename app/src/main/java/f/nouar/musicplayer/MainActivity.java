package f.nouar.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView allSongs = findViewById(R.id.all_songs);
        final Intent list_All_Songs = new Intent(this, ListSongs.class);
        allSongs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list_All_Songs.putExtra("type","All the songs");
                startActivity(list_All_Songs);
            }
        });



        final Intent list_Type = new Intent(this, ListType.class);

        // call ListType with the list of the albums
        ImageView Albums_view = findViewById(R.id.albums);
        Albums_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list_Type.putExtra("type","albums");
                startActivity(list_Type);
            }
        });

        // call ListType with the list of the artists
        ImageView Artists_view = findViewById(R.id.artists);
        Artists_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list_Type.putExtra("type","artists");
                startActivity(list_Type);
            }
        });


    }
}
