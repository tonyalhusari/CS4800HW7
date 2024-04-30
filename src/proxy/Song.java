package proxy;

public class Song {
    private int songId;
    private final String title;
    private final String artist;
    private final String album;
    private final int duration;

    public Song(String title, String artist, String album, int duration) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public void setSongId(int id) {
        this.songId = id;
    }

    public int getSongId() {
        return songId;
    }

    public String getTitle() {
        return title;
    }

    public String getAlbum() {
        return album;
    }

    @Override
    public String toString() {
        return "{" +
                "songID=" + songId +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", album='" + album + '\'' +
                ", duration=" + duration +
                '}' + "\n";
    }


}
