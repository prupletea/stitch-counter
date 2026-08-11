import java.util.Scanner;

public class StitchCounter {
    public static void main(String[] args)
    {
        Scanner reader = new Scanner(System.in);

        int patternGaugeStitches, yourGaugeStitches, patternStitches, yourStitches;
        double patternGaugeCm, yourGaugeCm;
        String input;
        
        System.out.println("! when typing in cm, use the decimal point (.), for example 4.2 or 10.0\n");

        //no parsing yet
        System.out.println("Pattern gauge, stitches:");
        input = reader.nextLine();
        patternGaugeStitches = Integer.parseInt(input);

        System.out.println("Pattern gauge, cm:");
        input = reader.nextLine();
        patternGaugeCm = Double.parseDouble(input);

        System.out.println("Your gauge, stitches:");
        input = reader.nextLine();
        yourGaugeStitches = Integer.parseInt(input);

        System.out.println("Your gauge, cm:");
        input = reader.nextLine();
        yourGaugeCm = Double.parseDouble(input);

        System.out.println("How many stitches does the pattern require?");
        input = reader.nextLine();
        patternStitches = Integer.parseInt(input);

        //calculations
        yourStitches = (int) Math.round((((patternStitches*patternGaugeCm)/patternGaugeStitches)*yourGaugeStitches)/yourGaugeCm);

        //results
        System.out.println("\nResults!");
        System.out.println("Based on your gauge and what the pattern requires,\n you need " + yourStitches + " stitches.");

        reader.close();
    }
}