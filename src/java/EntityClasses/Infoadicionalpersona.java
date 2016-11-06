/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "INFOADICIONALPERSONA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Infoadicionalpersona.findAll", query = "SELECT i FROM Infoadicionalpersona i"),
    @NamedQuery(name = "Infoadicionalpersona.findByPersona", query = "SELECT i FROM Infoadicionalpersona i WHERE i.infoadicionalpersonaPK.persona = :persona"),
    @NamedQuery(name = "Infoadicionalpersona.findByTipo", query = "SELECT i FROM Infoadicionalpersona i WHERE i.infoadicionalpersonaPK.tipo = :tipo"),
    @NamedQuery(name = "Infoadicionalpersona.findByContenido", query = "SELECT i FROM Infoadicionalpersona i WHERE i.contenido = :contenido")})
public class Infoadicionalpersona implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InfoadicionalpersonaPK infoadicionalpersonaPK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "CONTENIDO")
    private String contenido;
    @JoinColumn(name = "TIPO", referencedColumnName = "CODIGO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Infoadicional infoadicional;
    @JoinColumn(name = "PERSONA", referencedColumnName = "IDENTIFICACION", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Persona persona1;

    public Infoadicionalpersona() {
    }

    public Infoadicionalpersona(InfoadicionalpersonaPK infoadicionalpersonaPK) {
        this.infoadicionalpersonaPK = infoadicionalpersonaPK;
    }

    public Infoadicionalpersona(InfoadicionalpersonaPK infoadicionalpersonaPK, String contenido) {
        this.infoadicionalpersonaPK = infoadicionalpersonaPK;
        this.contenido = contenido;
    }

    public Infoadicionalpersona(long persona, int tipo) {
        this.infoadicionalpersonaPK = new InfoadicionalpersonaPK(persona, tipo);
    }

    public InfoadicionalpersonaPK getInfoadicionalpersonaPK() {
        return infoadicionalpersonaPK;
    }

    public void setInfoadicionalpersonaPK(InfoadicionalpersonaPK infoadicionalpersonaPK) {
        this.infoadicionalpersonaPK = infoadicionalpersonaPK;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Infoadicional getInfoadicional() {
        return infoadicional;
    }

    public void setInfoadicional(Infoadicional infoadicional) {
        this.infoadicional = infoadicional;
    }

    public Persona getPersona1() {
        return persona1;
    }

    public void setPersona1(Persona persona1) {
        this.persona1 = persona1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (infoadicionalpersonaPK != null ? infoadicionalpersonaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Infoadicionalpersona)) {
            return false;
        }
        Infoadicionalpersona other = (Infoadicionalpersona) object;
        if ((this.infoadicionalpersonaPK == null && other.infoadicionalpersonaPK != null) || (this.infoadicionalpersonaPK != null && !this.infoadicionalpersonaPK.equals(other.infoadicionalpersonaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Infoadicionalpersona[ infoadicionalpersonaPK=" + infoadicionalpersonaPK + " ]";
    }
    
}
