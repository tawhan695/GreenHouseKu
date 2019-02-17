
package greenhouseku;

import java.awt.Color;
import java.beans.Statement;
import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import com.pi4j.io.serial.*;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.util.Console;

import java.io.IOException;
import java.util.Date;
/**
 *
 * @author pi
 */
public class index extends javax.swing.JFrame implements Runnable {

    /**
     * Creates new form index
     */
    public index() {
        initComponents();
       PassWD.hide();
        c.start();
        next.hide();
    }
 
       //read usb
    
     private  String usb;

    public String getUsb() {
               String s1=usb;
        int s3 =s1.indexOf(":");
        String s2=s1.substring(0, s3);
        System.out.println("sub :"+s2);
        setSOIL(s2);
                int s4 =s1.lastIndexOf(":");
        
           String s5 =s1.substring(s3+1, s1.length());
           System.out.println(""+s5);
            setLIGHTSUN(s5);
                 soilMoisture.setText(s2+ " %");
                lighsun.setText(s5+ " %");
        return usb;
    }

    public void setUsb(String usb) {   
        this.usb = usb;
    }
    
    private String SOIL;
    private String LIGHTSUN;

    public String getSOIL() {
        return SOIL;
    }

    public void setSOIL(String SOIL) {
        this.SOIL = SOIL;
    }

    public String getLIGHTSUN() {
        return LIGHTSUN;
    }

    public void setLIGHTSUN(String LIGHTSUN) {
        this.LIGHTSUN = LIGHTSUN;
    }
    //####################################
    //####  read data soil and sun   #####
    //####################################
    public  void USB1()throws InterruptedException, IOException {

        final Console console = new Console();
        // allow for user to exit program using CTRL-C
        console.promptForExit();
        final Serial serial = SerialFactory.createInstance();

        // create and register the serial data listener
        serial.addListener(new SerialDataEventListener() {
            @Override
            public void dataReceived(SerialDataEvent event) {

                // NOTE! - It is extremely important to read the data received from the
                // serial port.  If it does not get read from the receive buffer, the
                // buffer will continue to grow and consume memory.

                // print out the data received to the console
                try {
                    console.println("[HEX DATA]   " + event.getHexByteString());
                    console.println("[ASCII DATA] " + event.getAsciiString());
                    setUsb(event.getAsciiString());
                    System.out.println(""+getUsb());
                 //   setAll(event.getAsciiString());
                   // System.out.println(""+event.getAsciiString());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        try {
            // create serial config object
            SerialConfig config = new SerialConfig();
            config.device(SerialPort.getDefaultPort())
                  .device("/dev/ttyACM0")
                  .baud(Baud._9600);



            // display connection details
            console.box(" Connecting to: " + config.toString(),
                    " We are sending ASCII data on the serial port every 1 second.",
                    " Data received on serial port will be displayed below.");


            // open the default serial device/port with the configuration settings
            serial.open(config);
            
//            // continuous loop to keep the program running until the user terminates the program
            while(console.isRunning()) {
                try {
                
                }
                catch(IllegalStateException ex){
                    ex.printStackTrace();
                }

                // wait 1 second before continuing
                Thread.sleep(0);
            }

        }
        catch(IOException ex) {
            console.println(" ==>> SERIAL SETUP FAILED : " + ex.getMessage());
            return;
        }
    }
    
    //##################################################################3

    //create matod
    //passwd admin
   String PW="1234";
   String P2="";
   int lenlimit=3;
    void Passwd(String n){
       // System.out.println("XXX");
        P2=P2.concat(n);
        sp.setText(P2);
        System.out.println("    "+P2);
        if(P2.equals(PW)){
           
            
             jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Unlock_104px_1.png")));
              next.show();
//            try {
//                sleep(2000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
//            }
             // sonF.hide();
        }
        
        else if(P2.length()==4){
            P2="";
            sp.setText("");
            jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Password_104px_1.png")));
        }else{
           jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Password_104px.png")));
        }
    }
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PassWD = new javax.swing.JPanel();
        sonF = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        n1 = new javax.swing.JLabel();
        n2 = new javax.swing.JLabel();
        n3 = new javax.swing.JLabel();
        n4 = new javax.swing.JLabel();
        n5 = new javax.swing.JLabel();
        n6 = new javax.swing.JLabel();
        n7 = new javax.swing.JLabel();
        n8 = new javax.swing.JLabel();
        n9 = new javax.swing.JLabel();
        n0 = new javax.swing.JLabel();
        next = new javax.swing.JLabel();
        sp = new javax.swing.JLabel();
        page1 = new javax.swing.JPanel();
        smax = new javax.swing.JComboBox<>();
        smin = new javax.swing.JComboBox<>();
        jLabel35 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        lmax = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        tmax = new javax.swing.JComboBox<>();
        tmin = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        save = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        lmin = new javax.swing.JComboBox<>();
        jLabel50 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        home = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        status = new javax.swing.JLabel();
        inTemp = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        outTemp = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel11 = new javax.swing.JLabel();
        internal_humiditu = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel15 = new javax.swing.JLabel();
        outside_humiditu = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        soilMoisture = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        fan = new javax.swing.JLabel();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        pump = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        lighsun = new javax.swing.JLabel();
        lightBulb = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel33 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 102, 0));
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(0, 0));

        PassWD.setPreferredSize(new java.awt.Dimension(1024, 600));
        PassWD.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        sonF.setBackground(new java.awt.Color(51, 51, 51));
        sonF.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("X");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        sonF.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 10, 50, 60));

        jLabel16.setFont(new java.awt.Font("Purisa", 1, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Please enter the password.");
        sonF.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 270, -1));

        jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Password_104px.png"))); // NOI18N
        sonF.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, -1, 119));

        n1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Level_1_40px.png"))); // NOI18N
        n1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n1MouseClicked(evt);
            }
        });
        sonF.add(n1, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 207, 42, 42));

        n2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Circled_2_C_40px.png"))); // NOI18N
        n2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n2MouseClicked(evt);
            }
        });
        sonF.add(n2, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 207, 42, 42));

        n3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Circled_3_C_40px.png"))); // NOI18N
        n3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n3MouseClicked(evt);
            }
        });
        sonF.add(n3, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 207, 42, 42));

        n4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Circled_4_C_40px.png"))); // NOI18N
        n4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n4MouseClicked(evt);
            }
        });
        sonF.add(n4, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 255, 42, 42));

        n5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Circled_5_C_40px.png"))); // NOI18N
        n5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n5MouseClicked(evt);
            }
        });
        sonF.add(n5, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 255, 42, 42));

        n6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Circled_6_C_40px.png"))); // NOI18N
        n6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n6MouseClicked(evt);
            }
        });
        sonF.add(n6, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 255, 42, 42));

        n7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Circled_7_C_40px.png"))); // NOI18N
        n7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n7MouseClicked(evt);
            }
        });
        sonF.add(n7, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 303, 42, 42));

        n8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Circled_8_C_40px.png"))); // NOI18N
        n8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n8MouseClicked(evt);
            }
        });
        sonF.add(n8, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 303, 42, 42));

        n9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Circled_9__C_40px.png"))); // NOI18N
        n9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n9MouseClicked(evt);
            }
        });
        sonF.add(n9, new org.netbeans.lib.awtextra.AbsoluteConstraints(243, 303, 42, 42));

        n0.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Circled_0_C_40px.png"))); // NOI18N
        n0.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                n0MouseClicked(evt);
            }
        });
        sonF.add(n0, new org.netbeans.lib.awtextra.AbsoluteConstraints(195, 351, 42, 42));

        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Next_page_104px.png"))); // NOI18N
        next.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nextMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                nextMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                nextMouseExited(evt);
            }
        });
        sonF.add(next, new org.netbeans.lib.awtextra.AbsoluteConstraints(159, 404, -1, -1));

        sp.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        sp.setForeground(new java.awt.Color(204, 255, 255));
        sp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sonF.add(sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 70, 30));

        PassWD.add(sonF, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, -1, 580));

        page1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        smax.setEditable(true);
        smax.setFont(new java.awt.Font("Purisa", 0, 24)); // NOI18N
        smax.setForeground(new java.awt.Color(255, 255, 255));
        smax.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", " " }));
        smax.setSelectedIndex(29);
        smax.setFocusable(false);
        smax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                smaxActionPerformed(evt);
            }
        });
        page1.add(smax, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 300, 150, 60));

        smin.setEditable(true);
        smin.setFont(new java.awt.Font("Purisa", 0, 24)); // NOI18N
        smin.setForeground(new java.awt.Color(255, 255, 255));
        smin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", " " }));
        smin.setSelectedIndex(29);
        smin.setFocusable(false);
        smin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sminActionPerformed(evt);
            }
        });
        page1.add(smin, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 410, 150, 60));

        jLabel35.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(255, 255, 255));
        jLabel35.setText("Pump ON ");
        page1.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, -1, -1));

        jLabel34.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(255, 255, 255));
        jLabel34.setText("Pump off ");
        page1.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 260, -1, -1));

        lmax.setEditable(true);
        lmax.setFont(new java.awt.Font("Purisa", 0, 24)); // NOI18N
        lmax.setForeground(new java.awt.Color(255, 255, 255));
        lmax.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100" }));
        lmax.setFocusable(false);
        lmax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lmaxActionPerformed(evt);
            }
        });
        page1.add(lmax, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 300, 150, 60));

        jLabel37.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        jLabel37.setForeground(new java.awt.Color(255, 255, 255));
        jLabel37.setText("Light Off");
        page1.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 260, 160, 30));

        tmax.setEditable(true);
        tmax.setFont(new java.awt.Font("Purisa", 0, 24)); // NOI18N
        tmax.setForeground(new java.awt.Color(255, 255, 255));
        tmax.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", " " }));
        tmax.setSelectedIndex(29);
        tmax.setFocusable(false);
        tmax.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tmaxActionPerformed(evt);
            }
        });
        page1.add(tmax, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 150, 60));

        tmin.setEditable(true);
        tmin.setFont(new java.awt.Font("Purisa", 0, 24)); // NOI18N
        tmin.setForeground(new java.awt.Color(255, 255, 255));
        tmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100", " " }));
        tmin.setSelectedIndex(29);
        tmin.setFocusable(false);
        tmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tminActionPerformed(evt);
            }
        });
        page1.add(tmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 410, 150, 60));

        jLabel4.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("fan Off");
        page1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 380, 140, -1));

        jLabel1.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("fan ON ");
        page1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 260, 140, -1));

        jLabel39.setFont(new java.awt.Font("Purisa", 0, 36)); // NOI18N
        jLabel39.setForeground(new java.awt.Color(255, 255, 255));
        jLabel39.setText("Setting Control ");
        page1.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 270, 50));

        jLabel40.setFont(new java.awt.Font("Purisa", 0, 48)); // NOI18N
        jLabel40.setForeground(new java.awt.Color(255, 255, 255));
        jLabel40.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/aWVDrj-R_400x40022222222.png"))); // NOI18N
        page1.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, 90));

        jLabel41.setFont(new java.awt.Font("Purisa", 0, 48)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("GreenHouse");
        page1.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 420, 80));

        jLabel42.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(255, 255, 255));
        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Temperature_30px.png"))); // NOI18N
        jLabel42.setText("Temp Min");
        page1.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 110, 40));

        jLabel43.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel43.setForeground(new java.awt.Color(255, 255, 255));
        jLabel43.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Hygrometer_30px.png"))); // NOI18N
        jLabel43.setText("Soil Moisture Min");
        page1.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 420, 150, 40));

        jLabel44.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel44.setForeground(new java.awt.Color(255, 255, 255));
        jLabel44.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Temperature_30px.png"))); // NOI18N
        jLabel44.setText("Temp Max");
        page1.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 310, 110, 40));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setForeground(new java.awt.Color(255, 255, 255));
        jLabel45.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Partly_Cloudy_Day_30px.png"))); // NOI18N
        jLabel45.setText("Light Sun Max");
        page1.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 310, -1, 40));

        jLabel48.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(255, 255, 255));
        jLabel48.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Hygrometer_30px.png"))); // NOI18N
        jLabel48.setText("Soil Moisture Max");
        page1.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 310, 150, 40));

        close.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        close.setForeground(new java.awt.Color(255, 0, 51));
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/seve/icons8_Cancel_52px_1.png"))); // NOI18N
        close.setText("close");
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });
        page1.add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 500, 130, 70));

        save.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        save.setForeground(new java.awt.Color(255, 255, 255));
        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/seve/icons8_Save_52px_1.png"))); // NOI18N
        save.setText("save");
        save.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                saveMouseClicked(evt);
            }
        });
        page1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 500, 130, 70));

        jLabel49.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel49.setForeground(new java.awt.Color(255, 255, 255));
        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Partly_Cloudy_Day_30px.png"))); // NOI18N
        jLabel49.setText("Light Sun Min");
        page1.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 420, 120, 40));

        lmin.setEditable(true);
        lmin.setFont(new java.awt.Font("Purisa", 0, 24)); // NOI18N
        lmin.setForeground(new java.awt.Color(255, 255, 255));
        lmin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", "33", "34", "35", "36", "37", "38", "39", "40", "41", "42", "43", "44", "45", "46", "47", "48", "49", "50", "51", "52", "53", "54", "55", "56", "57", "58", "59", "60", "61", "62", "63", "64", "65", "66", "67", "68", "69", "70", "71", "72", "73", "74", "75", "76", "77", "78", "79", "80", "81", "82", "83", "84", "85", "86", "87", "88", "89", "90", "91", "92", "93", "94", "95", "96", "97", "98", "99", "100" }));
        lmin.setFocusable(false);
        lmin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lminActionPerformed(evt);
            }
        });
        page1.add(lmin, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 410, 150, 60));

        jLabel50.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        jLabel50.setForeground(new java.awt.Color(255, 255, 255));
        jLabel50.setText("Light On");
        page1.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 370, 160, 30));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imge/background-close.png"))); // NOI18N
        jLabel38.setPreferredSize(new java.awt.Dimension(1024, 600));
        page1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        PassWD.add(page1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imge/background-close.png"))); // NOI18N
        jLabel32.setPreferredSize(new java.awt.Dimension(1024, 600));
        PassWD.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        home.setBackground(new java.awt.Color(51, 51, 51));
        home.setForeground(new java.awt.Color(255, 255, 255));
        home.setToolTipText("");
        home.setPreferredSize(new java.awt.Dimension(1024, 600));
        home.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Purisa", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/aWVDrj-R_400x40022222222.png"))); // NOI18N
        home.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 90, 90));

        jSeparator3.setBackground(new java.awt.Color(204, 204, 204));
        jSeparator3.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jSeparator3.setPreferredSize(new java.awt.Dimension(50, 5));
        home.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 170, 190, 10));
        jSeparator3.getAccessibleContext().setAccessibleName("");
        jSeparator3.getAccessibleContext().setAccessibleDescription("");

        status.setFont(new java.awt.Font("Purisa", 0, 14)); // NOI18N
        status.setForeground(new java.awt.Color(255, 255, 255));
        home.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 540, 280, 50));

        inTemp.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        inTemp.setForeground(new java.awt.Color(255, 255, 255));
        inTemp.setText("00");
        home.add(inTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 210, 60, 40));

        jLabel6.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Temperature_30px.png"))); // NOI18N
        home.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 30, 30));

        jSeparator4.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jSeparator4.setPreferredSize(new java.awt.Dimension(50, 5));
        home.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 170, 190, 10));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("OutsideTemperature");
        home.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 180, 200, -1));

        outTemp.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        outTemp.setForeground(new java.awt.Color(255, 255, 255));
        outTemp.setText("00");
        home.add(outTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 210, 60, 40));

        jLabel9.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Temperature_30px.png"))); // NOI18N
        home.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 210, 30, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Degerees Celsius");
        home.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 240, 190, 40));

        jSeparator5.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jSeparator5.setPreferredSize(new java.awt.Dimension(50, 5));
        home.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 170, 180, 10));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Internal Humidity");
        home.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 180, 190, 30));

        internal_humiditu.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        internal_humiditu.setForeground(new java.awt.Color(255, 255, 255));
        internal_humiditu.setText("00%");
        home.add(internal_humiditu, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 210, 70, 40));

        jLabel13.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Humidity_30px.png"))); // NOI18N
        home.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 220, 30, 30));

        jSeparator6.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jSeparator6.setPreferredSize(new java.awt.Dimension(50, 5));
        home.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 170, 180, 10));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Outside Humidty");
        home.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 180, 170, 30));

        outside_humiditu.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        outside_humiditu.setForeground(new java.awt.Color(255, 255, 255));
        outside_humiditu.setText("00%");
        home.add(outside_humiditu, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 210, 60, 40));

        jLabel17.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(255, 255, 255));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Humidity_30px.png"))); // NOI18N
        home.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, 30, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setText("Soil Moisture");
        home.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 370, 170, 30));

        jSeparator7.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jSeparator7.setPreferredSize(new java.awt.Dimension(50, 5));
        home.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 360, 180, 10));

        soilMoisture.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        soilMoisture.setForeground(new java.awt.Color(255, 255, 255));
        soilMoisture.setText("00%");
        home.add(soilMoisture, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 400, 60, 40));

        jLabel19.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(255, 255, 255));
        jLabel19.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Shutdown_52px.png"))); // NOI18N
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel19MouseClicked(evt);
            }
        });
        home.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 10, 60, 60));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(255, 255, 255));
        jLabel20.setText("Internal Temperature");
        home.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 180, 220, 30));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel21.setForeground(new java.awt.Color(255, 255, 255));
        jLabel21.setText("Fan");
        home.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 170, 50));

        jLabel22.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(255, 255, 255));
        jLabel22.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Fan_30px.png"))); // NOI18N
        home.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 30, 30));

        fan.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        fan.setForeground(new java.awt.Color(255, 255, 255));
        fan.setText("00");
        home.add(fan, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 60, 40));

        jSeparator8.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jSeparator8.setPreferredSize(new java.awt.Dimension(50, 5));
        home.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 360, 180, 10));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(255, 255, 255));
        jLabel24.setText("Pump");
        home.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 170, 50));

        jLabel25.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        jLabel25.setForeground(new java.awt.Color(255, 255, 255));
        jLabel25.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Settings_52px.png"))); // NOI18N
        jLabel25.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel25MouseClicked(evt);
            }
        });
        home.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(960, 530, 50, 60));

        jLabel46.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel46.setForeground(new java.awt.Color(255, 255, 255));
        jLabel46.setText("Light bulb");
        home.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 360, 170, 50));

        jLabel47.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        jLabel47.setForeground(new java.awt.Color(255, 255, 255));
        jLabel47.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Light_Automation_30px.png"))); // NOI18N
        home.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 400, 30, 40));

        pump.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        pump.setForeground(new java.awt.Color(255, 255, 255));
        pump.setText("00");
        home.add(pump, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 60, 40));

        jLabel26.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(255, 255, 255));
        jLabel26.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Hygrometer_30px.png"))); // NOI18N
        home.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 400, 30, 30));

        jLabel27.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(255, 255, 255));
        home.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 400, 30, 30));

        lighsun.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        lighsun.setForeground(new java.awt.Color(255, 255, 255));
        lighsun.setText("00");
        home.add(lighsun, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 400, 60, 40));

        lightBulb.setFont(new java.awt.Font("Purisa", 0, 18)); // NOI18N
        lightBulb.setForeground(new java.awt.Color(255, 255, 255));
        lightBulb.setText("00");
        home.add(lightBulb, new org.netbeans.lib.awtextra.AbsoluteConstraints(920, 400, 60, 40));

        jSeparator9.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jSeparator9.setPreferredSize(new java.awt.Dimension(50, 5));
        home.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 360, 180, 10));

        jSeparator10.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        jSeparator10.setPreferredSize(new java.awt.Dimension(50, 5));
        home.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, 180, 10));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setForeground(new java.awt.Color(255, 255, 255));
        jLabel33.setText("Degerees Celsius");
        home.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 240, 180, 30));

        jLabel28.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(255, 255, 255));
        jLabel28.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Watering_Can_30px.png"))); // NOI18N
        home.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 400, 30, 30));

        jLabel12.setFont(new java.awt.Font("Purisa", 0, 48)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("GreenHouse");
        home.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, 420, 80));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel36.setForeground(new java.awt.Color(255, 255, 255));
        jLabel36.setText("Light sun");
        home.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 360, 170, 50));

        jLabel8.setFont(new java.awt.Font("Purisa", 0, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Status");
        home.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 60, 50));

        jLabel30.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        jLabel30.setForeground(new java.awt.Color(255, 255, 255));
        jLabel30.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Partly_Cloudy_Day_30px.png"))); // NOI18N
        home.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 400, 30, 40));

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imge/background-close.png"))); // NOI18N
        home.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1020, 600));

        jLabel23.setFont(new java.awt.Font("Purisa", 0, 12)); // NOI18N
        jLabel23.setForeground(new java.awt.Color(255, 255, 255));
        jLabel23.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/icons8_Hygrometer_30px.png"))); // NOI18N
        home.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 210, 30, 30));

        jLabel5.setFont(new java.awt.Font("Purisa", 0, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Status");
        home.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 60, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PassWD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PassWD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tmaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tmaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tmaxActionPerformed

    private void tminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tminActionPerformed

    private void smaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_smaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_smaxActionPerformed

    private void sminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sminActionPerformed

    private void lmaxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lmaxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lmaxActionPerformed

    private void jLabel19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MouseClicked
        System.exit(1);
    }//GEN-LAST:event_jLabel19MouseClicked

    private void jLabel25MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel25MouseClicked
       PassWD.show();
       sonF.show();
       home.hide();
       page1.hide();
       
    }//GEN-LAST:event_jLabel25MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        PassWD.hide();
        sonF.hide();
       home.show();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void n1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n1MouseClicked
        Passwd("1");
    }//GEN-LAST:event_n1MouseClicked

    private void n2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n2MouseClicked
          Passwd("2");
    }//GEN-LAST:event_n2MouseClicked

    private void n3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n3MouseClicked
          Passwd("3");
    }//GEN-LAST:event_n3MouseClicked

    private void n4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n4MouseClicked
          Passwd("4");
    }//GEN-LAST:event_n4MouseClicked

    private void n5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n5MouseClicked
          Passwd("5");
    }//GEN-LAST:event_n5MouseClicked

    private void n6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n6MouseClicked
          Passwd("6");
    }//GEN-LAST:event_n6MouseClicked

    private void n7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n7MouseClicked
          Passwd("7");
    }//GEN-LAST:event_n7MouseClicked

    private void n8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n8MouseClicked
         Passwd("8");
    }//GEN-LAST:event_n8MouseClicked

    private void n9MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n9MouseClicked
          Passwd("9");
    }//GEN-LAST:event_n9MouseClicked

    private void n0MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_n0MouseClicked
          Passwd("0");
        
    }//GEN-LAST:event_n0MouseClicked

    private void nextMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseEntered
      next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Next_page_104px_1.png"))); // NOI18N
    }//GEN-LAST:event_nextMouseEntered

    private void nextMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseExited
       next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Next_page_104px.png"))); // NOI18N
    }//GEN-LAST:event_nextMouseExited

    private void nextMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nextMouseClicked
        // TODO add your handling code here:
        next.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Next_page_104px_1.png"))); // NOI18N
         jLabel18.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/icons8_Password_104px.png")));
        sonF.hide();
        page1.show();
        P2="";
        next.hide();
        sp.setText("");
        
        
           String sql = "SELECT * FROM db.datacontrol WHERE 1";
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull", "root", "");
            PreparedStatement ps = con.prepareStatement(sql);
//   Statement st=(Statement) con.createStatement();
            ResultSet r = ps.executeQuery();

            while (r.next()) {
                 tmax.setSelectedItem(r.getObject("temp_max"));
                 tmin.setSelectedItem(r.getObject("temp_min"));
                smax.setSelectedItem(r.getObject("soli_max"));
                smin.setSelectedItem(r.getObject("soil_min"));
                lmax.setSelectedItem(r.getObject("sun_max"));
                lmin.setSelectedItem(r.getObject("sun_min"));
                
                //lightBulb
            }
                con.close();
                ps.close();
                r.close();

        } catch (Exception e) {

            status.setText("Connect Database Fail ");

        }
    }//GEN-LAST:event_nextMouseClicked

    private void saveMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveMouseClicked
      save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconN/seve/icons8_Save_52px_2.png")));
      save.setForeground(Color.GREEN);
      
      String fan_on=tmax.getSelectedItem().toString();
      String fan_off=tmin.getSelectedItem().toString();
      String pump_on=smax.getSelectedItem().toString();
      String pump_off=smin.getSelectedItem().toString();
      String sun_max=lmax.getSelectedItem().toString();
      String sun_min=lmin.getSelectedItem().toString();
              
      //String light_off=l_off.getSelectedItem().toString();
      
       String sql = "UPDATE DB.datacontrol SET temp_max = "+fan_on+", temp_min = "+fan_off+", soli_max="+pump_off+" ,soil_min ="+pump_on+",sun_max="+sun_max+",sun_min="+sun_min+" WHERE id = 1 ";
        try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull", "root", "");
            PreparedStatement ps = con.prepareStatement(sql);
           // Statement st=(Statement)con.createStatement();
           // st.execute();
            ps.executeUpdate();
            con.close();
            ps.close();
            JOptionPane.showMessageDialog(null,"Save Save successfully","Save data",JOptionPane.PLAIN_MESSAGE);
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null,"Save Save fail","Save data",JOptionPane.PLAIN_MESSAGE);
        }
            
      
    }//GEN-LAST:event_saveMouseClicked

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        // TODO add your handling code here:
        PassWD.hide();
        home.show();
    }//GEN-LAST:event_closeMouseClicked

    private void lminActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lminActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_lminActionPerformed
    Thread c = new Thread(this);

    ArrayList<String> Pin = new ArrayList();

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(index.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
         
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new index().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PassWD;
    private javax.swing.JLabel close;
    private javax.swing.JLabel fan;
    private javax.swing.JPanel home;
    private javax.swing.JLabel inTemp;
    private javax.swing.JLabel internal_humiditu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lighsun;
    private javax.swing.JLabel lightBulb;
    private javax.swing.JComboBox<String> lmax;
    private javax.swing.JComboBox<String> lmin;
    private javax.swing.JLabel n0;
    private javax.swing.JLabel n1;
    private javax.swing.JLabel n2;
    private javax.swing.JLabel n3;
    private javax.swing.JLabel n4;
    private javax.swing.JLabel n5;
    private javax.swing.JLabel n6;
    private javax.swing.JLabel n7;
    private javax.swing.JLabel n8;
    private javax.swing.JLabel n9;
    private javax.swing.JLabel next;
    private javax.swing.JLabel outTemp;
    private javax.swing.JLabel outside_humiditu;
    private javax.swing.JPanel page1;
    private javax.swing.JLabel pump;
    private javax.swing.JLabel save;
    private javax.swing.JComboBox<String> smax;
    private javax.swing.JComboBox<String> smin;
    private javax.swing.JLabel soilMoisture;
    private javax.swing.JPanel sonF;
    private javax.swing.JLabel sp;
    private javax.swing.JLabel status;
    private javax.swing.JComboBox<String> tmax;
    private javax.swing.JComboBox<String> tmin;
    // End of variables declaration//GEN-END:variables
    private String FAN;
    private String PUMP;
    private String LIGHT;
    
    int i=0;
    @Override
    public void run() {
              status.setText("   Server Start ... ");      
            while (true) {  
            
                //****************************
                
                  try {
                      USB1();
                      
                  } catch (InterruptedException ex) {
                      Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
                  } catch (IOException ex) {
                      Logger.getLogger(index.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  
                  //*******************************
             
        String sql = "SELECT * FROM db.data ORDER BY temp_in DESC LIMIT 1";
         try {
            String driver = "com.mysql.jdbc.Driver";
            Class.forName(driver);
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql?zeroDateTimeBehavior=convertToNull", "root", "");
            PreparedStatement ps = con.prepareStatement(sql);
//   Statement st=(Statement) con.createStatement();
            ResultSet r = ps.executeQuery();

            while (r.next()) {
                 inTemp.setText(r.getString("temp_in"));
                 setFAN(r.getString("fan"));
                 setLIGHT(r.getString("light"));
                 setPUMP(r.getString("pump"));
                 fan.setText(getFAN());
                 pump.setText(getPUMP());
                 lightBulb.setText(getLIGHT());
               // System.out.println("" + );
                //System.out.println("" + );
                 inTemp.setText(r.getString("temp_in"));
                outTemp.setText(r.getString("temp_out"));
                internal_humiditu.setText( r.getString("humidity_in")+ " %");
                outside_humiditu.setText( r.getString("huminity_out")+ " %");
               
                
                //lightBulb
            }
                con.close();
                ps.close();
                r.close();

        } catch (Exception e) {

            status.setText("Connect Database Fail ");

        }
        }

    }

    
    public String getFAN() {
        return FAN;
    }

    public void setFAN(String FAN) {
        String s;
        if (FAN.equals("1")) {
                    s="ON";
                    fan.setForeground(new java.awt.Color(255, 255, 255));
                } else {
                    s="Off";
                    fan.setForeground(new java.awt.Color(255, 0, 0));
                }
        this.FAN = s;
    }

    public String getPUMP() {
        return PUMP;
    }

    public void setPUMP(String PUMP) {
            String s;
        if (PUMP.equals("1")) {
                    s="ON";
                    pump.setForeground(new java.awt.Color(255, 255, 255));
                } else {
                    s="Off";
                    pump.setForeground(new java.awt.Color(255, 0, 0));
                }
        this.PUMP = s;
    }

    public String getLIGHT() {
        return LIGHT;
    }

    public void setLIGHT(String LIGHT) {
            String s;
        if (LIGHT.equals("1")) {
                    s="ON";
                    lightBulb.setForeground(new java.awt.Color(255, 255, 255));
                } else {
                    s="Off";
                     lightBulb.setForeground(new java.awt.Color(255, 0, 0));
                }
        this.LIGHT = s;
    }
}

