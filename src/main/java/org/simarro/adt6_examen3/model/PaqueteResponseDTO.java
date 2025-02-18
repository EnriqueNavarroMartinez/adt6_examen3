package org.simarro.adt6_examen3.model;

import org.apache.logging.log4j.message.StringFormattedMessage;

import java.security.PrivateKey;
import java.time.LocalDate;

public class PaqueteResponseDTO {

    private String nombreUsuario;
    private LocalDate fechaPedido;
    private int precioTotal;

    public PaqueteResponseDTO(String nombreUsuario, LocalDate fechaPedido, int precioTotal) {
        this.nombreUsuario = nombreUsuario;
        this.fechaPedido = fechaPedido;
        this.precioTotal = precioTotal;
    }

    public PaqueteResponseDTO() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public LocalDate getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(LocalDate fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }
}
