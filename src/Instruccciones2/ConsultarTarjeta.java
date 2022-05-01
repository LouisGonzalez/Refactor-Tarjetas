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
public class ConsultarTarjeta extends Instruccion {

    private TarjetaDeCredito tarjeta;
    private String tipo, variableEstado, reporteHTML;
    private int limite = 0;
    
    @Override
    public void evaluarLinea(String linea) {
        ControladorDeArchivos controlador = new ControladorDeArchivos();
        String numeroDeTarjeta=linea
                .replaceAll("CONSULTAR_TARJETA","")
                .replace("(","")
                .replace(")","");
        tarjeta=controlador.leerTarjetaDeCredito("Tarjeta"+numeroDeTarjeta+".tacre");
        switch(tarjeta.getTipo()){
            case 1:
                tipo = "Nacional";
                limite = 2000;
                break;
            case 2:
                tipo = "Regional";
                limite = 5000;
                break;
            case 3:
                tipo = "Internacional";
                limite = 12000;
                break;
        }
        variableEstado = "No Activa";
        if(tarjeta.getEstaActiva())
            variableEstado = "Activa";
        writeHtml(numeroDeTarjeta);
        controlador.edicionDeReporteHTML(reporteHTML);
    }
    
    private void writeHtml(String numeroDeTarjeta){
        reporteHTML="<h3>Consulta de Tarjeta: " +numeroDeTarjeta +"</h3>" +
            "	<table style=\"border-collapse: collapse;\">\n" +
            "	  <tr>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n" +
            "	  </tr>\n" +
            "	  <tr>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+numeroDeTarjeta+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+tipo+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+limite+".00"+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getnombreDelCliente()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getDireccionDelCliente()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+variableEstado+"</td>\n" +
            "	  </tr>\n" +
            "	</table>";        
    }
}
