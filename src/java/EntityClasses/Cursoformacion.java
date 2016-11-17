/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "CURSOFORMACION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cursoformacion.findAll", query = "SELECT c FROM Cursoformacion c"),
    @NamedQuery(name = "Cursoformacion.findByReferencia", query = "SELECT c FROM Cursoformacion c WHERE c.referencia = :referencia"),
    @NamedQuery(name = "Cursoformacion.findByFechainicio", query = "SELECT c FROM Cursoformacion c WHERE c.fechainicio = :fechainicio"),
    @NamedQuery(name = "Cursoformacion.findByFechafinal", query = "SELECT c FROM Cursoformacion c WHERE c.fechafinal = :fechafinal"),
    @NamedQuery(name = "Cursoformacion.findByJustifiacion", query = "SELECT c FROM Cursoformacion c WHERE c.justifiacion = :justifiacion"),
    @NamedQuery(name = "Cursoformacion.findByObjetivosgenerales", query = "SELECT c FROM Cursoformacion c WHERE c.objetivosgenerales = :objetivosgenerales"),
    @NamedQuery(name = "Cursoformacion.findByObjetivosespecificos", query = "SELECT c FROM Cursoformacion c WHERE c.objetivosespecificos = :objetivosespecificos"),
    @NamedQuery(name = "Cursoformacion.findByValorempresa", query = "SELECT c FROM Cursoformacion c WHERE c.valorempresa = :valorempresa"),
    @NamedQuery(name = "Cursoformacion.findByValorlocal", query = "SELECT c FROM Cursoformacion c WHERE c.valorlocal = :valorlocal"),
    @NamedQuery(name = "Cursoformacion.findByLugar", query = "SELECT c FROM Cursoformacion c WHERE c.lugar = :lugar"),
    @NamedQuery(name = "Cursoformacion.findByNombre", query = "SELECT c FROM Cursoformacion c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Cursoformacion.findByAprobado", query = "SELECT c FROM Cursoformacion c WHERE c.aprobado = :aprobado")})
public class Cursoformacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "REFERENCIA")
    private Long referencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechainicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "FECHAFINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechafinal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "JUSTIFIACION")
    private String justifiacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "OBJETIVOSGENERALES")
    private String objetivosgenerales;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "OBJETIVOSESPECIFICOS")
    private String objetivosespecificos;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALOREMPRESA")
    private long valorempresa;
    @Basic(optional = false)
    @NotNull
    @Column(name = "VALORLOCAL")
    private long valorlocal;
    @Column(name = "LUGAR")
    private Character lugar;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "APROBADO")
    private Character aprobado;
    @ManyToMany(mappedBy = "cursoformacionCollection", fetch = FetchType.EAGER)
    private Collection<Persona> personaCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cursoformacion", fetch = FetchType.EAGER)
    private Collection<Horariocurso> horariocursoCollection;
    @JoinColumn(name = "CLIENTEFORMACION", referencedColumnName = "ID")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Clienteformacion clienteformacion;
    @JoinColumn(name = "CONFERENCISTA", referencedColumnName = "IDENTIFICACION")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona conferencista;
    @JoinColumn(name = "TIPOCURSOFORMACION", referencedColumnName = "CODIGO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tipocursoformacion tipocursoformacion;

    public Cursoformacion() {
    }

    public Cursoformacion(Long referencia) {
        this.referencia = referencia;
    }

    public Cursoformacion(Long referencia, Date fechainicio, Date fechafinal, String justifiacion, String objetivosgenerales, String objetivosespecificos, long valorempresa, long valorlocal, String nombre, Character aprobado) {
        this.referencia = referencia;
        this.fechainicio = fechainicio;
        this.fechafinal = fechafinal;
        this.justifiacion = justifiacion;
        this.objetivosgenerales = objetivosgenerales;
        this.objetivosespecificos = objetivosespecificos;
        this.valorempresa = valorempresa;
        this.valorlocal = valorlocal;
        this.nombre = nombre;
        this.aprobado = aprobado;
    }

    public Long getReferencia() {
        return referencia;
    }

    public void setReferencia(Long referencia) {
        this.referencia = referencia;
    }

    public Date getFechainicio() {
        return fechainicio;
    }

    public void setFechainicio(Date fechainicio) {
        this.fechainicio = fechainicio;
    }

    public Date getFechafinal() {
        return fechafinal;
    }

    public void setFechafinal(Date fechafinal) {
        this.fechafinal = fechafinal;
    }

    public String getJustifiacion() {
        return justifiacion;
    }

    public void setJustifiacion(String justifiacion) {
        this.justifiacion = justifiacion;
    }

    public String getObjetivosgenerales() {
        return objetivosgenerales;
    }

    public void setObjetivosgenerales(String objetivosgenerales) {
        this.objetivosgenerales = objetivosgenerales;
    }

    public String getObjetivosespecificos() {
        return objetivosespecificos;
    }

    public void setObjetivosespecificos(String objetivosespecificos) {
        this.objetivosespecificos = objetivosespecificos;
    }

    public long getValorempresa() {
        return valorempresa;
    }

    public void setValorempresa(long valorempresa) {
        this.valorempresa = valorempresa;
    }

    public long getValorlocal() {
        return valorlocal;
    }

    public void setValorlocal(long valorlocal) {
        this.valorlocal = valorlocal;
    }

    public Character getLugar() {
        return lugar;
    }

    public void setLugar(Character lugar) {
        this.lugar = lugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Character getAprobado() {
        return aprobado;
    }

    public void setAprobado(Character aprobado) {
        this.aprobado = aprobado;
    }

    @XmlTransient
    public Collection<Persona> getPersonaCollection() {
        return personaCollection;
    }

    public void setPersonaCollection(Collection<Persona> personaCollection) {
        this.personaCollection = personaCollection;
    }

    @XmlTransient
    public Collection<Horariocurso> getHorariocursoCollection() {
        return horariocursoCollection;
    }

    public void setHorariocursoCollection(Collection<Horariocurso> horariocursoCollection) {
        this.horariocursoCollection = horariocursoCollection;
    }

    public Clienteformacion getClienteformacion() {
        return clienteformacion;
    }

    public void setClienteformacion(Clienteformacion clienteformacion) {
        this.clienteformacion = clienteformacion;
    }

    public Persona getConferencista() {
        return conferencista;
    }

    public void setConferencista(Persona conferencista) {
        this.conferencista = conferencista;
    }

    public Tipocursoformacion getTipocursoformacion() {
        return tipocursoformacion;
    }

    public void setTipocursoformacion(Tipocursoformacion tipocursoformacion) {
        this.tipocursoformacion = tipocursoformacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (referencia != null ? referencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cursoformacion)) {
            return false;
        }
        Cursoformacion other = (Cursoformacion) object;
        if ((this.referencia == null && other.referencia != null) || (this.referencia != null && !this.referencia.equals(other.referencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Cursoformacion[ referencia=" + referencia + " ]";
    }
    
}
