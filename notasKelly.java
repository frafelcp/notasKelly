/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer_notas_kelly;

import java.util.Scanner;
//import javax.swing.JOptionPane;

//Dada las calificaciones de n estudiantes, obtener:
//Calificacion mayor y menor
//Dado un nota cualquiera decir cuantos estudiantes obutvieron esa nota
//Cuantas veces se obtuvo cada nota
//Agregre dos datos y ubiquelos en el lugar que les corresponda, despues de ordenar el vector
//Elimine todos las notas que son inferiores al promedio

/**
 *
 * @author Felix Castro
 */
public class notasKelly {
    public static void main(String[] args) {
        //ingresamo datos por teclado en consola
        Scanner entrada = new Scanner(System.in);
        
        //Definimos variables
        double [] califiEstu;
        int cantEstu, posi_num=0, h=0;
        
        //solicitamos la cantidad de estudiante
        System.out.println("Ingrese la cantidad de estudiante");
        cantEstu = entrada.nextInt();
        
        //vector
        califiEstu = new double[cantEstu];
        
        //ingreamos la notas
        System.out.println("Registro de notas de cada estudiante en orden");
        for (int i = 0; i < cantEstu/2; i++) {
            System.out.println("Ingrese la nota del estudiante "+(i+1));
            califiEstu[i] = entrada.nextDouble();
        }
        
        //probar vector imprimiendolo
        System.out.println("Notas de los estudiantes por orden ingresado");
        for (int i = 0; i < cantEstu; i++) {
            System.out.println("El estudiante "+ (i+1)+ ""
                    + " obtuvo una nota de "+ califiEstu[i]);
        }
        
        //metodo insercion
        for (int i = 1; i < cantEstu; i++) {
            //buscamos la posicion correecta del elemento destino
            int j=i;
            double aux = califiEstu[i];
            //localizamos el punto de insercion buscando hacia abajo
            while (j>0 && aux<califiEstu[j-1]) {                
                califiEstu[j] = califiEstu[j-1];
                j--;
            }
            califiEstu[j] = aux;
        }       
        
        
        //ingresamos una nueva notas
        System.out.println("Ingrese otra nota");
        double nota = entrada.nextDouble();
        
        //buscar la posicion donde va el numero
        while (califiEstu[h]<nota && h<cantEstu/2) {            
            posi_num++;
            h++;
        }
        
        //corremos una posicion
        for (int i = (cantEstu/2)-1; i >= posi_num; i--) {
            califiEstu[i+1] = califiEstu[i];
        }
        
        //insertamos el numero
        califiEstu[posi_num] = nota;
        
        //mayor
        double mayor = califiEstu[0];
        
        //menor
        double menor = califiEstu[0];
        
        //prueba imprimir notas
        System.out.println("Notas de los estudiantes por nota ascendente");
        for (int i = 0; i < cantEstu; i++) {
            System.out.println("la nota del estudiante "+(i+1)+" obtuvo "
                    + "una nota de "+ califiEstu[i]);
            
            //validar numero mayor y menor
            if (califiEstu[i]>mayor) {
                mayor = califiEstu[i];
            }
            
            if (califiEstu[i]<menor) {
                menor = califiEstu[i];
            }
        }
        
        //mostramos numero mayor y menor
        System.out.println("La nota mayor es "+ mayor);
        System.out.println("La nota menor es "+ menor);
    }
}
