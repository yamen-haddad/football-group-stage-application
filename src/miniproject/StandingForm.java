package miniproject;

import java.io.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.JFileChooser;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
/**
 *
 * @author MHD Yamen HADDAD
 */

public class StandingForm extends javax.swing.JFrame {

    /**
     * Creates new form StandingForm
     */
    public static Vector <Team> sortedTeams=new Vector<Team>();
    public static Vector <Team>unSortedTeams=new Vector<Team>();
    String [][]results=new String [20][20];
    class TableCellsTootip extends DefaultTableCellRenderer {
    String[] header = {"TEAM","Game Played","Points","Won","Draw","Lose","Goal For"
            ,"Goal Against","Goal Diffrence","HOME","AWAY"};
    public Component getTableCellRendererComponent(
                        JTable table, Object value,
                        boolean isSelected, boolean hasFocus,
                        int row, int column) {
        JLabel c = (JLabel)super.getTableCellRendererComponent(table, value, isSelected,
                hasFocus, row, column);
        c.setToolTipText(StandingForm.sortedTeams.get(row).getName() + " :" + header[column]);
        return c;
    }
}
    public StandingForm() {
        initComponents();
    }
    public StandingForm(Vector<Team> pteams,String [][]teamResults){
        initComponents();
        additionalButton.setToolTipText("to show additional statistics (direct matches, other goals piecharts etc)");
        exportButton.setToolTipText("to save all teams' results in a text file");
        exportTeamButton.setToolTipText("to save selected team results in a text file");
        teamComboBox.setToolTipText("select the Team you want to save its information on a text file");
        StandingTable.getTableHeader().setToolTipText(null);
        sortedTeams=new Vector<Team>();
        unSortedTeams=new Vector<Team>();
        StandingPanel.setVisible(true);
        results=new String[pteams.size()+1][pteams.size()+1];
        results=teamResults;
        for (Team team : pteams)
        {
            sortedTeams.add(team);
            unSortedTeams.add(team);
        }
        sortedTeams.sort(null);
        teamComboBox.removeAllItems();
        for(Team team:sortedTeams){
            String[] sArray=team.toString().split(",");
            String s=sArray[0];
            teamComboBox.addItem(s);
        }
            String[] header = {"Team","Gp","PTS","W","D","L","GF","GA","GD","Home","AWAY"};
            DefaultTableModel model = new DefaultTableModel(header,0);
            StandingTable.setModel(model);
            for (Team team : sortedTeams) {
                String rowData = team.toString();
                System.out.println(rowData);
                model.addRow(rowData.split(","));
            }
            StandingTable.setDefaultRenderer(model.getColumnClass(0), new TableCellsTootip());
        coloredTeamsPanel.setLayout(new GridLayout(1,1,0,0));
        StatisticJPanel sp=new StatisticJPanel(sortedTeams);
        sp.setVisible(true);
        coloredTeamsPanel.add(sp);
        this.repaint();
        revalidate();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     * Gp:Game Played
PTS:Points
W:Won
D:Draw
L:Loss
GF:Goal For
GA:Goal Against
GD:Goal Difference
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        StandingPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StandingTable = new javax.swing.JTable();
        exportButton = new javax.swing.JButton();
        teamComboBox = new javax.swing.JComboBox();
        exportTeamButton = new javax.swing.JButton();
        coloredTeamsPanel = new javax.swing.JPanel();
        additionalButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        StandingTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(StandingTable);

        javax.swing.GroupLayout StandingPanelLayout = new javax.swing.GroupLayout(StandingPanel);
        StandingPanel.setLayout(StandingPanelLayout);
        StandingPanelLayout.setHorizontalGroup(
            StandingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StandingPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 518, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 64, Short.MAX_VALUE))
        );
        StandingPanelLayout.setVerticalGroup(
            StandingPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StandingPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 11, Short.MAX_VALUE))
        );

        exportButton.setText("Export Results");
        exportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportButtonActionPerformed(evt);
            }
        });

        teamComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        exportTeamButton.setText("Export Team Result");
        exportTeamButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exportTeamButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout coloredTeamsPanelLayout = new javax.swing.GroupLayout(coloredTeamsPanel);
        coloredTeamsPanel.setLayout(coloredTeamsPanelLayout);
        coloredTeamsPanelLayout.setHorizontalGroup(
            coloredTeamsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        coloredTeamsPanelLayout.setVerticalGroup(
            coloredTeamsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );

        additionalButton.setText("Additional statistics");
        additionalButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                additionalButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(StandingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(19, 152, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(coloredTeamsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addComponent(teamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(42, 42, 42)
                                .addComponent(exportTeamButton)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(exportButton)
                                        .addGap(62, 62, 62))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(additionalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40))))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(StandingPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(coloredTeamsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(exportTeamButton)
                            .addComponent(teamComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(31, 31, 31)
                        .addComponent(exportButton)
                        .addGap(40, 40, 40)
                        .addComponent(additionalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void exportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportButtonActionPerformed
        // TODO add your handling code here:
        try
        {
        JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File siteFile=chooser.getSelectedFile();
        FileOutputStream fos=new FileOutputStream(siteFile,false);
        PrintStream pt=new PrintStream(fos);
        String header="Team,Gp,PTS,W,D,L,GF,GA,GD,Home,AWAY";
        pt.println(header);
        for (Team team : sortedTeams){
            pt.println(team);
        }
        }catch(Exception e){
            System.out.println("can not open the file");
        }
    }//GEN-LAST:event_exportButtonActionPerformed

    private void exportTeamButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exportTeamButtonActionPerformed
        // TODO add your handling code here:
        try
        {
        JFileChooser chooser=new JFileChooser();
        chooser.showOpenDialog(null);
        File siteFile=chooser.getSelectedFile();
        FileOutputStream fos=new FileOutputStream(siteFile,false);
        PrintStream pt=new PrintStream(fos);
        String header="Team,Gp,PTS,W,D,L,GF,GA,GD,Home,AWAY";
        pt.println(header);
        pt.println(sortedTeams.get(teamComboBox.getSelectedIndex()));
        }catch(Exception e){
            System.out.println("can not open the file");
        }
    }//GEN-LAST:event_exportTeamButtonActionPerformed

    AdditionalStatisticsFrame additionalFrame;
    private void additionalButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_additionalButtonActionPerformed
        // TODO add your handling code here:
        additionalFrame=new AdditionalStatisticsFrame(unSortedTeams,results);
        additionalFrame.setVisible(true);
    }//GEN-LAST:event_additionalButtonActionPerformed

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
            java.util.logging.Logger.getLogger(StandingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(StandingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(StandingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(StandingForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new StandingForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel StandingPanel;
    private javax.swing.JTable StandingTable;
    private javax.swing.JButton additionalButton;
    private javax.swing.JPanel coloredTeamsPanel;
    private javax.swing.JButton exportButton;
    private javax.swing.JButton exportTeamButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox teamComboBox;
    // End of variables declaration//GEN-END:variables
}