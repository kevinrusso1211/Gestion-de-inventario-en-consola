/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Inventario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Kevin Russo Emiliany
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //Esta es la cmenuia

        Scanner leer = new Scanner(System.in);
        int menu = 1, cantidad, precio;
        Gestion g = new Gestion();
        String nombre, descripcion, accionVariable = null;
        ArrayList<String> historial = new ArrayList<>();
       
        while (menu != 0) {
            try {   
                System.out.print("""
                            
                            Seleccione una opcion:        
                            
                            > 1. Agregar                  
                            > 2. Eliminar            
                            > 3. Buscar                   
                            > 4. Modificar                
                            > 5. Ver todos los productos  
                            > 6. Ver historial
                            > 0. Salir  
                                 
                            """);
                menu = leer.nextInt();

                switch (menu) {
                    
                    case 1:
                        //Agregar
                        System.out.print("Nombre: ");
                        nombre = leer.nextLine();
                        nombre = leer.nextLine();
                        if(g.verificarExiste(nombre)){
                            System.out.println(nombre.concat(" ya existe"));
                        } else {
                            System.out.print("Cantidad: ");
                            cantidad = leer.nextInt();
                            System.out.print("Precio: ");
                            precio = leer.nextInt();
                            System.out.print("Descripcion: ");
                            descripcion = leer.nextLine();
                            descripcion = leer.nextLine();
                            Producto p = new Producto(nombre, precio, cantidad, descripcion);
                            g.agregar(p);
                            historial.add("Agregado: "+p.nombre);
                        }
                        break;
                     
                     case 2:
                         //Eliminar
                         System.out.print("Nombre: ");
                         nombre = leer.nextLine();
                         nombre = leer.nextLine();
                         if(g.verificarExiste(nombre)){
                            g.eliminar(nombre);
                            historial.add("Eliminado: "+nombre);
                         }else{
                             System.out.println(nombre.concat(" no se encuentra"));
                         }
                         break;

                     case 3:
                         //Buscar
                         System.out.print("Nombre: ");
                         nombre = leer.nextLine();
                         nombre = leer.nextLine();
                         if(g.verificarExiste(nombre)){
                             System.out.println(g.buscar(nombre));
                             historial.add("Buscado: "+nombre);
                         }else{
                             System.out.println(nombre.concat(" no se encuentra"));
                         }
                         break;

                     case 4:
                         //Modificar
                         g.mostrarTodo();
                         System.out.print("Nombre del producto que va a modificar: ");
                         nombre = leer.nextLine();
                         nombre = leer.nextLine();
                         if(g.verificarExiste(nombre)){
                             g.modificar(nombre);
                             historial.add("Modificado: "+nombre);
                         }else{
                             System.out.println(nombre.concat(" no se encuentra"));
                         }
                         break;

                     case 5:
                         //ver productos
                         if(g.productos.size() != 0){
                             g.mostrarTodo();
                         }else{
                             System.out.println("No hay productos en el inventario");
                         }
                         historial.add("Ha visto todos los productos");
                         break;

                     case 6:
                         //Ver historial
                         for(String accion: historial){
                             System.out.println(accion);
                             accionVariable = accion;
                         }
                         if(accionVariable == null){
                                 System.out.println("No se ha realizado ninguna accion");
                             }
                         break;

                     case 0:
                         menu = 0;
                         break;

                     default:
                         System.out.println("La opcion que ingreso es incorrecta");
                 }
            } catch (InputMismatchException e) {
                System.out.println("Caracter no valido");
                leer.nextLine();
            }
       }
    }    
}




