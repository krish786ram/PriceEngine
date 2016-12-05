import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ramkrishnakulkarni on 01/12/16.
 */
public class PriceEngine {

    private BufferedReader br;
    private PrintWriter pw;
    private ArrayList<Product> products;
    private Competitors competitors;
    private Util util;

    public void parseFile() throws IOException {

        br=new BufferedReader(new FileReader("/Users/ramkrishnakulkarni/hackercup/input1.txt"));
        pw=new PrintWriter("/Users/ramkrishnakulkarni/hackercup/output1.txt");

        addProducts();

        int totalCompetitors=Integer.parseInt(br.readLine());

        addCompetitors(totalCompetitors);

        int productNumber=0;

        for(Product product:products) {
                Double finalPrice=calculateFinalPriceOfProduct(product);
                writeToFile(productNumber++,finalPrice);
         }

        pw.flush();
        br.close();
    }

    public ArrayList<Product> addProducts() throws IOException {

        products=new ArrayList<Product>();

        int totalProducts=Integer.parseInt(br.readLine());
        for(int iteration=0;iteration<totalProducts;iteration++) {
            String line = br.readLine();
            String[] productDetails = line.split(" ");
            String productName = productDetails[0];
            char supply = productDetails[1].charAt(0);
            char demand = productDetails[2].charAt(0);

            products.add(new Product(productName, supply, demand));
        }
        return products;
    }


    public void addCompetitors(int totalCompetitors) throws IOException {
        for(int iteration=0;iteration<totalCompetitors;iteration++){
            String line=br.readLine();
            String competitorDetails[]=line.split(" ");

            String productName=competitorDetails[0];
            String competitorName=competitorDetails[1];
            double competitorPrice=Double.parseDouble(competitorDetails[2]);

            competitors=new Competitors(competitorName,competitorPrice);

            addCompetitorToAppropriateProduct(productName);

        }
    }

    public void addCompetitorToAppropriateProduct(String givenProductName){

        for(Product product:products){
            String nameOfProduct=product.getProductName();
            if(nameOfProduct.equals(givenProductName)){
                product.addCompetitorToList(competitors);
                return;
            }
        }

    }

    public Double calculateFinalPriceOfProduct(Product product){
        util=new Util();

        List<Competitors> outOfRangeCompetitors = util.getCompetitorsWhosePriceOutOfRange(product.getCompetitorsList());

        product.removeOutOgRangeCompetitors(outOfRangeCompetitors);

        Double mostFrequentPrice = util.getMostFrequentMinimumPriceFromCompetitors(product);

        Double finalPriceOfProduct = util.calculateFinalPriceOfProduct(product.getSupply(), product.getDemand(), mostFrequentPrice);

        return finalPriceOfProduct;
    }

    public void writeToFile(int productNumber,Double finalPrice){
        pw.println((char)('A'+productNumber)+" "+finalPrice);
    }
}
