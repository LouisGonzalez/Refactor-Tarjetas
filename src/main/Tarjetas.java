/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;
import Archivos.ControladorDeArchivos;
import registrodetarjetas.Disenio;

/**
 *
 * @author Luis
 */
public class Tarjetas {
    
    public static void main(String[] args){
        ControladorDeArchivos controlador = new ControladorDeArchivos();
        controlador.edicionDeReporteHTML("<html>\n");    
        //archivo.asignarArchivo();
        Disenio dis = new Disenio();
        dis.setVisible(true);
    }
    
}
