package com.poojab26.jokejava;

import java.util.Random;

public class JokeSupplier {
    private final String jokes[] = {
            "Some things Man was never meant to know. For everything else, there’s Google.",
            "In order to understand recursion, you must first understand recursion. ",
            "There's a band called 1023MB. They haven't had any gigs yet.",
            "An SQL Query walks into a bar and sees two tables. He walks up and asks, 'Can I join you?' ",
            "There are only 10 types of people in the world: those that understand binary and those that don’t."
    };
    public String getJoke(){
        Random rand = new Random();
        int value = rand.nextInt(jokes.length - 1);
        return jokes[value];
    }
}
