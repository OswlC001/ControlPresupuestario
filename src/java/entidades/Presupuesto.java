/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ofcral
 */
@Entity
@Table(name = "Presupuesto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Presupuesto.findAll", query = "SELECT p FROM Presupuesto p"),
    @NamedQuery(name = "Presupuesto.findByIdPresupuesto", query = "SELECT p FROM Presupuesto p WHERE p.idPresupuesto = :idPresupuesto"),
    @NamedQuery(name = "Presupuesto.findByConcepto", query = "SELECT p FROM Presupuesto p WHERE p.concepto = :concepto"),
    @NamedQuery(name = "Presupuesto.findByCantidad", query = "SELECT p FROM Presupuesto p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "Presupuesto.findByPUnitario", query = "SELECT p FROM Presupuesto p WHERE p.pUnitario = :pUnitario")})
public class Presupuesto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Presupuesto")
    private Integer idPresupuesto;
    @Size(max = 45)
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "cantidad")
    private Float cantidad;
    @Column(name = "p_Unitario")
    private Float pUnitario;
    @JoinColumn(name = "id_Categ", referencedColumnName = "id_Categ")
    @ManyToOne(optional = false)
    private Categoria categoria;
    @JoinColumn(name = "id_Etapa", referencedColumnName = "id_Etapa")
    @ManyToOne(optional = false)
    private Etapa etapa;
    @JoinColumn(name = "id_Unidad", referencedColumnName = "id_Unidad")
    @ManyToOne(optional = false)
    private UnidadDeMedida unidadDeMedida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "presupuesto")
    private List<Gastos> gastosList;

    public Presupuesto() {
    }

    public Presupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public Integer getIdPresupuesto() {
        return idPresupuesto;
    }

    public void setIdPresupuesto(Integer idPresupuesto) {
        this.idPresupuesto = idPresupuesto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Float getCantidad() {
        return cantidad;
    }

    public void setCantidad(Float cantidad) {
        this.cantidad = cantidad;
    }

    public Float getPUnitario() {
        return pUnitario;
    }

    public void setPUnitario(Float pUnitario) {
        this.pUnitario = pUnitario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Etapa getEtapa() {
        return etapa;
    }

    public void setEtapa(Etapa etapa) {
        this.etapa = etapa;
    }

    public UnidadDeMedida getUnidadDeMedida() {
        return unidadDeMedida;
    }

    public void setUnidadDeMedida(UnidadDeMedida unidadDeMedida) {
        this.unidadDeMedida = unidadDeMedida;
    }

    @XmlTransient
    public List<Gastos> getGastosList() {
        return gastosList;
    }

    public void setGastosList(List<Gastos> gastosList) {
        this.gastosList = gastosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPresupuesto != null ? idPresupuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Presupuesto)) {
            return false;
        }
        Presupuesto other = (Presupuesto) object;
        if ((this.idPresupuesto == null && other.idPresupuesto != null) || (this.idPresupuesto != null && !this.idPresupuesto.equals(other.idPresupuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Presupuesto[ idPresupuesto=" + idPresupuesto + " ]";
    }
    
}
