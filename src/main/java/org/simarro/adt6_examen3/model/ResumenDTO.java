package org.simarro.adt6_examen3.model;

public class ResumenDTO {

    private int entregados;
    private int noEntregados;

    public ResumenDTO(int entregados, int noEntregados) {
        this.entregados = entregados;
        this.noEntregados = noEntregados;
    }
    public ResumenDTO(){}

    public int getEntregados() {
        return entregados;
    }

    public void setEntregados(int entregados) {
        this.entregados = entregados;
    }

    public int getNoEntregados() {
        return noEntregados;
    }

    public void setNoEntregados(int noEntregados) {
        this.noEntregados = noEntregados;
    }
}
