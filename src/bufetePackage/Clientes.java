/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bufetePackage;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author draco
 */
@Entity
@Table(name = "clientes", catalog = "bufete", schema = "")
@NamedQueries({
    @NamedQuery(name = "Clientes.findAll", query = "SELECT c FROM Clientes c"),
    @NamedQuery(name = "Clientes.findByIdentificador", query = "SELECT c FROM Clientes c WHERE c.identificador = :identificador"),
    @NamedQuery(name = "Clientes.findByNombre", query = "SELECT c FROM Clientes c WHERE c.nombre = :nombre"),
    @NamedQuery(name = "Clientes.findByApellido1", query = "SELECT c FROM Clientes c WHERE c.apellido1 = :apellido1"),
    @NamedQuery(name = "Clientes.findByApellido2", query = "SELECT c FROM Clientes c WHERE c.apellido2 = :apellido2"),
    @NamedQuery(name = "Clientes.findByAnotaciones", query = "SELECT c FROM Clientes c WHERE c.anotaciones = :anotaciones")})
public class Clientes implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "identificador")
    private String identificador;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "apellido1")
    private String apellido1;
    @Column(name = "apellido2")
    private String apellido2;
    @Column(name = "anotaciones")
    private String anotaciones;

    public Clientes() {
    }

    public Clientes(String identificador) {
        this.identificador = identificador;
    }

    public Clientes(String identificador, String nombre, String apellido1) {
        this.identificador = identificador;
        this.nombre = nombre;
        this.apellido1 = apellido1;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        String oldIdentificador = this.identificador;
        this.identificador = identificador;
        changeSupport.firePropertyChange("identificador", oldIdentificador, identificador);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        String oldNombre = this.nombre;
        this.nombre = nombre;
        changeSupport.firePropertyChange("nombre", oldNombre, nombre);
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        String oldApellido1 = this.apellido1;
        this.apellido1 = apellido1;
        changeSupport.firePropertyChange("apellido1", oldApellido1, apellido1);
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        String oldApellido2 = this.apellido2;
        this.apellido2 = apellido2;
        changeSupport.firePropertyChange("apellido2", oldApellido2, apellido2);
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        String oldAnotaciones = this.anotaciones;
        this.anotaciones = anotaciones;
        changeSupport.firePropertyChange("anotaciones", oldAnotaciones, anotaciones);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (identificador != null ? identificador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Clientes)) {
            return false;
        }
        Clientes other = (Clientes) object;
        if ((this.identificador == null && other.identificador != null) || (this.identificador != null && !this.identificador.equals(other.identificador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "bufetePackage.Clientes[ identificador=" + identificador + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
