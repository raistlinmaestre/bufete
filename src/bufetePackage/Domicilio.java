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


    public String getDireccion() {
        return direccion;
    }

    public int getEscalera() {
        return escalera;
    }

    public char getLetra() {
        return letra;
    }

    public int getPortal() {
        return portal;
    }

    public int getTipoDeVia() {
        return tipoDeVia;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public void setTipoDeVia(int tipoDeVia) {
        this.tipoDeVia = tipoDeVia;
    }

    public void setPortal(int portal) {
        this.portal = portal;
    }

    public void setEscalera(int escalera) {
        this.escalera = escalera;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }
    
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

    public Domicilio(String direccion, int tipoDeVia, int portal, int escalera, char letra, String edificio) {
        this.direccion = direccion;
        this.tipoDeVia = tipoDeVia;
        this.portal = portal;
        this.escalera = escalera;
        this.letra = letra;
        this.edificio = edificio;
    }
  
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
