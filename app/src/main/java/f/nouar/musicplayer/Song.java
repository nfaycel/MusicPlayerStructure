package f.nouar.musicplayer;

class Song {
    static String[] playing_status = {"", "", ""}; // current playing status: "Album, Artist, song title"
    private String Title;
    private int duration;
    private String Album;
    private String Artist;
    private String icon;

    public Song(String title, int duration, String album, String artist, String icon) {
        Title = title;
        this.duration = duration;
        Album = album;
        Artist = artist;
        this.icon = icon;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAlbum() {
        return Album;
    }

    public void setAlbum(String album) {
        Album = album;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }
}
