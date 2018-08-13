/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PackMenuForm;

import PackMenuForm.MesPanel.AjouterClient;
import PackMenuForm.MesPanel.ListeClient;
import java.awt.Desktop;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

/**
 *
 * @author StongKa
 */
public class MenuClient extends javax.swing.JInternalFrame {
    GridBagLayout layout = new GridBagLayout();
    AjouterClient ac;
    ListeClient lc;
    GridBagConstraints c;

    
    
    private void DynamicPanel(){
        DynamicGClient.setLayout(layout);
        ac = new AjouterClient();
        lc = new ListeClient();
        c = new GridBagConstraints();
        c.gridx=0;
        c.gridy=0;
        DynamicGClient.add(ac,c);
        DynamicGClient.add(lc,c);
        ac.setVisible(true);
        lc.setVisible(false);    
    }
    public MenuClient() {
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

        PanelContentClient = new javax.swing.JPanel();
        PanelBoutonClient = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnAjouterClient = new javax.swing.JButton();
        btnListeClient = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        DynamicGClient = new javax.swing.JPanel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        setPreferredSize(new java.awt.Dimension(1300, 800));
        try {
            setSelected(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }
        setVisible(true);

        PanelContentClient.setBackground(new java.awt.Color(244, 243, 243));

        PanelBoutonClient.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(204, 204, 204));
        jLabel1.setFont(new java.awt.Font("Algerian", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Gestion des client <<");
        jLabel1.setOpaque(true);

        btnAjouterClient.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnAjouterClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/AjouterClient.png"))); // NOI18N
        btnAjouterClient.setText("Ajouter client");
        btnAjouterClient.setContentAreaFilled(false);
        btnAjouterClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAjouterClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjouterClientActionPerformed(evt);
            }
        });

        btnListeClient.setFont(new java.awt.Font("Cambria", 1, 14)); // NOI18N
        btnListeClient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/ListeClient.png"))); // NOI18N
        btnListeClient.setText("Liste des clients");
        btnListeClient.setContentAreaFilled(false);
        btnListeClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnListeClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListeClientActionPerformed(evt);
            }
        });

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/PackMenuForm/Icons/Clients.png"))); // NOI18N

        javax.swing.GroupLayout PanelBoutonClientLayout = new javax.swing.GroupLayout(PanelBoutonClient);
        PanelBoutonClient.setLayout(PanelBoutonClientLayout);
        PanelBoutonClientLayout.setHorizontalGroup(
            PanelBoutonClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelBoutonClientLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelBoutonClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnAjouterClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnListeClient, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PanelBoutonClientLayout.setVerticalGroup(
            PanelBoutonClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelBoutonClientLayout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(btnAjouterClient, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(66, 66, 66)
                .addComponent(btnListeClient)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 216, Short.MAX_VALUE)
                .addComponent(jLabel4))
        );

        DynamicGClient.setBackground(new java.awt.Color(244, 243, 243));
        DynamicGClient.setMinimumSize(new java.awt.Dimension(100, 100));

        javax.swing.GroupLayout DynamicGClientLayout = new javax.swing.GroupLayout(DynamicGClient);
        DynamicGClient.setLayout(DynamicGClientLayout);
        DynamicGClientLayout.setHorizontalGroup(
            DynamicGClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1012, Short.MAX_VALUE)
        );
        DynamicGClientLayout.setVerticalGroup(
            DynamicGClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout PanelContentClientLayout = new javax.swing.GroupLayout(PanelContentClient);
        PanelContentClient.setLayout(PanelContentClientLayout);
        PanelContentClientLayout.setHorizontalGroup(
            PanelContentClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelContentClientLayout.createSequentialGroup()
                .addComponent(PanelBoutonClient, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DynamicGClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        PanelContentClientLayout.setVerticalGroup(
            PanelContentClientLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelBoutonClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(PanelContentClientLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(DynamicGClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContentClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelContentClient, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAjouterClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjouterClientActionPerformed
        // TODO add your handling code here:
        ac.setVisible(true);
        lc.setVisible(false);
    }//GEN-LAST:event_btnAjouterClientActionPerformed

    private void btnListeClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListeClientActionPerformed
        // TODO add your handling code here:
        ac.setVisible(false);
        lc.setVisible(true);
    }//GEN-LAST:event_btnListeClientActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel DynamicGClient;
    private javax.swing.JPanel PanelBoutonClient;
    private javax.swing.JPanel PanelContentClient;
    private javax.swing.JButton btnAjouterClient;
    private javax.swing.JButton btnListeClient;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables
}
