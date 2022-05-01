/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instruccciones2;

import Archivos.ControladorDeArchivos;
import Tarjeta.TarjetaDeCredito;

/**
 *
 * @author Luis
 */
public class CancelacionTarjeta extends Instruccion {

    private TarjetaDeCredito tarjeta;
    
    @Override
    public void evaluarLinea(String linea) {
        try{
            String numeroDeTarjeta=linea
                .replaceAll("CANCELACION_TARJETA","")
                .replace("(", "")
                .replace(")", "");
            String nombreDelArchivo="Tarjeta"+numeroDeTarjeta+".tacre";
            ControladorDeArchivos controlador = new ControladorDeArchivos();
            tarjeta=controlador.leerTarjetaDeCredito(nombreDelArchivo);
            if(tarjeta.getCreditoDeTarjeta()<0) 
                tarjeta.setEstaActiva(false);
            else 
                System.out.println("No se puede cancelar la tarjeta ya que tiene credito pendiente. ");
        }
        catch(NullPointerException e){
            System.out.println("No puede autorizar solicitudes que no existan ");
        }
    }
    
}
