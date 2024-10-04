package org.arsenisf;

import org.arsenisf.Music;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;


@Component("rockMusic")
public class RockMusic implements Music {
    private final static List<String> songs = Arrays.asList("Wind cries Mary", "Bring me", "Principles");

    public static List<String> getSongs() {
        return songs;
    }

    private String song;

    @Override
    public String getSong() {
        return song;
    }
}
