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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "EMPRESA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Empresa.findAll", query = "SELECT e FROM Empresa e"),
    @NamedQuery(name = "Empresa.findByNit", query = "SELECT e FROM Empresa e WHERE e.nit = :nit"),
    @NamedQuery(name = "Empresa.findByRazonsocial", query = "SELECT e FROM Empresa e WHERE e.razonsocial = :razonsocial"),
    @NamedQuery(name = "Empresa.findByDireccion", query = "SELECT e FROM Empresa e WHERE e.direccion = :direccion"),
    @NamedQuery(name = "Empresa.findByCiudad", query = "SELECT e FROM Empresa e WHERE e.ciudad = :ciudad"),
    @NamedQuery(name = "Empresa.findByEmail", query = "SELECT e FROM Empresa e WHERE e.email = :email"),
    @NamedQuery(name = "Empresa.findByDepartamento", query = "SELECT e FROM Empresa e WHERE e.departamento = :departamento"),
    @NamedQuery(name = "Empresa.findByNumeroempleados", query = "SELECT e FROM Empresa e WHERE e.numeroempleados = :numeroempleados"),
    @NamedQuery(name = "Empresa.findByNumerosucursales", query = "SELECT e FROM Empresa e WHERE e.numerosucursales = :numerosucursales"),
    @NamedQuery(name = "Empresa.findByActividadeconomica", query = "SELECT e FROM Empresa e WHERE e.actividadeconomica = :actividadeconomica"),
    @NamedQuery(name = "Empresa.findByDescripcionproyecto", query = "SELECT e FROM Empresa e WHERE e.descripcionproyecto = :descripcionproyecto")})
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "NIT")
    private Long nit;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "RAZONSOCIAL")
    private String razonsocial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CIUDAD")
    private String ciudad;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DEPARTAMENTO")
    private String departamento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "NUMEROEMPLEADOS")
    private String numeroempleados;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "NUMEROSUCURSALES")
    private String numerosucursales;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ACTIVIDADECONOMICA")
    private String actividadeconomica;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "DESCRIPCIONPROYECTO")
    private String descripcionproyecto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa", fetch = FetchType.EAGER)
    private Collection<Clienteformacion> clienteformacionCollection;
    @JoinColumn(name = "CONTACTO", referencedColumnName = "IDENTIFICACION")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona contacto;
    @JoinColumn(name = "REPRESENTANTE", referencedColumnName = "IDENTIFICACION")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona representante;

    public Empresa() {
    }

    public Empresa(Long nit) {
        this.nit = nit;
    }

    public Empresa(Long nit, String razonsocial, String direccion, String ciudad, String email, String departamento, String numeroempleados, String numerosucursales, String actividadeconomica, String descripcionproyecto) {
        this.nit = nit;
        this.razonsocial = razonsocial;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.email = email;
        this.departamento = departamento;
        this.numeroempleados = numeroempleados;
        this.numerosucursales = numerosucursales;
        this.actividadeconomica = actividadeconomica;
        this.descripcionproyecto = descripcionproyecto;
    }

    public Long getNit() {
        return nit;
    }

    public void setNit(Long nit) {
        this.nit = nit;
    }

    public String getRazonsocial() {
        return razonsocial;
    }

    public void setRazonsocial(String razonsocial) {
        this.razonsocial = razonsocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getNumeroempleados() {
        return numeroempleados;
    }

    public void setNumeroempleados(String numeroempleados) {
        this.numeroempleados = numeroempleados;
    }

    public String getNumerosucursales() {
        return numerosucursales;
    }

    public void setNumerosucursales(String numerosucursales) {
        this.numerosucursales = numerosucursales;
    }

    public String getActividadeconomica() {
        return actividadeconomica;
    }

    public void setActividadeconomica(String actividadeconomica) {
        this.actividadeconomica = actividadeconomica;
    }

    public String getDescripcionproyecto() {
        return descripcionproyecto;
    }

    public void setDescripcionproyecto(String descripcionproyecto) {
        this.descripcionproyecto = descripcionproyecto;
    }

    @XmlTransient
    public Collection<Clienteformacion> getClienteformacionCollection() {
        return clienteformacionCollection;
    }

    public void setClienteformacionCollection(Collection<Clienteformacion> clienteformacionCollection) {
        this.clienteformacionCollection = clienteformacionCollection;
    }

    public Persona getContacto() {
        return contacto;
    }

    public void setContacto(Persona contacto) {
        this.contacto = contacto;
    }

    public Persona getRepresentante() {
        return representante;
    }

    public void setRepresentante(Persona representante) {
        this.representante = representante;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (nit != null ? nit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Empresa)) {
            return false;
        }
        Empresa other = (Empresa) object;
        if ((this.nit == null && other.nit != null) || (this.nit != null && !this.nit.equals(other.nit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Empresa[ nit=" + nit + " ]";
    }
    
}
