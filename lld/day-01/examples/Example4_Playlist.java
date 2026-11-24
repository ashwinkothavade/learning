// WORKED LLD EXAMPLE: Playlist with rules. Shows: private state, rules in methods, no leaking the inner list,
// all-or-nothing failure. Run: java Example4_Playlist.java
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Example4_Playlist {
    static final class Playlist {
        private static final int MAX = 3;                       // RULES: no duplicates, at most MAX songs
        private final List<String> songs = new ArrayList<>();

        void add(String song) {
            if (song == null || song.isBlank()) throw new IllegalArgumentException("song name required");
            if (songs.contains(song)) throw new IllegalStateException("duplicate: " + song);
            if (songs.size() >= MAX) throw new IllegalStateException("playlist full");
            songs.add(song);
        }
        /** returns a read-only view so callers cannot break the rules */
        List<String> view() { return Collections.unmodifiableList(songs); }
    }

    public static void main(String[] args) {
        Playlist p = new Playlist();
        p.add("A"); p.add("B"); p.add("C");
        System.out.println("songs: " + p.view());
        try { p.add("D"); } catch (IllegalStateException e) { System.out.println("rejected: " + e.getMessage()); }
        try { p.view().add("sneaky"); } catch (UnsupportedOperationException e) { System.out.println("cannot bypass rules through the view"); }
        System.out.println("final: " + p.view());
    }
}
