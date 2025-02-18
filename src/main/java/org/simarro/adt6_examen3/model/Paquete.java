package org.simarro.adt6_examen3.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Paquete {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private LocalDate fechaPedido;
    @Column
    private  LocalDate fechaEntrega;
    @Column
    private int precioTotal;
    @Column
    private boolean entregado;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_Usuario")
    private Usuario Usuario;


    public Paquete(Integer id, LocalDate fechaPedido, LocalDate fechaEntrega, int precioTotal, boolean entregado) {
        this.id = id;
        this.fechaPedido = fechaPedido;
        this.fechaEntrega = fechaEntrega;
        this.precioTotal = precioTotal;
        this.entregado = entregado;
    }

    public Paquete(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public org.simarro.adt6_examen3.model.Usuario getUsuario() {
        return Usuario;
    }

    public void setUsuario(org.simarro.adt6_examen3.model.Usuario usuario) {
        Usuario = usuario;
    }
}
