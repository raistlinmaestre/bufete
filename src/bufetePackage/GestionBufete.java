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
 *
 * @author draco
 */
public class GestionBufete {
    private PreparedStatement pst = null;
    private ResultSet rs = null;
    private static Connection con = null;
    private static final String url = "jdbc:mysql://localhost:3306/bufete";
    
    public static void establecerConexion (String user, String password) {
        try {
            con = DriverManager.getConnection(url, user, password);
        } catch (SQLException ex) {
            Logger lgr = Logger.getLogger(BufeteJFrame.class.getName());
            lgr.log(Level.SEVERE, ex.getMessage(), ex);
            javax.swing.JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
        }
    }
    
    public boolean isConnected() {
        if (con == null)
            return false;
        else
            return true;
    }
    
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
     * 
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param nif
     * @param juridica
     * @param domicilio
     * @param localidad
     * @param codigo
     * @param con 
     */
    public void addCliente (String nombre, String apellido1, String apellido2, String nif,
            boolean juridica, String domicilio, String localidad, int codigo) {
        try{
            /*pst = con.prepareStatement("INSERT INTO clientes (nombre, apellido1, apellido2,"
                    + " identificador, juridica, domicilio, localidad, codigo) VALUES " +
                    "('" + nombre +"', '"+apellido1+"', '"+apellido2+"', '"+nif+"', '" + juridica
                    + "', '" + domicilio + "', '" + localidad + "', " + codigo + ");");*/
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
     * 
     * @param nombre
     * @param apellido1
     * @param apellido2
     * @param nif
     * @param juridica
     * @param domicilio
     * @param localidad
     * @param codigo
     * @param identificador
     * @param con 
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
 