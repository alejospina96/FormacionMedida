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
 * @author daniel
 */
@Entity
@Table(name = "TIPOCURSOFORMACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tipocursoformacion.findAll", query = "SELECT t FROM Tipocursoformacion t"),
    @NamedQuery(name = "Tipocursoformacion.findByCodigo", query = "SELECT t FROM Tipocursoformacion t WHERE t.codigo = :codigo"),
    @NamedQuery(name = "Tipocursoformacion.findByNombre", query = "SELECT t FROM Tipocursoformacion t WHERE t.nombre = :nombre")})
public class Tipocursoformacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "CODIGO")
    private Integer codigo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NOMBRE")
    private String nombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipocursoformacion", fetch = FetchType.EAGER)
    private Collection<Cursoformacion> cursoformacionCollection;

    public Tipocursoformacion() {
    }

    public Tipocursoformacion(Integer codigo) {
        this.codigo = codigo;
    }

    public Tipocursoformacion(Integer codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public Collection<Cursoformacion> getCursoformacionCollection() {
        return cursoformacionCollection;
    }

    public void setCursoformacionCollection(Collection<Cursoformacion> cursoformacionCollection) {
        this.cursoformacionCollection = cursoformacionCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipocursoformacion)) {
            return false;
        }
        Tipocursoformacion other = (Tipocursoformacion) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Tipocursoformacion[ codigo=" + codigo + " ]";
    }
    
}
