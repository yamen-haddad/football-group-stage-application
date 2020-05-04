package miniproject;

import java.awt.Color;
import java.awt.Graphics;
import java.util.StringTokenizer;
import javax.swing.JFrame;
/*
 * @author MHD Yamen HADDAD
 */
public class DirectMatchJPanel extends javax.swing.JPanel {
    String match1="",match2="";
    String team1="",team2="";
    int team1win=0,team1draw=0,team1loss=0,team1Goals=0,totalGoals=0,thickness=30; //from team1 we can calculate the information for team2
    int totalGamePlayed=2;
    public DirectMatchJPanel() {
        initComponents();
    }
    private void calculateMatch(String match,boolean home) //this function will get a string and edit the information of teams
    {
        if(match.equals(""))
        {
            totalGamePlayed--;
            return;
        }
        StringTokenizer st=new StringTokenizer(match,"-");
        String [] Goals=new String [3];
        Goals[0]=st.nextToken();
        Goals[1]=st.nextToken();
        int homeGoals=Integer.parseInt(Goals[0]),awayGoals=Integer.parseInt(Goals[1]); //we guarantee it will not throw an exception
        totalGoals+=homeGoals; totalGoals+=awayGoals;
        if(home)
        {
            team1Goals+=homeGoals;

            if(homeGoals==awayGoals)
                team1draw++;
            else if(homeGoals>awayGoals)
                team1win++;
            else
               team1loss++;
            return;
        }
        //else (it is an away match)
        team1Goals+=awayGoals;
        if(homeGoals==awayGoals)
             team1draw++;
        else if(homeGoals>awayGoals)
             team1loss++;
        else
             team1win++;
    }
    public DirectMatchJPanel(String team1,String team2,String m1,String m2) {
        initComponents();
        match1=m1;
        match2=m2;
        this.team1=team1; this.team2=team2;
        team1win=0;team1draw=0;team1loss=0;team1Goals=0;totalGoals=0;totalGamePlayed=2;
        calculateMatch(match1,true);//it is home match
        calculateMatch(match2,false);//it is away match
    }
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawString(team1+" Vs "+team2, 200, 10);
        g.drawString("total Goals :"+totalGoals, 100, 30);
        g.drawString("total Game Played= "+(team1win+team1draw+team1loss), 250, 30);
        g.drawString(team1, 50, 30);
        g.drawString(team2, 440, 30);
        g.setColor(Color.red);
        g.fillRect(10, 10, thickness, thickness);
        g.fillRect(10, 85, 15, 15);
        g.setColor(Color.blue);
        g.fillRect(400, 10, thickness, thickness);
        g.fillRect(400, 85, 15, 15);
        g.setColor(Color.red);
        g.fillRect(70, 50, team1win*150, 30);
        g.setColor(Color.green);
        g.fillRect(70+team1win*150, 50, team1draw*150, 30);
        g.fillRect(200, 85, 15, 15);
        g.setColor(Color.blue);
        g.fillRect(370-(team1loss*150), 50, team1loss*150, 30);
        g.setColor(Color.black);
        g.drawString("draw= "+team1draw, 220, 95);
        g.drawString(team1+":won= "+team1win, 30, 95);
        g.drawString(team2+":won= "+(totalGamePlayed-team1win-team1draw), 420, 95);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 500, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}
