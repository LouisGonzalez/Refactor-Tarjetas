/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instruccciones2;

import Archivos.ControladorDeArchivos;
import Tarjeta.Manejador;
import Tarjeta.TarjetaDeCredito;

/**
 *
 * @author Luis
 */
public class AutorizacionTarjeta extends Instruccion {

    private final Manejador manejadorTarjeta = new Manejador();
    private final ControladorDeArchivos controlador = new ControladorDeArchivos();
    private int salario, tipo, limite;
    private String nombre, direccion, numeroDeSiguienteTarjeta;
    private double credito;
    private boolean estado;
    
    @Override
    public void evaluarLinea(String linea) {
        try {
            Solicitud actual;
            int numeroDeSolicitud = Integer.valueOf(linea
                    .replaceAll("AUTORIZACION_TARJETA", "")
                    .replace("(","")
                    .replace(")",""));
            String nombreDelArchivo = "Solicitud"+numeroDeSolicitud+".sol";
            actual = controlador.leerSolicitud(nombreDelArchivo);
            salario = actual.getNumeroDeSolicitud();
            limite = (int) (salario*0.6);
            numeroDeSiguienteTarjeta=manejadorTarjeta.asignarNumNuevaTarjeta(limite,actual.getTipo());
            if(numeroDeSiguienteTarjeta == null)
                System.out.println("No se pudo autorizar su tarjeta porque no cumple con los requisitos");
            else {
                TarjetaDeCredito tarjeta = new TarjetaDeCredito(numeroDeSiguienteTarjeta, actual.getTipo(), limite, actual.getNombre(), actual.getDireccion(), 0, true);
                String nombreDelArchivoTarjeta="Tarjeta"+numeroDeSiguienteTarjeta+".tacre";
                controlador.escribirEnArchivo(nombreDelArchivoTarjeta, tarjeta);
            }
        } catch(NullPointerException e){
            System.out.println(e.getMessage() + " No puede autorizar una solicitud que no exista");
        }
    }
   
}
