/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Analizadores;

/**
 *
 * @author jose_
 */
public class Nodo {
    
    private Nodo izq, der;
    private int valor, nivel;
    
    public Nodo(){}
    
    public Nodo(Nodo izq, Nodo der){
        this.izq = izq;
        this.der = der;
        this.valor = (izq.getValor()*8)+der.getValor();
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
    
    public void escribirArbol(int nivel){
        String espacios = "";
        for (int i = 0; i < this.nivel; i++) {
            espacios+="   ";
        }
        if(this.izq == null){
            System.out.println(espacios+this.valor+"----->Sube: "+this.valor);
        }else{
            if(this.nivel == nivel) System.out.println(espacios+"     "+this.valor);
            System.out.println(espacios+(this.izq.getValor())+"*8  +  "+this.der.getValor()+"----->Sube: "+this.valor);
            this.izq.escribirArbol(nivel);
        }
    }
}
