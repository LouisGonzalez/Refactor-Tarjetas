/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarjeta;

import java.io.Serializable;

/**
 *
 * @author Luis
 */
public class TarjetaDeCredito implements Serializable{
    
    private String NumeroDeTarjeta;
    private int tipo;
    private int limite;
    private String nombreDelCliente;
    private String direccionDelCliente;
    private double credito;
    private boolean estaActiva;
    private String path;
    private String numTipo;
    //Constructor de la tarjeta de credito
    
    public TarjetaDeCredito( String NumeroDeTarjeta,int tipo,int limite,String nombreDelCliente,String direccionDelCliente,double credito,boolean estaActiva){
        this.NumeroDeTarjeta=NumeroDeTarjeta;
        this.tipo=tipo;
        this.limite=limite;
        this.nombreDelCliente=nombreDelCliente;
        this.direccionDelCliente=direccionDelCliente;
        this.credito=credito;
        this.estaActiva=estaActiva;
    }
    
    public TarjetaDeCredito(String path, String numTipo){
        this.path = path;
        this.numTipo = numTipo;
    }

    public int getLimite() {
        return limite;
    }

    public void setLimite(int limite) {
        this.limite = limite;
    }

    public String getNombreDelCliente() {
        return nombreDelCliente;
    }

    public void setNombreDelCliente(String nombreDelCliente) {
        this.nombreDelCliente = nombreDelCliente;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getNumTipo() {
        return numTipo;
    }

    public void setNumTipo(String numTipo) {
        this.numTipo = numTipo;
    }
    
    

    public TarjetaDeCredito(){}
    
    public String getNumeroDeTarjeta(){
        return this.NumeroDeTarjeta;
    }
    public int getTipo(){
    return this.tipo;
    }
    public int getlimite(){
        return this.limite;
    }
    public String getnombreDelCliente(){
        return this.nombreDelCliente;
    }
    public String getDireccionDelCliente(){
        return this.direccionDelCliente;
    }
    public double getCreditoDeTarjeta(){
        return this.credito;
    }
    public boolean getEstaActiva(){
        return this.estaActiva;
    }
    public void setEstaActiva(boolean valor)
    {
        this.estaActiva = valor;
    }
    public void setCredito(double valor)
    {
        this.credito = valor;
    }
}
