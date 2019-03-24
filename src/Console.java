public class Console {

    public static void main(String[] args){

        Probability prob = new Probability("123ahe",2,"123aa1");
        float val = prob.Calculate(1000000);
        System.out.println("The probability of that roll is ".concat(Float.toString(val*100)).concat("%."));

    }

}
