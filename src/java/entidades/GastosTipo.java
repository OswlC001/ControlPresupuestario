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
@Table(name = "Gastos_Tipo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GastosTipo.findAll", query = "SELECT g FROM GastosTipo g"),
    @NamedQuery(name = "GastosTipo.findByIdGastosTipo", query = "SELECT g FROM GastosTipo g WHERE g.idGastosTipo = :idGastosTipo"),
    @NamedQuery(name = "GastosTipo.findByDescriGastosTipo", query = "SELECT g FROM GastosTipo g WHERE g.descriGastosTipo = :descriGastosTipo")})
public class GastosTipo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Gastos_Tipo")
    private Integer idGastosTipo;
    @Size(max = 45)
    @Column(name = "descri_Gastos_Tipo")
    private String descriGastosTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gastosTipo")
    private List<Gastos> gastosList;

    public GastosTipo() {
    }

    public GastosTipo(Integer idGastosTipo) {
        this.idGastosTipo = idGastosTipo;
    }

    public Integer getIdGastosTipo() {
        return idGastosTipo;
    }

    public void setIdGastosTipo(Integer idGastosTipo) {
        this.idGastosTipo = idGastosTipo;
    }

    public String getDescriGastosTipo() {
        return descriGastosTipo;
    }

    public void setDescriGastosTipo(String descriGastosTipo) {
        this.descriGastosTipo = descriGastosTipo;
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
        hash += (idGastosTipo != null ? idGastosTipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastosTipo)) {
            return false;
        }
        GastosTipo other = (GastosTipo) object;
        if ((this.idGastosTipo == null && other.idGastosTipo != null) || (this.idGastosTipo != null && !this.idGastosTipo.equals(other.idGastosTipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.GastosTipo[ idGastosTipo=" + idGastosTipo + " ]";
    }
    
}
