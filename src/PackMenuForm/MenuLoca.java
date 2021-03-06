/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackMenuForm;

import PackMenuForm.MesPanel.AjouterClient;
import PackMenuForm.MesPanel.AjouterLoca;
import PackMenuForm.MesPanel.ListeClient;
import PackMenuForm.MesPanel.ListeLoca;
import PackMenuForm.MesPanel.RecettLoca;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 *
 * @author StongKa
 */
public class MenuLoca extends javax.swing.JInternalFrame {

    GridBagLayout layout = new GridBagLayout();
    AjouterLoca al;
    ListeLoca ll;
    RecettLoca rl;
    GridBagConstraints c;

    private void DynamicPanel(){
        DynamicGLoca.setLayout(layout);
        al = new AjouterLoca();
        ll = new ListeLoca();
        rl = new RecettLoca();
        c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        DynamicGLoca.add(al,c);
        DynamicGLoca.add(ll,c);
        DynamicGLoca.add(rl,c);
        al.setVisible(true);
        ll.setVisible(false);
        rl.setVisible(false);
    }
    public MenuLoca() {
        initComponents();
        DynamicPanel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelContentLoca = new javax.swing.JPanel();
        PanelBoutonLoca = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAjouterLoca = new javax.swing.JButton();
        btnListeLoca = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnListeLoca1 = new javax.swing.JButton();
        DynamicGLoca = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setPreferredSize(new java.awt.Dimension(1300, 800));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        PanelBoutonLoca.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Locations <<");
        jLabel1.setOpaque(true);

        btnAjouterLoca.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnAjouterLoca.setText("Nouvelle location");
        btnAjouterLoca.setContentAreaFilled(false);
        btnAjouterLoca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjouterLoca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterLocaActionPerformed(evt);
            }
        });

        btnListeLoca.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnListeLoca.setText("Liste des locations");
        btnListeLoca.setContentAreaFilled(false);
        btnListeLoca.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListeLoca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListeLocaActionPerformed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/ListeClient.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/AjouterClient.png"))); // NOI18N

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/ClientPNG.png"))); // NOI18N

        btnListeLoca1.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnListeLoca1.setText("Recettes locations");
        btnListeLoca1.setContentAreaFilled(false);
        btnListeLoca1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListeLoca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListeLoca1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelBoutonLocaLayout = new javax.swing.GroupLayout(PanelBoutonLoca);
        PanelBoutonLoca.setLayout(PanelBoutonLocaLayout);
        PanelBoutonLocaLayout.setHorizontalGroup(
            PanelBoutonLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelBoutonLocaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PanelBoutonLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelBoutonLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, PanelBoutonLocaLayout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnListeLoca, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))
                        .addGroup(PanelBoutonLocaLayout.createSequentialGroup()
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(btnAjouterLoca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(btnListeLoca1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        PanelBoutonLocaLayout.setVerticalGroup(
            PanelBoutonLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBoutonLocaLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(PanelBoutonLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnAjouterLoca, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(66, 66, 66)
                .addGroup(PanelBoutonLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListeLoca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(61, 61, 61)
                .addComponent(btnListeLoca1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(150, 150, 150)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        DynamicGLoca.setBackground(new java.awt.Color(51, 51, 255));
        DynamicGLoca.setMinimumSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout DynamicGLocaLayout = new javax.swing.GroupLayout(DynamicGLoca);
        DynamicGLoca.setLayout(DynamicGLocaLayout);
        DynamicGLocaLayout.setHorizontalGroup(
            DynamicGLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1026, Short.MAX_VALUE)
        );
        DynamicGLocaLayout.setVerticalGroup(
            DynamicGLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 748, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelContentLocaLayout = new javax.swing.GroupLayout(PanelContentLoca);
        PanelContentLoca.setLayout(PanelContentLocaLayout);
        PanelContentLocaLayout.setHorizontalGroup(
            PanelContentLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContentLocaLayout.createSequentialGroup()
                .addComponent(PanelBoutonLoca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DynamicGLoca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelContentLocaLayout.setVerticalGroup(
            PanelContentLocaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBoutonLoca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelContentLocaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DynamicGLoca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContentLoca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContentLoca, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAjouterLocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterLocaActionPerformed
        // TODO add your handling code here:
        al.setVisible(true);
        ll.setVisible(false);
        rl.setVisible(false);
    }//GEN-LAST:event_btnAjouterLocaActionPerformed

    private void btnListeLocaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeLocaActionPerformed
        // TODO add your handling code here:
        al.setVisible(false);
        ll.setVisible(true);
        rl.setVisible(false);
    }//GEN-LAST:event_btnListeLocaActionPerformed

    private void btnListeLoca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeLoca1ActionPerformed
        // TODO add your handling code here:
        al.setVisible(false);
        ll.setVisible(false);
        rl.setVisible(true);
    }//GEN-LAST:event_btnListeLoca1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DynamicGLoca;
    private javax.swing.JPanel PanelBoutonLoca;
    private javax.swing.JPanel PanelContentLoca;
    private javax.swing.JButton btnAjouterLoca;
    private javax.swing.JButton btnListeLoca;
    private javax.swing.JButton btnListeLoca1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
