/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackMenuForm.MesPanel;

import Application.BDD;
import Application.Parameter;
import Application.ResultSetTableModel;
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
public class ListeVehi extends javax.swing.JPanel {

    ResultSet rs;
    BDD db;
    String FRadio;
    public void table(){
        
        String t[] = {"immatricule", "Marque", "Modele", "Categorie", "Couleur", "Curburant", "Lieu_stationnement"};
        rs = db.querySelect(t, "g_client_vehi");
        tableVehi.setModel(new ResultSetTableModel(rs));
        rbtn_tout.setSelected(true);
        CountTableVehi();
    }
    
    private void InsertCmbModele(){
        String t[] = {"DISTINCT ModeleV"};
        rs = db.querySelect(t ,"typevoitures");
        try{
            while(rs.next()){
                cmbModele.addItem(rs.getString("ModeleV"));
                }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        } 
    }
        
    private void FiltreClientMarque(){
        if(cmbMarque.getSelectedItem().toString().equals("Tous")){
            table();
        }else{
            String a[] = {"immatricule", "Marque", "Modele", "Categorie", "Couleur", "Curburant", "Lieu_stationnement"};
            rs = db.fcSelectCommand(a ,"g_client_vehi", " Marque ='"+ cmbMarque.getSelectedItem().toString() + "'" );
           tableVehi.setModel(new ResultSetTableModel(rs)); 
        }
    }
    
    private void FiltreClientModele(){
        if(cmbModele.getSelectedItem().toString().equals("Tous")){
            table();
        }else{
            String a[] = {"immatricule", "Marque", "Modele", "Categorie", "Couleur", "Curburant", "Lieu_stationnement"};
            rs = db.fcSelectCommand(a ,"g_client_vehi", " Modele ='"+ cmbModele.getSelectedItem().toString() + "'" );
           tableVehi.setModel(new ResultSetTableModel(rs)); 
        }
    }
    
    private void FiltreClientCat(){
        if(cmbCat.getSelectedItem().toString().equals("Tous")){
            table();
        }else{
            String a[] = {"immatricule", "Marque", "Modele", "Categorie", "Couleur", "Curburant", "Lieu_stationnement"};
            rs = db.fcSelectCommand(a ,"g_client_vehi", " Categorie ='"+ cmbCat.getSelectedItem().toString() + "'" );
            tableVehi.setModel(new ResultSetTableModel(rs)); 
        }
    }
    
    private void FiltreVehiCurb(){
        if(rbtn_tout.isSelected()){
            table();
        }else if(rbtn_ess.isSelected()){
            FRadio = "Essence";
        }else if(rbtn_gas.isSelected()){
            FRadio = "Gasoil";
        }else if(rbtn_gas.isSelected()){
            FRadio = "GPL";
        }
        String a[] = {"immatricule", "Marque", "Modele", "Categorie", "Couleur", "Curburant", "Lieu_stationnement"};
            rs = db.fcSelectCommand(a ,"g_client_vehi", " Curburant ='"+ FRadio + "'" );
            tableVehi.setModel(new ResultSetTableModel(rs));
    }
    
    private void GroupBtn(){
        GroupBtn.add(rbtn_tout);
        GroupBtn.add(rbtn_ess);
        GroupBtn.add(rbtn_gpl);
        GroupBtn.add(rbtn_gas);
    }
    
    public void actualiser(){
        cmbMarque.setSelectedIndex(0);
        cmbModele.setSelectedIndex(0);
        cmbCat.setSelectedIndex(0);
        rbtn_tout.setSelected(true);
        txt_imma.setText("");
        txt_marque.setText("");
        txt_modele.setText("");
        txt_Catègorie.setText("");
        cmb_couleur.setSelectedIndex(0);
        cmb_carb.setSelectedIndex(0);
        txt_lieuS.setText("");
        table();
    }
    
    private void CountTableVehi(){
        String t[] = {"COUNT(*)"};
        rs = db.querySelect(t, "g_client_vehi");
        try{
            while(rs.next()){
                String res = rs.getString("COUNT(*)");
                lblResultVehi.setText(res+" Résultats");
            }
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
    }
    
    private void MenuTableSize(){
        tableVehi.getColumnModel().getColumn(7).setPreferredWidth(100);
    }
    
    public ListeVehi() {
        initComponents();
        db =new BDD(new Parameter().HOST_DB, new Parameter().USERNAME_DB, new Parameter().PASSWORD_DB, new Parameter().IPHOST, new Parameter().PORT);
        DynamicListeVehi.setVisible(true);
        PanelVisua.setVisible(false);
        table();
        GroupBtn();
        InsertCmbModele();
       // MenuTableSize();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GroupBtn = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cmbMarque = new javax.swing.JComboBox();
        cmbModele = new javax.swing.JComboBox();
        cmbCat = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        rbtn_ess = new javax.swing.JRadioButton();
        rbtn_gas = new javax.swing.JRadioButton();
        rbtn_gpl = new javax.swing.JRadioButton();
        rbtn_tout = new javax.swing.JRadioButton();
        btnActualiser = new javax.swing.JButton();
        lblResultVehi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableVehi = new javax.swing.JTable();
        DynamicListeVehi = new javax.swing.JPanel();
        PanelVisua = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        txt_marque = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_modele = new javax.swing.JTextField();
        txt_Catègorie = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txt_lieuS = new javax.swing.JTextField();
        txt_imma = new javax.swing.JTextField();
        cmb_couleur = new javax.swing.JComboBox();
        cmb_carb = new javax.swing.JComboBox();
        jPanel7 = new javax.swing.JPanel();
        btn_Modifier = new javax.swing.JButton();
        btn_Imprimer = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        btnNouv = new javax.swing.JButton();
        btnVisua = new javax.swing.JButton();
        btnSupp = new javax.swing.JButton();
        btnImp = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(244, 243, 243));

        jPanel1.setBackground(new java.awt.Color(244, 243, 243));

        jPanel2.setBackground(new java.awt.Color(244, 243, 243));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBackground(new java.awt.Color(244, 243, 243));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEtchedBorder(), "Critères de recherche", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel3.setText("Marque");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel4.setText("Modèle");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel5.setText("Catégorie");

        cmbMarque.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous", "Alfa Remeo", "Audi", "Aston Martin", "BMW", "Cadillac", "Chevrolet", "Dacia", "Corvette", "Ford", "Hyundai", "Lamborghini", "Land Rover", "Mercedes", "Mini", "Renault", "Peugeot" }));
        cmbMarque.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMarqueItemStateChanged(evt);
            }
        });
        cmbMarque.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbMarqueActionPerformed(evt);
            }
        });

        cmbModele.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous" }));
        cmbModele.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbModeleItemStateChanged(evt);
            }
        });

        cmbCat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Tous", "Tourisme", "Monospace" }));
        cmbCat.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCatItemStateChanged(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel14.setText("Carburant");

        rbtn_ess.setText("Essence");

        rbtn_gas.setText("Gasoil");

        rbtn_gpl.setText("GPL");
        rbtn_gpl.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtn_gplItemStateChanged(evt);
            }
        });
        rbtn_gpl.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtn_gplStateChanged(evt);
            }
        });
        rbtn_gpl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtn_gplMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtn_gplMousePressed(evt);
            }
        });
        rbtn_gpl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_gplActionPerformed(evt);
            }
        });
        rbtn_gpl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbtn_gplKeyPressed(evt);
            }
        });

        rbtn_tout.setText("Tout");
        rbtn_tout.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbtn_toutItemStateChanged(evt);
            }
        });
        rbtn_tout.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                rbtn_toutStateChanged(evt);
            }
        });
        rbtn_tout.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbtn_toutMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbtn_toutMousePressed(evt);
            }
        });
        rbtn_tout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_toutActionPerformed(evt);
            }
        });
        rbtn_tout.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                rbtn_toutKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cmbMarque, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cmbCat, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmbModele, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtn_tout)
                    .addComponent(rbtn_ess))
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rbtn_gas)
                    .addComponent(rbtn_gpl))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtn_gpl)
                            .addComponent(rbtn_tout))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtn_ess)
                            .addComponent(rbtn_gas)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cmbMarque, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbCat, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbModele, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(23, Short.MAX_VALUE))
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

        lblResultVehi.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        lblResultVehi.setForeground(new java.awt.Color(51, 51, 255));
        lblResultVehi.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblResultVehi.setText("jLabel6");

        tableVehi.setBackground(new java.awt.Color(244, 243, 243));
        tableVehi.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        tableVehi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Immatriculation", "Marque", "Modèle", "Catégorie", "Couleur", "Carburant", "Lieu de stationnement"
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
        tableVehi.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tableVehi.setGridColor(new java.awt.Color(226, 226, 226));
        tableVehi.setOpaque(false);
        tableVehi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVehiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableVehi);

        DynamicListeVehi.setBackground(new java.awt.Color(244, 243, 243));
        DynamicListeVehi.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        PanelVisua.setBackground(new java.awt.Color(244, 243, 243));

        jPanel5.setBackground(new java.awt.Color(244, 243, 243));
        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("Immatriculation");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel7.setText("Marque");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel8.setText("Modèle");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("Catègorie");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel10.setText("Couleur");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Carburant");

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel12.setText("Stationnement");

        txt_lieuS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lieuSActionPerformed(evt);
            }
        });

        cmb_couleur.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Abricot", "Absinthe", "Acajou", "Aigue-marine", "Aile de corbeau (cheveux)", "Albâtre", "Alezan (chevaux)", "Amande", "Amarante", "Ambre jaune", "Ambre rouge", "Améthyste", "Anthracite", "Aquilain (chevaux)", "Ardoise", "Argent", "Argent (héraldique)4", "Argile", "Asperge", "Aubergine", "Auburn (cheveux)", "Aurore", "Avocat", "Azur", "Azur (héraldique)", "Azur brume", "Azur clair", "Azurin", "Baillet (chevaux vieilli)", "Banane", "Basané (teint)", "Beige", "Beige clair", "Beigeasse (péjoratif)", "Beurre", "Beurre frais", "Bis", "Bis (héraldique)", "Bisque", "Bistre", "Bitume (pigment)", "Blanc", "Blanc cassé", "Blanc d'argent (pigment) ou de plomb", "Blanc d'Espagne (pigment)", "Blanc de lait", "Blanc de Meudon ou de Troyes (pigment)", "Blanc de zinc (pigment)", "Blanc lunaire", "Blé", "Bleu acier", "Bleu barbeau ou bleuet", "Bleu canard", "Bleu céleste", "Bleu charrette", "Bleu ciel", "Bleu de cobalt (pigment)", "Bleu de minuit", "Bleu de Prusse (pigment), de Berlin ou bleu hussard", "Bleu des mers du sud", "Bleu dragée", "Bleu électrique", "Bleu fumée", "Bleu givré", "Bleu guède (pigment)", "Bleu Klein &tm;", "Bleu Majorelle", "Bleu nuit", "Bleu outremer", "Bleu paon", "Bleu Persan", "Bleu pétrole", "Bleu", "Bleu roi ou de France", "Bleu turquin", "Blond vénitien (cheveux)", "Blond (cheveux)", "Bordeaux", "Bourgogne", "Bouton d'or", "Brique", "Bronze", "Brou de noix", "Brun (cheveux)", "Brun clair (cheveux)", "Bureau", "Caca d'oie", "Cacao", "Cachou (pigments)", "Cæruléum", "Café", "Café au lait", "Cannelle", "Capucine", "Caramel (pigments)", "Carmin (pigment)", "Carotte", "Cerise", "Cerise Hollywood", "Cerise profonde", "Cerise rose", "Céruse (pigment)", "Chair", "Chamois", "Chartreuse", "Châtaigne", "Châtain (cheveux)", "Chaudron", "Chocolat", "Cinabre (pigment)", "Citron", "Citrouille", "Colombin (vieilli)", "Coquelicot", "Coquille d'œuf", "Corail", "Cramoisi", "Crème", "Cuisse de nymphe", "Cuisse de nymphe émue", "Cuivre", "Cyan", "Denim", "Ébène", "Écarlate", "Écru", "Émeraude", "Étain", "Fauve", "Feu", "Feuille morte", "Flave", "Fraise", "Fraise écrasée", "Framboise", "Framboise rose", "Fuchsia", "Garance (pigment)", "Glauque", "Glycine", "Grège", "Grenadine", "Grenat", "Gris", "Gris acier", "Gris de lin", "Gris de Payne (mélange de pigments)", "Gris fer", "Gris perle", "Groseille", "Gueules (héraldique)", "Héliotrope", "Incarnadin", "Incarnat", "Indigo chaud", "Indigo du web", "Indigo électrique", "Indigo (teinture)", "Isabelle (chevaux)", "Ivoire", "Jais", "Jaune de cobalt ou auréolin (pigment)", "Jaune bouton d’or", "Jaune canari", "Jaune chartreuse", "Jaune d'or", "Jaune de Mars (pigment)", "Jaune de Naples (pigment)", "Jaune impérial", "Jaune mimosa", "Kaki", "Lapis-lazuli", "Lavallière (reliure)", "Lavande", "Lie de vin", "Lilas", "Lin", "Magenta fuchsia (encre)", "Magenta", "Magenta foncé, primaire en synthèse soustractive", "Maïs", "Malachite", "Mandarine", "Marine", "Marron", "Mastic", "Mauve (couleur)", "Melon", "Menthe", "Menthe à l'eau", "Mordoré", "Moutarde", "Nacarat", "Nankin", "Neige", "Noir", "Noir animal (pigment)", "Noir d'aniline (pigment)", "Noir d'encre", "Noir d'ivoire (pigment)", "Noir de carbone (pigment)", "Noir de fumée (pigment)", "Noir de jais", "Noisette", "Ocre jaune (pigment)", "Ocre rouge (pigment)", "Olive", "Opale", "Or", "Orange", "Orange brûlé", "Orchidée", "Orpiment (pigment)", "Orpin de Perse", "Paille", "Parme", "Pastel (pigment)", "Pelure d'oignon (œnologie)", "Pervenche", "Pistache", "Poil de chameau", "Ponceau", "Pourpre (héraldique)", "Prasin", "Prune", "Puce", "Queue-de-renard", "Rose", "Rose bonbon", "Rose dragée", "Rose du web", "Rose Mountbatten", "Rose Persan vif", "Rose razzle dazzle", "Rose shocking &tm;", "Rose ultra", "Rose vif", "Rouge-orangé sRGB", "Rouge anglais (pigment)", "Rouge cardinal", "Rouge cerise", "Rouge d'alizarine (pigment)", "Rouge d'Andrinople (pigment)", "Rouge de Falun (pigment)", "Rouge feu", "Rouge sang", "Rouge tomette", "Rouge turc (pigment)", "Rouille", "Roux", "Rubis", "Sable", "Sable (héraldique)", "Safran", "Safre", "Sang de bœuf", "Sanguine", "Saphir", "Sarcelle", "Saumon", "Saumon rose", "Sépia (pigment)", "Sinople (héraldique)", "Smalt (pigment)", "Smaragdin (pigment)", "Soufre", "Souris", "Tabac", "Tangerine (couleur)", "Taupe", "Terre d'ombre (pigment)", "Terre de Sienne (pigment)", "Terre de Sienne brûlée (pigment)", "Tomate", "Topaze", "Tourterelle", "Turquoise", "Vanille", "Vermeil", "Vermillon", "Vert", "Vert anis", "Vert bouteille", "Vert céladon", "Vert chartreuse", "Vert d'eau", "Vert de chrome ou anglais (pigment)", "Vert-de-gris (pigment)", "Vert de Hooker (mélange de pigments)", "Vert de vessie (pigment)", "Vert épinard", "Vert gazon ou herbe", "Vert impérial", "Vert kaki", "Vert lichen", "Vert lime", "Vert mélèze", "Vert militaire", "Vert mousse", "Vert opaline", "Vert perroquet", "Vert pin", "Vert poireau", "Vert pomme", "Vert prairie", "Vert printemps", "Vert sapin", "Vert sauge", "Vert tilleul", "Vert Véronèse (pigment)", "Violet", "Violet d'évêque", "Violine", "Viride (pigment)", "Zinzolin", " " }));

        cmb_carb.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Essence", "Gasoil", "GPL" }));

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
                    .addComponent(txt_modele, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(txt_Catègorie)
                    .addComponent(txt_marque)
                    .addComponent(txt_imma, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(45, 45, 45)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 94, Short.MAX_VALUE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_lieuS, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
                    .addComponent(cmb_carb, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmb_couleur, javax.swing.GroupLayout.Alignment.TRAILING, 0, 173, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel10)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txt_imma, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(cmb_couleur))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_marque, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(cmb_carb, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txt_modele, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txt_lieuS, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_Catègorie, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
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

        javax.swing.GroupLayout PanelVisuaLayout = new javax.swing.GroupLayout(PanelVisua);
        PanelVisua.setLayout(PanelVisuaLayout);
        PanelVisuaLayout.setHorizontalGroup(
            PanelVisuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVisuaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(PanelVisuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        PanelVisuaLayout.setVerticalGroup(
            PanelVisuaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelVisuaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout DynamicListeVehiLayout = new javax.swing.GroupLayout(DynamicListeVehi);
        DynamicListeVehi.setLayout(DynamicListeVehiLayout);
        DynamicListeVehiLayout.setHorizontalGroup(
            DynamicListeVehiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
            .addGroup(DynamicListeVehiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DynamicListeVehiLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelVisua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        DynamicListeVehiLayout.setVerticalGroup(
            DynamicListeVehiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 328, Short.MAX_VALUE)
            .addGroup(DynamicListeVehiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(DynamicListeVehiLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(PanelVisua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnActualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(251, 251, 251)
                        .addComponent(lblResultVehi, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(DynamicListeVehi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnActualiser, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblResultVehi, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DynamicListeVehi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVisua, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnNouv, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnSupp, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                    .addComponent(btnImp, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
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

        jPanel9.setBackground(new java.awt.Color(244, 243, 243));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 202, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(157, 157, 157))
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/listeVoiture.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 3, 24)); // NOI18N
        jLabel2.setText("Liste des véhicules");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(281, 281, 281)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 211, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cmbMarqueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbMarqueActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbMarqueActionPerformed

    private void btnActualiserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualiserActionPerformed
        // TODO add your handling code here:
        actualiser();
    }//GEN-LAST:event_btnActualiserActionPerformed

    private void tableVehiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVehiMouseClicked
        // TODO add your handling code here:
        txt_imma.setText(String.valueOf(tableVehi.getValueAt(tableVehi.getSelectedRow(), 0)));
        txt_marque.setText(String.valueOf(tableVehi.getValueAt(tableVehi.getSelectedRow(), 1)));
        txt_modele.setText(String.valueOf(tableVehi.getValueAt(tableVehi.getSelectedRow(), 2)));
        txt_Catègorie.setText(String.valueOf(tableVehi.getValueAt(tableVehi.getSelectedRow(), 3)));
        cmb_couleur.setSelectedItem(String.valueOf(tableVehi.getValueAt(tableVehi.getSelectedRow(), 4)));
        cmb_carb.setSelectedItem(String.valueOf(tableVehi.getValueAt(tableVehi.getSelectedRow(), 5)));
        txt_lieuS.setText(String.valueOf(tableVehi.getValueAt(tableVehi.getSelectedRow(), 6)));
    }//GEN-LAST:event_tableVehiMouseClicked

    private void txt_lieuSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lieuSActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lieuSActionPerformed

    private void btn_ModifierActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ModifierActionPerformed
        // TODO add your handling code here:
        if(txt_imma.getText().equals("") || txt_marque.getText().equals("") || txt_modele.getText().equals("")
            || txt_Catègorie.getText().equals("") || txt_lieuS.getText().equals("")){

            JOptionPane.showMessageDialog(this, "SVP saisir les information complete");
        }else {
            String[] colo = {"immatricule", "Marque", "Modele", "Categorie", "Couleur", "Curburant", "Lieu_stationnement"};
            String[] info = {txt_imma.getText(), txt_marque.getText(), txt_modele.getText(), txt_Catègorie.getText(), cmb_couleur.getSelectedItem().toString(), cmb_carb.getSelectedItem().toString(), txt_lieuS.getText()};;
            String id = String.valueOf(tableVehi.getValueAt(tableVehi.getSelectedRow(), 0));
            System.out.println(db.queryUpdate("g_client_vehi", colo, info, "immatricule ='" + id + "'"));
            table();
        }
    }//GEN-LAST:event_btn_ModifierActionPerformed

    private void btnNouvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNouvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNouvActionPerformed

    private void btnVisuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVisuaActionPerformed
        PanelVisua.setVisible(true);
    }//GEN-LAST:event_btnVisuaActionPerformed

    private void btnSuppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuppActionPerformed
        // TODO add your handling code here:
       String id = String.valueOf(tableVehi.getValueAt(tableVehi.getSelectedRow(), 0));
        if(JOptionPane.showConfirmDialog(this,"est ce que tu es sure que tu veux supprimer",
            "attention !!!!!", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION){
        System.out.println(id);
        db.queryDelete("g_client_vehi", "immatricule= '" + id + "'");

        }else{
            return;
        }
        table();
    }//GEN-LAST:event_btnSuppActionPerformed

    private void cmbMarqueItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMarqueItemStateChanged
        // TODO add your handling code here:
        FiltreClientMarque();
    }//GEN-LAST:event_cmbMarqueItemStateChanged

    private void cmbModeleItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbModeleItemStateChanged
        // TODO add your handling code here:
        FiltreClientModele();
    }//GEN-LAST:event_cmbModeleItemStateChanged

    private void cmbCatItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCatItemStateChanged
        // TODO add your handling code here:
        FiltreClientCat();
    }//GEN-LAST:event_cmbCatItemStateChanged

    private void rbtn_toutStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbtn_toutStateChanged
        // TODO add your handling code here:
        //FiltreVehiCurb();
    }//GEN-LAST:event_rbtn_toutStateChanged

    private void rbtn_gplStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_rbtn_gplStateChanged
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rbtn_gplStateChanged

    private void rbtn_gplKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbtn_gplKeyPressed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rbtn_gplKeyPressed

    private void rbtn_toutKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rbtn_toutKeyPressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_rbtn_toutKeyPressed

    private void rbtn_gplActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_gplActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rbtn_gplActionPerformed

    private void rbtn_toutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtn_toutActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rbtn_toutActionPerformed

    private void rbtn_toutMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtn_toutMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rbtn_toutMouseClicked

    private void rbtn_gplMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtn_gplMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_rbtn_gplMouseClicked

    private void rbtn_toutMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtn_toutMousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_rbtn_toutMousePressed

    private void rbtn_gplMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbtn_gplMousePressed
        // TODO add your handling code here:
       
    }//GEN-LAST:event_rbtn_gplMousePressed

    private void rbtn_toutItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtn_toutItemStateChanged
        // TODO add your handling code here:
         
    }//GEN-LAST:event_rbtn_toutItemStateChanged

    private void rbtn_gplItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbtn_gplItemStateChanged
        // TODO add your handling code here:
         
    }//GEN-LAST:event_rbtn_gplItemStateChanged

    private void btn_ImprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ImprimerActionPerformed
            
         try{
            String imma = txt_imma.getText();
            String marque = txt_marque.getText();
            String modele = txt_modele.getText();            
            String categorie = txt_Catègorie.getText() ;
            String couleur = (String)(cmb_couleur.getSelectedItem());
            String carb = (String)(cmb_carb.getSelectedItem());
            String lieuS = txt_lieuS.getText() ;            
            
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
            page.getInstance(document,new FileOutputStream("UnVehiculeListe.pdf"));            
            
            document.open();
            // Ajouter une images
            Image image = Image.getInstance ("C:\\Users\\StongKa\\Documents\\NetBeansProjects\\AgenceLocationVoitures\\src\\PackMenuForm\\Icons\\itext\\vb.png");
            image.scaleToFit(100, 90);
            //image.scaleAbsolute(60,50);            
            document.add(image);             
            // Le titre de document
            title = new Paragraph("Informations sur le Vehicule", 
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
            
            p1.add(new Chunk("Immatriculation :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p1.add(new Chunk("                "+ imma , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p1.setAlignment(Element.ALIGN_LEFT);
            document.add(p1);
            document.add(new Paragraph("\n"));
            
            // Ajouter les colonnes au paragraphes
            p2.add(new Chunk("Marque :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p2.add(new Chunk("                              "+marque , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p2.setAlignment(Element.ALIGN_LEFT); 
            // Ajouter les paragraphes ( ou bien Les visualiser )
            document.add(p2);
            document.add(new Paragraph("\n"));
            
            p3.add(new Chunk("Modèle :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p3.add(new Chunk("                              "+ modele , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p3.setAlignment(Element.ALIGN_LEFT);
            document.add(p3);
            document.add(new Paragraph("\n"));
            
            p4.add(new Chunk("Catégorie :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p4.add(new Chunk("                          "+ categorie , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p4.setAlignment(Element.ALIGN_LEFT);
            document.add(p4);
            document.add(new Paragraph("\n"));
            
            p5.add(new Chunk("Couleur :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p5.add(new Chunk("                            "+ couleur , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p5.setAlignment(Element.ALIGN_LEFT);
            document.add(p5);
            document.add(new Paragraph("\n"));
            
            p6.add(new Chunk("Carburant :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p6.add(new Chunk("                        "+ carb , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p6.setAlignment(Element.ALIGN_LEFT);
            document.add(p6);
            document.add(new Paragraph("\n"));
                        
            p7.add(new Chunk("Lieu de Stationnement :", new Font(Font.FontFamily.TIMES_ROMAN, 14, Font.BOLDITALIC)));
            p7.add(new Chunk("     "+ lieuS , new Font(Font.FontFamily.HELVETICA, 13, Font.ITALIC)));
            p7.setAlignment(Element.ALIGN_LEFT);
            document.add(p7);
            document.add(new Paragraph("\n"));            
            
            // Fermeture de document
            document.close();
            // le chemin de fichier PDF
            String filePath = "C:\\Users\\StongKa\\Documents\\NetBeansProjects\\AgenceLocationVoitures\\UnVehiculeListe.pdf";
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
            
            JasperDesign REPORT=JRXmlLoader.load("C:\\Users\\StongKa\\Documents\\NetBeansProjects\\AgenceLocationVoitures\\src\\PackMenuForm\\MesPanel\\Reports\\ListeVehicules.jrxml");
            JasperReport JASP_REP=JasperCompileManager.compileReport(REPORT);
            
            JasperPrint JASP_PRINT=JasperFillManager.fillReport(JASP_REP,null,cnx);
            JasperViewer.viewReport(JASP_PRINT);
            //en format pdf
           JasperExportManager.exportReportToPdfFile(JASP_PRINT,"C:\\Users\\StongKa\\Documents\\NetBeansProjects\\AgenceLocationVoitures\\src\\PackMenuForm\\MesPanel\\Reports\\ListeVehicules.pdf");
        }catch(Exception e){
            System.out.println(e);
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnImpActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DynamicListeVehi;
    private javax.swing.ButtonGroup GroupBtn;
    private javax.swing.JPanel PanelVisua;
    private javax.swing.JButton btnActualiser;
    private javax.swing.JButton btnImp;
    private javax.swing.JButton btnNouv;
    private javax.swing.JButton btnSupp;
    private javax.swing.JButton btnVisua;
    private javax.swing.JButton btn_Imprimer;
    private javax.swing.JButton btn_Modifier;
    private javax.swing.JComboBox cmbCat;
    private javax.swing.JComboBox cmbMarque;
    private javax.swing.JComboBox cmbModele;
    private javax.swing.JComboBox cmb_carb;
    private javax.swing.JComboBox cmb_couleur;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblResultVehi;
    private javax.swing.JRadioButton rbtn_ess;
    private javax.swing.JRadioButton rbtn_gas;
    private javax.swing.JRadioButton rbtn_gpl;
    private javax.swing.JRadioButton rbtn_tout;
    private javax.swing.JTable tableVehi;
    private javax.swing.JTextField txt_Catègorie;
    private javax.swing.JTextField txt_imma;
    private javax.swing.JTextField txt_lieuS;
    private javax.swing.JTextField txt_marque;
    private javax.swing.JTextField txt_modele;
    // End of variables declaration//GEN-END:variables
}
