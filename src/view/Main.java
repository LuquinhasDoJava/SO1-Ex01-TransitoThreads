package view;

import controller.Transito;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(1);

        for(int x = 0; x<10; x++){
            Transito ts = new Transito(x,semaphore);
            ts.start();
        }
    }
}
