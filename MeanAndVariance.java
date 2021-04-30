package com.Assignment0;

import java.util.*;


public class MeanAndVariance {
    float[] data; // the float array instance variable
    public float mean () {
        float sum = 0;
        for(int i = 0; i<data.length; i++){
            sum += data[i];
        }
        return  (sum/data.length);
    }
    public float variance () {
        //Creating variable with the same value as mean, that will be used to find difference
        float average = mean();
        float sumdif = 0;
        for(int i=0; i<data.length; i++) {
            //finding the squared difference of each variable and summing them
            sumdif += (data[i] - average)*(data[i] - average);
        }
        return (sumdif/((data.length)-1));
    }

    @Override // overrides Object toString - all Java classes inherit (ultimately) from Object
    public String toString () {
        String output = "";
        for(int i =0; i< data.length; i++){
            output += data[i];
        }

        //return Arrays.toString(data);
        return output;
    }
    public MeanAndVariance (float[] myData) {
        data = myData;
    }
    public MeanAndVariance () {
        data = null;
    }

    private static int getDataNoFromKeyboard (Scanner input) {
        System.out.print("Enter the number of data set elements:\n");
        int ndata;
        while (true) { // loop until we get it correctly
            try {
                ndata = input.nextInt();
                if(ndata >0){
                    break;
                } else {
                    System.out.print("Please enter a value higher than 0\n");
                }

            } catch (Exception e){
                System.out.print("Please enter an integer value\n");
                input.nextLine();
            }
            // we got it correctly, so break out of the loop
        }
        return ndata;
    }

    public void getDataSetFromKeyboard (Scanner input) {
        int ndata = getDataNoFromKeyboard(input);
        System.out.print("Enter the the values for array\n");
        data = new float[ndata]; // we create the array instance variable
        int k =0; //variable for different array points
        while (true) {
            if(k<ndata){
                try {
                    data[k] = input.nextFloat();
                    k++;
                } catch (Exception e) {
                    System.out.print("Please input a float or integer value:\n");
                    input.nextLine();
                }
            } else {
                break;
            }
        }
    }

    public void getRandomDataSet (int ndata, int upperBound) {
        data = new float[ndata]; // we create the array instance variable
        int k =0; //variable for different array points
        Random randGen = new Random();
        while (true) {
            if(k<ndata){
                data[k] = randGen.nextFloat()*upperBound;
                k++;
            }else{
                break;
            }
        }
        // here you should write code that uses the Random nextFloat method
        // to initialise all the array elements with random floating-point values
        // in the range [0..upperBound)
    }


    public static void main (String[] args) {
        // we create a MeanAndVariance object instance
        MeanAndVariance mv = new MeanAndVariance();
        if (args.length == 0) { // no arguments, so we get user data from the keyboard
            Scanner input = new Scanner(System.in); // create scanner that reads stdin
            mv.getDataSetFromKeyboard(input); // get user data from keyboard
        }
        else if (args.length == 2) { // two arguments, produce random data set
            try{
                int ndata = Integer.parseInt(args[0]);
                int upperBound = Integer.parseInt(args[1]);
                if (ndata <= 0 || upperBound == 0) { // incorrect values of ndata or upperBound
                    System.out.print("ndata and/or upperBound has wrong value, try again\n");
                    System.exit(0); // terminate program
                }
                mv.getRandomDataSet(ndata, upperBound); // produce random data set
            } catch (Exception e){
                System.out.print("Please insert integer values\n");
                System.exit(0); // terminate program
            }
        }
        else { // any other number of arguments
            System.out.print("incorrect number of arguments, try again\n");
            System.exit(0); // terminate program
        }
        System.out.print("The mean and variance of the following numbers are:\n");
        System.out.printf("Numbers: %s\n", mv.toString());
        System.out.printf("Mean: %f Variance: %f\n", mv.mean(), mv.variance());
    }

} // end class
