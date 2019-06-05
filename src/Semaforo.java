
import java.util.*;
import java.util.concurrent.Semaphore;
import java.util.concurrent.ThreadLocalRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 1511 IRON
 */
public class Semaforo {

    public static void main(String[] args) throws InterruptedException {
        
        int processosPermitidos = 1;
        int numProcessos = 10;
        int aux = 0;
        Fila buffer = new Fila(1000);
        List<Processador> arrayProcessos = new ArrayList<>();

        Semaphore semaphore = new Semaphore(processosPermitidos);
        
        // 0 para processo de inclusao
        //1 para processo de exclusao
        for (int i = 0; i < numProcessos; i++) {
            if (i < 5) {
                arrayProcessos.add(new Processador(i, semaphore, buffer, 0));
            } else {
                arrayProcessos.add(new Processador(i, semaphore, buffer, 1));
            }
        }

        
        while(aux<200){
            Collections.shuffle(arrayProcessos);
            
            for(int i=0; i<10; i++){
                try {
                    arrayProcessos.get(i).start();
                } catch (Exception e) {
                    arrayProcessos.get(i).join();                    
                    arrayProcessos.set(i, new Processador(arrayProcessos.get(i).idProcesso, semaphore, buffer, arrayProcessos.get(i).tipo));
                    arrayProcessos.get(i).start();
                }
                }
            aux++;
            
            }
    }
}
