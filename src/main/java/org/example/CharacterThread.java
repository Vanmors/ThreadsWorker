package org.example;

public class CharacterThread extends Thread {
    private final String name;
    private final Scene scene;

    public CharacterThread(String name, Scene scene) {
        this.name = name;
        this.scene = scene;
    }

    @Override
    public void run() {
        while (!scene.isFinished()) {
            scene.printLine(name);
        }
    }
}