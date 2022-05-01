/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Archivos;

import Instruccciones2.Solicitud;
import Tarjeta.TarjetaDeCredito;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Luis
 */
public class ControladorDeArchivos implements Serializable {
    Solicitud solicitud;
    TarjetaDeCredito tarjeta;
    /*
    El siguiente codigo funciona para escribir archivos binarios en el disco duro
    */
    public void escribirEnArchivo(String nombreDelArchivo,Object objetoAEscribir){
        ObjectOutputStream fileOut;
        try{
            fileOut = new ObjectOutputStream(                                   //Este comando inizializa un nuevo flujo de salida
            new FileOutputStream(nombreDelArchivo));                            //en otras palabras abre el archivo, como no existe, lo crea.
            fileOut.writeObject(objetoAEscribir);                               //Escribe el objeto solicitud en el archivo
            fileOut.close();                                                    //Cierra el archivo
        } 
        catch (IOException e){                                              //Captura todas las excepciones posibles de entrada y salida de datos
            System.out.println("Error: " + e.getMessage());
        }
    }
    
    
    public void crearArchivo(String nombre){
            DataOutputStream fileOut;
        try{
            fileOut = new DataOutputStream(                                   //Este comando inizializa un nuevo flujo de salida
            new FileOutputStream(nombre));                                      //en otras palabras abre el archivo, como no existe, lo crea.
            fileOut.writeInt(1);
            fileOut.close();                                                    //Cierra el archivo
        } 
        catch (IOException e){                                                  //Captura todas las excepciones posibles de entrada y salida de datos
            System.out.println("Error: " + e.getMessage());
        }
    }

    public TarjetaDeCredito leerTarjetaDeCredito(String archivoEntrante){
        ObjectInputStream fileIn;
        try{
            fileIn = new ObjectInputStream(
            new FileInputStream(archivoEntrante));
            tarjeta = (TarjetaDeCredito) fileIn.readObject();                        //Al nuevo objeto Solicitud le ponemos la mascara de la solicitud;
            fileIn.close();
        }
        catch (IOException e)
        {
            System.out.println("IO Error: " + e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("ClassNotFound " + e.getMessage());
        }
        return tarjeta;
    }

    public Solicitud leerSolicitud(String archivoEntrante){
        ObjectInputStream fileIn;
        try{
            fileIn = new ObjectInputStream(
            new FileInputStream(archivoEntrante));
            solicitud = (Solicitud) fileIn.readObject();                        //Al nuevo objeto Solicitud le ponemos la mascara de la solicitud;
            fileIn.close();
        }
        catch (IOException e)
        {
            System.out.println("IO Error: " + e.getMessage());
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("ClassNotFound " + e.getMessage());
        }
        return solicitud;
    }
    
    public void edicionDeReporteHTML(String textoEntrante){
    File archivo = new File("Reportes.html");
    FileOutputStream salida = null;
		try {
                        salida = new FileOutputStream(archivo,true);
			salida.write(textoEntrante.getBytes());
                        salida.close();
		} catch (IOException ex) {
			System.out.println(ex.getMessage()+" no se pudo gravar el texto");
		}
    }
}



