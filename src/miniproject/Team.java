package miniproject;

/**
 *
 * @author User
 */
public class Team implements Comparable<Team>
{
    private String TeamName;
    public int gamePlayed;
    public int points;
    public int gameWon;
    public int gameDraw;
    public int gameLoss;
    public int goalFor;
    public int goalAgainst;
    public int homeWon;
    public int homeLoss;
    public int homeDraw;
    public int awayWon;
    public int awayLoss;
    public int awayDraw;
    public Team()  //default constructor sets all fields to zero
    {
        this.awayDraw=0;this.awayLoss=0;this.awayWon=0;this.gameDraw=0;this.gameLoss=0;
        this.gamePlayed=0;this.gameWon=0;this.goalFor=0;this.goalAgainst=0;this.homeDraw=0;
        this.homeLoss=0;this.homeWon=0;this.points=0;
    }
    public Team(String s)
    {
        String [] sa=s.split(",");
        TeamName=sa[0]; 
        this.awayDraw=0;this.awayLoss=0;this.awayWon=0;this.gameDraw=Integer.parseInt(sa[4]);this.gameLoss=Integer.parseInt(sa[5]);
        this.gamePlayed=Integer.parseInt(sa[1]);this.gameWon=Integer.parseInt(sa[3]);this.goalFor=Integer.parseInt(sa[6]);this.goalAgainst=Integer.parseInt(sa[7]);this.homeDraw=0;
        this.homeLoss=0;this.homeWon=0;this.points=Integer.parseInt(sa[2]);
    }
    public String getName()
    {
        return this.TeamName;
    }
    public void setName(String s)
    {
        this.TeamName=s;
    }
    @Override
    public String toString()
    {
        int goalDef=this.goalFor-this.goalAgainst;
        String home=""+this.homeWon+"-"+this.homeDraw+"-"+this.homeLoss;
        String away=""+this.awayWon+"-"+this.awayDraw+"-"+this.awayLoss;
        String s="";
        s=TeamName+","+this.gamePlayed+","+this.points+","+this.gameWon+","+this.gameDraw+","+this.gameLoss+","+this.goalFor+","+this.goalAgainst+","+goalDef+","+home+","+away;
        return s;
    }
    @Override
    public int compareTo(Team a)
    {
        if(this.points<a.points)
        {
            return 1;
        }
        else if(this.points==a.points)
        {
            if(this.goalFor-this.goalAgainst<a.goalFor-a.goalAgainst)
            {
                return 1;
            }
            else if(this.goalFor-this.goalAgainst==a.goalFor-a.goalAgainst)
            {
                if(this.goalFor<a.goalFor)
                {
                    return 1;
                }
                else if(this.goalFor==a.goalFor)
                {
                    return 0;
                }
            }
        }
        return -1;
    }
}
