package proxy;

import java.util.ArrayList;
import java.util.List;

public class ProxySongService implements SongService {
    private final SongService realService;
    private final List<Song> cache;

    public List<Song> getCache() {
        return cache;
    }

    public ProxySongService(SongService realService) {
        this.realService = realService;
        this.cache = new ArrayList<>();
    }

    @Override
    public Song searchById(int songID) {
        for (Song song : cache) {
            if (song.getSongId() == songID) {
                System.out.println("Retrieving song metadata for " + song.getTitle() + " from cache.");
                return song;
            }
        }
        // if song is not in cache, fetch it from the real service
        Song song = realService.searchById(songID);
        if (song != null) {
            cache.add(song);
            System.out.println("Fetched and cached song metadata for " + song.getTitle() + " from real service.");
        }
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        List<Song> result = new ArrayList<>();
        for (Song song : cache) {
            if (song.getTitle().contains(title)) {
                result.add(song);
                System.out.println("Retrieving song metadata for " + song.getTitle() + " from cache.");
            }
        }

        List<Song> additionalSongs = new ArrayList<>();
        List<Song> songsFromServer = realService.searchByTitle(title);
        for (Song song : songsFromServer) {
            if (!cache.contains(song)) {
                additionalSongs.add(song);
                cache.add(song);
                System.out.println("Fetched and cached song metadata for title \"" + song.getTitle() + "\" from the server.");
            }
        }

        result.addAll(additionalSongs);
        return result;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        List<Song> result = new ArrayList<>();
        for (Song song : cache) {
            if (song.getAlbum().equals(album)) {
                result.add(song);
                System.out.println("Retrieving song metadata for " + song.getTitle() + " from cache.");
            }
        }

        List<Song> additionalSongs = new ArrayList<>();
        List<Song> songsFromServer = realService.searchByAlbum(album);
        for (Song song : songsFromServer) {
            if (!cache.contains(song)) {
                additionalSongs.add(song);
                cache.add(song);
                System.out.println("Fetched and cached song metadata for album \"" + album + "\" from the server.");
            }
        }
        result.addAll(additionalSongs);
        return result;
    }
}
