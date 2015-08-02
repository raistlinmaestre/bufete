/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bufetePackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.Date;

/**
 * Clase que realiza las gestiones de la base de datos
 * 
 * @author draco
 */
public class GestionBufete {
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private static Connection con = null;
    private static final String url = "jdbc:mysql://localhost:3306/bufete";
    
    /**
     * Establece una conexión con la base de datos
     * 
     * @param user Usuario de la base de datos
     * @param password Contraseña del usuario
     */
    public static void establecerConexion(String user, String password) {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(BufeteJFrame.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            javax.swing.JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        }
    }
    /**
     * Comprueba si hay una conexión activa con la base de datos
     * 
     * @return Devuelve verdadero si hay conexión con la base de datos activa
     */
    public boolean isConnected() {
        if (con == null)
            return false;
        else
            return true;
    }
    /**
     * Busca los clientes que cumplen con los criterios de búsqueda
     * 
     * @param tipoBusqueda Establece el parámetro a comparar
     * @param valor Valor con el cual se realiza la búsqueda
     * @return Lista con los DNI de los clientes que cumplen los criterios de búsqueda
     */
    public ArrayList<String[]> busqueda(int tipoBusqueda, String valor){ //TODO: demás casos
        int contador = 0;
        ArrayList<String[]> lista = new ArrayList<String[]>(); 
        switch (tipoBusqueda) {
            case 0: //Nombre
                try {
                    pst = con.prepareStatement("SELECT apellido1, apellido2, nombre, identificador FROM clientes "+
                            "WHERE (nombre LIKE '%"+valor+"%') OR "+
                            "(apellido1 LIKE '%"+valor+"%') OR "+
                            "(apellido2 LIKE '%"+valor+"%') ORDER BY apellido1;");
                    rs = pst.executeQuery();
                    while (rs.next()) {
                        String[] cliente = new String[2];
                        cliente[0] = rs.getString(1)+" "+rs.getString(2)+", "+rs.getString(3);
                        cliente[1] = rs.getString(4);
                        lista.add(cliente);
                    }
                } catch (SQLException ex) {
                    Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                } finally {
                    try {
                        if (rs != null)
                            rs.close();
                        if (pst != null)
                            pst.close();
                    } catch (SQLException ex) {
                        Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                        lgr.log(Level.SEVERE, ex.getMessage(), ex);
                    }
                }
                return lista;
            case 1: //NIF
                try{
                    pst = con.prepareStatement("SELECT apellido1, apellido2, nombre, identificador FROM clientes "
                            + "WHERE identificador LIKE '%"+valor+"%' ORDER BY apellido1;");
                    rs = pst.executeQuery();
                    if (rs.next()) {
                        String[] cliente = new String[2];
                        cliente[0] = rs.getString(1)+" "+rs.getString(2)+", "+rs.getString(3);
                        cliente[1] = rs.getString(4);
                        lista.add(cliente);
                    }
                } catch (SQLException ex) {
                    Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                } finally {
                    try {
                        if (rs != null)
                            rs.close();
                        if (pst != null)
                            pst.close();
                    } catch (SQLException ex) {
                        Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                        lgr.log(Level.SEVERE, ex.getMessage(), ex);
                    }
                }
                return lista;
            case 2: //TODO: mejorar (buscar cómo acceder a clientes desde procedimientos)
                try{
                    ArrayList<String> identificadores = new ArrayList<String>();
                    pst = con.prepareStatement("SELECT identificador FROM procedimientos "
                            + "WHERE numero LIKE '%"+valor+"%';");
                    rs = pst.executeQuery();
                    while (rs.next())
                        identificadores.add(rs.getString(valor));
                    if (identificadores.isEmpty() != true){
                        while (contador < identificadores.size()) {
                            pst = con.prepareStatement("SELECT apellido1, apellido2, nombre, identificador FROM clientes "
                                    + "WHERE identificador='" + identificadores.get(contador) + "';");
                            rs = pst.executeQuery();
                            if (rs.next()) {
                                String[] cliente = new String[2];
                                cliente[0] = rs.getString(1)+" "+rs.getString(2)+", "+rs.getString(3);
                                cliente[1] = rs.getString(4);
                                lista.add(cliente);
                            }
                            contador++;
                        }
                    }
                } catch (SQLException ex) {
                    Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                } finally {
                    try {
                        if (rs != null)
                            rs.close();
                        if (pst != null)
                            pst.close();
                    } catch (SQLException ex) {
                        Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                        lgr.log(Level.SEVERE, ex.getMessage(), ex);
                    }
                }
                return lista;
            case 3:
                try{
                    ArrayList<String> identificadores = new ArrayList<String>();
                    pst = con.prepareStatement("SELECT identificador FROM procedimientos "
                            + "WHERE juzgado='" + valor + "';");
                    rs = pst.executeQuery();
                    while (rs.next())
                        identificadores.add(rs.getString(valor));
                    if (identificadores.isEmpty() != true){
                        while (contador < identificadores.size()) {
                            pst = con.prepareStatement("SELECT apellido1, apellido2, nombre, identificador FROM clientes "
                                    + "WHERE identificador='" + identificadores.get(contador) + "';");
                            rs = pst.executeQuery();
                            if (rs.next()) {
                                String[] cliente = new String[2];
                                cliente[0] = rs.getString(1)+" "+rs.getString(2)+", "+rs.getString(3);
                                cliente[1] = rs.getString(4);
                                lista.add(cliente);
                            }
                            contador++;
                        }
                    }
                } catch (SQLException ex) {
                    Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                } finally {
                    try {
                        if (rs != null)
                            rs.close();
                        if (pst != null)
                            pst.close();
                    } catch (SQLException ex) {
                        Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                        lgr.log(Level.SEVERE, ex.getMessage(), ex);
                    }
                }
            case 4: //Expediente
                try{
                    ArrayList<String> identificadores = new ArrayList<String>();
                    pst = con.prepareStatement("SELECT identificador FROM procedimientos "
                            + "WHERE expediente='" + valor + "';");
                    rs = pst.executeQuery();
                    while (rs.next())
                        identificadores.add(rs.getString(valor));
                    if (identificadores.isEmpty() != true){
                        while (contador < identificadores.size()) {
                            pst = con.prepareStatement("SELECT apellido1, apellido2, nombre, identificador FROM clientes "
                                    + "WHERE identificador='" + identificadores.get(contador) + "';");
                            rs = pst.executeQuery();
                            if (rs.next()) {
                                String[] cliente = new String[2];
                                cliente[0] = rs.getString(1)+" "+rs.getString(2)+", "+rs.getString(3);
                                cliente[1] = rs.getString(4);
                                lista.add(cliente);
                            }
                            contador++;
                        }
                    }
                } catch (SQLException ex) {
                    Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                    lgr.log(Level.SEVERE, ex.getMessage(), ex);
                } finally {
                    try {
                        if (rs != null)
                            rs.close();
                        if (pst != null)
                            pst.close();
                    } catch (SQLException ex) {
                        Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                        lgr.log(Level.SEVERE, ex.getMessage(), ex);
                    }
                }
                return lista;
            default:
                return null;
        } 
    }
    /** 
     * Busca los datos de un cliente
     * 
     * @param nif DNI del cliente
     * @return Datos del cliente
     */
    public Cliente busquedaDatos(String nif){
        Cliente cliente = new Cliente();
        Identificador identificador = new Identificador(nif);
        Domicilio domicilio = new Domicilio();
        Procedimiento procedimiento = new Procedimiento();
        try{
            pst = con.prepareStatement("SELECT nombre, apellido1, apellido2, anotaciones, juridica "+
                    "FROM clientes WHERE identificador='"+nif+"';");
            rs = pst.executeQuery();
            if (rs.next()) {
                cliente.setNombre(rs.getString(1));
                cliente.setApellido1(rs.getString(2));
                cliente.setApellido2(rs.getString(3));
                cliente.setAnotaciones(rs.getString(4));
                cliente.setJuridica(rs.getBoolean(5));
                cliente.setIdentificador(identificador);
            }
            //
            pst = con.prepareStatement("SELECT tipoVia, domicilio, portal, escalera, letra, codigo, localidad, provincia "+
                    "FROM domicilios WHERE identificador='"+nif+"';");
            rs = pst.executeQuery();
            if (rs.next()){
                domicilio.setTipoDeVia(rs.getInt(1));
                domicilio.setDireccion(rs.getString(2));
                domicilio.setPortal(rs.getInt(3));
                domicilio.setEscalera(rs.getInt(4));
                //domicilio.setEdificio(); TODO: añadir Edificio a domicilios en mysql
                domicilio.setLetra(rs.getString(5).charAt(0));
                domicilio.setCodigo(rs.getInt(6));
                domicilio.setLocalidad(rs.getString(7));
                domicilio.setProvincia(rs.getString(8));
                cliente.setDomicilio(domicilio);
            }
            pst = con.prepareStatement("SELECT numero, juzgado, tipo, abierto, minuta, pagado, procurador,"
                    + " procuradorContrario, fecha, expediente FROM procedimientos WHERE identificador='"+nif+"';");
            rs = pst.executeQuery();
            while(rs.next()) { // Lo hace para todos los procedimientos
                procedimiento.setNig(rs.getString(1));
                procedimiento.setJuzgado(rs.getString(2));
                procedimiento.setTipoDeProcedimiento(rs.getString(3));
                procedimiento.setAbierto(rs.getBoolean(4));
                procedimiento.setMinuta(rs.getInt(5));
                procedimiento.setPagado(rs.getInt(6));
                procedimiento.setProcurador(rs.getString(7));
                procedimiento.setProcuradorContrario(rs.getString(8));
                procedimiento.setFecha(rs.getDate(9).toString());
                procedimiento.setExpediente(rs.getInt(10));
                cliente.addProcedimiento(procedimiento);
            } 
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(GestionBufete.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (rs != null)
                    rs.close();
                if (pst != null)
                    pst.close();
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
        return cliente;
    }
    /**
     * Añade un nuevo cliente a la base de datos
     * 
     * @param nombre Nombre del cliente
     * @param apellido1 Primer apellido del cliente
     * @param apellido2 Segundo apellido del cliente
     * @param nif DNI del cliente
     * @param juridica Indica si es una persona jurídica o no (física)
     * @param domicilio Domicilio del cliente
     * @param localidad Localidad de residencia del cliente
     * @param codigo Código postal
     */
    public void addCliente (String nombre, String apellido1, String apellido2, String nif,
            boolean juridica, String domicilio, String localidad, int codigo) {
        try{
            pst =con.prepareStatement("INSERT INTO clientes (nombre, apellido1, apellido2,"
                    +" identificador, juridica) VALUES ('"+nombre+"', '"+apellido1+"', '"
                    +apellido2+"', '"+nif+"', " + juridica+");");
            pst.executeUpdate();
            pst =con.prepareStatement("INSERT INTO domicilios (domicilio, localidad, codigo, "
                    + "identificador) VALUES ('"+domicilio+"', '"+localidad+"', '"
                    +codigo+"', '"+nif+"');");
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(GestionBufete.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            javax.swing.JOptionPane.showMessageDialog(null, "Error al intentar escribir"
                    + "en la base de datos. Compruebe que todo ha sido escrito correctamente.");
        } finally {
            try {
                if (pst != null)
                    pst.close();
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    /**
     * Añade un procedimiento al cliente
     * 
     * @param nig DNI del cliente
     * @param numero Número del procedimiento
     * @param juzgado Juzgado que lleva el procedimiento
     * @param tipo Tipo de procedimiento
     * @param abierto Indica si el procedimiento está abierto o no
     * @param minuta Pago acordado
     * @param pagado Cantidad recibida hasta la fecha
     * @param fecha Fecha de vencimiento
     * @param procurador Procurador de la parte contratante
     * @param procuradorContrario Procurador de la parte contraria
     */
    public void addProcedimiento (String nig, String numero, String juzgado, String tipo, boolean abierto, 
            float minuta, float pagado, String fecha, String procurador, String procuradorContrario) {
        int ab = (abierto) ? 1 : 0;
        try{
            pst = con.prepareStatement("INSERT INTO procedimientos (identificador, numero, juzgado, tipo, "
                    +"abierto, minuta, pagado, fecha, procurador, procuradorContrario) VALUES "
                    +"('"+nig+"', '"+numero+"', '"+juzgado+"', '"+tipo+"', "+ab+", "+minuta+", "+pagado+", '"
                    +fecha+"', '"+procurador+"' , '"+procuradorContrario+"');");
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(GestionBufete.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (pst != null)
                    pst.close();
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
/**
 * Actualiza los datos del cliente
 * 
 * @param nombre Valor actualizado del nombre del cliente
 * @param apellido1 Valor actualizado del primer apellido del cliente
 * @param apellido2 Valor actualizado del segundo apellido del cliente
 * @param nif Valor actualizado del DNI del cliente
 * @param juridica Indica si es una persona jurídica o no (física)
 * @param domicilio Valor actualizado del domicilio del cliente
 * @param localidad Valor actualizado de la localidad de residencia del cliente
 * @param codigo Valor actualizado del código postal
 * @param identificador Valor actualizado no actualizado del DNI
 */
    public void updateCliente (String nombre, String apellido1, String apellido2, String nif,
            boolean juridica,
            String domicilio, String localidad, String codigo, String identificador) {
        try{
            int jur = (juridica) ? 1 : 0;
            pst = con.prepareStatement("UPDATE clientes SET nombre='" + nombre + "', apellido1='" + apellido1 + 
                    "', apellido2='" + apellido2 + "', identificador='" + nif + "' , juridica=" + jur + " "
                    + "WHERE identificador='" + identificador + "';");
            pst.executeUpdate();
            
            pst = con.prepareStatement("UPDATE domicilios SET domicilio='" + domicilio + "', localidad='"
                    + localidad + "', codigo='" + codigo + "' WHERE identificador='" + identificador + "';");
            pst.executeUpdate();
            
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(GestionBufete.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (pst != null)
                    pst.close();
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    /**
     * Actualiza los datos del procedimiento
     * 
     * @param numero Valor actualizado del número del procedimiento
     * @param juzgado Valor actualizado del juzgado que lleva el procedimiento
     * @param tipo Valor actualizado del tipo de procedimiento
     * @param abierto Indica si el procedimiento está abierto o no
     * @param minuta Valor actualizado del pago acordado
     * @param pagado Valor actualizado de la cantidad recibida hasta la fecha
     * @param fecha Valor actualizado de la fecha de vencimiento
     * @param procurador Valor actualizado del procurador de la parte contratante
     * @param procuradorContrario Valor actualizado del procurador de la parte contraria
     * @param anotaciones Valor actualizado del campo de anotaciones
     */
    public void updateProcedimiento(String numero, String juzgado, String tipo, boolean abierto, float minuta,
            float pagado, String fecha, String procurador, String procuradorContrario, String anotaciones){
        try{
            int ab = (abierto) ? 1 : 0;
            pst = con.prepareStatement("UPDATE procedimientos SET numero='" + numero + "', juzgado='" + juzgado + 
                    "', tipo='" + tipo + "', abierto=" + ab + ", minuta=" + minuta + ", pagado=" + pagado +
                    ", fecha='" + fecha + ", procurador='" + procurador + "', procuradorContrario='" +
                    procuradorContrario + "', anotaciones='" + anotaciones + "' WHERE numero='" + numero + "';");
            pst.executeUpdate();
            
            
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(GestionBufete.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
        } finally {
            try {
                if (pst != null)
                    pst.close();
            } catch (SQLException ex) {
                Logger lgr = Logger.getLogger(GestionBufete.class.getName());
                lgr.log(Level.SEVERE, ex.getMessage(), ex);
            }
        }
    }
    
}
 