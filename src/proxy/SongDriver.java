package proxy;

public class SongDriver {

    public static void main(String[] args) {
        RealSongService realServer = new RealSongService();
        SongService proxyServer = new ProxySongService(realServer);

        // create 10 songs and attempt to search them using the song service
        Song song1 = new Song("song1", "artist1", "album1", 100);
        Song song2 = new Song("song2", "artist2", "album1", 200);
        Song song3 = new Song("song3", "artist3", "album1", 300);
        Song song4 = new Song("song4", "artist4", "album4", 400);
        Song song5 = new Song("song5", "artist5", "album5", 500);
        Song song6 = new Song("song6", "artist6", "album6", 600);
        Song song7 = new Song("song7", "artist7", "album6", 700);
        Song song8 = new Song("song8", "artist8", "album9", 800);
        Song song9 = new Song("song9", "artist9", "album9", 900);
        Song song10 = new Song("song10", "artist10", "album9", 1000);
        realServer.addSong(song1);
        realServer.addSong(song2);
        realServer.addSong(song3);
        realServer.addSong(song4);
        realServer.addSong(song5);
        realServer.addSong(song6);
        realServer.addSong(song7);
        realServer.addSong(song8);
        realServer.addSong(song9);
        realServer.addSong(song10);

        //this should be fetched from the real service
        System.out.println(proxyServer.searchById(5));
        System.out.println("----------------------------------");

        //this should not be in the cache
        System.out.println(proxyServer.searchById(5));
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");


        // this should be fetched from the real service
        System.out.println(proxyServer.searchByTitle("song2"));
        System.out.println("----------------------------------");

        //this should not be in the cache
        System.out.println(proxyServer.searchByTitle("song2"));
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");

        Song song22 = new Song("song22", "artist22", "album22", 1100);
        realServer.addSong(song22);

        // song 2 should be in the cache, song 22 should be fetched from the real service
        System.out.println(proxyServer.searchByTitle("song2"));
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");


        // song 2 should be in the cache, song 2,3 should be fetched from the real service
        System.out.println(proxyServer.searchByAlbum("album1"));
        System.out.println("----------------------------------");
        System.out.println("----------------------------------");

        //song 1,2,3 now should be in the cache
        System.out.println(proxyServer.searchByAlbum("album1"));

    }

}
