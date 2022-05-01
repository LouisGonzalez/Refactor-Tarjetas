/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instruccciones2;

import Archivos.ControladorDeArchivos;
import Tarjeta.TarjetaDeCredito;
import java.io.File;

/**
 *
 * @author Luis
 */
public class ListadoTarjeta extends Instruccion {

    private final ControladorDeArchivos controlador = new ControladorDeArchivos();
    private TarjetaDeCredito tarjeta;
    private String reporteHTML, tipo, condicion;
    private int limite = 0;
    
    @Override
    public void evaluarLinea(String linea) {
        reporteHTML = "";
        File carpeta = new File(new File(".").getAbsolutePath());
        File[] files = carpeta.listFiles((dirl, name) ->
            name.endsWith(".tacre"));
        header();
        for (File file : files) {
            condicion = "CANCELADA";
            tarjeta = controlador.leerTarjetaDeCredito(file.getPath());
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
            if(tarjeta.getEstaActiva())
                condicion = "ACTIVA";
            footer();
        }
        reporteHTML += "</table>";
        controlador.edicionDeReporteHTML(reporteHTML);
    }
    
    private void header(){
        reporteHTML += "<table style=\"border-collapse: collapse;\">\n"
                + "<h3>Listado de Tarjetas<h3>" +
            "	    <th style=\"border: 1px solid #000000;\">NUMERO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">LIMITE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
            "       <th style=\"border: 1px solid #000000;\">FECHA</th>\n" +               
            "	    <th style=\"border: 1px solid #000000;\">ESTADO TARJETA</th>\n" +
            "	  </tr>";

    }
    
    private void footer(){
        reporteHTML +=
                "         <tr>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getNumeroDeTarjeta()+"</th>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+tipo+"</th>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+limite+"</th>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getnombreDelCliente()+"</th>\n" +
                "	    <td style=\"border: 1px solid #000000;\">"+tarjeta.getDireccionDelCliente()+"</th>\n" +
                "           <td style=\"border: 1px solid #000000;\">"+""+"</th>\n" +                   
                "	    <td style=\"border: 1px solid #000000;\">"+condicion+"</th>\n" +
                "	  </tr>";                
        
    }
    
}
