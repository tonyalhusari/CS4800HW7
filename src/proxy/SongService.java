package proxy;

import java.util.List;

public interface SongService {
    Song searchById(int id);

    List<Song> searchByTitle(String title);

    List<Song> searchByAlbum(String album);

}
