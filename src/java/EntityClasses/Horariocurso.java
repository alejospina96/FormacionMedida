/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniel
 */
@Entity
@Table(name = "HORARIOCURSO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horariocurso.findAll", query = "SELECT h FROM Horariocurso h"),
    @NamedQuery(name = "Horariocurso.findByHorainicio", query = "SELECT h FROM Horariocurso h WHERE h.horariocursoPK.horainicio = :horainicio"),
    @NamedQuery(name = "Horariocurso.findByHorafin", query = "SELECT h FROM Horariocurso h WHERE h.horafin = :horafin"),
    @NamedQuery(name = "Horariocurso.findByDia", query = "SELECT h FROM Horariocurso h WHERE h.horariocursoPK.dia = :dia"),
    @NamedQuery(name = "Horariocurso.findByCurso", query = "SELECT h FROM Horariocurso h WHERE h.horariocursoPK.curso = :curso")})
public class Horariocurso implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HorariocursoPK horariocursoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAFIN")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horafin;
    @JoinColumn(name = "CURSO", referencedColumnName = "REFERENCIA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cursoformacion cursoformacion;

    public Horariocurso() {
    }

    public Horariocurso(HorariocursoPK horariocursoPK) {
        this.horariocursoPK = horariocursoPK;
    }

    public Horariocurso(HorariocursoPK horariocursoPK, Date horafin) {
        this.horariocursoPK = horariocursoPK;
        this.horafin = horafin;
    }

    public Horariocurso(Date horainicio, String dia, long curso) {
        this.horariocursoPK = new HorariocursoPK(horainicio, dia, curso);
    }

    public HorariocursoPK getHorariocursoPK() {
        return horariocursoPK;
    }

    public void setHorariocursoPK(HorariocursoPK horariocursoPK) {
        this.horariocursoPK = horariocursoPK;
    }

    public Date getHorafin() {
        return horafin;
    }

    public void setHorafin(Date horafin) {
        this.horafin = horafin;
    }

    public Cursoformacion getCursoformacion() {
        return cursoformacion;
    }

    public void setCursoformacion(Cursoformacion cursoformacion) {
        this.cursoformacion = cursoformacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horariocursoPK != null ? horariocursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horariocurso)) {
            return false;
        }
        Horariocurso other = (Horariocurso) object;
        if ((this.horariocursoPK == null && other.horariocursoPK != null) || (this.horariocursoPK != null && !this.horariocursoPK.equals(other.horariocursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.Horariocurso[ horariocursoPK=" + horariocursoPK + " ]";
    }
    
}
