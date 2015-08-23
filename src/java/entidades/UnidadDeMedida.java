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
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ofcral
 */
@Entity
@Table(name = "Unidad_De_Medida")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UnidadDeMedida.findAll", query = "SELECT u FROM UnidadDeMedida u"),
    @NamedQuery(name = "UnidadDeMedida.findByIdUnidad", query = "SELECT u FROM UnidadDeMedida u WHERE u.idUnidad = :idUnidad"),
    @NamedQuery(name = "UnidadDeMedida.findByDescriUnidad", query = "SELECT u FROM UnidadDeMedida u WHERE u.descriUnidad = :descriUnidad")})
public class UnidadDeMedida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Unidad")
    private Integer idUnidad;
    @Size(max = 45)
    @Column(name = "descri_Unidad")
    private String descriUnidad;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unidadDeMedida")
    private List<Presupuesto> presupuestoList;

    public UnidadDeMedida() {
    }

    public UnidadDeMedida(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getDescriUnidad() {
        return descriUnidad;
    }

    public void setDescriUnidad(String descriUnidad) {
        this.descriUnidad = descriUnidad;
    }

    @XmlTransient
    public List<Presupuesto> getPresupuestoList() {
        return presupuestoList;
    }

    public void setPresupuestoList(List<Presupuesto> presupuestoList) {
        this.presupuestoList = presupuestoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidad != null ? idUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UnidadDeMedida)) {
            return false;
        }
        UnidadDeMedida other = (UnidadDeMedida) object;
        if ((this.idUnidad == null && other.idUnidad != null) || (this.idUnidad != null && !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.UnidadDeMedida[ idUnidad=" + idUnidad + " ]";
    }
    
}
