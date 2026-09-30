// Problem 2: The Playlist

class Playlist {

    private String[] songs;
    private int songCount;

    Playlist(int size) {
        songs = new String[size];
        songCount = 0;
    }

    void addSong(String song) {
        if (songCount < songs.length) {
            songs[songCount] = song;
            songCount++;
        }
    }

    String[] getSongs() {
        String[] copy = new String[songCount];

        for (int i = 0; i < songCount; i++) {
            copy[i] = songs[i];
        }

        return copy;
    }

    int getSongCount() {
        return songCount;
    }
}

public class Main {
    public static void main(String[] args) {

        Playlist p = new Playlist(10);

        p.addSong("Song A");
        p.addSong("Song B");

        String[] copy = p.getSongs();

        copy[0] = "Hacked";

        String[] songs = p.getSongs();

        System.out.println(songs[0]);
        System.out.println(songs[1]);
        System.out.println("Song Count: " + p.getSongCount());
    }
}
