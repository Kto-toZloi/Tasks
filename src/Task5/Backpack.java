package Task5;

import java.util.ArrayList;
import java.util.Objects;

public class Backpack {
    /**
     * Решение задачи о рюкзаке (сейфе)
     */
    public static void main(String[] args) {

        Integer[] weight_list = {1,  2, 3, 4, 5};
        Integer[] price_list = {12, 25, 5, 9, 7};

        int max_weight = 8;
        int count = price_list.length;

        Integer[][] table = new Integer[count + 1][];

        for (int i = 0; i < count + 1; i++) {
            table[i] = new Integer[max_weight + 1]; // если берём по целым делениям весов
        }

        for (int i = 0; i < count + 1; i++) {
            for (int j = 0; j < max_weight + 1; j++) {
                if(i == 0 || j == 0){// либо вес рюкзака (j) 0 либо в нём 0 элементов (i)
                    table[i][j] = 0;
                }
                else{
                    if (j >= weight_list[i-1]){//текущий элемент по весу не превышает размерность рюкзака
                        table[i][j] = Math.max(
                                //Текущий элемент не берётся в рюкзак
                                table[i-1][j],

                                //Текущий элемент взят в рюкзак, тогда его вес вычитается из вместимости рюкзака,
                                // а стоимость рассчитывается как стоимость текущего элемента
                                // + максимальная стоимость на предыдущем шаге
                                table[i-1][j - weight_list[i-1]] + price_list[i-1]
                        );
                    }
                    else {//превышает
                        table[i][j] = table[i-1][j];
                    }
                }
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        findPath(table, weight_list, res, count, max_weight);
        res.forEach(System.out::println);

    }

    private static void findPath(Integer[][] table, Integer[] weight_list, ArrayList<Integer> res, int i, int j){

        if(table[i][j] == 0){
            return;
        }
        if(Objects.equals(table[i - 1][j], table[i][j])){
            findPath(table, weight_list, res, i-1, j);
        }
        else {
            findPath(table, weight_list, res, i-1, j-weight_list[i-1]);
            res.add(i);
        }

    }


}
