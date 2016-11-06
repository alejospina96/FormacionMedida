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
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author daniel
 */
@Embeddable
public class HorariocursoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "HORAINICIO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horainicio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "DIA")
    private String dia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CURSO")
    private long curso;

    public HorariocursoPK() {
    }

    public HorariocursoPK(Date horainicio, String dia, long curso) {
        this.horainicio = horainicio;
        this.dia = dia;
        this.curso = curso;
    }

    public Date getHorainicio() {
        return horainicio;
    }

    public void setHorainicio(Date horainicio) {
        this.horainicio = horainicio;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public long getCurso() {
        return curso;
    }

    public void setCurso(long curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (horainicio != null ? horainicio.hashCode() : 0);
        hash += (dia != null ? dia.hashCode() : 0);
        hash += (int) curso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HorariocursoPK)) {
            return false;
        }
        HorariocursoPK other = (HorariocursoPK) object;
        if ((this.horainicio == null && other.horainicio != null) || (this.horainicio != null && !this.horainicio.equals(other.horainicio))) {
            return false;
        }
        if ((this.dia == null && other.dia != null) || (this.dia != null && !this.dia.equals(other.dia))) {
            return false;
        }
        if (this.curso != other.curso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.HorariocursoPK[ horainicio=" + horainicio + ", dia=" + dia + ", curso=" + curso + " ]";
    }
    
}
