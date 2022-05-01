/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Manejadores;

import Instruccciones2.AutorizacionTarjeta;
import Instruccciones2.CancelacionTarjeta;
import Instruccciones2.ConsultarTarjeta;
import Instruccciones2.EstadoCuenta;
import Instruccciones2.ListadoSolicitudes;
import Instruccciones2.ListadoTarjeta;
import Instruccciones2.Movimiento;
import Instruccciones2.Solicitud;

/**
 *
 * @author Luis
 */
public class Ejecutor {
    
    public void ejecutar(Delegado del, String tipo){
        switch(tipo){
            case "SOLICITUD":
                del.ejecutarTarea(new Solicitud(), tipo);
                break;
            case "MOVIMIENTO":
                del.ejecutarTarea(new Movimiento(), tipo);
                break;
            case "AUTORIZACION_TARJETA":
                del.ejecutarTarea(new AutorizacionTarjeta(), tipo);
                break;
            case "CANCELACION_TARJETA":
                del.ejecutarTarea(new CancelacionTarjeta(), tipo);
                break;
            case "CONSULTAR_TARJETA":
                del.ejecutarTarea(new ConsultarTarjeta(), tipo);
                break;
            case "ESTADO_CUENTA":
                del.ejecutarTarea(new EstadoCuenta(), tipo);
                break;
            case "LISTADO_TARJETAS":
                del.ejecutarTarea(new ListadoTarjeta(), tipo);
                break;
            case "LISTADO_SOLICITUDES":
                del.ejecutarTarea(new ListadoSolicitudes(), tipo);
                break;
        }
    }
    
}
