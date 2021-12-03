package cn.bravedawn.java8.virtualextensionmethods;

public class FormulaTest {


    public static void main(String[] args) {
        Formula formula= new Formula() {
            @Override
            public double calculate(int a) {
                return sqrt(a * 100);
            }
        };


        double result = formula.calculate(100);
        double result2 = formula.sqrt(16);
        System.out.println(result);
        System.out.println(result2);
    }
}
