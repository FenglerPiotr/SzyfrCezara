package pl.camp.it.szyfr.cezara;

public class Main {
    public static void main(String[] args) {
        String result = Cezar.encode("piotr", 5);
        System.out.println(result);

        String result2 = Cezar.decode("untyw", 5);
        System.out.println(result2);
    }




}
