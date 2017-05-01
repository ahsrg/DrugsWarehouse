/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication2;

import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Adia
 */
public class insumo {
    private final SimpleStringProperty fecha;
    private final SimpleStringProperty tipo;
    private final SimpleStringProperty cantidad;
    private final SimpleStringProperty caducidad;
    private final SimpleStringProperty observa;
    
    public insumo(String fecha, String tipo, String cantidad,String caducidad,String observa ){
        super();
        this.fecha = new SimpleStringProperty(fecha);
        this.tipo = new SimpleStringProperty(tipo);
        this.caducidad = new SimpleStringProperty(caducidad);
        this.cantidad = new SimpleStringProperty(cantidad);
        this.observa = new SimpleStringProperty(observa);
    }

    public String getFecha() {
        return fecha.get();
    }

    public void setFecha(String date) {
         fecha.set(date);
    }
    
    public String getTipo() {
        return tipo.get();
    }
    
    public void setTipo(String tipo) {
         fecha.set(tipo);
    }

    
    public String getCantidad() {
        return fecha.get();
    }

    public void setCantidad(String can) {
         fecha.set(can);
    }

    public String getCaducidad() {
        return caducidad.get();
    }

    public void setCaducidad(String cadu) {
         fecha.set(cadu);
    }
    
    public String getObserva() {
        return observa.get();
    }
    
    public void setObserva(String obs) {
         fecha.set(obs);
    }
}
