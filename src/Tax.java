
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Administrator
 */
public class Tax {

    @SuppressWarnings("UnusedAssignment")
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        final int f = 4;
        int[] IncomeRange = new int[f];
        int[] TaxRate = new int[f];
        int MaxTaxRate = 0;
        int Income = 0;
        int Max = 0;
        int Min = 0;
        int Sum = 0;
        int sm = 0;
        int mn = 0;
        float TR = 0;

        for (int i = 0; i < f; i++) {
            System.out.print("Please enter income and  tax rate  in tax bracket " + (i + 1) + ": ");
            IncomeRange[i] = sc.nextInt();
            TaxRate[i] = sc.nextInt();
        }

        System.out.print("Please enter tax rate if income > " + IncomeRange[3] + " : ");
        MaxTaxRate = sc.nextInt();

        System.out.print("Please enter income: ");
        Income = sc.nextInt();

        for (int i = 0; i < f; i++) {
            Max = IncomeRange[i];
            if (Max > Income) {
                Max = Income;
            }
            mn = Max - Min;
            if (i > 0) {
                mn += 1;
            }

            TR = (float) (TaxRate[i] / 100.00);
            sm = (int) ((mn) * TR);
            System.out.print(Min + " - " + Max + " you pay " + (mn) + " x ");
            System.out.printf("%.2f", TR);
            System.out.println(" = " + sm + " baht.");
            Min = (Max + 1);
            Sum += ((mn) * TR);

            if (Max == Income) {
                break;
            }
        }

        Max = Income;
        if (Max > 750000) {
            mn = Max - 750000;
            TR = (float) (MaxTaxRate / 100.00);
            sm = (int) ((mn) * TR);
            System.out.print(Min + " - " + Max + " you pay " + (mn) + " x ");
            System.out.printf("%.2f", TR);
            System.out.println(" = " + sm + " baht.");
            Min = (Max + 1);
            Sum += ((mn) * TR);
        }

        System.out.println("Total Tax : " + Sum + " baht.");
    }
}
