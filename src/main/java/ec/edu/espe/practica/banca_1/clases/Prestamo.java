/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.practica.banca_1.clases;

import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.text.DecimalFormat;


/**
 *
 * @author DiegoYandun
 */
public class Prestamo {

    private final Conexion conn;
    private ResultSet resultado;
    private double monto;
    private int tiempo;
    private double interes;
    private double cuotaPagar;
    
    DefaultTableModel model;

    public Prestamo() {
        this.monto = 0.0;
        this.tiempo = 0;
        this.interes = 0;
        conn = new Conexion();
    }

    public double getInteres() {
        return interes;
    }


    public double montoPromedio(String cedula) {

       String[] Datos = new String[5];

        try {// buscar el ultimo mes  importante SELECT * FROM `usuario` ORDER BY `etiqueta` DESC LIMIT 1
            resultado = conn.ejecutarSQLSelect("select mov.codigo_movimiento,EXTRACT(MONTH from mov.fecha), "
                    + "EXTRACT(YEAR from mov.fecha) , mov.CODIGO_CUENTA, mov.saldo from movimiento mov ,cuenta cue "
                    + "where cue.codigo_cuenta= mov.codigo_cuenta and cue.cedula = " + cedula + " order by fecha  DESC LIMIT 1");
            while (resultado.next()) {
                Datos[0] = resultado.getString(1);
                System.out.println("codigo  " + Datos[0]);
                Datos[1] = resultado.getString(2);
                System.out.println("Mes  " + Datos[1]);
                Datos[2] = resultado.getString(3);
                System.out.println("AÃ±o  " + Datos[2]);
                Datos[3] = resultado.getString(4);
                System.out.println("codigo de cuenta  " + Datos[3]);
                Datos[4] = resultado.getString(5);
                System.out.println("Saldo " + Datos[4]);

            }

            resultado = conn.ejecutarSQLSelect("select COUNT(*),SUM(saldo) from movimiento where  codigo_cuenta = "
                    + Datos[3] + " and EXTRACT(MONTH from fecha)= " + Datos[1] + " and EXTRACT(YEAR from fecha)=" + Datos[2] + "");
            while (resultado.next()) {
                Datos[0] = resultado.getString(1);
                System.out.println("NUMERO  " + Datos[0]);
                Datos[1] = resultado.getString(2);
                System.out.println("SALDO " + Datos[1]);
                // con esto ya puedo sacar el promedio 
            }

        } catch (SQLException ex) {
        }
        double dividendo = Double.parseDouble(Datos[1]);
        double divisor = Double.parseDouble(Datos[0]);
        return dividendo / divisor;

    }

    public void tablaAmortizacion(JComboBox tiemp, double valPrestamo, JTable Tabla) {
        
        DefaultTableModel model=new DefaultTableModel();
        model.addColumn("Mes");
        model.addColumn("Amortizacion");
        model.addColumn("Interes");
        model.addColumn("Pago");
        model.addColumn("Saldo");
        Tabla.setModel(model);
        DecimalFormat formd = new DecimalFormat("0.00");
        String Datos[] = new String[5];
        int mes=0;
        double cantint=0;
        double pago=0;
        tiempo = Integer.parseInt(tiemp.getSelectedItem().toString());
        if (tiempo <= 12) {
            interes = 0.1;
        } else {
            interes = 0.16;
        }
        pago=valPrestamo*(((Math.pow((1+interes),tiempo))*interes)/((Math.pow((1+interes), tiempo))-1));
        Datos[0]=String.valueOf(mes);
        Datos[1]="";Datos[2]="";Datos[3]="";
        Datos[4]=String.valueOf(valPrestamo);
        model.addRow(Datos);
        Tabla.setModel(model);
        do{
            mes++;
            Datos[0]=String.valueOf(mes);
            cantint=valPrestamo*interes;
            Datos[1]=String.valueOf(formd.format(pago-cantint));           
            Datos[2]=String.valueOf(formd.format(cantint));           
            Datos[3]=String.valueOf(formd.format(pago));
            valPrestamo=valPrestamo-(pago-cantint);
            Datos[4]=String.valueOf(formd.format(valPrestamo));
                       
            model.addRow(Datos);
            Tabla.setModel(model);
        }while(Math.floor(valPrestamo)>0);        
    }

}
