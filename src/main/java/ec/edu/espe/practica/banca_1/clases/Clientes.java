
package ec.edu.espe.practica.banca_1.clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author diegoyandun
 */
public class Clientes {
    private final Conexion conn;
    private ResultSet resultado;
    //Atributos para nuevo cliente
    private String Nombre;
    private String Cedula;
    private String Genero;
    private double Ingreso_mensual;
    private int Codigo;
    private int control;
    String[] Datos=new String[4];

    public Clientes() {
        conn = new Conexion();
        control = 0;
    }
    
    
    public int buscarClieentes(JTable Tabla){
        DefaultTableModel model = new DefaultTableModel();
        int band=0;
        Datos[0]="-1";
        model.addColumn("Cedula");
        model.addColumn("Nombre");
        model.addColumn("Genero");
        model.addColumn("Ingreso Mensual");
        Tabla.setModel(model);
        try {
            resultado = conn.ejecutarSQLSelect("select * from Cliente where CEDULA like '%"+Cedula+"%'");
            while (resultado.next()) {
                    Datos[0] = resultado.getString(1);
                    Datos[1] = resultado.getString(2);
                    Datos[2] = resultado.getString(3);
                    Datos[3] = resultado.getString(4);
                    model.addRow(Datos);
                    band=1;
                    control = 99;      
            }
            Tabla.setModel(model);
            if(Datos[0]=="-1"){
                 JOptionPane.showMessageDialog(null, "El Cliente ya esta Registrado");
                 control=0;
                 band=0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return band;
    }
    
        public void listaClieentes(JTable Tabla){
        DefaultTableModel model = new DefaultTableModel();
        int band=0;
        Datos[0]="-1";
        model.addColumn("Cédula");
        model.addColumn("Nombre");
        model.addColumn("Genero");
        model.addColumn("Ingreso Mensual");
        Tabla.setModel(model);
        try {
            resultado = conn.ejecutarSQLSelect("select * from Cliente");
            while (resultado.next()) {
                    Datos[0] = resultado.getString(1);
                    Datos[1] = resultado.getString(2);
                    Datos[2] = resultado.getString(3);
                    Datos[3] = resultado.getString(4);
                    model.addRow(Datos);
                    Tabla.setModel(model);
                      
            }           
            System.out.println(Datos[0]);
            if(Datos[0]=="-1"){
                 JOptionPane.showMessageDialog(null, "No hay Clientes registrados");                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    
    public void generarCodigo(){
        String cod = "0";       
        try {
            resultado = conn.ejecutarSQLSelect("Select max(U_CODIGO) from usuario");
            while (resultado.next()) {
                cod = resultado.getString(1);
            }
            Codigo = Integer.parseInt(cod);
            Codigo++;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public double getIngreso_mensual() {
        return Ingreso_mensual;
    }

    public void setIngreso_mensual(double Ingreso_mensual) {
        this.Ingreso_mensual = Ingreso_mensual;
    }
       

       
    public void nuevoCliente(){
        if(control != 99){
            conn.ejecutarSQL("INSERT INTO cliente(CEDULA,NOMBRE,GENERO,INGRESO_MENSUAL)" +
                "VALUES ('"+Cedula+"','"+Nombre+"','"+Genero+"','"+Ingreso_mensual+"')"); 
        }else{
            JOptionPane.showMessageDialog(null, "El cliente se encuentra registrado");
        }
    }
    
    public void actualizarCliente(){        
        if(control == 99){
            if(Datos[1].equals(Nombre) || Datos[3].equals(Ingreso_mensual)){
                JOptionPane.showMessageDialog(null, "No a modificado la informacion");
            }else{
                conn.ejecutarSQL("UPDATE cliente set NOMBRE='"+Nombre+"', INGRESO_MENSUAL="+Ingreso_mensual+" where CEDULA='"+Cedula+"'"); 
                JOptionPane.showMessageDialog(null, "Cliente modificado");
            }
        }else{
            JOptionPane.showMessageDialog(null, "Cliente no registrado");
        }
    }

    
    public void borrarCliente(){
       

        int val=JOptionPane.showConfirmDialog(null,"Se borra el cliente con cedula: "+Cedula);
        
        if(val==0){
            if(control == 99){
                conn.ejecutarSQL("DELETE FROM cliente WHERE CEDULA='"+Cedula+"'");
                JOptionPane.showMessageDialog(null, "Cliente borrado");
            }else{
                JOptionPane.showMessageDialog(null, "Cliente no registrado");
            }
        }

    }
    
    public boolean validarCedula(String cedula){
        boolean cedulaCorrecta = false; 
        try {
            if (cedula.length() == 10) // ConstantesApp.LongitudCedula
            {
                int tercerDigito = Integer.parseInt(cedula.substring(2, 3));
                if (tercerDigito < 6) {
                    // Coeficientes de validación cédula
                    // El decimo digito se lo considera dígito verificador
                    int[] coefValCedula = { 2, 1, 2, 1, 2, 1, 2, 1, 2 };
                    int verificador = Integer.parseInt(cedula.substring(9,10));
                    int suma = 0;
                    int digito = 0;
                    for (int i = 0; i < (cedula.length() - 1); i++) {
                        digito = Integer.parseInt(cedula.substring(i, i + 1))* coefValCedula[i];
                        suma += ((digito % 10) + (digito / 10));
                    }
                    if ((suma % 10 == 0) && (suma % 10 == verificador)) {
                        cedulaCorrecta = true;
                    }
                    else if ((10 - (suma % 10)) == verificador) {
                        cedulaCorrecta = true;
                    } else {
                        cedulaCorrecta = false;
                    }
                } else {
                    cedulaCorrecta = false;
                }
            } else {//primero
                cedulaCorrecta = false;
            }
        } catch (NumberFormatException nfe) {
            cedulaCorrecta = false;
        } catch (Exception err) {
            JOptionPane.showMessageDialog(null,"Una excepcion ocurrio en el proceso de validadcion" + err);
        cedulaCorrecta = false;
        }
        if (!cedulaCorrecta) {
            JOptionPane.showMessageDialog(null,"La Cédula ingresada es Incorrecta");        
        }
        return cedulaCorrecta;
    }
}
