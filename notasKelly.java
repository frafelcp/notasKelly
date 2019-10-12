/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer_notas_kelly;

import java.util.Scanner;

/**
 *
 * @author KELLY
 */
public class notasKelly {

    public static void main(String[] args) {
     
    int n,e = 0, cant=0;    
    Scanner leer = new Scanner(System.in);
     System.out.println("ingrese la cantidad de alumnos");
     n= leer.nextInt();
     
    System.out.print("------------------------\n");
    
    double[] nota = new double[n+2]; // aqui se declara el vector
    
    for (int j = 0; j < n; j++) { // aqui se llena el vector
        e=e+1;
        System.out.print("ingrese la Nota del estudiante "+ e +"\n");
        nota[j] = leer.nextDouble();
        
    }
    
    
    
    for (int x = 0; x < nota.length; x++) { // aqui se ordena el vector
        for (int i = 0; i < nota.length-x-1; i++) {
            if(nota[i] < nota[i+1]){
                double tmp = nota[i+1];
                nota[i+1] = nota[i];
                nota[i] = tmp;
            }
        }
      }
    
    System.out.print("------------------------\n");
    
    e=0;
     System.out.print("Posición de las notas de mayor a menor " +"\n");
    for (int i=0; i<n; i++) { // aqui mostramos las notas de mayor a menor  
       e = n-i;
       System.out.print("Posición "+ e +": "+ nota[i]+"\n");
    }
    
    System.out.print("------------------------\n");
        
    System.out.print("ingrese la Nota a consultar " +"\n");
    double notab = leer.nextDouble();    
     for (int i=0; i < n; i++) { // aqui buscamos la nota   
        if(nota[i] == notab){
                cant = cant + 1;
            }
     }
     System.out.print("La cantidad de estudiantes con la nota "+ notab +": "+ cant +"\n");
     
     
     System.out.print("------------------------\n");
     
   // consultamos la cantidad de veces que se repite una nota 
    int cantidad = 0;
    double aux = 0;
    for(int j=0;j<nota.length;j++){
     if(aux != nota[j]){   
      for(int i=0;i<nota.length-1;i++){
            if(nota[j]==nota[i+1]){
                cantidad = cantidad + 1;  
            }else{
                cantidad= 1;
            }
        }
        System.out.println("La nota " + nota[j] + " se repite "+cantidad+" veces");
      }
        aux= nota[j];
       
    }
     
       
    
     System.out.print("------------------------\n");
    
    // aqui insertamos la nueva nota
        for (int ab = 1; ab < 3; ab++) {
            System.out.print("ingrese la Nota nueva " + "\n");
            double notan = leer.nextDouble();
            int ac = 0;
            int posicion = 0;
            while (notan > nota[ac] && ac < n) {
                posicion = posicion + 1;
                ac = ac + 1;
            }
            for (int i = n; i >= posicion; i--) {
                nota[i] = nota[i - 1];
            }
            nota[posicion] = notan;
            n = n + 1;
        }
    
     System.out.print("------------------------\n");
    
     // aqui buscamos la nota menor al promedio y se elimina   
    double prom, suma=0; 
    for (int i=0; i < nota.length; i++) { 
        suma = suma + nota[i];
     }    
    prom = suma / nota.length;
    System.out.print("El promedio de las notas es :" + prom +"\n");
    int posicioneliminar = -1;
    for (int i=0; i < nota.length; i++) {
        if(nota[i] < prom){
               posicioneliminar = i;
               nota[i] = 0;
               if(posicioneliminar >= 0){
                    System.out.print("El dato en la posicion " + posicioneliminar +" se eliminó.\n");
                }else{
                    System.out.print("No se encontro el dato. " +"\n");
                }
            }
     }    
    
    
    }
   
}