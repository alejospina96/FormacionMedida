/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EntityClasses;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author daniel
 */
@Embeddable
public class InfoadicionalpersonaPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "PERSONA")
    private long persona;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TIPO")
    private int tipo;

    public InfoadicionalpersonaPK() {
    }

    public InfoadicionalpersonaPK(long persona, int tipo) {
        this.persona = persona;
        this.tipo = tipo;
    }

    public long getPersona() {
        return persona;
    }

    public void setPersona(long persona) {
        this.persona = persona;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) persona;
        hash += (int) tipo;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InfoadicionalpersonaPK)) {
            return false;
        }
        InfoadicionalpersonaPK other = (InfoadicionalpersonaPK) object;
        if (this.persona != other.persona) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "EntityClasses.InfoadicionalpersonaPK[ persona=" + persona + ", tipo=" + tipo + " ]";
    }
    
}
