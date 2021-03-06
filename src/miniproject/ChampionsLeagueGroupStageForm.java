package miniproject;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.util.StringTokenizer;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class ChampionsLeagueGroupStageForm extends javax.swing.JFrame {

    /**
     * Creates new form ChampionsLeagueGroupStageForm
     */
    int numOfTeams=0;
    TextField [] TeamNamesTextFiledArray=new TextField[5];
    TextField [][] TeamsTableTextField=new TextField[10][10];
    Vector<Team> teams=new Vector<Team>(10,2);
    String [] teamsName;
    String [][]results=new String [20][20];
    StandingForm sf;
    public ChampionsLeagueGroupStageForm() {
        initComponents();
        TeamNamesLabelPanel.setVisible(false);
        TeamNamesPanel.setVisible(false);
        TeamsTablePanel.setVisible(false);
        ErrorPanel.setVisible(false);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
       private boolean addMatch(int home,int away,String result)
    {
        //first we have to validate that the format of the result is correct
        if(result.length()<3)
        {
            return false;
        }
        int dashCounter=0;
        for(int i=1;i<result.length()-1;i++)
        {
            if(result.charAt(i)=='-')
            {
                dashCounter++;
            }
        }
        if(dashCounter!=1)
            return false;
        StringTokenizer st=new StringTokenizer(result,"-");
        String [] Goals=new String [3];
        Goals[0]=st.nextToken();
        Goals[1]=st.nextToken();
        try
        {
            int homeGoals = Integer.parseInt(Goals[0]);
            int awayGoals = Integer.parseInt(Goals[1]);
            teams.get(home).goalFor += homeGoals;
            teams.get(away).goalFor += awayGoals;
            teams.get(home).goalAgainst += awayGoals;
            teams.get(away).goalAgainst += homeGoals;
            teams.get(home).gamePlayed ++;
            teams.get(away).gamePlayed ++;
            if(homeGoals==awayGoals)
            {
                teams.get(home).points++;
                teams.get(away).points++;
                teams.get(home).homeDraw++;
                teams.get(away).awayDraw++;
                teams.get(away).gameDraw++;
                teams.get(home).gameDraw++;
            }
            else if(homeGoals>awayGoals)
            {
                teams.get(home).points+=3;
                teams.get(home).homeWon++;
                teams.get(home).gameWon++;
                teams.get(away).awayLoss++;
                teams.get(away).gameLoss++;
            }
            else
            {
                teams.get(away).points+=3;
                teams.get(home).homeLoss++;
                teams.get(away).awayWon++;
                teams.get(away).gameWon++;
                teams.get(home).gameLoss++;
            }
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NumOfTeamsPanel = new javax.swing.JPanel();
        NumOfTeamsLabel = new javax.swing.JLabel();
        NumOfTeamsTextField = new javax.swing.JTextField();
        NumOfTeamsButton = new javax.swing.JButton();
        TeamNamesLabelPanel = new javax.swing.JPanel();
        TeamNamesLabel = new javax.swing.JLabel();
        TeamNamesPanel = new javax.swing.JPanel();
        CreateTableButton = new javax.swing.JButton();
        TeamsTablePanel = new javax.swing.JPanel();
        StandingsButton = new javax.swing.JButton();
        ErrorPanel = new javax.swing.JPanel();
        ErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NumOfTeamsLabel.setText("enter the number of teams");

        NumOfTeamsButton.setText("submit");
        NumOfTeamsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NumOfTeamsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout NumOfTeamsPanelLayout = new javax.swing.GroupLayout(NumOfTeamsPanel);
        NumOfTeamsPanel.setLayout(NumOfTeamsPanelLayout);
        NumOfTeamsPanelLayout.setHorizontalGroup(
            NumOfTeamsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NumOfTeamsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NumOfTeamsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NumOfTeamsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(NumOfTeamsButton)
                .addContainerGap(16, Short.MAX_VALUE))
        );
        NumOfTeamsPanelLayout.setVerticalGroup(
            NumOfTeamsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(NumOfTeamsPanelLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(NumOfTeamsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NumOfTeamsLabel)
                    .addComponent(NumOfTeamsTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NumOfTeamsButton))
                .addContainerGap(28, Short.MAX_VALUE))
        );

        TeamNamesLabel.setText("enter the name of the teams:");

        javax.swing.GroupLayout TeamNamesLabelPanelLayout = new javax.swing.GroupLayout(TeamNamesLabelPanel);
        TeamNamesLabelPanel.setLayout(TeamNamesLabelPanelLayout);
        TeamNamesLabelPanelLayout.setHorizontalGroup(
            TeamNamesLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeamNamesLabelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TeamNamesLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(136, Short.MAX_VALUE))
        );
        TeamNamesLabelPanelLayout.setVerticalGroup(
            TeamNamesLabelPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeamNamesLabelPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(TeamNamesLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        CreateTableButton.setText("create table");
        CreateTableButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateTableButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TeamNamesPanelLayout = new javax.swing.GroupLayout(TeamNamesPanel);
        TeamNamesPanel.setLayout(TeamNamesPanelLayout);
        TeamNamesPanelLayout.setHorizontalGroup(
            TeamNamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeamNamesPanelLayout.createSequentialGroup()
                .addContainerGap(284, Short.MAX_VALUE)
                .addComponent(CreateTableButton)
                .addGap(29, 29, 29))
        );
        TeamNamesPanelLayout.setVerticalGroup(
            TeamNamesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeamNamesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CreateTableButton)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        StandingsButton.setText("Standings");
        StandingsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                StandingsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout TeamsTablePanelLayout = new javax.swing.GroupLayout(TeamsTablePanel);
        TeamsTablePanel.setLayout(TeamsTablePanelLayout);
        TeamsTablePanelLayout.setHorizontalGroup(
            TeamsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TeamsTablePanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(StandingsButton)
                .addContainerGap(506, Short.MAX_VALUE))
        );
        TeamsTablePanelLayout.setVerticalGroup(
            TeamsTablePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, TeamsTablePanelLayout.createSequentialGroup()
                .addContainerGap(162, Short.MAX_VALUE)
                .addComponent(StandingsButton)
                .addContainerGap())
        );

        ErrorLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout ErrorPanelLayout = new javax.swing.GroupLayout(ErrorPanel);
        ErrorPanel.setLayout(ErrorPanelLayout);
        ErrorPanelLayout.setHorizontalGroup(
            ErrorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(ErrorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                .addContainerGap())
        );
        ErrorPanelLayout.setVerticalGroup(
            ErrorPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ErrorPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(ErrorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TeamNamesLabelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(TeamNamesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NumOfTeamsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ErrorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(TeamsTablePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 89, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NumOfTeamsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TeamNamesLabelPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(ErrorPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(TeamNamesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(TeamsTablePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void NumOfTeamsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NumOfTeamsButtonActionPerformed
        // TODO add your handling code here:
        TeamNamesPanel.setVisible(false);
        TeamNamesLabelPanel.setVisible(false);
        ErrorPanel.setVisible(false);
        TeamsTablePanel.setVisible(false);
        String num=NumOfTeamsTextField.getText();
        try
        {
            numOfTeams=Integer.parseInt(num);
            TeamNamesPanel.removeAll();
            if(numOfTeams<2)
                throw new Exception("error in number of teams please reenter");
            TeamNamesLabelPanel.setVisible(true);
            TeamNamesPanel.setVisible(true);
            TeamNamesPanel.setLayout(new GridLayout(0,numOfTeams));
            TeamNamesTextFiledArray=new TextField [numOfTeams];
            teamsName=new String[numOfTeams];
            results=new String[numOfTeams+1][numOfTeams+1];
            for(int i=0;i<numOfTeams;i++)
            {
                TeamNamesTextFiledArray[i]=new TextField("");
                TeamNamesPanel.add(TeamNamesTextFiledArray[i]);
            }
            TeamNamesPanel.add(CreateTableButton);
        }
        catch(NumberFormatException e )
        {
            String message="The number format is not correct";
            ErrorPanel.setVisible(true);
            ErrorLabel.setForeground(Color.red);
            ErrorLabel.setText(message);
        }
        catch(Exception ex){
            String message=ex.getMessage();
            ErrorPanel.setVisible(true);
            ErrorLabel.setForeground(Color.red);
            ErrorLabel.setText(message);
        }
    }//GEN-LAST:event_NumOfTeamsButtonActionPerformed

    private void CreateTableButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateTableButtonActionPerformed
        // TODO add your handling code here:
        TeamsTablePanel.removeAll();
        TeamsTablePanel.setVisible(false);
        for(int i=0;i<numOfTeams;i++)
        {
            teams.add(new Team());
            teamsName[i]=TeamNamesTextFiledArray[i].getText();
        }
        TeamsTablePanel.setLayout(new GridLayout(0,numOfTeams+1));
        for(int i=0;i<numOfTeams+1;i++)
        {
            for(int j=0;j<numOfTeams+1;j++)
            {
                results[i][j]="";
                if(i==0 && j==0)
                {
                    TeamsTablePanel.add(new Label("   "));
                }
                else if(i==0)
                {
                    TeamsTablePanel.add(new Label(teamsName[j-1]));
                }
                else if(j==0)
                {
                    TeamsTablePanel.add(new Label(teamsName[i-1]));
                }
                else if(i==j)
                {
                    TeamsTableTextField[i][j]=new TextField("---");
                    TeamsTablePanel.add(TeamsTableTextField[i][j]);
                }
                else
                {
                    TeamsTableTextField[i][j]=new TextField("");
                    TeamsTablePanel.add(TeamsTableTextField[i][j]);
                }
            }
        }
        TeamsTablePanel.add(StandingsButton);
        TeamsTablePanel.revalidate();
        TeamsTablePanel.setVisible(true);
    }//GEN-LAST:event_CreateTableButtonActionPerformed

    private void StandingsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_StandingsButtonActionPerformed
        // TODO add your handling code here:
        boolean success=true;
        int i=0,j=0;
        teams=new Vector<Team> ();
        for(int l=0;l<numOfTeams;l++)
        {
            teams.add(new Team());
            teams.get(l).setName(teamsName[l]);
        }
        for( i=0;i<numOfTeams;i++)
        {
            for( j=0;j<numOfTeams;j++)
            {
                if(i!=j && !TeamsTableTextField[i+1][j+1].getText().isEmpty())
                {
                    if(!addMatch(i,j,TeamsTableTextField[i+1][j+1].getText()))
                    {
                        success=false;
                        break;
                    }
                    else
                    {
                        results[i][j]=TeamsTableTextField[i+1][j+1].getText();
                        TeamsTableTextField[i+1][j+1].setBackground(Color.white);
                    }
                }
            }
            if(!success)
            break;
        }
        if(success)
        {
            String message="Done see the current standings";
            sf=new StandingForm(teams,results);
            sf.setVisible(true);
            ErrorPanel.setVisible(true);
            ErrorLabel.setForeground(Color.green);
            ErrorLabel.setText(message);
        }
        else
        {
            TeamsTableTextField[i+1][j+1].setBackground(Color.red);
            String message="Error in score format in "+teams.get(i).getName()+" Vs "+ teams.get(j).getName();
            ErrorPanel.setVisible(true);
            ErrorLabel.setForeground(Color.red);
            ErrorLabel.setText(message);
        }
    }//GEN-LAST:event_StandingsButtonActionPerformed

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
            java.util.logging.Logger.getLogger(ChampionsLeagueGroupStageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ChampionsLeagueGroupStageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ChampionsLeagueGroupStageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ChampionsLeagueGroupStageForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ChampionsLeagueGroupStageForm().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateTableButton;
    private javax.swing.JLabel ErrorLabel;
    private javax.swing.JPanel ErrorPanel;
    private javax.swing.JButton NumOfTeamsButton;
    private javax.swing.JLabel NumOfTeamsLabel;
    private javax.swing.JPanel NumOfTeamsPanel;
    private javax.swing.JTextField NumOfTeamsTextField;
    private javax.swing.JButton StandingsButton;
    private javax.swing.JLabel TeamNamesLabel;
    private javax.swing.JPanel TeamNamesLabelPanel;
    private javax.swing.JPanel TeamNamesPanel;
    private javax.swing.JPanel TeamsTablePanel;
    // End of variables declaration//GEN-END:variables
}