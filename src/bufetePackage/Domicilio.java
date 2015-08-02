/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bufetePackage;

/**
 *
 * @author draco
 */
public class Domicilio {
    
    public final static int calle=0;
    public final static int avenida=1;
    public final static int plaza=2;
    private String direccion;
    private int tipoDeVia;
    private int portal;
    private int escalera;
    private char letra;
    private String edificio;
    private String localidad;  
    private String provincia;

    private int codigo;

    /**
     * Get the value of codigo
     *
     * @return the value of codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Set the value of codigo
     *
     * @param codigo new value of codigo
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * Get the value of provincia
     *
     * @return the value of provincia
     */
    public String getProvincia() {
        return provincia;
    }

    /**
     * Set the value of provincia
     *
     * @param provincia new value of provincia
     */
    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }


    /**
     * Get the value of localidad
     *
     * @return the value of localidad
     */
    public String getLocalidad() {
        return localidad;
    }

    /**
     * Set the value of localidad
     *
     * @param localidad new value of localidad
     */
    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    /**
     * Get de value of direccion
     * 
     * @return direccion value of direccion
     */
    public String getDireccion() {
        return direccion;
    }
    /**
     * Get the value of escalera
     * 
     * @return escalera value of escalera
     */
    public int getEscalera() {
        return escalera;
    }
    /**
     * Get the value of letra
     * 
     * @return letra value of letra
     */
    public char getLetra() {
        return letra;
    }
    /**
     * Get the value of portal
     * 
     * @return portal value of portal
     */
    public int getPortal() {
        return portal;
    }
    /** Get the value of tipoDeVia
     * 
     * @return tipoDeVia value of tipoDeVia
     */
    public int getTipoDeVia() {
        return tipoDeVia;
    }
    /**
     * Get the value of edificio
     * 
     * @return edificio value of edificio
     */
    public String getEdificio() {
        return edificio;
    }
    /**
     * Set the value of direccion
     * 
     * @param direccion new value of direccion
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    /**
     * Set the value of edificio
     * 
     * @param edificio new value of edificio
     */
    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }
    /**
     * Set the value of tipoDeVia
     * 
     * @param tipoDeVia new value of tipoDeVia
     */
    public void setTipoDeVia(int tipoDeVia) {
        this.tipoDeVia = tipoDeVia;
    }
    /**
     * Set the value of portal
     * 
     * @param portal new value of portal
     */
    public void setPortal(int portal) {
        this.portal = portal;
    }
    /**
     * Set the value of escalera
     * 
     * @param escalera 
     */
    public void setEscalera(int escalera) {
        this.escalera = escalera;
    }
    /** 
     * Set the value of letra
     * @param letra new value of letra
     */
    public void setLetra(char letra) {
        this.letra = letra;
    }
    /**
     * Instancia del método toString()
     * @return Dirección completa
     */
    public String toString(){
        String cadena = new String();
        /*switch (tipoDeVia) {
            case 0:
                cadena = "C/ ";
                break;
            case 1:
                cadena = "Avda. ";
                break;
            case 2:
                cadena = "Pza. ";
                break;
            default:
                // No se añade nada
        }*/
        cadena += direccion;
        /*if (edificio != null)
            cadena += " Edificio " + edificio;
        if (portal != 0)
            cadena += " Nº " + portal;
        if (escalera != 0)
            cadena += " Escalera " + escalera;
        if (letra != '\000')
            cadena += " " + letra;*/
        /*cadena += " " + codigo;
        cadena += " " + localidad;
        if (provincia != null)
            cadena += " (" + provincia + ")";*/
       
        return cadena;
    }
    /**
     * Constructor explícito
     * 
     * @param direccion Nombre de la calle, avenida o plaza
     * @param tipoDeVia Especifica el tipo de vía (calle, avenida o plaza)
     * @param portal Número del portal
     * @param escalera Número de escalera
     * @param letra Letra del domicilio
     * @param edificio Nombre del edificio
     */
    public Domicilio(String direccion, int tipoDeVia, int portal, int escalera, char letra, String edificio) {
        this.direccion = direccion;
        this.tipoDeVia = tipoDeVia;
        this.portal = portal;
        this.escalera = escalera;
        this.letra = letra;
        this.edificio = edificio;
    }
    /**
     * Constructor por defecto
     */
    public Domicilio(){
        tipoDeVia = 0;
        direccion = null;
        portal = 0;
        escalera = 0;
        letra = '\000';
        edificio = null;
        codigo = 0;
        localidad = null;
        provincia = null;
    }
    
  
}
