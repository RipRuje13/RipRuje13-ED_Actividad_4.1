/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estdat_actividad_4;

import java.util.Scanner;

/**
 *
 * @author Noriega
 */
public class EstDat_Actividad_4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ColaDinamica<String> car = new ColaDinamica<>();
        ColaDinamica<String> car2 = new ColaDinamica<>();
        PilaDinamica<String> pil = new PilaDinamica<>();
        String exp;
        int op;

        System.out.println("Expresiones polacas");
        do {
            System.out.println("Ingrese una expresion");
            exp = sc.nextLine();
            rellenarCola(car, exp);

            System.out.println("1.- Convertir expresion normal a polaca");
            System.out.println("2.- Evaluar Expresion polaca");
            System.out.println("3.- Salir");
            op = sc.nextInt();

            switch (op) {
                case 1:
                    convertirExpresion(car, car2, pil);
                    break;

                case 2:
                    break;

            }
        } while (op != 3);
    }

    public static void rellenarCola(ColaDinamica<String> cola, String expresion) {
        String aux2, ex = expresion;
        char aux1;

        for (int i = 0; i < ex.length(); i++) {
            aux1 = ex.charAt(i);
            aux2 = Character.toString(aux1);
            cola.añade(aux2);
        }

    }

    public static void convertirExpresion(ColaDinamica<String> cola1, ColaDinamica<String> cola2, PilaDinamica<String> pila) {

        while (!cola1.isEmpty()) {

            if ((cola1.primero().equals("(")) || (cola1.primero().equals("+")) || (cola1.primero().equals("-"))
                    || (cola1.primero().equals("*")) || (cola1.primero().equals("/")) || (cola1.primero().equals("^"))) {

                pila.push(cola1.primero());
                cola1.elimina();
            }
            
            if(cola1.primero().equals("(")){
                cola1.elimina();
            }
            
            if (cola1.primero().equals(")")) {

                while (!pila.isEmpty()) {
                    cola2.añade(pila.top());
                    pila.pop();
                }
                cola1.elimina();
            }
            
            cola2.añade(cola1.primero());
            cola1.elimina();

        }
        if(!pila.isEmpty()){
                while (!pila.isEmpty()) {
                    cola2.añade(pila.top());
                    pila.pop();
                }
            }
        System.out.print(cola2.toString());
    }
}
