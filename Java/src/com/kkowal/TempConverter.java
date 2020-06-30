package com.kkowal;

public class TempConverter {

        public static void main(String[] args) {
            //1C = 1*1.8+32
            //3 degrees, 15 degrees, 25 degrees
            double tempOne = 3;
            double tempTwo = 15.0;
            double tempThree = 25.0d;

            calculate(tempOne);
            calculate(tempTwo);
            calculate(tempThree);

        }

        private static void calculate(double temp){
            System.out.println(temp*1.8+32);
        }
    }

