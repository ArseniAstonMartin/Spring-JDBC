package org.arsenisf;

import org.arsenisf.Music;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Random;


@Component
@Scope("prototype")
public class MusicPlayer {
    private Music music1;
    private Music music2;
    @Value("${musicPlayer.name}")
    private String name;
    @Value("${musicPlayer.volume}")
    private int volume;

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public int getVolume() {
        return volume;
    }

    @Autowired
    public MusicPlayer(@Qualifier("rockMusic") Music music1,
                       @Qualifier("classicalMusic") Music music2) {
        this.music1 = music1;
        this.music2 = music2;
    }

    public String playMusic(Genre genre) {
        Random random = new Random();
        int randomNumber = random.nextInt(3);
        String music;
        if (genre == Genre.CLASSICAL) {
            music = ClassicalMusic.getSongs().get(randomNumber);
        }
        else if (genre == Genre.ROCK) {
            music = RockMusic.getSongs().get(randomNumber);
        }
        else music = "none";
        String res = "Playing: " + music;
        System.out.println(res);
        return res;
    }
}
