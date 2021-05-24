import java.util.List;

public class LabExample { // 1, 3, -2,     2
    public static double sumOfPricesGreaterThan (List<Double> prices, Double value) { //1  //prima lista od double
        if (prices==null || prices.isEmpty()) //2 // proverka dali listata e prazna
            throw new RuntimeException("List of prices is not ok"); //3 // frlime exception
        double sum = 0; //4 // ako ne se frli exception se inicializir sumata
        for (int i=0;i<prices.size();i++) { //5 // iterirame za da sobirame suma na site prices
            if (prices.get(i)<0) //6 // proverka dali nekoj price e negativna
                throw new RuntimeException("Negative price is not allowed"); //7 // ke se frla exception
            if (prices.get(i)>value) //8 // ako sumata ne e negativna
                sum+=prices.get(i); //9 // soodvetnata suma ke se sobira
        } //10
        return sum; //11 // ke se vraka sumata
    } // 12
}
