package org.arsenisf;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class ClassicalMusic implements Music {
    private final static List<String> songs = Arrays.asList("Requiem of souls", "Moonlight sonata", "Hungarian Rhapsody");

    public static List<String> getSongs() {
        return songs;
    }
    private String song;

    public String getSong() {
        return song;
    }
}
