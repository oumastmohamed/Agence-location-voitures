/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackMenuForm.MesPanel;

import Application.BDD;
import Application.Parameter;
import Application.ResultSetTableModel;
import PackMenuForm.MenuClient;
import PackMenuForm.MenuForm;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import static com.itextpdf.text.Font.BOLD;
import static com.itextpdf.text.Font.NORMAL;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.KeyEvent;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
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
public class ListeClient extends javax.swing.JPanel {

    ResultSet rs;
    BDD db;
    
    private void MenuTableSize(){
        tableClient.getColumnModel().getColumn(1).setPreferredWidth(60);
        tableClient.getColumnModel().getColumn(2).setPreferredWidth(90);
        tableClient.getColumnModel().getColumn(3).setPreferredWidth(50);
        tableClient.getColumnModel().getColumn(4).setPreferredWidth(50);
        tableClient.getColumnModel().getColumn(5).setPreferredWidth(55);
        tableClient.getColumnModel().getColumn(7).setPreferredWidth(110);
    }
    
    private void FiltreClientVille(){
        if(cmbVille.getSelectedItem().toString().equals("Tous")){
            table();
        }else{
            String a[] = {"pieceIdentite", "numPiece", "date_delivr_piece", "nom", "prenom", "tele", "numPermis", "date_delivr_permis"};
            rs = db.fcSelectCommand(a ,"g_client_inf", " ville ='"+ cmbVille.getSelectedItem().toString() + "'" );
           tableClient.setModel(new ResultSetTableModel(rs)); 
           CountTableVehi();
        }
    }
    
    private void FiltreClientNom(){
        if(cmbNom.getSelectedItem().toString().equals("Tous")){
            table();
        }else{
            String a[] = {"pieceIdentite", "numPiece", "date_delivr_piece", "nom", "prenom", "tele", "numPermis", "date_delivr_permis"};
            rs = db.fcSelectCommand(a ,"g_client_inf", " nom ='"+ cmbNom.getSelectedItem().toString() + "'" );
           tableClient.setModel(new ResultSetTableModel(rs)); 
           CountTableVehi();
        }
    }
    
    private void FiltreClientPrenom(){
        if(cmbPrenom.getSelectedItem().toString().equals("Tous")){
            table();
        }else{
            String a[] = {"pieceIdentite", "numPiece", "date_delivr_piece", "nom", "prenom", "tele", "numPermis", "date_delivr_permis"};
            rs = db.fcSelectCommand(a ,"g_client_inf", " prenom ='"+ cmbPrenom.getSelectedItem().toString() + "'" );
           tableClient.setModel(new ResultSetTableModel(rs)); 
           CountTableVehi();
        }
    }
    
    private void InsertCmbPrenom(){
        String t[] = {"prenom"};
        rs = db.querySelect(t ,"g_client_inf");
        try{
            while(rs.next()){
                cmbPrenom.addItem(rs.getString("prenom"));
                }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    private void InsertCmbVille(){
        String t[] = {"ville"};
        rs = db.querySelect(t ,"g_client_inf");
        try{
            while(rs.next()){
                cmbVille.addItem(rs.getString("ville"));
                }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    private void InsertNom(){
        String t[] = {"nom"};
        rs = db.querySelect(t ,"g_client_inf");
        try{
            while(rs.next()){
                cmbNom.addItem(rs.getString("nom"));
                }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
    }
    
    public void table(){
        //String nomTable = "g_client_info as inf, g_client_permis as pe, g_client_piece as pi";
        String t[] = {"pieceIdentite", "numPiece", "date_delivr_piece", "nom", "prenom", "tele", "numPermis", "date_delivr_permis"};
        rs = db.querySelect(t, "g_client_inf");
        tableClient.setModel(new ResultSetTableModel(rs));
        CountTableVehi();
    }
    public void actualiser(){
        cmbVille.setSelectedIndex(0);
        cmbNom.setSelectedIndex(0);
        cmbPrenom.setSelectedIndex(0);
        cmb_piece.setSelectedIndex(0);
        txt_n_piece.setText("");
        txt_dat_delivr_piece.setText("");
        txt_nom.setText("");
        txt_prenom.setText("");
        txt_tele.setText("");
        txt_n_permis.setText("");
        txt_dat_delivr_permi.setText("");
        table();
    }
    
    private void CountTableVehi(){
        String t[] = {"COUNT(*)"};
        rs = db.querySelect(t, "g_client_inf");
        try{
            while(rs.next()){
                String res = rs.getString("COUNT(*)");
                lblResultClient.setText(res+" Résultats");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    public ListeClient() {
        initComponents();
        DynamicListeClient.setVisible(false);
        db =new BDD(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
        MenuTableSize();
        table();
        CountTableVehi();
        InsertNom();
        InsertCmbPrenom();
        InsertCmbVille();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbVille = new javax.swing.JComboBox();
        cmbNom = new javax.swing.JComboBox();
        cmbPrenom = new javax.swing.JComboBox();
        btnActualiser = new javax.swing.JButton();
        lblResultClient = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableClient = new javax.swing.JTable();
        DynamicListeClient = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_n_piece = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_dat_delivr_piece = new javax.swing.JTextField();
        txt_nom = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txt_prenom = new javax.swing.JTextField();
        txt_tele = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_n_permis = new javax.swing.JTextField();
        txt_dat_delivr_permi = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        cmb_piece = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        btn_Modifier = new javax.swing.JButton();
        btn_Imprimer = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        btnNouv = new javax.swing.JButton();
        btnVisua = new javax.swing.JButton();
        btnSupp = new javax.swing.JButton();
        btnImp = new javax.swing.JButton();

        setBackground(new java.awt.Color(244, 243, 243));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        jLabel2.setText("Liste des clients");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 211, 44));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/ListeClient.png"))); // NOI18N
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 50, 44));

        jPanel1.setBackground(new java.awt.Color(244, 243, 243));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBackground(new java.awt.Color(244, 243, 243));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Critères de recherche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Ville");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Nom");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Prenom");

        cmbVille.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous" }));
        cmbVille.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbVilleItemStateChanged(evt);
            }
        });
        cmbVille.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbVilleActionPerformed(evt);
            }
        });

        cmbNom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous" }));
        cmbNom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbNomItemStateChanged(evt);
            }
        });

        cmbPrenom.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous" }));
        cmbPrenom.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPrenomItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(cmbVille, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jLabel4)
                .addGap(27, 27, 27)
                .addComponent(cmbNom, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(28, 28, 28)
                .addComponent(cmbPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5)
                    .addComponent(cmbVille, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbNom, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbPrenom, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
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

        lblResultClient.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblResultClient.setForeground(new java.awt.Color(0, 0, 255));
        lblResultClient.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultClient.setText("jLabel6");

        tableClient.setBackground(new java.awt.Color(244, 243, 243));
        tableClient.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableClient.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Pièce d'identité", "Numéro pièce", "Date de délivrance", "Nom", "Prenom", "Téléphone", "Numéro permis", "Date délivrance permis"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tableClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableClient.setGridColor(new java.awt.Color(226, 226, 226));
        tableClient.setOpaque(false);
        tableClient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableClientMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableClient);

        DynamicListeClient.setBackground(new java.awt.Color(244, 243, 243));
        DynamicListeClient.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel4.setBackground(new java.awt.Color(244, 243, 243));

        jPanel5.setBackground(new java.awt.Color(244, 243, 243));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Pièce d'identité ");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("N° Pièce ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Date délivrance ");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Nom ");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Prenom");

        txt_prenom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_prenomActionPerformed(evt);
            }
        });

        txt_tele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_teleActionPerformed(evt);
            }
        });
        txt_tele.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_teleKeyTyped(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Téléphone");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("N° permis");

        txt_n_permis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_n_permisActionPerformed(evt);
            }
        });
        txt_n_permis.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_n_permisKeyTyped(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText("Date délivrance");

        cmb_piece.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CIN", "Passport" }));
        cmb_piece.setOpaque(false);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING))
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_dat_delivr_piece, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(txt_nom)
                    .addComponent(txt_n_piece)
                    .addComponent(cmb_piece, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_tele, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_n_permis, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_dat_delivr_permi, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txt_prenom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmb_piece, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_n_piece, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txt_tele, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_dat_delivr_piece, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_n_permis, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(txt_dat_delivr_permi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(244, 243, 243));

        btn_Modifier.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_Modifier.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/Modifier.png"))); // NOI18N
        btn_Modifier.setText("Modifier");
        btn_Modifier.setOpaque(false);
        btn_Modifier.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ModifierActionPerformed(evt);
            }
        });

        btn_Imprimer.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btn_Imprimer.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/ImprimerInfo.png"))); // NOI18N
        btn_Imprimer.setText("Imprimer");
        btn_Imprimer.setOpaque(false);
        btn_Imprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ImprimerActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_Modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btn_Imprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(btn_Imprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(btn_Modifier, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout DynamicListeClientLayout = new javax.swing.GroupLayout(DynamicListeClient);
        DynamicListeClient.setLayout(DynamicListeClientLayout);
        DynamicListeClientLayout.setHorizontalGroup(
            DynamicListeClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 793, Short.MAX_VALUE)
            .addGroup(DynamicListeClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DynamicListeClientLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        DynamicListeClientLayout.setVerticalGroup(
            DynamicListeClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 308, Short.MAX_VALUE)
            .addGroup(DynamicListeClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DynamicListeClientLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnActualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(lblResultClient, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DynamicListeClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblResultClient, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DynamicListeClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 61, -1, 700));

        jPanel2.setBackground(new java.awt.Color(244, 243, 243));

        jPanel6.setBackground(new java.awt.Color(244, 243, 243));
        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());

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

        btnVisua.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        btnVisua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/visualiser.png"))); // NOI18N
        btnVisua.setText("Visualiser");
        btnVisua.setOpaque(false);
        btnVisua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVisuaActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 176, Short.MAX_VALUE)
                    .addComponent(btnNouv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSupp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnImp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVisua, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnNouv, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnSupp, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(btnImp, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(241, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
        );

        add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 0, 220, 780));
    }// </editor-fold>//GEN-END:initComponents

    private void btnNouvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNouvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNouvActionPerformed

    private void btnVisuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisuaActionPerformed
         DynamicListeClient.setVisible(true);
    }//GEN-LAST:event_btnVisuaActionPerformed

    private void btnSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppActionPerformed
        // TODO add your handling code here:
        String id = String.valueOf(tableClient.getValueAt(tableClient.getSelectedRow(), 1));
        if(JOptionPane.showConfirmDialog(this,"est ce que tu es sure que tu veux supprimer",
                 "attention !!!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
            System.out.println(id);
                 db.queryDelete("g_client_inf", "numPiece= '" + id + "'");
                 
        }else{
              return;
        }
        table();
    }//GEN-LAST:event_btnSuppActionPerformed

    private void btnActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualiserActionPerformed
        // TODO add your handling code here:
        actualiser();
    }//GEN-LAST:event_btnActualiserActionPerformed

    private void cmbVilleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbVilleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbVilleActionPerformed

    private void txt_prenomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_prenomActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_prenomActionPerformed

    private void txt_teleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_teleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_teleActionPerformed

    private void txt_n_permisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_n_permisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_n_permisActionPerformed

    private void tableClientMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableClientMouseClicked
        // TODO add your handling code here:
        cmb_piece.setSelectedItem(String.valueOf(tableClient.getValueAt(tableClient.getSelectedRow(), 0)));
        txt_n_piece.setText(String.valueOf(tableClient.getValueAt(tableClient.getSelectedRow(), 1)));
        txt_dat_delivr_piece.setText(String.valueOf(tableClient.getValueAt(tableClient.getSelectedRow(), 2)));
        txt_nom.setText(String.valueOf(tableClient.getValueAt(tableClient.getSelectedRow(), 3)));
        txt_prenom.setText(String.valueOf(tableClient.getValueAt(tableClient.getSelectedRow(), 4)));
        txt_tele.setText(String.valueOf(tableClient.getValueAt(tableClient.getSelectedRow(), 5)));
        txt_n_permis.setText(String.valueOf(tableClient.getValueAt(tableClient.getSelectedRow(), 6)));
        txt_dat_delivr_permi.setText(String.valueOf(tableClient.getValueAt(tableClient.getSelectedRow(), 7)));
    }//GEN-LAST:event_tableClientMouseClicked

    private void btn_ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModifierActionPerformed
        // TODO add your handling code here:
        if(txt_n_piece.getText().equals("") || txt_dat_delivr_piece.getText().equals("") || txt_nom.getText().equals("") 
               || txt_prenom.getText().equals("") || txt_tele.getText().equals("")){
        
         JOptionPane.showMessageDialog(this, "SVP saisir les information complete");
        }else {
         String[] colo = {"pieceIdentite", "numPiece", "date_delivr_piece", "nom", "prenom", "tele", "numPermis", "date_delivr_permis"};
         String[] info = {cmb_piece.getSelectedItem().toString(), txt_n_piece.getText(), txt_dat_delivr_piece.getText(), txt_nom.getText(), txt_prenom.getText(), txt_tele.getText(), txt_n_permis.getText(), txt_dat_delivr_permi.getText()};
         String id = String.valueOf(tableClient.getValueAt(tableClient.getSelectedRow(), 1));
               System.out.println(db.queryUpdate("g_client_inf", colo, info, "numPiece ='" + id + "'"));
               table();
               }
    }//GEN-LAST:event_btn_ModifierActionPerformed

    private void cmbVilleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbVilleItemStateChanged
        // TODO add your handling code here:
        FiltreClientVille();
        CountTableVehi();
    }//GEN-LAST:event_cmbVilleItemStateChanged

    private void cmbNomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbNomItemStateChanged
        // TODO add your handling code here:
        FiltreClientNom();
        CountTableVehi();
    }//GEN-LAST:event_cmbNomItemStateChanged

    private void cmbPrenomItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPrenomItemStateChanged
        // TODO add your handling code here:
        FiltreClientPrenom();
        CountTableVehi();
    }//GEN-LAST:event_cmbPrenomItemStateChanged

    private void txt_n_permisKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_n_permisKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_txt_n_permisKeyTyped

    private void txt_teleKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_teleKeyTyped
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)){
            evt.consume();
        }
    }//GEN-LAST:event_txt_teleKeyTyped

    private void btn_ImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ImprimerActionPerformed
        
         try{
            
            String p_id = (String)(cmb_piece.getSelectedItem()) ;
            String num_id = txt_n_piece.getText();
            String date_d_piece = txt_dat_delivr_piece.getText();            
            String nom = txt_nom.getText() ;
            String prenom = txt_prenom.getText() ;
            String num_permis = txt_n_permis.getText() ;
            String date_d_permis = txt_dat_delivr_permi.getText() ;
            String tele = txt_tele.getText() ;
            
            Paragraph title = new Paragraph();
            Paragraph date  = new Paragraph();
            Paragraph p1    = new Paragraph();
            Paragraph p2    = new Paragraph();
            Paragraph p3    = new Paragraph();
            Paragraph p4    = new Paragraph();
            Paragraph p5    = new Paragraph();
            Paragraph p6    = new Paragraph();
            Paragraph p7    = new Paragraph();
            Paragraph p8    = new Paragraph();
                    
            Document document=new Document(); 
            //setBackground(Color.BLUE);
            PdfWriter page = null;
            page.getInstance(document,new FileOutputStream("UnClientListe.pdf"));            
            
            document.open();
            // Ajouter une images
            Image image = Image.getInstance ("C:\\Users\\StongKa\\Documents\\NetBeansProjects\\AgenceLocationVoitures\\src\\PackMenuForm\\Icons\\itext\\manred.png");
            image.scaleToFit(100, 90);
            //image.scaleAbsolute(60,50);            
            document.add(image);             
            // Le titre de document
            title = new Paragraph("Détailles sur le Client", 
                    FontFactory.getFont(FontFactory.TIMES_BOLDITALIC, 30, BOLD, BaseColor.BLUE));
            title.setAlignment(Element.ALIGN_CENTER);                        
            document.add(title);
            document.add(new Paragraph("\n"));
            date = new Paragraph( new Chunk(new Date().toString(), 
                    FontFactory.getFont(FontFactory.TIMES, 10, NORMAL, BaseColor.GREEN)));
            document.add(date);
            document.add(new Paragraph("----------------------------------------------------------------"
                                    + "------------------------------------------------------------------"));
            document.add(new Paragraph("\n\n"));
            
            p1.add(new Chunk("Numéro d'Identité :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p1.add(new Chunk("                    "+ num_id , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p1.setAlignment(Element.ALIGN_LEFT);
            document.add(p1);
            document.add(new Paragraph("\n"));
            
            // Ajouter les colonnes au paragraphes
            p2.add(new Chunk("Pièce d'identité :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p2.add(new Chunk("                         "+   p_id , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p2.setAlignment(Element.ALIGN_LEFT); 
            // Ajouter les paragraphes ( ou bien Les visualiser )
            document.add(p2);
            document.add(new Paragraph("\n"));
            
            p3.add(new Chunk("Date Dilévrance de Pièce :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p3.add(new Chunk("         "+ date_d_piece , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p3.setAlignment(Element.ALIGN_LEFT);
            document.add(p3);
            document.add(new Paragraph("\n"));
            
            p4.add(new Chunk("Nom :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p4.add(new Chunk("                                         "+ nom , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p4.setAlignment(Element.ALIGN_LEFT);
            document.add(p4);
            document.add(new Paragraph("\n"));
            
            p5.add(new Chunk("Prénom :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p5.add(new Chunk("                                    "+ prenom , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p5.setAlignment(Element.ALIGN_LEFT);
            document.add(p5);
            document.add(new Paragraph("\n"));
            
            p6.add(new Chunk("Numéro de Permis :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p6.add(new Chunk("                  "+ num_permis , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p6.setAlignment(Element.ALIGN_LEFT);
            document.add(p6);
            document.add(new Paragraph("\n"));
                        
            p7.add(new Chunk("Date Dilévrance de Permis :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p7.add(new Chunk("     "+ date_d_permis , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p7.setAlignment(Element.ALIGN_LEFT);
            document.add(p7);
            document.add(new Paragraph("\n"));
            
            p8.add(new Chunk("Numéro de Téléphone :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p8.add(new Chunk("             "+ tele , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p8.setAlignment(Element.ALIGN_LEFT);
            document.add(p8);
            document.add(new Paragraph("\n\n"));
            
            // Fermeture de document
            document.close();
            // le chemin de fichier PDF
            String filePath = "C:\\Users\\StongKa\\Documents\\NetBeansProjects\\AgenceLocationVoitures\\UnClientListe.pdf";
            // Executer et afficher le fichier
            Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + filePath); 
            
            //JOptionPane.showMessageDialog(null,"Raport Enregistré avec succée.");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,ex);
        }
    }//GEN-LAST:event_btn_ImprimerActionPerformed

    private void btnImpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImpActionPerformed
        
         try{
            //db =new BDD(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
            
            Connection cnx;
            Driver monDriver;
            monDriver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(monDriver);           
            cnx=DriverManager.getConnection("jdbc:mysql://localhost/gestion_location_voitures","root","");
            
            JasperDesign REPORT=JRXmlLoader.load("C:\\Users\\StongKa\\Documents\\NetBeansProjects\\AgenceLocationVoitures\\src\\PackMenuForm\\MesPanel\\Reports\\ListeClients2.jrxml");
            JasperReport JASP_REP=JasperCompileManager.compileReport(REPORT);
            
            JasperPrint JASP_PRINT=JasperFillManager.fillReport(JASP_REP,null,cnx);
            JasperViewer.viewReport(JASP_PRINT);
            //en format pdf
           JasperExportManager.exportReportToPdfFile(JASP_PRINT,"C:\\Users\\StongKa\\Documents\\NetBeansProjects\\AgenceLocationVoitures\\src\\PackMenuForm\\MesPanel\\Reports\\ListeClients.pdf");
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnImpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DynamicListeClient;
    private javax.swing.JButton btnActualiser;
    private javax.swing.JButton btnImp;
    private javax.swing.JButton btnNouv;
    private javax.swing.JButton btnSupp;
    private javax.swing.JButton btnVisua;
    private javax.swing.JButton btn_Imprimer;
    private javax.swing.JButton btn_Modifier;
    private javax.swing.JComboBox cmbNom;
    private javax.swing.JComboBox cmbPrenom;
    private javax.swing.JComboBox cmbVille;
    private javax.swing.JComboBox cmb_piece;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblResultClient;
    private javax.swing.JTable tableClient;
    private javax.swing.JTextField txt_dat_delivr_permi;
    private javax.swing.JTextField txt_dat_delivr_piece;
    private javax.swing.JTextField txt_n_permis;
    private javax.swing.JTextField txt_n_piece;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_prenom;
    private javax.swing.JTextField txt_tele;
    // End of variables declaration//GEN-END:variables
}
