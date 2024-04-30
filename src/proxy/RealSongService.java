package proxy;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class RealSongService implements SongService {

    private final List<Song> songs;

    public RealSongService() {
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        // generate a unique ID starting at 1
        song.setSongId(songs.size() + 1);
        songs.add(song);
    }

    @Override
    public Song searchById(int id) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        // check to see if the song exists
        for (Song song : songs) {
            if (song.getSongId() == id) {
                return song;
            }
        }
        throw new NoSuchElementException("Song with ID " + id + " not found.");
    }

    @Override
    public List<Song> searchByTitle(String title) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getTitle().contains(title)) {
                result.add(song);
            }
        }
        return result;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
        }
        List<Song> result = new ArrayList<>();
        for (Song song : songs) {
            if (song.getAlbum().equals(album)) {
                result.add(song);
            }
        }
        return result;
    }
}
