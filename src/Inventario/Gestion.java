/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Inventario;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Kevin Russo Emiliany
 */
public class Gestion {
    public int precio, cantidad, menu, menu2;
    public boolean encontrado;
    public String nombre, descripcion, productoBuscado;
    Scanner leer = new Scanner(System.in);
  
    ArrayList<Producto> productos = new ArrayList<>();
    
    public void agregar(Producto producto){
        productos.add(producto);
    }
    
    public void eliminar(String nombre){
        for(int i = 0; i < productos.size(); i ++){        
            if(nombre.equals(productos.get(i).nombre)){              
                productos.remove(i);                 
                System.out.println("Producto eliminado"); 
            }
        }
    }
    
    public String buscar(String nombre){       
        for(int i = 0; i < productos.size(); i ++){          
            if(nombre.equals(productos.get(i).nombre)){              
                productoBuscado = String.valueOf(productos.get(i));
                System.out.println("Encontrado");               
            }                
        }
        return productoBuscado;
    }
    
    public void modificar(String nombre){       
        for(int i = 0; i < productos.size(); i ++){           
            if(nombre.equals(productos.get(i).nombre)){ 
                try{
                    System.out.print("""
                                   
                                   Que es lo que desea modificar: 
                                   > 1. Nombre
                                   > 2. Cantidad
                                   > 3. Precio
                                   > 4. Descripcion
                                   > 5. Todo
                                   > 0. Cancelar
                                   
                                   """);
                    menu = leer.nextInt();
                    switch(menu){

                        case 1:
                            //Nombre
                            System.out.print("Nombre: ");
                            nombre = leer.nextLine();
                            nombre = leer.nextLine();
                            productos.get(i).nombre = nombre;
                            break;

                        case 2:
                            //Cantidad
                            System.out.println("""
                                               
                                               > 1. Incrementar
                                               > 2. Disminuir
                                               > 0. Cancelar
                                               
                                               """);
                            menu2 = leer.nextInt();
                            switch(menu2){
                            
                                case 1:
                                    //Incrementar
                                    System.out.print("Cantidad que ingresa: ");
                                    cantidad = leer.nextInt();
                                    productos.get(i).cantidad = productos.get(i).cantidad + cantidad;
                                    break;
                                    
                                case 2:
                                    //Disminuir
                                    System.out.print("Cantidad que sale: ");
                                    cantidad = leer.nextInt();
                                    if(cantidad > productos.get(i).cantidad){
                                        System.out.println("Esta cantidad que ha ingresado es mayor a la que ya tiene");
                                    }else{
                                        productos.get(i).cantidad = productos.get(i).cantidad - cantidad;
                                    }
                                    break;
                                    
                                default:
                                    System.out.println("Opcion incorrecta");
                            }
                            
                            break;
                            
                        case 3:
                            //precio
                            System.out.print("Precio: ");
                            precio = leer.nextInt();
                            productos.get(i).precio = precio;
                            break;

                        case 4:
                            //Descripcion
                            System.out.print("Descripcion: ");
                            descripcion = leer.nextLine();
                            descripcion = leer.nextLine();
                            productos.get(i).descripcion = descripcion;
                            break;
                            
                        case 5:
                            //Todo
                            System.out.print("Nombre: ");
                            nombre = leer.nextLine();
                            nombre = leer.nextLine();
                            for(int j = 0; j < productos.size(); i ++){
                                if(nombre.equals(productos.get(j).nombre)){
                                    System.out.println("Ya este nombre existe");
                                    break;
                                }else{
                                    productos.get(j).nombre = nombre;
                                    System.out.print("Precio: ");
                                    precio = leer.nextInt();
                                    productos.get(j).precio = precio;
                                    System.out.print("Descripcion: ");
                                    descripcion = leer.nextLine();
                                    descripcion = leer.nextLine();
                                    productos.get(j).descripcion = descripcion;
                                    break;
                                }
                            }
                            break;
                            
                        case 0:
                            continue;

                        default:
                            System.out.println("Opcion incorrecta");
                    }
                    if(productos.get(i).cantidad == 0){
                                productos.remove(i);
                    }
                    System.out.println("Modificado");               
                    
                }catch(InputMismatchException e){
                    System.out.println("Caracter no valido");
                }
            }      
        }
    }
    
    public boolean verificarExiste(String nombre){
        encontrado = false;
        for(int i = 0; i < productos.size(); i ++){
            if(nombre.equals(productos.get(i).nombre)){
                encontrado = true;
                break;
            }
        }
        return encontrado;
    }
    
    public void mostrarTodo(){      
        for(Producto producto: productos){   
                System.out.println(producto.toString());
        }
    } 
}
