package f.nouar.musicplayer;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {

    public SongAdapter( Activity context, ArrayList<Song> songs) {
        super(context, 0,songs);
    }
    @Override
    public View getView(int position,  View convertView,  ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.song_item, parent, false);
        }
        Song currentSong = getItem(position);
        TextView song_title = listItemView.findViewById(R.id.song_title);
        song_title.setText(currentSong.getTitle());
        // set the duration value
        TextView song_duration = listItemView.findViewById(R.id.song_duration);
        song_duration.setText(Integer.toString(currentSong.getDuration()));
        // set the Album title
        TextView song_album = listItemView.findViewById(R.id.song_album);
        song_album.setText(currentSong.getAlbum()+ " | "+currentSong.getArtist());
        return listItemView;
    }
}
