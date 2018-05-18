package com.poojab26.jokejava;

import java.util.Random;

public class JokeSupplier {
    private final String jokes[] = {
            "A random joke ",
            "Another random joke ",
            "A third random joke ",
            "Joke joke joke ",
            "Joke jokitty joke joke joke"
    };
    public String getJoke(){
        Random rand = new Random();
        int value = rand.nextInt(jokes.length - 1);
        return jokes[value];
    }
}
