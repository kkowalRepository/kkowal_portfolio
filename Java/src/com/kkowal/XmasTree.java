package com.kkowal;

public class XmasTree {

        public static void main(String[] args) {
            String draw = "*";
            int howManyLines = 10;

            for (int line = 0; line < howManyLines; line++) {
                for (int whichMark = 0; whichMark < howManyLines * 2; whichMark++) {
                    if (whichMark < (howManyLines - line) || whichMark > (howManyLines + line)) {
                        System.out.print(" ");
                    } else {
                        System.out.print(draw);
                    }
                }
                System.out.println("");
            }
        }
    }

