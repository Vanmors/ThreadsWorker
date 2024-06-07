package org.example;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class Scene {
    private final List<String> lines;
    private int currentLine = 0;
    private final ReentrantLock lock = new ReentrantLock();
    private boolean isFinished = false;

    public Scene(List<String> lines) {
        this.lines = lines;
    }

    public void printLine(String character) {
        lock.lock();
        try {
            while (currentLine < lines.size()) {
                if (lines.get(currentLine).startsWith(character + ":")) {
                    System.out.println(lines.get(currentLine));
                    currentLine++;
                    if (currentLine >= lines.size()) {
                        isFinished = true;
                    }
                    return;
                } else {
                    lock.unlock();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    lock.lock();
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public boolean isFinished() {
        return isFinished;
    }
}
