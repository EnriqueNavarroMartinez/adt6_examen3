package org.simarro.adt6_examen3.model;

import java.time.LocalDate;

public class PaqueteRequestDTO {


    private LocalDate fechaPedido;
    private LocalDate fechaEntrega;
    private int precioTotal;
    private String emailCliente;

    public PaqueteRequestDTO(LocalDate fechaPedido, LocalDate fechaEntrega, int precioTotal, String emailCliente) {
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.precioTotal = precioTotal;
        this.emailCliente = emailCliente;
    }

    public PaqueteRequestDTO(){

    }
    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }
}
