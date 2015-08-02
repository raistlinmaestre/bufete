/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bufetePackage;

/**
 * Clase que rige los procedimientos
 * 
 * @author draco
 */
public class Procedimiento {
    
    private String juzgado;
    private boolean judicial;
    private String anotaciones;
    private String tipoDeProcedimiento;
    private String nig;
    private float minuta;
    private String numeroProcedimiento;
    private boolean abierto;
    private float pagado;
    private String procurador;    
    private String procuradorContrario;
    private String fecha;
    private int expediente;

    /**
     * Get the value of expediente
     *
     * @return the value of expediente
     */
    public int getExpediente() {
        return expediente;
    }
    /**
     * Set the value of expediente
     *
     * @param expediente new value of expediente
     */
    public void setExpediente(int expediente) {
        this.expediente = expediente;
    }
    /**
     * Get the value of fecha
     *
     * @return the value of fecha
     */
    public String getFecha() {
        return fecha;
    }
    /**
     * Set the value of fecha
     *
     * @param fecha new value of fecha
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    /**
     * Get the value of procuradorContrario
     *
     * @return the value of procuradorContrario
     */
    public String getProcuradorContrario() {
        return procuradorContrario;
    }
    /**
     * Set the value of procuradorContrario
     *
     * @param procuradorContrario new value of procuradorContrario
     */
    public void setProcuradorContrario(String procuradorContrario) {
        this.procuradorContrario = procuradorContrario;
    }
    /**
     * Get the value of procurador
     *
     * @return the value of procurador
     */
    public String getProcurador() {
        return procurador;
    }
    /**
     * Set the value of procurador
     *
     * @param procurador new value of procurador
     */
    public void setProcurador(String procurador) {
        this.procurador = procurador;
    }
    /**
     * Get the value of pagado
     *
     * @return the value of pagado
     */
    public float getPagado() {
        return pagado;
    }
    /**
     * Set the value of pagado
     *
     * @param pagado new value of pagado
     */
    public void setPagado(float pagado) {
        this.pagado = pagado;
    }
    /**
     * Get the value of abierto
     *
     * @return the value of abierto
     */
    public boolean isAbierto() {
        return abierto;
    }
    /**
     * Set the value of abierto
     *
     * @param abierto new value of abierto
     */
    public void setAbierto(boolean abierto) {
        this.abierto = abierto;
    }
    /**
     * Get the value of numeroProcedimiento
     *
     * @return the value of numeroProcedimiento
     */
    public String getNumeroProcedimiento() {
        return numeroProcedimiento;
    }
    /**
     * Set the value of numeroProcedimiento
     *
     * @param numeroProcedimiento new value of numeroProcedimiento
     *
    public void setNumeroProcedimiento(String numeroProcedimiento) {
        this.numeroProcedimiento = numeroProcedimiento;
    }*/
    /**
     * Get the value of minuta
     *
     * @return the value of minuta
     */
    public float getMinuta() {
        return minuta;
    }
    /**
     * Set the value of minuta
     *
     * @param minuta new value of minuta
     */
    public void setMinuta(float minuta) {
        this.minuta = minuta;
    }
    /**
     * Get the value of NIG
     *
     * @return the value of nig
     */
    public String getNig() {
        return nig;
    }
    /**
     * Set the value of nig
     *
     * @param nig new value of nig
     */
    public void setNig(String nig) {
        this.nig = nig;
    }
    /**
     * Get the value of tipoDeProcedimiento
     *
     * @return the value of tipoDeProcedimiento
     */
    public String getTipoDeProcedimiento() {
        return tipoDeProcedimiento;
    }
   /**
     * Set the value of tipoDeProcedimiento
     *
     * @param tipoDeProcedimiento new value of tipoDeProcedimiento
     */
    public void setTipoDeProcedimiento(String tipoDeProcedimiento) {
        this.tipoDeProcedimiento = tipoDeProcedimiento;
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
     * Get the value of judicial
     *
     * @return the value of judicial
     */
    public boolean isJudicial() {
        return judicial;
    }
    /**
     * Set the value of judicial
     *
     * @param judicial new value of judicial
     */
    public void setJudicial(boolean judicial) {
        this.judicial = judicial;
    }
    /**
     * Get the value of juzgado
     *
     * @return the value of juzgado
     */
    public String getJuzgado() {
        return juzgado;
    }
    /**
     * Set the value of juzgado
     *
     * @param juzgado new value of juzgado
     */
    public void setJuzgado(String juzgado) {
        this.juzgado = juzgado;
    }
    /**
     * Construcctor de la clase
     * @param juzgado Juzgado que lleva el procedimiento
     * @param judicial Indica si el procedimiento es o no judicial
     * @param tipoDeProcedimiento Tipo de procedimiento
     * @param nig DNI del cliente
     * @param minuta Pago acordado
     * @param numeroProcedimiento Número del procedimiento
     * @param abierto Indica si el procedimiento está o no abierto
     * @param pagado Cantidad abonada hasta la fecha
     * @param procurador Procurador de la parte contratante
     * @param procuradorContrario Procurador de la parte contraria
     * @param fecha Fecha de vencimiento
     */
    public Procedimiento(String juzgado, boolean judicial, String tipoDeProcedimiento, String nig, float minuta, String numeroProcedimiento, boolean abierto, float pagado, String procurador, String procuradorContrario, String fecha) {
        this.juzgado = juzgado;
        this.judicial = judicial;
        this.tipoDeProcedimiento = tipoDeProcedimiento;
        this.nig = nig;
        this.minuta = minuta;
        this.numeroProcedimiento = numeroProcedimiento;
        this.abierto = abierto;
        this.pagado = pagado;
        this.procurador = procurador;
        this.procuradorContrario = procuradorContrario;
        this.fecha = fecha;
    }
    /**
     * Constructor por defecto
     */
    public Procedimiento(){}
}
