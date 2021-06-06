/*
 *  UCF COP3330 Summer 2021 Assignment 1 Solution
 *  Copyright 2021 Luis Corona
 */
import java.util.Scanner;

public class App {

    static Scanner in = new Scanner(System.in);
    static final float legalBloodLevel = (float) .08;
    static final float mADR = (float) .73;
    static final float fADR = (float) .66;
    public static void main(String[] args) {
        App app = new App();
        String gender = app.readGender();
        String alcoholConsumed = app.readConsumed();
        String weight = app.readWeight();
        String timeSince = app.readTime();
        float bloodAlcohol = app.bloodLevel(gender,weight,alcoholConsumed,timeSince);
        app.printOutput(bloodAlcohol);
    }

    private void printOutput(float bloodAlcohol) {
        String newline = System.lineSeparator();
        final String msg = bloodAlcohol <= legalBloodLevel
                ? "Your BAC is " + bloodAlcohol + newline + "It is legal for you to drive."
                :"Your BAC is " + bloodAlcohol + newline + "It is not legal for you to drive.";
        System.out.print(msg);
    }

    private float bloodLevel(String gender, String weight, String alcoholConsumed, String timeSince) {
        int genderInt = Integer.parseInt(gender);
        int weightInt = Integer.parseInt(weight);
        int alcoholConsumedInt = Integer.parseInt(alcoholConsumed);
        int timeSinceInt = Integer.parseInt(timeSince);
        float BAC = 0;
       if(genderInt == 1)
           BAC = (float) ( ( (alcoholConsumedInt * 5.14) / weightInt ) * (mADR) - (.015 * timeSinceInt));
       else
           BAC = (float) ( ( (alcoholConsumedInt * 5.14) / weightInt ) * (fADR) - (.015 * timeSinceInt));

       return BAC;
    }

    private String readGender() {
        System.out.print("Enter a 1 is you are male or a 2 if you are female: ");
        String gender = in.nextLine();
        try{
            int genderInt = Integer.parseInt(gender);
        } catch(NumberFormatException e){
            System.out.print("Input must be a numeric value\n");
            System.exit(0);
        }
        return gender;
    }

    private String readConsumed() {
        System.out.print("How many ounces of alcohol did you have? ");
        String alcoholConsumed = in.nextLine();
        return alcoholConsumed;
    }

    private String readWeight() {
        System.out.print("What is your weight, in pounds? ");
        String weight = in.nextLine();
        return weight;
    }

    private String readTime() {
        System.out.print("How many hours has it been since your last drink? ");
        String timeSince = in.nextLine();
        return timeSince;
    }
}





