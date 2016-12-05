import apple.laf.JRSUIUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ramkrishnakulkarni on 30/11/16.
 */
public class Util {


    public double calculateAverage(List<Competitors> competitors ){
        double average=0.0;
        double sum=0.0;
        for(Competitors competitor:competitors){
            sum+=competitor.getCompetitorPrice();
        }
        average=sum/competitors.size();

        return average;
    }

    public boolean checkIfPriceInRange(double price,double average){
        double factor=average/2.0;

        if((price>(average+factor))||(price<(average-factor))){
            return  false;
        }
        return true;
    }

    public List<Competitors> getCompetitorsWhosePriceOutOfRange(List<Competitors> competitorsList){

        List<Competitors> outOfRangeCompetitors=new ArrayList<Competitors>();
        double average=calculateAverage(competitorsList);
        boolean inRange;
        for(Competitors competitor:competitorsList){
            inRange=checkIfPriceInRange(competitor.getCompetitorPrice(),average);

            if(!inRange) {
                outOfRangeCompetitors.add(competitor);
            }
        }

        return outOfRangeCompetitors;
    }

    public TreeMap<Double,Integer> getFrequencyCount(List<Competitors> competitorsWhosePriceInRange){
        TreeMap<Double,Integer> FrequencyOfPrice=new TreeMap<Double, Integer>();

        for(Competitors competitor:competitorsWhosePriceInRange){
            if(FrequencyOfPrice.containsKey(competitor.getCompetitorPrice())) {
                FrequencyOfPrice.put(competitor.getCompetitorPrice(),FrequencyOfPrice.get(competitor.getCompetitorPrice())+1);
            }
            else{
                FrequencyOfPrice.put(competitor.getCompetitorPrice(),1);
            }
        }

        return FrequencyOfPrice;
    }

    public Double getMostFrequentMinimumPriceFromCompetitors(Product product){

        TreeMap<Double,Integer> FrequencyOfPrices=getFrequencyCount(product.getCompetitorsList());

        int max=Integer.MIN_VALUE;
        Double mostFrequentMinPrice=null;
        for(Map.Entry<Double,Integer> entry : FrequencyOfPrices.entrySet()) {
            Double price = entry.getKey();
            Integer frequency = entry.getValue();

            if(frequency>max)
            {
                max=frequency;
                mostFrequentMinPrice=price;
            }
        }
        return mostFrequentMinPrice;
    }

    public Double calculateFinalPriceOfProduct(char supply,char demand,double chosenPrice){
        Double factor=0.0;

        if(supply=='L' && demand=='L'){
            factor=0.1*chosenPrice;
        }
        else if(supply=='L' && demand=='H'){
            factor=0.05*chosenPrice;
        }
        else if(supply=='H'&&demand=='L'){
            factor=-0.05*chosenPrice;
        }

        return (chosenPrice+factor);
    }
}
