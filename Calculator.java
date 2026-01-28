import java.util.Scanner;

public class Calculator
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        ArithmeticOperations op = new ArithmeticOperations();
        int ch;

        while (true)
        {
            System.out.println("\nSelect one of the operations:");
            System.out.println("1. Addition");
            System.out.println("2. Subtraction");
            System.out.println("3. Multiply");
            System.out.println("4. Divide");
            System.out.println("5. Modulus");
            System.out.println("0. Exit");

            ch = scan.nextInt();

            if (ch == 0)
            {
                System.out.println("Exiting the program.");
                break;
            }

            System.out.println("enter the first number: ");
            op.n1 = scan.nextDouble();

            System.out.println("enter the second number: ");
            op.n2 = scan.nextDouble();

            switch (ch)
            {
                case 1:
                    System.out.println("Sum: " + op.addNums(op.n1, op.n2));
                    break;

                case 2:
                    System.out.println("diff: " + op.subtractNums(op.n1, op.n2));
                    break;

                case 3:
                    System.out.println("prod: " + op.multiplyNums(op.n1, op.n2));
                    break;

                case 4:
                    System.out.println("div: " + op.divideNums(op.n1, op.n2));
                    break;

                case 5:
                    System.out.println("remainder: " + op.modulusNums(op.n1, op.n2));
                    break;

                default:
                    System.out.println("Invalid operation!");
            }
        }

        scan.close();
    }
}
