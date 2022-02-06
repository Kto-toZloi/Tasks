package Task4;

import java.util.*;

public class Numbers {

    public static void main(String[] args) {
        String[][] nums = {
                {       " ***  ",
                        "*   * ",
                        "*   * ",
                        "*   * ",
                        "*   * ",
                        "*   * ",
                        " ***  "
                },

                {
                        "  *   ",
                        " **   ",
                        "  *   ",
                        "  *   ",
                        "  *   ",
                        "  *   ",
                        "***** "
                },
                {
                        " ***  ",
                        "*   * ",
                        "*  *  ",
                        "  *   ",
                        " *    ",
                        "*     ",
                        "***** "
                },
                {
                        " ***  ",
                        "*   * ",
                        "    * ",
                        "  *   ",
                        "    * ",
                        "*   * ",
                        " ***  "
                },
                {
                        "   *  ",
                        "  **  ",
                        " * *  ",
                        "*  *  ",
                        "***** ",
                        "   *  ",
                        "   *  "
                },
                {
                        "***** ",
                        "*     ",
                        "*     ",
                        "***** ",
                        "    * ",
                        "    * ",
                        "***** "
                },
                {
                        " ***  ",
                        "*   * ",
                        "*     ",
                        "****  ",
                        "*   * ",
                        "*   * ",
                        " ***  "
                },
                {
                        "***** ",
                        "    * ",
                        "   *  ",
                        "  *   ",
                        " *    ",
                        "*     ",
                        "*     "
                },
                {
                        " ***  ",
                        "*   * ",
                        "*   * ",
                        " ***  ",
                        "*   * ",
                        "*   * ",
                        " ***  "
                },
                {
                        " ***  ",
                        "*   * ",
                        "*   * ",
                        " **** ",
                        "    * ",
                        "*   * ",
                        " ***  "
                }
        };


        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        int a = Integer.parseInt(s);

        int max=0;
        LinkedList<Integer> result = new LinkedList<>();
        while(a != 0) {
            result.add(0, a%10);
            if (a % 10 > max) max = a % 10;
            a = a / 10;
        }

        for (int i = 0; i < s.length()-result.size(); i++) {
            result.add(0, 0);
        }


        for (int i = 0; i < 7; i++) {
            for (Integer l: result) {
                if (l == max){
                    System.out.print(nums[l][i].replace("*", String.valueOf(l)));
                }
                else System.out.print(nums[l][i]);
            }
            System.out.println();
        }

    }
}
