/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.practica.banca_1.clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jeffe
 */
public class Prestamo {

    private final Conexion conn;
    private ResultSet resultado;
    private double monto;
    private int tiempo;

    public Prestamo(double monto, int tiempo) {
        this.monto = monto;
        this.tiempo = tiempo;
        conn = new Conexion();
    }

    public int monto() {
        
        String[] Datos = new String[5];
        DefaultTableModel model = new DefaultTableModel();
        String cuenta = "10023";
        try {// buscar el ultimo mes  importante SELECT * FROM `usuario` ORDER BY `etiqueta` DESC LIMIT 1
            resultado = conn.ejecutarSQLSelect("select codigo_movimiento,EXTRACT(MONTH from fecha), EXTRACT(YEAR from fecha)"
                    + ",monto,saldo from movimiento where  codigo_cuenta = " + cuenta + " order by fecha  DESC LIMIT 1");
            while (resultado.next()) {
                Datos[0] = resultado.getString(1);
                System.out.println("codigo  " + Datos[0]);
                Datos[1] = resultado.getString(2);
                System.out.println("tipo  " + Datos[1]);
                Datos[2] = resultado.getString(3);
                System.out.println("Fecha  " + Datos[2]);
                Datos[3] = resultado.getString(4);
                System.out.println("Monto " + Datos[3]);
                Datos[4] = resultado.getString(5);
                System.out.println("Saldo " + Datos[4]);

                //  model.addRow(Datos);
            }
            // busco todos los datos luego comparo solo con los del ultimo mes 
            // importante SELECT EXTRACT( YEAR_MONTH FROM `date` ) FROM `Table` WHERE Condition = 'Condition';
            resultado = conn.ejecutarSQLSelect("select COUNT(*),SUM(saldo) from movimiento where  codigo_cuenta = " + cuenta + " and EXTRACT(MONTH from fecha)= " + Datos[1] + " and EXTRACT(YEAR from fecha)=" + Datos[2] + "");
            while (resultado.next()) {
                Datos[0] = resultado.getString(1);
                System.out.println("NUMERO  " + Datos[0]);
                Datos[1] = resultado.getString(2);
                System.out.println("SALDO " + Datos[1]);
              // con esto ya puedo sacar el promedio 
            }

            System.out.println("");
            //  Mostrar.setModel(model);

            //  model.addRow(Datos);
        } catch (SQLException ex) {
        }

        return 0;
    }
}
