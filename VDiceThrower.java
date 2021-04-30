package Assignment1;

import java.util.Random;
import java.util.Scanner;

public class VDiceThrower {

    public static void main(String[] args){
        Random r = new Random();
        Scanner s = new Scanner(System.in);

        int[] diceNumbers; // array for storing numbers from 1 to the user chosen number
        int[] diceRollsOfNumbers; // array of storing how many times certain value occured

        int diceSides = 0;
        int numberToBeThrown = 0;
        if(args.length == 0){
            System.out.println("Number of faces");
            while(true){
                try {
                    diceSides = s.nextInt();
                    if(diceSides>1){
                        break;
                    } else {
                        System.out.println("it has to be a value higher than 1");
                    }
                } catch (Exception e){
                    System.out.println("it has to be an integer value");
                    s.nextLine();
                }
            }
            System.out.println("Number of times to throw the dice (has to be multiple of faces)");
            while(true){
                try {
                    numberToBeThrown = s.nextInt();
                    if(numberToBeThrown%diceSides == 0){
                        break;
                    } else {
                        System.out.println("it has to be a multiple of faces");
                    }
                } catch (Exception e){
                    System.out.println("it has to be an integer value");
                    s.nextLine();
                    continue;
                }
            }

        }else if(args.length == 2){
            try{
                diceSides = Integer.parseInt(args[0]);
                numberToBeThrown = Integer.parseInt(args[1]);
            } catch (Exception e){
                System.out.print("Please enter integer values\n");
                System.exit(0); // terminate program
            }

            if(diceSides<=0 || numberToBeThrown <= 0 || (numberToBeThrown%diceSides) != 0) {
                System.out.print("dice sides and/or number to roll has wrong value, try again\n");
                System.exit(0); // terminate program
            }
            //creating array

        } else {
            System.out.print("incorrect number of arguments, try again\n");
            System.exit(0); // terminate program
        }

        //Now we have number of faces and to be rolled
        diceNumbers = new int[diceSides];
        for(int i=0; i<diceSides; i++){
            diceNumbers[i] = i+1;
        }
        diceRollsOfNumbers = new int[numberToBeThrown];
        int tempRandomNumber;
        for(int j=0; j<numberToBeThrown; j++){
            tempRandomNumber = r.nextInt(diceSides);
            diceRollsOfNumbers[tempRandomNumber] += 1;
        }
        for(int j=0; j<diceSides; j++){
            System.out.println(diceRollsOfNumbers[j]);
        }
    }
}
