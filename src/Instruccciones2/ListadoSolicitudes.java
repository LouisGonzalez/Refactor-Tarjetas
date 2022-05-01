/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instruccciones2;

import Archivos.ControladorDeArchivos;
import java.io.File;

/**
 *
 * @author Luis
 */
public class ListadoSolicitudes extends Instruccion {

    private String reporteHTML, tipo;
    private final ControladorDeArchivos controlador = new ControladorDeArchivos();
    private Solicitud actual;
    
    @Override
    public void evaluarLinea(String linea) {
        reporteHTML = "";
        File carpeta = new File(new File (".").getAbsolutePath());
        File[] files = carpeta.listFiles((dirl, name) -> 
            name.endsWith(".sol"));
        header();
        for (File file : files) {
            //esta linea de abajo no se bien si funciona, probarla despues
            actual = controlador.leerSolicitud(file.getPath());
            if(actual.getTipo() == 1) tipo = "Nacional";
            if(actual.getTipo() == 2) tipo = "Regional";
            if(actual.getTipo() == 3) tipo = "Internacional";
            footer();            
        }
        reporteHTML += "</table>";
        controlador.edicionDeReporteHTML(reporteHTML);
        
    }
    
    private void header(){
        reporteHTML += "<table style=\"border-collapse: collapse;\">\n"
            + "<h3>Listado de Tarjetas<h3>" +
            "	  <tr>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NUMERO DE SOLICITUD</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">FECHA DE SOLICITUD</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">TIPO DE TARJETA</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">NOMBRE</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">SALARIO</th>\n" +
            "	    <th style=\"border: 1px solid #000000;\">DIRECCION</th>\n" +
            "           <th style=\"border: 1px solid #000000;\">FECHA APROV/RECH</th>\n" +               
            "	    <th style=\"border: 1px solid #000000;\">ESTADO SOLICITUD</th>\n" +
            "	  </tr>";

    }
    
    private void footer(){
        reporteHTML +=
        "         <tr>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+actual.getNumeroDeSolicitud()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+actual.getFecha()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+tipo+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+actual.getNombre()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+actual.getSalario()+"</td>\n" +
            "	    <td style=\"border: 1px solid #000000;\">"+actual.getDireccion()+"</td>\n" +
            "           <td style=\"border: 1px solid #000000;\">"+""+"</td>\n" +               
            "	    <td style=\"border: 1px solid #000000;\">"+""+"</td>\n" +
            "	  </tr>";

    }
    
}
