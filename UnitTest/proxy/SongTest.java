package proxy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SongTest {
    @Test
    public void testSetSongId() {
        // Arrange
        Song song = new Song("Title", "Artist", "Album", 240);
        song.setSongId(123);

        int expected = 123;
        int actual = song.getSongId();

        // Assert
        assertEquals(expected, actual);
    }
    @Test
    void testGetTitle() {
        String expectedTitle = "Title";
        Song song = new Song("Title", "Artist", "Album", 240);
        String actualTitle = song.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }

    @Test
    void testGetAlbum() {
        String expectedAlbum = "Album";
        Song song = new Song("Title", "Artist", "Album", 240);
        String actualAlbum = song.getAlbum();
        assertEquals(expectedAlbum, actualAlbum);
    }

    @Test
    void testGetSongId() {
        int expectedId = 123;
        Song song = new Song("Title", "Artist", "Album", 240);
        song.setSongId(expectedId);
        int actualId = song.getSongId();
        assertEquals(expectedId, actualId);
    }

    @Test
    void testToString() {
        String expectedToString = "{songID=123, title='Title', artist='Artist', album='Album', duration=240}\n";
        Song song = new Song("Title", "Artist", "Album", 240);
        song.setSongId(123);
        String actualToString = song.toString();
        assertEquals(expectedToString, actualToString);
    }




}