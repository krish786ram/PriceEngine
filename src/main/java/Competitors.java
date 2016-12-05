/**
 * Created by ramkrishnakulkarni on 30/11/16.
 */
public class Competitors {
    private String CompetitorName;
    private double competitorPrice;

    Competitors(String competitorName,double competitorPrice){
        this.CompetitorName=competitorName;
        this.competitorPrice=competitorPrice;
    }

    public String getCompetitorName() {
        return CompetitorName;
    }

    public double getCompetitorPrice() {
        return competitorPrice;
    }
}
