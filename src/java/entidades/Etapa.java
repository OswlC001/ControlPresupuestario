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
@Table(name = "Etapa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Etapa.findAll", query = "SELECT e FROM Etapa e"),
    @NamedQuery(name = "Etapa.findByIdEtapa", query = "SELECT e FROM Etapa e WHERE e.idEtapa = :idEtapa"),
    @NamedQuery(name = "Etapa.findByDescriEtapa", query = "SELECT e FROM Etapa e WHERE e.descriEtapa = :descriEtapa")})
public class Etapa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Etapa")
    private Integer idEtapa;
    @Size(max = 45)
    @Column(name = "descri_Etapa")
    private String descriEtapa;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "etapa")
    private List<Presupuesto> presupuestoList;

    public Etapa() {
    }

    public Etapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    public Integer getIdEtapa() {
        return idEtapa;
    }

    public void setIdEtapa(Integer idEtapa) {
        this.idEtapa = idEtapa;
    }

    public String getDescriEtapa() {
        return descriEtapa;
    }

    public void setDescriEtapa(String descriEtapa) {
        this.descriEtapa = descriEtapa;
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
        hash += (idEtapa != null ? idEtapa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Etapa)) {
            return false;
        }
        Etapa other = (Etapa) object;
        if ((this.idEtapa == null && other.idEtapa != null) || (this.idEtapa != null && !this.idEtapa.equals(other.idEtapa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Etapa[ idEtapa=" + idEtapa + " ]";
    }
    
}
