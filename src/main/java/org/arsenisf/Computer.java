package org.arsenisf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Neil Alishev
 */
@Component
public class Computer {
    private int id;
    private MusicPlayer musicPlayer;

    @Autowired
    public Computer(MusicPlayer musicPlayer) {
        this.id = 1;
        this.musicPlayer = musicPlayer;
    }

    public String toString(Genre genre) {
        return "Computer " + id + " " + musicPlayer.playMusic(genre);
    }
}