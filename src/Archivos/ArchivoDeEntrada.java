/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import Manejadores.Delegado;
import Manejadores.Ejecutor;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Serializable;
import java.util.Scanner;
import registrodetarjetas.Disenio;

/**
 *
 * @author Luis
 */
public class ArchivoDeEntrada implements Serializable{
    
    Disenio actualizarInstrucciones = new Disenio();
    private final Delegado del = new Delegado();
    private final Ejecutor exec = new Ejecutor();
    private final ControladorDeArchivos controlador = new ControladorDeArchivos();
    /*
    Este procedimiento sirve para leer el archivo de entrada 
    que contiene todas las instrucciones a ingresar al sistema.
    */
    public void asignarArchivo(String path){ 
        Scanner archivoDeEntrada;
        String line = null;
        try{
            archivoDeEntrada = new Scanner(new FileReader(path));
            controlador.crearArchivo("numeroNacionalCorriente.txt");
            controlador.crearArchivo("numeroRegionalCorriente.txt");
            controlador.crearArchivo("numeroInternacionalCorriente.txt");
            while (archivoDeEntrada.hasNextLine()){
                line = archivoDeEntrada.nextLine();
                System.out.println(line);
                actualizarInstrucciones.setAreaInstrucciones(String.valueOf(line)); //Las lineas que se van leyendo se almacenan en line
                //codigo malo
                //instruccion.evaluarLinea(line);



                //codigo bueno
                exec.ejecutar(del, line);
           }
           archivoDeEntrada.close(); //luego de haber abierto el archivo de entrada tambien hay que cerrarlo para 
        //que se liberen desbloquerlo y que se liberen recursos. 
       } catch (FileNotFoundException e){ // si el archivo no existe captura la excepcion y lanza un mensaje
            System.out.println("Error: " + e.getMessage());
       } 
    }//cerramos el procedimiento asignarArchivo
}//cerramos la clase ArchivoDeEntrada. 
