/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 1511 IRON
 */
public class Fila {

    Integer fila[];
    int frente, rabo, tamanhoMax, tamanhoAtual, aux;

    public Fila(int tamanhoMax) {
        fila = new Integer[tamanhoMax];
        frente = -1;
        rabo = -1;
        this.tamanhoMax = tamanhoMax;
        this.tamanhoAtual = 0;
        this.aux = 0;
    }

    public int Inserir() {
       
        if (rabo < 1000) {
            if (frente == -1) {
                frente++;
                fila[frente] = 1;
                rabo = frente;
                aux++;
            } else {
                rabo++;
                fila[rabo] = 1;
                aux++;
            }
            return 1;
        }
        return 0;
    }

    public int retirar(){
        if(aux!=0){
            if(frente == 0){
                frente--;
            }
            rabo--;
            aux--;
            return 1;
        }
        return 0;
    }
}
