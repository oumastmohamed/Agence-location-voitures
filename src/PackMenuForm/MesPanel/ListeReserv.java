/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackMenuForm.MesPanel;

import Application.BDD;
import Application.Parameter;
import Application.ResultSetTableModel;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author StongKa
 */
public class ListeReserv extends javax.swing.JPanel {

    ResultSet rs;
    BDD db;
    
    private void actualser(){
        cmb_nom.setSelectedIndex(0);
        cmb_prenom.setSelectedIndex(0);
        cmb_marque.setSelectedIndex(0);
        cmb_modele.setSelectedIndex(0);
        cmb_imma.setSelectedIndex(0);
        cmb_d.setSelectedIndex(0);
        cmb_r.setSelectedIndex(0);
        table();
        
    }
    
    private void InsertCmbNom(){
        String t[] = {"nom"};
        rs = db.querySelect(t ,"g_client_inf");
        try{
            while(rs.next()){
                cmb_nom.addItem(rs.getString("nom"));
                }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    private void InsertCmbPrenom(){
        String t[] = {"prenom"};
        rs = db.querySelect(t ,"g_client_inf");
        try{
            while(rs.next()){
                cmb_prenom.addItem(rs.getString("prenom"));
                }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    private void InsertCmbMarque(){
        String t[] = {"Marque"};
        rs = db.querySelect(t ,"g_client_vehi");
        try{
            while(rs.next()){
                cmb_marque.addItem(rs.getString("Marque"));
                }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    private void table(){
        String t[] = {"v.immatricule", "inf.nom", "inf.prenom", "res.Date_depart", "res.Lieu_depart", "res.Date_retour", "res.Lieu_retour"};
        rs = db.querySelect(t, "g_client_inf as inf JOIN g_client_vehi as v JOIN g_reservation as res ON (inf.numPiece = res.numPiece) and (v.immatricule = res.immatricule)");
        tableReserv.setModel(new ResultSetTableModel(rs));
    }
    
    private void InsertCmbModele(){
        String t[] = {"Modele"};
        rs = db.querySelect(t ,"g_client_vehi");
        try{
            while(rs.next()){
                cmb_modele.addItem(rs.getString("Modele"));
                }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    private void InsertCmbImma(){
        String t[] = {"immatricule"};
        rs = db.querySelect(t ,"g_client_vehi");
        try{
            while(rs.next()){
                cmb_imma.addItem(rs.getString("immatricule"));
                }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    private void FiltreClientNom(){
        if(cmb_nom.getSelectedItem().toString().equals("Tous")){
            table();
        }else{
            String a[] = {"v.immatricule", "inf.nom", "inf.prenom", "res.Date_depart", "res.Lieu_depart", "res.Date_retour", "res.Lieu_retour"};
            rs = db.fcSelectCommand(a ,"g_client_inf as inf JOIN g_client_vehi as v JOIN g_reservation as res ON (inf.numPiece = res.numPiece) and (v.immatricule = res.immatricule)", " inf.nom ='"+ cmb_nom.getSelectedItem().toString() + "'" );
           tableReserv.setModel(new ResultSetTableModel(rs)); 
        }
    }
    
    private void FiltreClientPrenom(){
        if(cmb_prenom.getSelectedItem().toString().equals("Tous")){
            table();
        }else{
            String a[] = {"v.immatricule", "inf.nom", "inf.prenom", "res.Date_depart", "res.Lieu_depart", "res.Date_retour", "res.Lieu_retour"};
            rs = db.fcSelectCommand(a ,"g_client_inf as inf JOIN g_client_vehi as v JOIN g_reservation as res ON (inf.numPiece = res.numPiece) and (v.immatricule = res.immatricule)", " inf.prenom ='"+ cmb_prenom.getSelectedItem().toString() + "'" );
           tableReserv.setModel(new ResultSetTableModel(rs)); 
        }
    }
    
    private void FiltreVehiMarque(){
        if(cmb_marque.getSelectedItem().toString().equals("Tous")){
            table();
        }else{
            String a[] = {"v.immatricule", "inf.nom", "inf.prenom", "res.Date_depart", "res.Lieu_depart", "res.Date_retour", "res.Lieu_retour"};
            rs = db.fcSelectCommand(a ,"g_client_inf as inf JOIN g_client_vehi as v JOIN g_reservation as res ON (inf.numPiece = res.numPiece) and (v.immatricule = res.immatricule)", " v.Marque ='"+ cmb_marque.getSelectedItem().toString() + "'" );
           tableReserv.setModel(new ResultSetTableModel(rs)); 
        }
    }
    
    private void FiltreVehiModele(){
        if(cmb_marque.getSelectedItem().toString().equals("Tous")){
            table();
        }else{
            String a[] = {"v.immatricule", "inf.nom", "inf.prenom", "res.Date_depart", "res.Lieu_depart", "res.Date_retour", "res.Lieu_retour"};
            rs = db.fcSelectCommand(a ,"g_client_inf as inf JOIN g_client_vehi as v JOIN g_reservation as res ON (inf.numPiece = res.numPiece) and (v.immatricule = res.immatricule)", " v.Modele ='"+ cmb_modele.getSelectedItem().toString() + "'" );
           tableReserv.setModel(new ResultSetTableModel(rs)); 
        }
    }
    
    private void FiltreVehiImma(){
        if(cmb_imma.getSelectedItem().toString().equals("Tous")){
            table();
        }else{
            String a[] = {"v.immatricule", "inf.nom", "inf.prenom", "res.Date_depart", "res.Lieu_depart", "res.Date_retour", "res.Lieu_retour"};
            rs = db.fcSelectCommand(a ,"g_client_inf as inf JOIN g_client_vehi as v JOIN g_reservation as res ON (inf.numPiece = res.numPiece) and (v.immatricule = res.immatricule)", " v.immatricule ='"+ cmb_imma.getSelectedItem().toString() + "'" );
           tableReserv.setModel(new ResultSetTableModel(rs)); 
        }
    }
    
    private void FiltreAgenceDepart(){
        if(cmb_d.getSelectedItem().toString().equals("Tous")){
            table();
        }else{
            String a[] = {"v.immatricule", "inf.nom", "inf.prenom", "res.Date_depart", "res.Lieu_depart", "res.Date_retour", "res.Lieu_retour"};
            rs = db.fcSelectCommand(a ,"g_client_inf as inf JOIN g_client_vehi as v JOIN g_reservation as res ON (inf.numPiece = res.numPiece) and (v.immatricule = res.immatricule)", " res.Lieu_depart ='"+ cmb_d.getSelectedItem().toString() + "'" );
           tableReserv.setModel(new ResultSetTableModel(rs)); 
        }
    }
    
    private void FiltreAgenceRetour(){
        if(cmb_r.getSelectedItem().toString().equals("Tous")){
            table();
        }else{
            String a[] = {"v.immatricule", "inf.nom", "inf.prenom", "res.Date_depart", "res.Lieu_depart", "res.Date_retour", "res.Lieu_retour"};
            rs = db.fcSelectCommand(a ,"g_client_inf as inf JOIN g_client_vehi as v JOIN g_reservation as res ON (inf.numPiece = res.numPiece) and (v.immatricule = res.immatricule)", " res.Lieu_retour ='"+ cmb_r.getSelectedItem().toString() + "'" );
           tableReserv.setModel(new ResultSetTableModel(rs)); 
        }
    }
    
    public ListeReserv() {
        initComponents();
        db =new BDD(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
        table();
        InsertCmbNom();
        InsertCmbPrenom();
        InsertCmbMarque();
        InsertCmbModele();
        InsertCmbImma();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        cmb_prenom = new javax.swing.JComboBox();
        cmb_nom = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmb_marque = new javax.swing.JComboBox();
        cmb_modele = new javax.swing.JComboBox();
        cmb_imma = new javax.swing.JComboBox();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cmb_d = new javax.swing.JComboBox();
        cmb_r = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableReserv = new javax.swing.JTable();
        btnActualiser = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnNouv = new javax.swing.JButton();
        btnSupp = new javax.swing.JButton();
        btnImp = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();

        setBackground(new java.awt.Color(244, 243, 243));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/listeVoiture.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        jLabel2.setText("Liste des réservations");

        jPanel1.setBackground(new java.awt.Color(244, 243, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(244, 243, 243));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Par client", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Nom");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Prenom");

        cmb_prenom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous" }));
        cmb_prenom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_prenomItemStateChanged(evt);
            }
        });

        cmb_nom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous" }));
        cmb_nom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_nomItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cmb_prenom, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_nom, 0, 131, Short.MAX_VALUE))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmb_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cmb_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBackground(new java.awt.Color(244, 243, 243));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Par véhicules", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Marque");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Modèle");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Immatriculation");

        cmb_marque.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous" }));
        cmb_marque.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_marqueItemStateChanged(evt);
            }
        });

        cmb_modele.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous" }));
        cmb_modele.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_modeleItemStateChanged(evt);
            }
        });

        cmb_imma.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous" }));
        cmb_imma.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_immaItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(cmb_marque, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(cmb_modele, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmb_imma, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmb_marque, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmb_modele, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmb_imma, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(244, 243, 243));
        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Par Agence", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(0, 0, 204))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Départ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Retour");

        cmb_d.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous", "Agence A", "Agence B" }));
        cmb_d.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_dItemStateChanged(evt);
            }
        });

        cmb_r.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous", "Agence X", "Agence Y" }));
        cmb_r.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmb_rItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_r, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(cmb_d, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(19, 19, 19))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(cmb_d, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(cmb_r, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50))
        );

        jPanel5.setBackground(new java.awt.Color(244, 243, 243));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        tableReserv.setBackground(new java.awt.Color(244, 243, 243));
        tableReserv.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableReserv.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Immatriculation", "Nom", "Prenom", "DateDepart", "LieuDepart", "DateRetour", "LieuRetour"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableReserv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableReserv.setGridColor(new java.awt.Color(226, 226, 226));
        tableReserv.setOpaque(false);
        tableReserv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableReservMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableReserv);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        btnActualiser.setBackground(new java.awt.Color(244, 243, 243));
        btnActualiser.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/Actualiser.png"))); // NOI18N
        btnActualiser.setBorderPainted(false);
        btnActualiser.setContentAreaFilled(false);
        btnActualiser.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnActualiser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualiserActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnActualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        jPanel6.setBackground(new java.awt.Color(244, 243, 243));

        jPanel8.setBackground(new java.awt.Color(244, 243, 243));
        jPanel8.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnNouv.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnNouv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/nouveau.png"))); // NOI18N
        btnNouv.setText("Nouveau");
        btnNouv.setEnabled(false);
        btnNouv.setFocusPainted(false);
        btnNouv.setOpaque(false);
        btnNouv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNouvActionPerformed(evt);
            }
        });

        btnSupp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnSupp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/supprimer.png"))); // NOI18N
        btnSupp.setText("Supprimer");
        btnSupp.setOpaque(false);
        btnSupp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuppActionPerformed(evt);
            }
        });

        btnImp.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnImp.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/Imprimer.png"))); // NOI18N
        btnImp.setText("Imprimer");
        btnImp.setOpaque(false);
        btnImp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImpActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnNouv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSupp, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                    .addComponent(btnImp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addComponent(btnNouv, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnImp, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(244, 243, 243));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 232, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 159, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(22, Short.MAX_VALUE)))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel6Layout.createSequentialGroup()
                    .addGap(184, 184, 184)
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(169, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(287, 287, 287)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 716, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 21, Short.MAX_VALUE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnNouvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNouvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNouvActionPerformed

    private void btnSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppActionPerformed
        // TODO add your handling code here:
        String id = String.valueOf(tableReserv.getValueAt(tableReserv.getSelectedRow(), 0));
        if(JOptionPane.showConfirmDialog(this,"est ce que tu es sure que tu veux supprimer",
            "attention !!!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
        System.out.println(id);
        db.queryDelete("g_reservation", "immatricule= '" + id + "'");

        }else{
            return;
        }
        table();
    }//GEN-LAST:event_btnSuppActionPerformed

    private void tableReservMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableReservMouseClicked
        // TODO add your handling code here:
//        txt_imma.setText(String.valueOf(tableReserv.getValueAt(tableReserv.getSelectedRow(), 0)));
//        txt_marque.setText(String.valueOf(tableReserv.getValueAt(tableReserv.getSelectedRow(), 1)));
//        txt_modele.setText(String.valueOf(tableReserv.getValueAt(tableReserv.getSelectedRow(), 2)));
//        txt_Catègorie.setText(String.valueOf(tableReserv.getValueAt(tableReserv.getSelectedRow(), 3)));
//        cmb_couleur.setSelectedItem(String.valueOf(tableReserv.getValueAt(tableReserv.getSelectedRow(), 4)));
//        cmb_carb.setSelectedItem(String.valueOf(tableReserv.getValueAt(tableReserv.getSelectedRow(), 5)));
//        txt_lieuS.setText(String.valueOf(tableReserv.getValueAt(tableReserv.getSelectedRow(), 6)));
    }//GEN-LAST:event_tableReservMouseClicked

    private void btnActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualiserActionPerformed
        // TODO add your handling code here:
        actualser();
    }//GEN-LAST:event_btnActualiserActionPerformed

    private void cmb_nomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_nomItemStateChanged
        // TODO add your handling code here:
        FiltreClientNom();
    }//GEN-LAST:event_cmb_nomItemStateChanged

    private void cmb_prenomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_prenomItemStateChanged
        // TODO add your handling code here:
        FiltreClientPrenom();
    }//GEN-LAST:event_cmb_prenomItemStateChanged

    private void cmb_marqueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_marqueItemStateChanged
        // TODO add your handling code here:
        FiltreVehiMarque();
    }//GEN-LAST:event_cmb_marqueItemStateChanged

    private void cmb_modeleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_modeleItemStateChanged
        // TODO add your handling code here:
        FiltreVehiModele();
    }//GEN-LAST:event_cmb_modeleItemStateChanged

    private void cmb_immaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_immaItemStateChanged
        // TODO add your handling code here:
        FiltreVehiImma();
    }//GEN-LAST:event_cmb_immaItemStateChanged

    private void cmb_dItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_dItemStateChanged
        // TODO add your handling code here:
        FiltreAgenceDepart();
    }//GEN-LAST:event_cmb_dItemStateChanged

    private void cmb_rItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmb_rItemStateChanged
        // TODO add your handling code here:
        FiltreAgenceRetour();
    }//GEN-LAST:event_cmb_rItemStateChanged

    private void btnImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpActionPerformed
        
        try{
            //db =new BDD(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
            
            Connection cnx;
            Driver monDriver;
            monDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(monDriver);           
            cnx=DriverManager.getConnection("jdbc:mysql://localhost/gestion_location_voitures","root","");
            
            JasperDesign REPORT=JRXmlLoader.load("C:\\Users\\StongKa\\Documents\\NetBeansProjects\\AgenceLocationVoitures\\src\\PackMenuForm\\MesPanel\\Reports\\ListeReservation.jrxml");
            JasperReport JASP_REP=JasperCompileManager.compileReport(REPORT);
            
            JasperPrint JASP_PRINT=JasperFillManager.fillReport(JASP_REP,null,cnx);
            JasperViewer.viewReport(JASP_PRINT);
            //en format pdf
           JasperExportManager.exportReportToPdfFile(JASP_PRINT,"C:\\Users\\StongKa\\Documents\\NetBeansProjects\\AgenceLocationVoitures\\src\\PackMenuForm\\MesPanel\\Reports\\ListeReservation.pdf");
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnImpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualiser;
    private javax.swing.JButton btnImp;
    private javax.swing.JButton btnNouv;
    private javax.swing.JButton btnSupp;
    private javax.swing.JComboBox cmb_d;
    private javax.swing.JComboBox cmb_imma;
    private javax.swing.JComboBox cmb_marque;
    private javax.swing.JComboBox cmb_modele;
    private javax.swing.JComboBox cmb_nom;
    private javax.swing.JComboBox cmb_prenom;
    private javax.swing.JComboBox cmb_r;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableReserv;
    // End of variables declaration//GEN-END:variables
}
