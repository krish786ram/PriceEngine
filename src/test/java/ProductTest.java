import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramkrishnakulkarni on 01/12/16.
 */
public class ProductTest {

    private Product product;
    private Util util;

    @Before
    public void setup(){

        util=new Util();
        /*product=new Product("Laptops",'H','L');
        Competitors comp1 = new Competitors("apple",1.0);
        Competitors comp2 = new Competitors("sony",0.9);
        Competitors comp3 = new Competitors("lg",1.1);
        Competitors comp4 = new Competitors("HP",3.5);
        product.addCompetitorToList(comp1);
        product.addCompetitorToList(comp2);
        product.addCompetitorToList(comp3);
        product.addCompetitorToList(comp4);*/
    }

/*
   @Test
    public void returnTrueIfCompetitorsOutOfRangeAreRemoved(){
        product=new Product("Laptops",'H','L');
        Competitors comp1 = new Competitors("apple",1.0);
        Competitors comp2 = new Competitors("sony",0.9);
        Competitors comp3 = new Competitors("lg",1.1);
        Competitors comp4 = new Competitors("HP",3.5);
        Competitors comp5 = new Competitors("dell",0.1);
        product.addCompetitorToList(comp1);
        product.addCompetitorToList(comp2);
        product.addCompetitorToList(comp3);
        product.addCompetitorToList(comp4);
        product.addCompetitorToList(comp5);

        List<Competitors> outOfRangeCompetitors = util.getCompetitorsWhosePriceOutOfRange(product.getCompetitorsList());

        Assert.assertEquals(true,product.removeOutOgRangeCompetitors(outOfRangeCompetitors));
    }


    @Test
    public void returnFalseIfAllCompetitorsInRange(){
        product=new Product("Laptops",'H','L');
        Competitors comp1 = new Competitors("apple",1.0);
        Competitors comp2 = new Competitors("sony",0.9);
        Competitors comp3 = new Competitors("lg",1.1);
        Competitors comp4 = new Competitors("dell",0.9);
        Competitors comp5 = new Competitors("lenovo",1.1);
        product.addCompetitorToList(comp1);
        product.addCompetitorToList(comp2);
        product.addCompetitorToList(comp3);
        product.addCompetitorToList(comp4);
        product.addCompetitorToList(comp5);

        List<Competitors> outOfRangeCompetitors = util.getCompetitorsWhosePriceOutOfRange(product.getCompetitorsList());


        Assert.assertEquals(false,product.removeOutOgRangeCompetitors(outOfRangeCompetitors));
    }
*/
}
