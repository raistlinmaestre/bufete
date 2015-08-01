/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bufetePackage;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author draco
 */
public class Cliente implements Serializable {
    
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Identificador identificador;
    private Domicilio domicilio;
    private ArrayList<Procedimiento> listaProcedimientos;
    private String anotaciones;
    private boolean juridica;

    /**
     * Get the value of juridica
     *
     * @return the value of juridica
     */
    public boolean isJuridica() {
        return juridica;
    }

    /**
     * Set the value of juridica
     *
     * @param juridica new value of juridica
     */
    public void setJuridica(boolean juridica) {
        this.juridica = juridica;
    }


    /**
     * Get the value of anotaciones
     *
     * @return the value of anotaciones
     */
    public String getAnotaciones() {
        return anotaciones;
    }

    /**
     * Set the value of anotaciones
     *
     * @param anotaciones new value of anotaciones
     */
    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }

    /**
     * Get the value of domicilio
     *
     * @return the value of domicilio
     */
    public Domicilio getDomicilio() {
        return domicilio;
    }

    /**
     * Set the value of domicilio
     *
     * @param domicilio new value of domicilio
     */
    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }


    /**
     * Get the value of identificador
     *
     * @return the value of identificador
     */
    public Identificador getIdentificador() {
        return identificador;
    }

    /**
     * Set the value of identificador
     *
     * @param identificador new value of identificador
     */
    public void setIdentificador(Identificador identificador) {
        this.identificador = identificador;
    }


    /**
     * Get the value of apellido2
     *
     * @return the value of apellido2
     */
    public String getApellido2() {
        return apellido2;
    }

    /**
     * Set the value of apellido2
     *
     * @param apellido2 new value of apellido2
     */
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }


    /**
     * Get the value of apellido1
     *
     * @return the value of apellido1
     */
    public String getApellido1() {
        return apellido1;
    }

    /**
     * Set the value of apellido1
     *
     * @param apellido1 new value of apellido1
     */
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }


    /**
     * Get the value of nombre
     *
     * @return the value of nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Set the value of nombre
     *
     * @param nombre new value of nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Añade un procedimiento a la lista
     * @param procedimiento 
     */
    public void addProcedimiento(Procedimiento procedimiento){
        listaProcedimientos.add(procedimiento);
    }
    /**
     * 
     * @param num
     * @return 
     */
    public Procedimiento getProcedimiento(int num){
        if (listaProcedimientos.size() != 0)
            return listaProcedimientos.get(num);
        else
            return null;
    }
    
    public ArrayList<Procedimiento> getListaProcedimientos(){
        if (listaProcedimientos.size() != 0)
            return listaProcedimientos;
        else
            return null;
    }
    
    
    
    /**
     * 
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param identificador
     * @param domicilio 
     */

    public Cliente(String nombre, String apellido1, String apellido2, Identificador identificador, Domicilio domicilio) {
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.identificador = identificador;
        this.domicilio = domicilio;
        this.listaProcedimientos = new ArrayList<Procedimiento>();
        this.anotaciones = null;
    }

    public Cliente() {
        this.nombre = null;
        this.apellido1 = null;
        this.apellido2 = null;
        this.identificador = null;
        this.domicilio = null;
        this.listaProcedimientos = new ArrayList<Procedimiento>();
        this.anotaciones = null;
    }
    
    
    
}
