package org.arsenisf;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("org.arsenisf")
@PropertySource("classpath:musicPlayer.properties")
public class Config {

}
