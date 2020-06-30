# Java Exercises

### TempConverter

A simple app that calculates given Fahrenheit temperature values `tempOne, tempTwo, tempThree` to Celsius values. Code below:

```
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
```

### Xmas Tree

An app that takes the `x` mark to create a visual representation of a christmas tree. Code below:

```
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
```

And here's how it turned out:
![](images/xmasTree.png)
