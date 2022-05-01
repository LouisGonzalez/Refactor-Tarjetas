/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manejadores;

import Instruccciones2.Instruccion;
/**
 *
 * @author Luis
 */
public class Delegado {
    
    public void ejecutarTarea(Instruccion tarea, String line){
        tarea.evaluarLinea(line);
    }
}
