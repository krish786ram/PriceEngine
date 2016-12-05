import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ramkrishnakulkarni on 30/11/16.
 */
public class Product {

    private String productName;
    private char demand;
    private char supply;
    private List<Competitors> competitorsList;
    private Util util;

    public Product(String productName,char supply,char demand){
        this.productName=productName;
        this.supply=supply;
        this.demand=demand;
        competitorsList=new ArrayList<Competitors>();
        util=new Util();
    }

    public String getProductName() {
        return productName;
    }

    public char getDemand() {
        return demand;
    }

    public char getSupply() {
        return supply;
    }

    public List<Competitors> getCompetitorsList() {
        return competitorsList;
    }

    public void addCompetitorToList(Competitors competitor){
        competitorsList.add(competitor);
    }

    public void removeOutOgRangeCompetitors(List<Competitors> outOfRangeCompetitorsList){
        for(Competitors outOfRangeCompetitor:outOfRangeCompetitorsList){
            competitorsList.remove(outOfRangeCompetitor);
        }
    }

}
