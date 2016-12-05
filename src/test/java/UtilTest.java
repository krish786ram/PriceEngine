import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by ramkrishnakulkarni on 01/12/16.
 */
public class UtilTest {
    private Util util;
    private Product product;
    private List<Competitors> outOfRangeCompetitors;

    @Before
    public void setup(){
        util = new Util();
        product=new Product("laptops",'H','H');

        Competitors comp1 = new Competitors("apple",1.0);
        Competitors comp2 = new Competitors("sony",0.9);
        Competitors comp3 = new Competitors("lg",1.1);
        Competitors comp4 = new Competitors("dell",0.9);
        Competitors comp5 = new Competitors("lenovo",1.1);
        Competitors comp6 = new Competitors("asus",1.0);

        product.addCompetitorToList(comp1);
        product.addCompetitorToList(comp2);
        product.addCompetitorToList(comp3);
        product.addCompetitorToList(comp4);
        product.addCompetitorToList(comp5);
        product.addCompetitorToList(comp6);

        outOfRangeCompetitors = new ArrayList<Competitors>();

        outOfRangeCompetitors.add(comp4);
        outOfRangeCompetitors.add(comp5);

    }


    @Test
    public void shouldCalculateCorrectAverage() {
        Assert.assertEquals(1.0,util.calculateAverage(product.getCompetitorsList()),0.0);

    }

    @Test
    public void returnFalseIfOutOfRange(){
        Assert.assertEquals(false,util.checkIfPriceInRange(2,1));
    }

    @Test
    public void ReturnListOfCompetitorWhosePriceIsOutOfRange(){

            Competitors comp7 = new Competitors("acer",3.5);
            Competitors comp8 = new Competitors("toshiba",0.1);

            product.addCompetitorToList(comp7);
            product.addCompetitorToList(comp8);

            outOfRangeCompetitors = new ArrayList<Competitors>();

            outOfRangeCompetitors.add(comp7);
            outOfRangeCompetitors.add(comp8);

            Assert.assertEquals(outOfRangeCompetitors,util.getCompetitorsWhosePriceOutOfRange(product.getCompetitorsList()));
    }

    @Test
    public void checkFrequencyOfCompetitorPrices(){
        TreeMap<Double,Integer> FrequencyOfPrices=new TreeMap<Double, Integer>();

        FrequencyOfPrices.put(1.0,2);
        FrequencyOfPrices.put(0.9,2);
        FrequencyOfPrices.put(1.1,2);

        Assert.assertEquals(FrequencyOfPrices,util.getFrequencyCount(product.getCompetitorsList()));
    }

       @Test
    public void returnMaximumFrequencyPriceFromCompetitors(){
        Assert.assertEquals(0.9,util.getMostFrequentMinimumPriceFromCompetitors(product),0.0);
    }

    @Test
    public void shouldReturnMostFrequentMinimumPriceOfProduct(){

        Assert.assertEquals(0.9,util.getMostFrequentMinimumPriceFromCompetitors(product),0.0);

    }

    @Test
    public void shouldReturnFinalPriceOfProduct(){

        Assert.assertEquals(10.5,util.calculateFinalPriceOfProduct('L','H',10.0),0.0);
    }
}
