package lab;

import java.util.Scanner;
import java.util.Scanner;

class GasMileageCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalMiles = 0, totalGallons = 0;
        int tripCount = 0;

        while(true) {
            System.out.print("Enter miles driven (or -1 to end): ");
            double miles = sc.nextDouble();
            if(miles == -1) break;
            System.out.print("Enter gallons used: ");
            double gallons = sc.nextDouble();
            tripCount++;
            double mpg = miles / gallons;
            totalMiles += miles;
            totalGallons += gallons;
            System.out.println("Miles per gallon for this trip: " + mpg);
            double overallMpg = totalMiles / totalGallons;
            System.out.println("Overall miles per gallon up to this point: " + overallMpg);
        }

        sc.close();
    }
}
