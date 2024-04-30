package proxy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProxySongServiceTest {

    @Test
    void testSearchById_FromCache() {
        RealSongService realService = new RealSongService();
        ProxySongService proxyService = new ProxySongService(realService);

        Song song1 = new Song("song1", "artist1", "album1", 100);
        proxyService.getCache().add(song1);

        song1.setSongId(1);
        proxyService.getCache().add(song1);

        Song expected = song1;
        Song actual = proxyService.searchById(1);

        assertEquals(expected, actual);
    }

    @Test
    void testSearchById_FromRealService() {
        RealSongService realService = new RealSongService();
        ProxySongService proxyService = new ProxySongService(realService);
        Song songFromRealService = new Song("Title2", "Artist2", "Album2", 240);

        realService.addSong(songFromRealService);
        Song expected = songFromRealService;
        Song actual = proxyService.searchById(1);

        assertEquals(expected, actual);
    }

    @Test
    void testSearchByTitle_FromCache() {
        RealSongService realService = new RealSongService();
        ProxySongService proxyService = new ProxySongService(realService);
        Song cachedSong1 = new Song("Title1", "Artist1", "Album1", 240);
        Song cachedSong2 = new Song("Title2", "Artist2", "Album2", 240);

        realService.addSong(cachedSong1);
        realService.addSong(cachedSong2);

        proxyService.getCache().add(cachedSong1);
        proxyService.getCache().add(cachedSong2);

        List<Song> expected = Arrays.asList(cachedSong1, cachedSong2);
        List<Song> actual = proxyService.searchByTitle("Title");

        assertEquals(expected, actual);
    }

    @Test
    void testSearchByTitle_FromRealService() {
        RealSongService realService = new RealSongService();
        ProxySongService proxyService = new ProxySongService(realService);
        Song songFromRealService1 = new Song("Title1", "Artist1", "Album1", 240);
        Song songFromRealService2 = new Song("Title2", "Artist2", "Album2", 240);

        realService.addSong(songFromRealService1);
        realService.addSong(songFromRealService2);

        List<Song> expected = Arrays.asList(songFromRealService1, songFromRealService2);
        List<Song> actual = proxyService.searchByTitle("Title");

        assertEquals(expected, actual);
    }

    @Test
    void testSearchByAlbum_FromCache() {
        RealSongService realService = new RealSongService();
        ProxySongService proxyService = new ProxySongService(realService);

        Song cachedSong1 = new Song("Title1", "Artist1", "Album1", 240);
        Song cachedSong2 = new Song("Title2", "Artist2", "Album1", 240);

        realService.addSong(cachedSong1);
        realService.addSong(cachedSong2);

        proxyService.getCache().add(cachedSong1);
        proxyService.getCache().add(cachedSong2);

        List<Song> expected = Arrays.asList(cachedSong1, cachedSong2);
        List<Song> actual = proxyService.searchByAlbum("Album1");

        assertEquals(expected, actual);
    }

    @Test
    void testSearchByAlbum_FromRealService() {
        RealSongService realService = new RealSongService();
        ProxySongService proxyService = new ProxySongService(realService);
        Song songFromRealService1 = new Song("Title1", "Artist1", "Album1", 240);
        Song songFromRealService2 = new Song("Title2", "Artist2", "Album1", 240);

        realService.addSong(songFromRealService1);
        realService.addSong(songFromRealService2);

        List<Song> expected = Arrays.asList(songFromRealService1, songFromRealService2);
        List<Song> actual = proxyService.searchByAlbum("Album1");

        assertEquals(expected, actual);
    }


}