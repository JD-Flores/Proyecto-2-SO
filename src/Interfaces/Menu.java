/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Classes.Administrador;
import Classes.Car;
import Classes.Global;
import Classes.Procesador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

/**
 *
 * @author Windows
 */
public class Menu extends javax.swing.JFrame {

        public Menu() {
                initComponents();
                this.setTitle("Proyecto 2");
                this.setLocationRelativeTo(null);
                this.setVisible(true);
                this.setResizable(false);
                startTimer();
        }

        private int processingTime = 3000;

        private Procesador ai = new Procesador(this.processingTime);
        private Administrador administrador = new Administrador(ai);

        private void startTimer() {
                int delay = 10; // milliseconds
                ActionListener taskPerformer = new ActionListener() {
                        public void actionPerformed(ActionEvent evt) {
                            
                                aiStateLabel.setText(ai.state);
                                
                                processingTime = processingTimeSlider.getValue()/5;
                                processingTimeLabel.setText(Integer.toString(processingTime));
                                ai.setProcessingTime(processingTime*1000);
                                
                                bugattiCola1TextField.setText(administrador.getCola1BugattiText());
                                bugattiCola2TextField.setText(administrador.getCola2BugattiText());
                                bugattiCola3TextField.setText(administrador.getCola3BugattiText());
                                bugattiColaRefuerzoTextField.setText(administrador.getColaRefuerzoBugattiText());

                                lamborghiniCola1TextField1.setText(administrador.getCola1LamborghiniText());
                                lamborghiniCola2TextField1.setText(administrador.getCola2LamborghiniText());
                                lamborghiniCola3TextField1.setText(administrador.getCola3LamborghiniText());
                                lamborghiniColaRefuerzoTextField1
                                                .setText(administrador.getColaRefuerzoLamborghiniText());

                                bugattiVictoryCounterLabel.setText(String.valueOf(administrador.bugattiWinners.size()));
                                bugattiVictoryCounterLabel3
                                                .setText(String.valueOf(administrador.lamborghiniWinners.size()));

                                if (!Objects.isNull(administrador.currentBugattiCar)) {

                                        bugattiIdLabel.setText("B"
                                                        + Integer.toString(administrador.currentBugattiCar.getId()));
                                        switch (administrador.currentBugattiCar.getModel()) {
                                                case 1:
                                                        bugattiModeloLabel.setText("Chiron");
                                                        bugattiCarImage.setIcon(
                                                                        new ImageIcon(getClass().getResource(
                                                                                        "/Imagenes/bugatti/bugatti_chiron.png")));
                                                        break;

                                                case 2:
                                                        bugattiModeloLabel.setText("EB110");
                                                        bugattiCarImage.setIcon(
                                                                        new ImageIcon(getClass().getResource(
                                                                                        "/Imagenes/bugatti/bugatti_eb110.png")));
                                                        break;
                                                case 3:
                                                        bugattiModeloLabel.setText("La Voiture");
                                                        bugattiCarImage.setIcon(
                                                                        new ImageIcon(getClass().getResource(
                                                                                        "/Imagenes/bugatti/bugatti_la_voiture.png")));
                                                        break;
                                                case 4:
                                                        bugattiModeloLabel.setText("Veyron");
                                                        bugattiCarImage.setIcon(
                                                                        new ImageIcon(getClass().getResource(
                                                                                        "/Imagenes/bugatti/bugatti_veyron.png")));
                                                        break;
                                                case 5:
                                                        bugattiModeloLabel.setText("Vision");
                                                        bugattiCarImage.setIcon(
                                                                        new ImageIcon(getClass().getResource(
                                                                                        "/Imagenes/bugatti/bugatti_vision.png")));
                                                        break;
                                        }

                                        switch (administrador.currentBugattiCar.state) {
                                                case "racing":
                                                        bugattiStateLabel.setForeground(Color.black);
                                                        bugattiTimeLabel.setText("0:00");
                                                        bugattiStateLabel.setText("Corriendo");
                                                        break;
                                                case "waiting":
                                                        bugattiStateLabel.setForeground(Color.darkGray);
                                                        bugattiTimeLabel.setText("0:00");
                                                        bugattiStateLabel.setText("Esperando...");
                                                        break;
                                                case "winner":
                                                        bugattiStateLabel.setForeground(Color.green);
                                                        bugattiTimeLabel.setText(
                                                                        ai.stringTime(ai.getBugattiRaceTimeInSeconds()));
                                                        bugattiStateLabel.setText("Ganador!");
                                                        break;
                                                case "loser":
                                                        bugattiStateLabel.setForeground(Color.red);
                                                        bugattiTimeLabel.setText(
                                                                        ai.stringTime(ai.getBugattiRaceTimeInSeconds()));
                                                        bugattiStateLabel.setText("Perdedor");
                                                        break;
                                                case "repair":
                                                        bugattiStateLabel.setForeground(Color.darkGray);
                                                        bugattiTimeLabel.setText("0:00");
                                                        bugattiStateLabel.setText("A reparación");
                                                        break;
                                                case "tie":
                                                        bugattiStateLabel.setForeground(Color.black);
                                                        bugattiTimeLabel.setText(
                                                                        ai.stringTime(ai.getBugattiRaceTimeInSeconds()));
                                                        bugattiStateLabel.setText("Empate");
                                                        break;
                                        }

                                }
                                if (!Objects.isNull(administrador.currentLamborghiniCar)) {
                                        lamboIdLabel.setText("L"
                                                        + Integer.toString(administrador.currentLamborghiniCar.getId()));
                                        switch (administrador.currentLamborghiniCar.getModel()) {
                                                case 1:
                                                        lamboModeloLabel.setText("Aventador");
                                                        lamboCarImage.setIcon(
                                                                        new ImageIcon(getClass().getResource(
                                                                                        "/Imagenes/lamborghini/lambo_aventador.png")));
                                                        break;

                                                case 2:
                                                        lamboModeloLabel.setText("Diablo");
                                                        lamboCarImage.setIcon(
                                                                        new ImageIcon(getClass().getResource(
                                                                                        "/Imagenes/lamborghini/lambo_diablo.png")));
                                                        break;
                                                case 3:
                                                        lamboModeloLabel.setText("Miura");
                                                        lamboCarImage.setIcon(
                                                                        new ImageIcon(getClass().getResource(
                                                                                        "/Imagenes/lamborghini/lambo_miura.png")));
                                                        break;
                                                case 4:
                                                        lamboModeloLabel.setText("Murcielago");
                                                        lamboCarImage.setIcon(
                                                                        new ImageIcon(getClass().getResource(
                                                                                        "/Imagenes/lamborghini/lambo_murcielago.png")));
                                                        break;
                                                case 5:
                                                        lamboModeloLabel.setText("Veneno");
                                                        lamboCarImage.setIcon(
                                                                        new ImageIcon(getClass().getResource(
                                                                                        "/Imagenes/lamborghini/lambo_veneno.png")));
                                                        break;
                                        }

                                        switch (administrador.currentLamborghiniCar.state) {
                                                case "racing":
                                                        lamboStateLabel.setForeground(Color.black);
                                                        lamboTimeLabel.setText("0:00");
                                                        lamboStateLabel.setText("Corriendo");
                                                        break;
                                                case "waiting":
                                                        lamboStateLabel.setForeground(Color.darkGray);
                                                        lamboTimeLabel.setText("0:00");
                                                        lamboStateLabel.setText("Esperando...");
                                                        break;
                                                case "winner":
                                                        lamboStateLabel.setForeground(Color.green);
                                                        lamboTimeLabel.setText(
                                                                        ai.stringTime(ai.getLamborghiniRaceTimeInSeconds()));
                                                        lamboStateLabel.setText("Ganador!");
                                                        break;
                                                case "loser":
                                                        lamboStateLabel.setForeground(Color.red);
                                                        lamboTimeLabel.setText(
                                                                        ai.stringTime(ai.getLamborghiniRaceTimeInSeconds()));
                                                        lamboStateLabel.setText("Perdedor");
                                                        break;
                                                case "repair":
                                                        lamboStateLabel.setForeground(Color.darkGray);
                                                        lamboTimeLabel.setText("0:00");
                                                        lamboStateLabel.setText("A reparación");
                                                        break;
                                                case "tie":
                                                        lamboStateLabel.setForeground(Color.black);
                                                        lamboTimeLabel.setText(
                                                                        ai.stringTime(ai.getLamborghiniRaceTimeInSeconds()));
                                                        lamboStateLabel.setText("Empate");
                                                        break;
                                        }
                                }

                        }
                };
                new javax.swing.Timer(delay, taskPerformer).start();
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        bugattiCarImage = new javax.swing.JLabel();
        lamboCarImage = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bugattiIdLabel = new javax.swing.JLabel();
        lamboIdLabel = new javax.swing.JLabel();
        bugattiModeloLabel = new javax.swing.JLabel();
        lamboModeloLabel = new javax.swing.JLabel();
        bugattiStateLabel = new javax.swing.JLabel();
        lamboStateLabel = new javax.swing.JLabel();
        lamboTimeLabel = new javax.swing.JLabel();
        bugattiTimeLabel = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        processingTimeSlider = new javax.swing.JSlider();
        jLabel21 = new javax.swing.JLabel();
        processingTimeLabel = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        empezarButton1 = new javax.swing.JButton();
        Stop = new javax.swing.JButton();
        Play1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        bugattiCola1TextField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        bugattiCola2TextField = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        bugattiCola3TextField = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        bugattiColaRefuerzoTextField = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        bugattiVictoryCounterLabel = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        aiStateLabel = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        bugattiVictoryCounterLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lamborghiniCola1TextField1 = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        lamborghiniColaRefuerzoTextField1 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        lamborghiniCola3TextField1 = new javax.swing.JTextField();
        lamborghiniCola2TextField1 = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1080, 650));
        setMinimumSize(new java.awt.Dimension(1080, 650));

        jPanel2.setBackground(new java.awt.Color(224, 224, 224));
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 700));
        jPanel2.setVerifyInputWhenFocusTarget(false);

        bugattiCarImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        bugattiCarImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/bugatti/bugatti_chiron.png"))); // NOI18N

        lamboCarImage.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lamboCarImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Interfaces/lamborghini/lambo_murcielago.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Eras Bold ITC", 0, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(22, 15, 41));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("VS");

        bugattiIdLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        bugattiIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bugattiIdLabel.setText("ID Bugatti");

        lamboIdLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        lamboIdLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lamboIdLabel.setText("ID Lambo");

        bugattiModeloLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        bugattiModeloLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bugattiModeloLabel.setText("Modelo Bugatti");

        lamboModeloLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        lamboModeloLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lamboModeloLabel.setText("Modelo Lambo");

        bugattiStateLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        bugattiStateLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bugattiStateLabel.setText("Estado");

        lamboStateLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        lamboStateLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lamboStateLabel.setText("Estado");

        lamboTimeLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        lamboTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lamboTimeLabel.setText("0:00");

        bugattiTimeLabel.setFont(new java.awt.Font("Eras Bold ITC", 0, 14)); // NOI18N
        bugattiTimeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        bugattiTimeLabel.setText("0:00");

        jLabel1.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(102, 102, 102));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("ID");

        jLabel5.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Modelo");

        jLabel6.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(102, 102, 102));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Tiempo");

        jLabel9.setFont(new java.awt.Font("Eras Bold ITC", 0, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Estado");

        jLabel21.setFont(new java.awt.Font("Fugaz One", 0, 14)); // NOI18N
        jLabel21.setText("Tiempo de Procesamiento:");

        processingTimeLabel.setFont(new java.awt.Font("Fugaz One", 0, 14)); // NOI18N
        processingTimeLabel.setText("0");

        jLabel23.setFont(new java.awt.Font("Fugaz One", 0, 14)); // NOI18N
        jLabel23.setText("segundo(s)");

        empezarButton1.setFont(new java.awt.Font("Fugaz One", 0, 18)); // NOI18N
        empezarButton1.setForeground(new java.awt.Color(22, 15, 41));
        empezarButton1.setText("Empezar");
        empezarButton1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        empezarButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                empezarButton1ActionPerformed(evt);
            }
        });

        Stop.setBackground(new java.awt.Color(102, 0, 0));
        Stop.setFont(new java.awt.Font("Fugaz One", 0, 18)); // NOI18N
        Stop.setForeground(new java.awt.Color(0, 0, 0));
        Stop.setText("Stop");
        Stop.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Stop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StopActionPerformed(evt);
            }
        });

        Play1.setBackground(new java.awt.Color(0, 102, 0));
        Play1.setFont(new java.awt.Font("Fugaz One", 0, 18)); // NOI18N
        Play1.setForeground(new java.awt.Color(0, 0, 0));
        Play1.setText("Play");
        Play1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        Play1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Play1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(bugattiIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(lamboIdLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(bugattiModeloLabel)
                .addGap(39, 39, 39)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(lamboModeloLabel))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(bugattiTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(lamboTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addComponent(bugattiStateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(lamboStateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(bugattiCarImage)
                .addGap(6, 6, 6)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(lamboCarImage))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jLabel21)
                .addGap(6, 6, 6)
                .addComponent(processingTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jLabel23))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(140, 140, 140)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(processingTimeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(empezarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Play1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bugattiIdLabel)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel1))
                    .addComponent(lamboIdLabel))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bugattiModeloLabel)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel5))
                    .addComponent(lamboModeloLabel))
                .addGap(12, 12, 12)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bugattiTimeLabel)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel6))
                    .addComponent(lamboTimeLabel))
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bugattiStateLabel)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel9))
                    .addComponent(lamboStateLabel))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(bugattiCarImage)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lamboCarImage, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel21)
                    .addComponent(processingTimeLabel)
                    .addComponent(jLabel23))
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(processingTimeSlider, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(empezarButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Stop, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addComponent(Play1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        jPanel1.setBackground(new java.awt.Color(230, 175, 175));
        jPanel1.setPreferredSize(new java.awt.Dimension(300, 650));
        jPanel1.setVerifyInputWhenFocusTarget(false);

        bugattiCola1TextField.setEditable(false);
        bugattiCola1TextField.setBackground(new java.awt.Color(240, 240, 240));
        bugattiCola1TextField.setColumns(1);
        bugattiCola1TextField.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        bugattiCola1TextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        bugattiCola1TextField.setAutoscrolls(false);
        bugattiCola1TextField.setFocusable(false);
        bugattiCola1TextField.setMaximumSize(new java.awt.Dimension(187, 187));
        bugattiCola1TextField.setRequestFocusEnabled(false);
        bugattiCola1TextField.setVerifyInputWhenFocusTarget(false);
        bugattiCola1TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bugattiCola1TextFieldActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Fugaz One", 0, 14)); // NOI18N
        jLabel11.setText("Cola 1");

        jLabel13.setFont(new java.awt.Font("Fugaz One", 0, 14)); // NOI18N
        jLabel13.setText("Cola 2");

        bugattiCola2TextField.setEditable(false);
        bugattiCola2TextField.setBackground(new java.awt.Color(240, 240, 240));
        bugattiCola2TextField.setColumns(1);
        bugattiCola2TextField.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        bugattiCola2TextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        bugattiCola2TextField.setAutoscrolls(false);
        bugattiCola2TextField.setFocusable(false);
        bugattiCola2TextField.setMaximumSize(new java.awt.Dimension(187, 187));
        bugattiCola2TextField.setRequestFocusEnabled(false);
        bugattiCola2TextField.setVerifyInputWhenFocusTarget(false);
        bugattiCola2TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bugattiCola2TextFieldActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Fugaz One", 0, 14)); // NOI18N
        jLabel14.setText("Cola 3");

        bugattiCola3TextField.setEditable(false);
        bugattiCola3TextField.setBackground(new java.awt.Color(240, 240, 240));
        bugattiCola3TextField.setColumns(1);
        bugattiCola3TextField.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        bugattiCola3TextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        bugattiCola3TextField.setAutoscrolls(false);
        bugattiCola3TextField.setFocusable(false);
        bugattiCola3TextField.setMaximumSize(new java.awt.Dimension(187, 187));
        bugattiCola3TextField.setRequestFocusEnabled(false);
        bugattiCola3TextField.setVerifyInputWhenFocusTarget(false);
        bugattiCola3TextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bugattiCola3TextFieldActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Fugaz One", 0, 14)); // NOI18N
        jLabel15.setText("Cola Refuerzo");

        bugattiColaRefuerzoTextField.setEditable(false);
        bugattiColaRefuerzoTextField.setBackground(new java.awt.Color(240, 240, 240));
        bugattiColaRefuerzoTextField.setColumns(1);
        bugattiColaRefuerzoTextField.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        bugattiColaRefuerzoTextField.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        bugattiColaRefuerzoTextField.setAutoscrolls(false);
        bugattiColaRefuerzoTextField.setFocusable(false);
        bugattiColaRefuerzoTextField.setMaximumSize(new java.awt.Dimension(187, 187));
        bugattiColaRefuerzoTextField.setRequestFocusEnabled(false);
        bugattiColaRefuerzoTextField.setVerifyInputWhenFocusTarget(false);
        bugattiColaRefuerzoTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bugattiColaRefuerzoTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel11))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(bugattiCola1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel13))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(bugattiCola2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(201, 201, 201)
                .addComponent(jLabel14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(bugattiCola3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(152, 152, 152)
                .addComponent(jLabel15))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(55, 55, 55)
                .addComponent(bugattiColaRefuerzoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(jLabel11)
                .addGap(6, 6, 6)
                .addComponent(bugattiCola1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel13)
                .addGap(6, 6, 6)
                .addComponent(bugattiCola2TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel14)
                .addGap(6, 6, 6)
                .addComponent(bugattiCola3TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel15)
                .addGap(6, 6, 6)
                .addComponent(bugattiColaRefuerzoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel3.setBackground(new java.awt.Color(37, 37, 37));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/bugatti_logo.png"))); // NOI18N
        jLabel2.setText("Bugatti");

        jLabel7.setFont(new java.awt.Font("Fugaz One", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(224, 224, 224));
        jLabel7.setText("Victorias:");

        bugattiVictoryCounterLabel.setFont(new java.awt.Font("Fugaz One", 0, 18)); // NOI18N
        bugattiVictoryCounterLabel.setForeground(new java.awt.Color(224, 224, 224));
        bugattiVictoryCounterLabel.setText("0");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel7)
                .addGap(6, 6, 6)
                .addComponent(bugattiVictoryCounterLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(jLabel7))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(95, 95, 95)
                        .addComponent(bugattiVictoryCounterLabel))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(37, 37, 37));

        jLabel4.setFont(new java.awt.Font("Fugaz One", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(224, 224, 224));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("La IA está:");

        aiStateLabel.setFont(new java.awt.Font("Fugaz One", 0, 24)); // NOI18N
        aiStateLabel.setForeground(new java.awt.Color(224, 224, 224));
        aiStateLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        aiStateLabel.setText("Esperando");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(aiStateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(aiStateLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(37, 37, 37));

        jLabel17.setFont(new java.awt.Font("Fugaz One", 0, 18)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(224, 224, 224));
        jLabel17.setText("Victorias:");

        bugattiVictoryCounterLabel3.setFont(new java.awt.Font("Fugaz One", 0, 18)); // NOI18N
        bugattiVictoryCounterLabel3.setForeground(new java.awt.Color(224, 224, 224));
        bugattiVictoryCounterLabel3.setText("0");

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/lambo_logo.png"))); // NOI18N

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8)
                .addGap(18, 18, 18)
                .addComponent(jLabel17)
                .addGap(6, 6, 6)
                .addComponent(bugattiVictoryCounterLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(jLabel17))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(99, 99, 99)
                .addComponent(bugattiVictoryCounterLabel3))
        );

        jPanel7.setBackground(new java.awt.Color(233, 205, 123));
        jPanel7.setPreferredSize(new java.awt.Dimension(300, 650));
        jPanel7.setVerifyInputWhenFocusTarget(false);

        lamborghiniCola1TextField1.setEditable(false);
        lamborghiniCola1TextField1.setBackground(new java.awt.Color(240, 240, 240));
        lamborghiniCola1TextField1.setColumns(1);
        lamborghiniCola1TextField1.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lamborghiniCola1TextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lamborghiniCola1TextField1.setAutoscrolls(false);
        lamborghiniCola1TextField1.setFocusable(false);
        lamborghiniCola1TextField1.setMaximumSize(new java.awt.Dimension(187, 187));
        lamborghiniCola1TextField1.setRequestFocusEnabled(false);
        lamborghiniCola1TextField1.setVerifyInputWhenFocusTarget(false);
        lamborghiniCola1TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamborghiniCola1TextField1ActionPerformed(evt);
            }
        });

        jLabel20.setFont(new java.awt.Font("Fugaz One", 0, 14)); // NOI18N
        jLabel20.setText("Cola Refuerzo");

        lamborghiniColaRefuerzoTextField1.setEditable(false);
        lamborghiniColaRefuerzoTextField1.setBackground(new java.awt.Color(240, 240, 240));
        lamborghiniColaRefuerzoTextField1.setColumns(1);
        lamborghiniColaRefuerzoTextField1.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lamborghiniColaRefuerzoTextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lamborghiniColaRefuerzoTextField1.setAutoscrolls(false);
        lamborghiniColaRefuerzoTextField1.setFocusable(false);
        lamborghiniColaRefuerzoTextField1.setMaximumSize(new java.awt.Dimension(187, 187));
        lamborghiniColaRefuerzoTextField1.setRequestFocusEnabled(false);
        lamborghiniColaRefuerzoTextField1.setVerifyInputWhenFocusTarget(false);
        lamborghiniColaRefuerzoTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamborghiniColaRefuerzoTextField1ActionPerformed(evt);
            }
        });

        jLabel19.setFont(new java.awt.Font("Fugaz One", 0, 14)); // NOI18N
        jLabel19.setText("Cola 3");

        lamborghiniCola3TextField1.setEditable(false);
        lamborghiniCola3TextField1.setBackground(new java.awt.Color(240, 240, 240));
        lamborghiniCola3TextField1.setColumns(1);
        lamborghiniCola3TextField1.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lamborghiniCola3TextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lamborghiniCola3TextField1.setAutoscrolls(false);
        lamborghiniCola3TextField1.setFocusable(false);
        lamborghiniCola3TextField1.setMaximumSize(new java.awt.Dimension(187, 187));
        lamborghiniCola3TextField1.setRequestFocusEnabled(false);
        lamborghiniCola3TextField1.setVerifyInputWhenFocusTarget(false);
        lamborghiniCola3TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamborghiniCola3TextField1ActionPerformed(evt);
            }
        });

        lamborghiniCola2TextField1.setEditable(false);
        lamborghiniCola2TextField1.setBackground(new java.awt.Color(240, 240, 240));
        lamborghiniCola2TextField1.setColumns(1);
        lamborghiniCola2TextField1.setFont(new java.awt.Font("Eras Demi ITC", 0, 14)); // NOI18N
        lamborghiniCola2TextField1.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        lamborghiniCola2TextField1.setAutoscrolls(false);
        lamborghiniCola2TextField1.setFocusable(false);
        lamborghiniCola2TextField1.setMaximumSize(new java.awt.Dimension(187, 187));
        lamborghiniCola2TextField1.setRequestFocusEnabled(false);
        lamborghiniCola2TextField1.setVerifyInputWhenFocusTarget(false);
        lamborghiniCola2TextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lamborghiniCola2TextField1ActionPerformed(evt);
            }
        });

        jLabel16.setFont(new java.awt.Font("Fugaz One", 0, 14)); // NOI18N
        jLabel16.setText("Cola 1");

        jLabel18.setFont(new java.awt.Font("Fugaz One", 0, 14)); // NOI18N
        jLabel18.setText("Cola 2");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(lamborghiniCola1TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18)
                    .addComponent(lamborghiniCola2TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel19)
                    .addComponent(lamborghiniCola3TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20)
                    .addComponent(lamborghiniColaRefuerzoTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 187, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel16)
                .addGap(6, 6, 6)
                .addComponent(lamborghiniCola1TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel18)
                .addGap(6, 6, 6)
                .addComponent(lamborghiniCola2TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jLabel19)
                .addGap(6, 6, 6)
                .addComponent(lamborghiniCola3TextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addComponent(jLabel20)
                .addGap(6, 6, 6)
                .addComponent(lamborghiniColaRefuerzoTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void empezarButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_empezarButton1ActionPerformed
        administrador = new Administrador(ai);
        administrador.start();
        empezarButton1.setText("Empezar de nuevo");
    }//GEN-LAST:event_empezarButton1ActionPerformed

    private void StopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StopActionPerformed
        Global.play = false;
    }//GEN-LAST:event_StopActionPerformed

    private void Play1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Play1ActionPerformed
        Global.play = true;
    }//GEN-LAST:event_Play1ActionPerformed

        private void bugattiCola1TextFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bugattiCola1TextFieldActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_bugattiCola1TextFieldActionPerformed

        private void empezarButtonActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_empezarButtonActionPerformed

        }// GEN-LAST:event_empezarButtonActionPerformed

        private void bugattiCola2TextFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bugattiCola2TextFieldActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_bugattiCola2TextFieldActionPerformed

        private void bugattiCola3TextFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bugattiCola3TextFieldActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_bugattiCola3TextFieldActionPerformed

        private void bugattiColaRefuerzoTextFieldActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_bugattiColaRefuerzoTextFieldActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_bugattiColaRefuerzoTextFieldActionPerformed

        private void lamborghiniCola1TextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_lamborghiniCola1TextField1ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_lamborghiniCola1TextField1ActionPerformed

        private void lamborghiniCola2TextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_lamborghiniCola2TextField1ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_lamborghiniCola2TextField1ActionPerformed

        private void lamborghiniCola3TextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_lamborghiniCola3TextField1ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_lamborghiniCola3TextField1ActionPerformed

        private void lamborghiniColaRefuerzoTextField1ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_lamborghiniColaRefuerzoTextField1ActionPerformed
                // TODO add your handling code here:
        }// GEN-LAST:event_lamborghiniColaRefuerzoTextField1ActionPerformed

        /**
         * @param args the command line arguments
         */
        public static void main(String args[]) {
                /* Set the Nimbus look and feel */
                // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
                // (optional) ">
                /*
                 * If Nimbus (introduced in Java SE 6) is not available, stay with the default
                 * look and feel.
                 * For details see
                 * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
                 */
                try {
                        for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                                        .getInstalledLookAndFeels()) {
                                if ("Nimbus".equals(info.getName())) {
                                        javax.swing.UIManager.setLookAndFeel(info.getClassName());
                                        break;
                                }
                        }
                } catch (ClassNotFoundException ex) {
                        java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE,
                                        null, ex);
                }
                // </editor-fold>

                /* Create and display the form */
                java.awt.EventQueue.invokeLater(() -> {
                        new Menu().setVisible(true);
                });
        }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Play1;
    private javax.swing.JButton Stop;
    private javax.swing.JLabel aiStateLabel;
    private javax.swing.JLabel bugattiCarImage;
    private javax.swing.JTextField bugattiCola1TextField;
    private javax.swing.JTextField bugattiCola2TextField;
    private javax.swing.JTextField bugattiCola3TextField;
    private javax.swing.JTextField bugattiColaRefuerzoTextField;
    private javax.swing.JLabel bugattiIdLabel;
    private javax.swing.JLabel bugattiModeloLabel;
    private javax.swing.JLabel bugattiStateLabel;
    private javax.swing.JLabel bugattiTimeLabel;
    private javax.swing.JLabel bugattiVictoryCounterLabel;
    private javax.swing.JLabel bugattiVictoryCounterLabel3;
    private javax.swing.JButton empezarButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
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
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JLabel lamboCarImage;
    private javax.swing.JLabel lamboIdLabel;
    private javax.swing.JLabel lamboModeloLabel;
    private javax.swing.JLabel lamboStateLabel;
    private javax.swing.JLabel lamboTimeLabel;
    private javax.swing.JTextField lamborghiniCola1TextField1;
    private javax.swing.JTextField lamborghiniCola2TextField1;
    private javax.swing.JTextField lamborghiniCola3TextField1;
    private javax.swing.JTextField lamborghiniColaRefuerzoTextField1;
    private javax.swing.JLabel processingTimeLabel;
    private javax.swing.JSlider processingTimeSlider;
    // End of variables declaration//GEN-END:variables
}
