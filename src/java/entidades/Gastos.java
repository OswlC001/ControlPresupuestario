/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ofcral
 */
@Entity
@Table(name = "Gastos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Gastos.findAll", query = "SELECT g FROM Gastos g"),
    @NamedQuery(name = "Gastos.findByIdGastos", query = "SELECT g FROM Gastos g WHERE g.idGastos = :idGastos"),
    @NamedQuery(name = "Gastos.findByFechaGastos", query = "SELECT g FROM Gastos g WHERE g.fechaGastos = :fechaGastos"),
    @NamedQuery(name = "Gastos.findByCantidadGastos", query = "SELECT g FROM Gastos g WHERE g.cantidadGastos = :cantidadGastos"),
    @NamedQuery(name = "Gastos.findByPUnitarioGastos", query = "SELECT g FROM Gastos g WHERE g.pUnitarioGastos = :pUnitarioGastos")})
public class Gastos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idGastos")
    private Integer idGastos;
    @Size(max = 45)
    @Column(name = "fecha_Gastos")
    private String fechaGastos;
    @Size(max = 45)
    @Column(name = "cantidad_Gastos")
    private String cantidadGastos;
    @Size(max = 45)
    @Column(name = "p_Unitario_Gastos")
    private String pUnitarioGastos;
    @JoinColumn(name = "id_Gastos_Tipo", referencedColumnName = "id_Gastos_Tipo")
    @ManyToOne(optional = false)
    private GastosTipo gastosTipo;
    @JoinColumn(name = "id_Presupuesto", referencedColumnName = "id_Presupuesto")
    @ManyToOne(optional = false)
    private Presupuesto presupuesto;

    public Gastos() {
    }

    public Gastos(Integer idGastos) {
        this.idGastos = idGastos;
    }

    public Integer getIdGastos() {
        return idGastos;
    }

    public void setIdGastos(Integer idGastos) {
        this.idGastos = idGastos;
    }

    public String getFechaGastos() {
        return fechaGastos;
    }

    public void setFechaGastos(String fechaGastos) {
        this.fechaGastos = fechaGastos;
    }

    public String getCantidadGastos() {
        return cantidadGastos;
    }

    public void setCantidadGastos(String cantidadGastos) {
        this.cantidadGastos = cantidadGastos;
    }

    public String getPUnitarioGastos() {
        return pUnitarioGastos;
    }

    public void setPUnitarioGastos(String pUnitarioGastos) {
        this.pUnitarioGastos = pUnitarioGastos;
    }

    public GastosTipo getGastosTipo() {
        return gastosTipo;
    }

    public void setGastosTipo(GastosTipo gastosTipo) {
        this.gastosTipo = gastosTipo;
    }

    public Presupuesto getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Presupuesto presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGastos != null ? idGastos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Gastos)) {
            return false;
        }
        Gastos other = (Gastos) object;
        if ((this.idGastos == null && other.idGastos != null) || (this.idGastos != null && !this.idGastos.equals(other.idGastos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Gastos[ idGastos=" + idGastos + " ]";
    }
    
}
