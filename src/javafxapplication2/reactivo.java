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
public class reactivo {
    
   // private final SimpleStringProperty id;
    private final SimpleStringProperty fecha;
    private final SimpleStringProperty nombre;
    private final SimpleStringProperty lote;
    private final SimpleStringProperty cantidad;
    private final SimpleStringProperty caducidad;
    private final SimpleStringProperty observa;
    
    public reactivo(String fecha, String nombre,String lote, String cantidad,String caducidad,String observa ){
        super();
        this.fecha = new SimpleStringProperty(fecha);
        this.nombre = new SimpleStringProperty(nombre);
        this.caducidad = new SimpleStringProperty(caducidad);
        this.cantidad = new SimpleStringProperty(cantidad);
        this.lote = new SimpleStringProperty(lote);
        this.observa = new SimpleStringProperty(observa);
    }

    public String getFecha() {
        return fecha.get();
    }

    public void setFecha(String date) {
         fecha.set(date);
    }
    
    public String getNombre() {
        return nombre.get();
    }
    
    public void setNombre(String name) {
         nombre.set(name);
    }

    public String getLote() {
        return lote.get();
    }
    
    public void setLote(String loe) {
         lote.set(loe);
    }
    
    public String getCantidad() {
        return cantidad.get();
    }

    public void setCantidad(String can) {
         cantidad.set(can);
    }

    public String getCaducidad() {
        return caducidad.get();
    }

    public void setCaducidad(String cadu) {
         caducidad.set(cadu);
    }
    
    public String getObserva() {
        return observa.get();
    }
    
    public void setObserva(String obs) {
         observa.set(obs);
    }
    
}
