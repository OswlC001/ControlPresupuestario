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
@Table(name = "Categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Categoria.findAll", query = "SELECT c FROM Categoria c"),
    @NamedQuery(name = "Categoria.findByIdCateg", query = "SELECT c FROM Categoria c WHERE c.idCateg = :idCateg"),
    @NamedQuery(name = "Categoria.findByDescriCateg", query = "SELECT c FROM Categoria c WHERE c.descriCateg = :descriCateg")})
public class Categoria implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_Categ")
    private Integer idCateg;
    @Size(max = 45)
    @Column(name = "descri_Categ")
    private String descriCateg;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "categoria")
    private List<Presupuesto> presupuestoList;

    public Categoria() {
    }

    public Categoria(Integer idCateg) {
        this.idCateg = idCateg;
    }

    public Integer getIdCateg() {
        return idCateg;
    }

    public void setIdCateg(Integer idCateg) {
        this.idCateg = idCateg;
    }

    public String getDescriCateg() {
        return descriCateg;
    }

    public void setDescriCateg(String descriCateg) {
        this.descriCateg = descriCateg;
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
        hash += (idCateg != null ? idCateg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Categoria)) {
            return false;
        }
        Categoria other = (Categoria) object;
        if ((this.idCateg == null && other.idCateg != null) || (this.idCateg != null && !this.idCateg.equals(other.idCateg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.Categoria[ idCateg=" + idCateg + " ]";
    }
    
}
