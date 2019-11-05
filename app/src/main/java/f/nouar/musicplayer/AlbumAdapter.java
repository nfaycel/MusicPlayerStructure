package f.nouar.musicplayer;


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;

public class AlbumAdapter extends ArrayAdapter<Song> {
    public AlbumAdapter(Activity context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.album_item, parent, false);
        }
        Song currentAlbum = getItem(position);
        TextView album_title = listItemView.findViewById(R.id.album_title);
        album_title.setText(currentAlbum.getAlbum());
        // set the Album title
        TextView album_artist = listItemView.findViewById(R.id.album_artist);
        album_artist.setText(currentAlbum.getArtist());
        // Set the icon
        ImageView icon = listItemView.findViewById(R.id.song_icon);
        icon.setImageResource(R.drawable.album_rect);
        return listItemView;
    }
}
