/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareacompiladoresconvertidoroctal;

import Analizadores.Lexer;
import Analizadores.Nodo;
import Analizadores.parser;
import java.io.StringReader;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java_cup.runtime.Symbol;

/**
 *
 * @author jose_
 */
public class TareaCompiladoresConvertidorOctal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Por favor ingrese el valor Octal que desea convertir a decimal: ");
            String cadena = sc.nextLine();
            Lexer lexer = new Lexer(new StringReader(cadena));
            parser parserr = new parser(lexer);
            Nodo nodo = (Nodo) parserr.parse().value;
            System.out.println("--------------------------------------------------");
            System.out.println("El resultado de la conversion es: "+nodo.getValor());
            System.out.println("--------------------------------------------------");
            System.out.println("Su \"arbol\" quedaría de la siguiente forma: \n");
            nodo.escribirArbol(nodo.getNivel());
        } catch (Exception ex) {
            Logger.getLogger(TareaCompiladoresConvertidorOctal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
