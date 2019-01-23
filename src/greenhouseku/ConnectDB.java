/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greenhouseku;

import java.beans.Statement;
import java.lang.Thread.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.Year;
import javax.swing.JOptionPane;

/**
 *
 * @author pi
 */
/*
    while (true) {            
             status.setText("Server Start ... ");
        String sql = "SELECT * FROM DB.data ORDER BY temp_in DESC LIMIT 1";
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull", "root", "987978");
            PreparedStatement ps = con.prepareStatement(sql);
//   Statement st=(Statement) con.createStatement();
            ResultSet r = ps.executeQuery();

            while (r.next()) {
                 inTemp.setText(r.getString("temp_in"));
                System.out.println("" + r.getString("fan"));
                System.out.println("" + r.getString("light"));
                System.out.println("" + r.getString("pump"));
                System.out.println("" + r.getString("temp_in"));
                System.out.println("" + r.getString("temp_out"));
                System.out.println("" + r.getString("humidity_in"));
                System.out.println("" + r.getString("huminity_out"));
                System.out.println("" + r.getString("soil"));
                
                //lightBulb
            }
            Temp_in = r.getString("temp_in");
                Temp_out = r.getString("temp_out");
                Fan = r.getString("fan");
                Lihgt = r.getString("light");
                Pump = r.getString("pump");
                Humidity_in = r.getString("humidity_in");
                Humidity_Out = r.getString("huminity_out");
                Soil = r.getString("soil");
                Date = r.getString("date");
                Soid = r.getString("soil");
//             inTem  
//                
//                
                inTemp.setText(r.getString("temp_in"));
                outTemp.setText(Temp_out);
                internal_humiditu.setText(Humidity_in + " %");
                outside_humiditu.setText(Humidity_Out + " %");
                soilMoisture.setText(Soid + " %");
                if (Fan.equals("1")) {
                    fan.setText("ON");
                } else {
                    fan.setText("Off");
                }
                if (Pump.equals("1")) {
                    pump.setText("ON");
                } else {
                    pump.setText("Off");
                }
                if (Lihgt.equals("1")) {
                    lightBulb.setText("ON");
                } else {
                    lightBulb.setText("Off");
                }
                con.close();
                ps.close();
                r.close();

        } catch (Exception e) {

            status.setText("Connect Database Fail ");

        }
*/
public class ConnectDB extends index{
    
    public void Temp(){
          String sql ="SELECT * FROM DB.data ORDER BY temp_in DESC LIMIT 1";
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","root","987978");
           PreparedStatement ps=con.prepareStatement(sql);
//   Statement st=(Statement) con.createStatement();
           ResultSet r=ps.executeQuery();
         
               while (r.next()) {
               System.out.println(""+r.getString("date"));
               System.out.println(""+r.getString("fan"));
               System.out.println(""+r.getString("light"));
               System.out.println(""+r.getString("pump"));
               System.out.println(""+r.getString("temp_in"));
               System.out.println(""+r.getString("temp_out"));
               System.out.println(""+r.getString("humidity_in"));
               System.out.println(""+r.getString("huminity_out"));
               System.out.println(""+r.getString("soil"));
               
//               
//                
//                
            }
               
                
                
            
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null,"Data not saved: " + e,"Error",JOptionPane.ERROR_MESSAGE);

        } 

    }

    

    public static void main(String[] args) {
//        String sql ="SELECT * FROM DB.data";
//        try {
//            String driver = "com.mysql.jdbc.Driver";
//            Class.forName(driver);
//           Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull","root","987978");
//           PreparedStatement ps=con.prepareStatement(sql);
////   Statement st=(Statement) con.createStatement();
//           ResultSet r=ps.executeQuery();
//           int i=1;
//           while (r.next()) {
//                System.out.println(""+r.getString(i));
//               
//                
//                
//            }
//        } catch (Exception e) {
//
//            JOptionPane.showMessageDialog(null,"Data not saved: " + e,"Error",JOptionPane.ERROR_MESSAGE);
//
//        } 
  ConnectDB c =new ConnectDB();
  c.Temp();

    }
    }
    

