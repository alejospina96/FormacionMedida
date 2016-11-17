/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "CLIENTEFORMACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Clienteformacion.findAll", query = "SELECT c FROM Clienteformacion c"),
    @NamedQuery(name = "Clienteformacion.findById", query = "SELECT c FROM Clienteformacion c WHERE c.id = :id")})
public class Clienteformacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "clienteformacion", fetch = FetchType.EAGER)
    private Collection<Cursoformacion> cursoformacionCollection;
    @JoinColumn(name = "DESCUENTO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Descuento descuento;
    @JoinColumn(name = "EMPRESA", referencedColumnName = "NIT")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empresa empresa;

    public Clienteformacion() {
    }

    public Clienteformacion(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @XmlTransient
    public Collection<Cursoformacion> getCursoformacionCollection() {
        return cursoformacionCollection;
    }

    public void setCursoformacionCollection(Collection<Cursoformacion> cursoformacionCollection) {
        this.cursoformacionCollection = cursoformacionCollection;
    }

    public Descuento getDescuento() {
        return descuento;
    }

    public void setDescuento(Descuento descuento) {
        this.descuento = descuento;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clienteformacion)) {
            return false;
        }
        Clienteformacion other = (Clienteformacion) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Clienteformacion[ id=" + id + " ]";
    }
    
}
