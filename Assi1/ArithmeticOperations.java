import java.util.Scanner;
public class ArithmeticOperations
{
    public double n1, n2;
    public double addNums(double n1, double n2)
    {
        return n1 + n2;
    }
    public double subtractNums(double n1, double n2)
    {
        return n1 - n2;
    }
    public double multiplyNums(double n1, double n2)
    {
        return n1 * n2;
    }
    public double divideNums(double n1, double n2)
    {
        return n1 / n2;
    }
    public double modulusNums(double n1, double n2)
    {
        return n1 % n2;
    }
    public static void main(String[] args) 
    {
        ArithmeticOperations op = new ArithmeticOperations();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number:");
        op.n1 = sc.nextDouble();
        System.out.println("Enter the second number:");
        op.n2 = sc.nextDouble();
        double sum = op.addNums(op.n1, op.n2);
        double diff = op.subtractNums(op.n1, op.n2);
        double prod = op.multiplyNums(op.n1, op.n2);
        double div = op.divideNums(op.n1, op.n2);
        double remainder = op.modulusNums(op.n1, op.n2);
        System.out.println("Sum:" + sum + " " + "Difference:" + diff + " " + "Multiply:" + prod + " " + "Divide:" + div + " " + "Modulus:" + remainder + " ");
               
    }
}