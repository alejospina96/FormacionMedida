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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "PERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Persona.findAll", query = "SELECT p FROM Persona p"),
    @NamedQuery(name = "Persona.findByIdentificacion", query = "SELECT p FROM Persona p WHERE p.identificacion = :identificacion"),
    @NamedQuery(name = "Persona.findByCiudadexpedicionidentificacion", query = "SELECT p FROM Persona p WHERE p.ciudadexpedicionidentificacion = :ciudadexpedicionidentificacion"),
    @NamedQuery(name = "Persona.findByPrimernombre", query = "SELECT p FROM Persona p WHERE p.primernombre = :primernombre"),
    @NamedQuery(name = "Persona.findBySegundonombre", query = "SELECT p FROM Persona p WHERE p.segundonombre = :segundonombre"),
    @NamedQuery(name = "Persona.findByPrimerapellido", query = "SELECT p FROM Persona p WHERE p.primerapellido = :primerapellido"),
    @NamedQuery(name = "Persona.findBySegundoapellido", query = "SELECT p FROM Persona p WHERE p.segundoapellido = :segundoapellido"),
    @NamedQuery(name = "Persona.findByGenero", query = "SELECT p FROM Persona p WHERE p.genero = :genero"),
    @NamedQuery(name = "Persona.findByEmail", query = "SELECT p FROM Persona p WHERE p.email = :email"),
    @NamedQuery(name = "Persona.findByTelefono", query = "SELECT p FROM Persona p WHERE p.telefono = :telefono"),
    @NamedQuery(name = "Persona.findByCelular", query = "SELECT p FROM Persona p WHERE p.celular = :celular")})
public class Persona implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDENTIFICACION")
    private Long identificacion;
    @Size(max = 50)
    @Column(name = "CIUDADEXPEDICIONIDENTIFICACION")
    private String ciudadexpedicionidentificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PRIMERNOMBRE")
    private String primernombre;
    @Size(max = 40)
    @Column(name = "SEGUNDONOMBRE")
    private String segundonombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PRIMERAPELLIDO")
    private String primerapellido;
    @Size(max = 40)
    @Column(name = "SEGUNDOAPELLIDO")
    private String segundoapellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GENERO")
    private Character genero;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 15)
    @Column(name = "TELEFONO")
    private String telefono;
    @Size(max = 10)
    @Column(name = "CELULAR")
    private String celular;
    @JoinTable(name = "ASISTENTESCURSOFORMACION", joinColumns = {
        @JoinColumn(name = "ASISTENTE", referencedColumnName = "IDENTIFICACION")}, inverseJoinColumns = {
        @JoinColumn(name = "CURSOFORMACION", referencedColumnName = "REFERENCIA")})
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Cursoformacion> cursoformacionCollection;
    @JoinColumn(name = "TIPO", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tipopersona tipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conferencista", fetch = FetchType.EAGER)
    private Collection<Cursoformacion> cursoformacionCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contacto", fetch = FetchType.EAGER)
    private Collection<Empresa> empresaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "representante", fetch = FetchType.EAGER)
    private Collection<Empresa> empresaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "persona1", fetch = FetchType.EAGER)
    private Collection<Infoadicionalpersona> infoadicionalpersonaCollection;

    public Persona() {
    }

    public Persona(Long identificacion) {
        this.identificacion = identificacion;
    }

    public Persona(Long identificacion, String primernombre, String primerapellido, Character genero, String email) {
        this.identificacion = identificacion;
        this.primernombre = primernombre;
        this.primerapellido = primerapellido;
        this.genero = genero;
        this.email = email;
    }

    public Long getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(Long identificacion) {
        this.identificacion = identificacion;
    }

    public String getCiudadexpedicionidentificacion() {
        return ciudadexpedicionidentificacion;
    }

    public void setCiudadexpedicionidentificacion(String ciudadexpedicionidentificacion) {
        this.ciudadexpedicionidentificacion = ciudadexpedicionidentificacion;
    }

    public String getPrimernombre() {
        return primernombre;
    }

    public void setPrimernombre(String primernombre) {
        this.primernombre = primernombre;
    }

    public String getSegundonombre() {
        return segundonombre;
    }

    public void setSegundonombre(String segundonombre) {
        this.segundonombre = segundonombre;
    }

    public String getPrimerapellido() {
        return primerapellido;
    }

    public void setPrimerapellido(String primerapellido) {
        this.primerapellido = primerapellido;
    }

    public String getSegundoapellido() {
        return segundoapellido;
    }

    public void setSegundoapellido(String segundoapellido) {
        this.segundoapellido = segundoapellido;
    }

    public Character getGenero() {
        return genero;
    }

    public void setGenero(Character genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @XmlTransient
    public Collection<Cursoformacion> getCursoformacionCollection() {
        return cursoformacionCollection;
    }

    public void setCursoformacionCollection(Collection<Cursoformacion> cursoformacionCollection) {
        this.cursoformacionCollection = cursoformacionCollection;
    }

    public Tipopersona getTipo() {
        return tipo;
    }

    public void setTipo(Tipopersona tipo) {
        this.tipo = tipo;
    }

    @XmlTransient
    public Collection<Cursoformacion> getCursoformacionCollection1() {
        return cursoformacionCollection1;
    }

    public void setCursoformacionCollection1(Collection<Cursoformacion> cursoformacionCollection1) {
        this.cursoformacionCollection1 = cursoformacionCollection1;
    }

    @XmlTransient
    public Collection<Empresa> getEmpresaCollection() {
        return empresaCollection;
    }

    public void setEmpresaCollection(Collection<Empresa> empresaCollection) {
        this.empresaCollection = empresaCollection;
    }

    @XmlTransient
    public Collection<Empresa> getEmpresaCollection1() {
        return empresaCollection1;
    }

    public void setEmpresaCollection1(Collection<Empresa> empresaCollection1) {
        this.empresaCollection1 = empresaCollection1;
    }

    @XmlTransient
    public Collection<Infoadicionalpersona> getInfoadicionalpersonaCollection() {
        return infoadicionalpersonaCollection;
    }

    public void setInfoadicionalpersonaCollection(Collection<Infoadicionalpersona> infoadicionalpersonaCollection) {
        this.infoadicionalpersonaCollection = infoadicionalpersonaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificacion != null ? identificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Persona)) {
            return false;
        }
        Persona other = (Persona) object;
        if ((this.identificacion == null && other.identificacion != null) || (this.identificacion != null && !this.identificacion.equals(other.identificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Persona[ identificacion=" + identificacion + " ]";
    }
    
}
