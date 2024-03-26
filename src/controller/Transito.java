package controller;

import java.util.concurrent.Semaphore;

public class Transito extends Thread{
    int carro;
    String sentindo;
    Semaphore semaphore;

    public Transito(int x, Semaphore semaphore){
        this.carro = x;
        this.semaphore = semaphore;
        this.sentindo = "vazio";
    }
    public void run(){
        int x = carro%4;
        switch (x){
            case 1: this.sentindo = "Norte/Sul";break;
            case 2: this.sentindo = "Leste/Oeste";break;
            case 3: this.sentindo = "Sul/Norte";break;
            case 0: this.sentindo = "Oeste/Leste";break;
        }
        cruzarCruzamentos();
    }
    private void cruzarCruzamentos() {
        try {
            semaphore.acquire();
            System.out.println("Carro n°"+carro+" está atravessando "+sentindo);
            sleep(500);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            System.out.println("Carro n°"+carro+" terminou de atravesar "+sentindo);
            semaphore.release();
        }
    }
}
