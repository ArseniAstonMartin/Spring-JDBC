package org.arsenisf;

import org.arsenisf.Music;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class TestSpring {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        MusicPlayer musicPlayer2 = context.getBean("musicPlayer", MusicPlayer.class);

        System.out.println(musicPlayer==musicPlayer2);
        musicPlayer.setVolume(100);
        System.out.println(musicPlayer2.getVolume());
        context.close();
    }
}
