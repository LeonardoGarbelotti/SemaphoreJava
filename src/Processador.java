
import java.util.*;
import java.util.concurrent.Semaphore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1511 IRON
 */
public class Processador extends Thread {
    Fila buffer;
    public int idProcesso;
    public Semaphore semaforo;
    public int tipo;

    public Processador(int id, Semaphore semaphore, Fila fila, int tipo) {
        this.idProcesso = id;
        this.semaforo = semaphore;
        buffer = fila;
        this.tipo = tipo;
    }

    public void ProcessoInserir() {
        int aux = 0;
        try {
            // Thread.sleep((long)(Math.random()*1000));
        } catch(Exception e) {
            
        } finally {
            int verificar;
            while(aux<10){
                verificar = buffer.Inserir();
                if(verificar!=0) System.out.println("Processo "+idProcesso+" inseriu na fila");
                else System.out.println("Processo " + idProcesso + " não conseguiu inserir na fila");
                aux++;
            }
        }
    }

    public void ProcessoConsumir() {
        int aux = 0;
        try{
           // Thread.sleep((long)(Math.random()*1000));
        } catch(Exception e) {
        } finally {
            int verificar;
            while(aux<10){
                verificar = buffer.retirar();
                if(verificar!=0) System.out.println("Processo " + idProcesso + " excluiu da fila");
                else System.out.println("Processo " + idProcesso + " não excluiu da fila");
                aux++;
            }
        }
        
    }

    public void run() {
        try {
            semaforo.acquire();
            if (tipo == 0) {
                ProcessoInserir();
            } else if (tipo == 1) {
                ProcessoConsumir();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release();
        }
    }
}
