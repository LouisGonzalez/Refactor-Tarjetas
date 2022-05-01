/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarjeta;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Luis
 */
public class Manejador {
 
    
    public void actualizarArchivo(int numero, String path){
        try {
            DataOutputStream fileOut = new DataOutputStream(
                    new FileOutputStream(path, false));
            fileOut.writeInt(numero);
        } catch(IOException e) {
            System.out.println("IO Error "+e.getMessage());
        }
    }
    
    public String leerYAsignarArchivo(TarjetaDeCredito tarjeta){
        int numero = 0;
        String noTarjeta = "";
        try {
            DataInputStream fileIn = new DataInputStream(
                    new FileInputStream(tarjeta.getPath()));
            numero = fileIn.readInt();
            noTarjeta = asignarNumeroTarjeta(tarjeta.getNumTipo(), numero);
            numero++;
            actualizarArchivo(numero, tarjeta.getPath());
        } catch(IOException e){
            System.out.println("IO Error "+e.getMessage());
        }
        return noTarjeta;
    }
    
    public String asignarNumeroTarjeta(String base, int valor){
        String numeroDeTarjeta = null;
        if(valor >= 1 && valor < 10)
            numeroDeTarjeta = base +"000"+valor;
        if(valor >= 10 && valor < 100)
            numeroDeTarjeta = base + "00" + valor;
        if(valor >= 100 && valor < 10000)
            numeroDeTarjeta = base + "0" + valor;
        return numeroDeTarjeta;
    }
    
    public String asignarNumNuevaTarjeta(int limiteCredito, int tipo){
        String valorActual = "";
        if(tipo == 1 && limiteCredito >= 2000)
            valorActual = leerYAsignarArchivo(new Nacional());
        else if(tipo == 2 && limiteCredito >= 5000)
            valorActual = leerYAsignarArchivo(new Regional());
        else if(tipo == 3 && limiteCredito >= 12000)
            valorActual = leerYAsignarArchivo(new Internacional());
        return valorActual;
    }
    
    
}
