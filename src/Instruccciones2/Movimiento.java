/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instruccciones2;

import Archivos.ControladorDeArchivos;
import Tarjeta.TarjetaDeCredito;
import java.util.Calendar;
import java.util.StringTokenizer;
import sun.util.locale.StringTokenIterator;

/**
 *
 * @author Luis
 */
public class Movimiento extends Instruccion {

    private TarjetaDeCredito tarjeta;
    private String numeroDeTarjeta, fecha, tipoDeMovimiento, descripcion, establecimiento;
    private double monto;
    private final ControladorDeArchivos controlador = new ControladorDeArchivos();
    
    @Override
    public void evaluarLinea(String linea) {
        StringTokenizer token = new StringTokenizer(linea, ",");
        String temp = token.nextToken().replace("(", "");
        setearVariables(token, temp);
        tarjeta=controlador.leerTarjetaDeCredito("Tarjeta"+numeroDeTarjeta+".tacre");
        tarjeta.setCredito(tarjeta.getCreditoDeTarjeta()+monto);
        controlador.escribirEnArchivo("Tarjeta"+numeroDeTarjeta+".tacre", tarjeta);     //Actualizacion del objeto en el archivo
        //Instrucciones.Movimiento movimiento = new Instrucciones.Movimiento(numeroDeTarjeta,fecha,tipoDeMovimiento,descripcion,establecimiento,monto);
        Calendar tiempo=Calendar.getInstance();
        String nombreDelNuevoMovimiento="Movimiento"+String.valueOf(tiempo.getTimeInMillis())+".mvito";
        controlador.escribirEnArchivo(nombreDelNuevoMovimiento, this);
    }
    
    public void setearVariables(StringTokenizer token, String temp){
        numeroDeTarjeta = temp.replaceAll("MOVIMIENTO", "");
        fecha = token.nextToken().replaceAll("\"", "");
        tipoDeMovimiento=(token.nextToken().replace("\"", ""));
        descripcion=(token.nextToken().replace("\"", ""));
        establecimiento=(token.nextToken().replace("\"", ""));
        monto = Double.parseDouble(token.nextToken().replaceAll("\"", "").replace(")", ""));
    }
    
}
