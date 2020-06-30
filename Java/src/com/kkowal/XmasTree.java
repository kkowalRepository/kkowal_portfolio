package com.kkowal;

public class XmasTree {

        public static void main(String[] args) {
            String draw = "*";
            int numOfLines = 10;

            for (int line = 0; line < numOfLines; line++) {
                for (int whichMark = 0;
                     whichMark < numOfLines * 2;
                     whichMark++)
                {
                    if (whichMark < (numOfLines - line) || whichMark > (numOfLines + line))
                    {
                        System.out.print(" ");
                    } else {
                        System.out.print(draw);
                    }
                }
                System.out.println("");
            }
        }
    }

