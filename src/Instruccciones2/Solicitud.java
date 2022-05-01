/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Instruccciones2;

import Archivos.ControladorDeArchivos;
import java.util.StringTokenizer;

/**
 *
 * @author Luis
 */
public class Solicitud extends Instruccion {

    private int numeroDeSolicitud;
    private String fecha;
    private int tipo;
    private String nombre;
    private int salario;
    private String direccion;
    private final ControladorDeArchivos controlador = new ControladorDeArchivos();

    public Solicitud(){}
    
    public Solicitud(int numSolicitud,String fecha, int tipo, String nombre, int salario,String direccion){
        this.numeroDeSolicitud=numSolicitud;
        this.fecha=fecha;
        this.tipo=tipo;
        this.nombre=nombre;
        this.salario=salario;
        this.direccion=direccion;
    }

    public int getNumeroDeSolicitud() {
        return numeroDeSolicitud;
    }

    public void setNumeroDeSolicitud(int numeroDeSolicitud) {
        this.numeroDeSolicitud = numeroDeSolicitud;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    @Override
    public void evaluarLinea(String linea) {
        StringTokenizer token = new StringTokenizer(linea, ",");
        String temp = token.nextToken().replace("(", "");
        this.numeroDeSolicitud = Integer.parseInt(temp.replaceAll("SOLICITUD", ""));
        temp = token.nextToken();
        setearVariables(token, temp);
        String numeroDeLaSolicitud=String.valueOf(this.numeroDeSolicitud);
        String nombreDeLaNuevaSolicitud="Solicitud"+numeroDeLaSolicitud+".sol";
        controlador.escribirEnArchivo(nombreDeLaNuevaSolicitud, this);        
    }
    
    private void setearVariables(StringTokenizer token, String temp){
        this.fecha=temp.replaceAll("\"",""); //mediante esta instruccion se quitan las comillas a la fecha 
        this.tipo=Integer.valueOf(token.nextToken().replace("\"", ""));
        this.nombre=String.valueOf(token.nextToken().replaceAll("\"", ""));
        this.salario=Integer.valueOf(token.nextToken());
        this.direccion=token.nextToken().replaceAll("\"", "").replace(")", "");
    }
    
}
