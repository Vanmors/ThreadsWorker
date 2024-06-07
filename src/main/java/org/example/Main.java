package org.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> lines = new ArrayList<>();

        try {
            lines = Files.readAllLines(Paths.get("dialogue.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(lines);

        CharacterThread chandler = new CharacterThread("Chandler", scene);
        CharacterThread joey = new CharacterThread("Joey", scene);
        CharacterThread monica = new CharacterThread("Monica", scene);
        CharacterThread phoebe = new CharacterThread("Phoebe", scene);
        CharacterThread rachel = new CharacterThread("Rachel", scene);
        CharacterThread ross = new CharacterThread("Ross", scene);

        chandler.start();
        joey.start();
        monica.start();
        phoebe.start();
        rachel.start();
        ross.start();

        try {
            chandler.join();
            joey.join();
            monica.join();
            phoebe.join();
            rachel.join();
            ross.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
