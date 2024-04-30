package proxy;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RealSongServiceTest {

    @Test
    void testAddSong() {
        RealSongService songService = new RealSongService();
        Song song1 = new Song("Title1", "Artist1", "Album1", 240);
        Song song2 = new Song("Title2", "Artist2", "Album2", 240);

        songService.addSong(song1);
        songService.addSong(song2);

        assertEquals(1, song1.getSongId());
        assertEquals(2, song2.getSongId());
    }

    @Test
    void testSearchById() {
        RealSongService songService = new RealSongService();
        Song song1 = new Song("Title1", "Artist1", "Album1", 240);
        Song song2 = new Song("Title2", "Artist2", "Album2", 240);

        songService.addSong(song1);
        songService.addSong(song2);

        assertEquals(song1, songService.searchById(1));
        assertEquals(song2, songService.searchById(2));
    }

    @Test
    void testSearchById_NotFound() {
        RealSongService songService = new RealSongService();
        assertThrows(NoSuchElementException.class, () -> songService.searchById(1));
    }

    @Test
    void testSearchByTitle() {
        RealSongService songService = new RealSongService();
        Song song1 = new Song("Title1", "Artist1", "Album1", 240);
        Song song2 = new Song("Title2", "Artist2", "Album2", 240);
        Song song3 = new Song("Hello", "Artist3", "Album3", 240);

        songService.addSong(song1);
        songService.addSong(song2);
        songService.addSong(song3);

        List<Song> result = songService.searchByTitle("Title");
        assertEquals(2, result.size());
        assertTrue(result.contains(song1));
        assertTrue(result.contains(song2));
    }

    @Test
    void testSearchByAlbum() {
        RealSongService songService = new RealSongService();
        Song song1 = new Song("Title1", "Artist1", "Album1", 240);
        Song song2 = new Song("Title2", "Artist2", "Album2", 240);
        Song song3 = new Song("AnotherTitle", "Artist3", "Album1", 240);

        songService.addSong(song1);
        songService.addSong(song2);
        songService.addSong(song3);

        List<Song> result = songService.searchByAlbum("Album1");
        assertEquals(2, result.size());
        assertTrue(result.contains(song1));
        assertTrue(result.contains(song3));
    }
}