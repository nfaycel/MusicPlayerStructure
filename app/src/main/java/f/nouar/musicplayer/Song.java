package f.nouar.musicplayer;

class Song {
    private String Title;
    private int duration;
    private String Album;
    private String Artist;
    private String icon;
    static  String[] playing_status={"","",""}; // current playing status: "Album, Artist, song title"


    public Song(String title, int duration, String album, String artist, String icon) {
        Title = title;
        duration = duration;
        Album = album;
        Artist = artist;
        icon = icon;
    }

    public String getTitle() {
        return Title;
    }

    public int getDuration() {
        return duration;
    }

    public String getAlbum() {
        return Album;
    }

    public String getIcon() {
        return icon;
    }

    public String getArtist() {
        return Artist;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAlbum(String album) {
        Album = album;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public void setIcon(String icon) { this.icon = icon; }


}
