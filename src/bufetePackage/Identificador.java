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
public class Identificador {
    private char letra;
    private char control;
    private int numero;

    /**
     * Get the value of numero
     *
     * @return the value of numero
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Set the value of numero
     *
     * @param numero new value of numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    /**
     * Get the value of control
     *
     * @return the value of control
     */
    public char getControl() {
        return control;
    }

    /**
     * Set the value of control
     *
     * @param control new value of control
     */
    public void setControl(char control) {
        this.control = control;
    }

    /**
     * Get the value of letra
     *
     * @return the value of letra
     */
    public char getLetra() {
        return letra;
    }

    /**
     * Set the value of letra
     *
     * @param letra new value of letra
     */
    public void setLetra(char letra) {
        this.letra = letra;
    }
    
    public String toString(){
        String cadena = new String();
        if (letra != '\000')
            cadena = Character.toString(letra);
        cadena += Integer.toString(numero)+control;
        return cadena;
    }
  
  
    public Identificador(char letra, int numero) {
        this.letra = letra;
        this.numero = numero;
        this.control = Identificador.calcularControl(numero);
    }

    public Identificador(int numero) {
        this.letra = '\000';
        this.numero = numero;
        this.control = Identificador.calcularControl(numero);
    }

    public Identificador() {
    }
    /**
     * Establece el número y el carácter de control a partir de un String de 9 caracteres con los mismos
     * 
     * @param nif String de 9 caracteres. 8 serán numéricos y el 9º alfabético
     */
    public Identificador(String nif){//TODO: caso más genérico
        this.control = nif.charAt(8);
        this.numero = Integer.parseInt(nif.substring(0,8));
    }
    
   /** Comprueba si el dígito de control es el correcto, devuelve falso en caso contrario.
   * @param numero Número del NIF
   * @param control Dígito de control
   * @return Devuelve verdadero si coincide
   */
    public static boolean comporbarControl(int numero, char control){
        if (Character.isLowerCase(control))
            control = Character.toUpperCase(control);
        if (control == calcularControl(numero))
            return true;
        return false;
    }
    //De momento sólo calcula para el DNI
    public static char calcularControl(int numero){
        char control;
        int resto;
        resto = numero % 23;
        switch (resto) {
            case 0:
                control = 'T';
                return control;
            case 1:
                control = 'R';
                return control;
            case 2:
                control = 'W';
                return control;
            case 3:
                control = 'A';
                return control;
            case 4:
                control = 'G';
                return control;
            case 5:
                control = 'M';
                return control;
            case 6:
                control = 'Y';
                return control;
            case 7:
                control = 'F';
                return control;
            case 8:
                control = 'P';
                return control;
            case 9:
                control = 'D';
                return control;
            case 10:
                control = 'X';
                return control;
            case 11:
                control = 'B';
                return control;
            case 12:
                control = 'N';
                return control;
            case 13:
                control = 'J';
                return control;
            case 14:
                control = 'Z';
                return control;
            case 15:
                control = 'S';
                return control;
            case 16:
                control = 'Q';
                return control;
            case 17:
                control = 'V';
                return control;
            case 18:
                control = 'H';
                return control;
            case 19:
                control = 'L';
                return control;
            case 20:
                control = 'C';
                return control;
            case 21:
                control = 'K';
                return control;
            case 22:
                control = 'E';
                return control;
            default:
                System.err.print(resto);
                control = '\000';
                return control;
        }
    } 
}
