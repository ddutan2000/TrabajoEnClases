/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.modelo;

import java.util.Date;

/**
 *
 * @author Dutan2000
 */
public class Asunto {
    private int numeroCaso;
    private Date FechaDeInicio;
    private Date fechaFinal;
    private String estado;
    private String cedulaCliente;
    private String cedulaProcurador;

    public Asunto() {
    }

    public Asunto(int numeroCaso, Date FechaDeInicio, Date fechaFinal, String estado, String cedulaCliente, String cedulaProcurador) {
        this.numeroCaso = numeroCaso;
        this.FechaDeInicio = FechaDeInicio;
        this.fechaFinal = fechaFinal;
        this.estado = estado;
        this.cedulaCliente = cedulaCliente;
        this.cedulaProcurador = cedulaProcurador;
    }

    public int getNumeroCaso() {
        return numeroCaso;
    }

    public void setNumeroCaso(int numeroCaso) {
        this.numeroCaso = numeroCaso;
    }

    public Date getFechaDeInicio() {
        return FechaDeInicio;
    }

    public void setFechaDeInicio(Date FechaDeInicio) {
        this.FechaDeInicio = FechaDeInicio;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCedulaCliente() {
        return cedulaCliente;
    }

    public void setCedulaCliente(String cedulaCliente) {
        this.cedulaCliente = cedulaCliente;
    }

    public String getCedulaProcurador() {
        return cedulaProcurador;
    }

    public void setCedulaProcurador(String cedulaProcurador) {
        this.cedulaProcurador = cedulaProcurador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + this.numeroCaso;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Asunto other = (Asunto) obj;
        if (this.numeroCaso != other.numeroCaso) {
            return false;
        }
        return true;
    }
    
    
    
}
