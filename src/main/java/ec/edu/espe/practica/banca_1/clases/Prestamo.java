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
import javax.swing.JTextField;
import java.util.Calendar;

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
        Datos[0] = "-1";
        double res = 0;

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
            if (Datos[0].equals("-1")) {
                res = -1;
            } else {
                resultado = conn.ejecutarSQLSelect("select COUNT(*),SUM(saldo) from movimiento where  codigo_cuenta = "
                        + Datos[3] + " and EXTRACT(MONTH from fecha)= " + Datos[1] + " and EXTRACT(YEAR from fecha)=" + Datos[2] + "");
                while (resultado.next()) {
                    Datos[0] = resultado.getString(1);
                    System.out.println("NUMERO  " + Datos[0]);
                    Datos[1] = resultado.getString(2);
                    System.out.println("SALDO " + Datos[1]);
                    // con esto ya puedo sacar el promedio 
                }
                double dividendo = Double.parseDouble(Datos[1]);
                double divisor = Double.parseDouble(Datos[0]);
                res = dividendo / divisor;
            }

        } catch (SQLException ex) {
        }

        return res;

    }

    public double saldoactual(String cedula) {

        String data = "";

        try {// buscar el ultimo mes  importante SELECT * FROM `usuario` ORDER BY `etiqueta` DESC LIMIT 1

            resultado = conn.ejecutarSQLSelect("select INGRESO_MENSUAL from cliente where cedula='" + cedula + "'");
            while (resultado.next()) {
                data = resultado.getString(1);
                System.out.println("Ingreso Mensual=" + data);

                // con esto ya puedo sacar el promedio 
            }

        } catch (SQLException ex) {
        }

        return Double.parseDouble(data);

    }

    public double tablaAmortizacion(String tiemp, double valPrestamo, JTable Tabla, String cedula) {
       Calendar cal= Calendar.getInstance();
        String fecha=cal.get(cal.DATE)+"/"+(cal.get(cal.MONTH)+1)+"/"+cal.get(cal.YEAR);
        int dia = cal.get(cal.DATE);
        int mes2 = cal.get(cal.MONTH)+1;
        int anio = cal.get(cal.YEAR);
        boolean bandera = false;
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Couta");
        model.addColumn("Fecha Pago");
        model.addColumn("Amortizacion");
        model.addColumn("Interes");
        model.addColumn("Pago");
        model.addColumn("Saldo");
        Tabla.setModel(model);
        DecimalFormat formd = new DecimalFormat("0.00");
        String Datos[] = new String[6];
        int mes = 0;
        double cantint = 0;
        double pago = 0;
        tiempo = Integer.parseInt(tiemp);
        if (tiempo <= 12) {
            interes = 0.1 / 12;
        } else {
            interes = 0.16 / 12;
        }
        pago = valPrestamo * ((interes * (Math.pow((1 + interes), tiempo))) / ((Math.pow((1 + interes), tiempo)) - 1));
        System.out.println("pago" + pago);
        cuotaPagar = pago;
        if (pago <= saldoactual(cedula) * 0.3) {
            Datos[0] = String.valueOf(mes);
            Datos[1] = fecha;
            Datos[2] = "";
            Datos[3] = "";
            Datos[4] = "";
            Datos[5] = String.valueOf(valPrestamo);
            mes2++;
            model.addRow(Datos);
            Tabla.setModel(model);
            boolean a = conn.ejecutarSQL("INSERT INTO amortizacion(cedula,mes,fechaPago,amortizacion,interes,pago,saldo)" +
                "VALUES ('"+cedula+"',"+mes+",'0','0','0','0','0')");
            do {

                System.out.println("que pasa ");
                mes++;
                Datos[0] = String.valueOf(mes);
                Datos[1] = dia+"/" + mes2 + "/" +anio;
                cantint = valPrestamo * interes;
                Datos[2] = String.valueOf(formd.format(pago - cantint));
                Datos[3] = String.valueOf(formd.format(cantint));
                Datos[4] = String.valueOf(formd.format(pago));
                valPrestamo = valPrestamo - (pago - cantint);
                Datos[4] = String.valueOf(formd.format(valPrestamo));
                //System.out.println("Dato 0:" +Integer.parseInt(Datos[0])+"Datos 1:"+formd.format(pago - cantint)+
                //        "Datos 2:"+formd.format(cantint)+"Datos 3:"+formd.format(pago)+"Datos 4:"+formd.format(Math.abs(valPrestamo)));
                boolean b = conn.ejecutarSQL("INSERT INTO amortizacion(cedula,mes,fechaPago,amortizacion,interes,pago,saldo)" +
                "VALUES ('"+cedula+"',"+mes+",sysdate(),'"+(pago - cantint)+"','"+cantint+"','"+pago+"','"+valPrestamo+"')");
                System.out.println("estoooo"+"INSERT INTO amortizacion(cedula,mes,amortizacion,interes,pago,saldo)" +
                "VALUES ("+cedula+","+mes+","+formd.format(pago - cantint)+","+formd.format(cantint)+","+formd.format(pago)+","+formd.format(valPrestamo)+")");
                System.out.println("rttttt"+b);
                model.addRow(Datos);
                Tabla.setModel(model);
                mes2++;
            } while (Math.floor(valPrestamo) > 0);
        } else {
            bandera = true;
        }
        return pago;
    }

    public String guardarPrestamo(String cedula, double monto, int plazo,double interes,double pagoPrestamo) {
        String data = "-1";
        try {// buscar el ultimo mes  importante SELECT * FROM `usuario` ORDER BY `etiqueta` DESC LIMIT 1
            resultado = conn.ejecutarSQLSelect("select MONTO_OTORGADO FROM prestamos WHERE CEDULA='" + cedula + "'");
            while (resultado.next()) {
                data = resultado.getString(1);
                System.out.println("saldoobtenido=" + data);
            }

            if (data.equals("-1")) {
                resultado = conn.ejecutarSQLSelect("select MAX(ID) FROM prestamos");
                while (resultado.next()) {
                    data = resultado.getString(1);
                    System.out.println("ID MAXIMO=" + data);
                }
                int idpr = Integer.parseInt(data) + 1;

                            
                
                
               boolean a= conn.ejecutarSQL("INSERT INTO prestamos(ID,CEDULA,MONTO_OTORGADO"
                       + ",INTERES,MONTO_DEUDA,PLAZO,FECHA) VALUES (" + idpr + ",'" + cedula + "'," + monto + "," + interes +","+pagoPrestamo+ "," + plazo + ",sysdate())");
                System.out.println("quiero ver si guadra"+a); 
               data = "Prestamo guardado";
            } else {
                data = "Este cliente ya tiene un prestamo de " + data;
            }

        } catch (SQLException ex) {
        }
        return data;
    }

  

    public boolean buscar(String cedula, JTextField txmonto, JTextField txcuota, JTextField txfecha, JTextField txplazo, JTextField txtasa, JTable Tabla) {
        boolean flag = false;
        String mon = "", plaz = "";
        String data = "-1";
        DecimalFormat formd = new DecimalFormat("0.00");

        try {
            resultado = conn.ejecutarSQLSelect("select *from prestamos where cedula='" + cedula + "'");
            while (resultado.next()) {
                data = resultado.getString(1);
                mon = resultado.getString(3);
                plaz = resultado.getString(5);
                txfecha.setText(resultado.getString(6));
            }
            if (data.equals("-1")) {
                flag = true;
            } else {
                txmonto.setText(mon);
                txplazo.setText(plaz);
                tablaAmortizacion(plaz, Double.parseDouble(mon), Tabla, cedula);
                txcuota.setText(String.valueOf(formd.format(cuotaPagar)));
                txtasa.setText(String.valueOf(interes * 100) + "%");
            }
        } catch (SQLException ex) {
        }

        return flag;
    }
}
