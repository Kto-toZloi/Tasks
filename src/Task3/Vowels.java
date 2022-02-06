package Task3;

import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Vowels {

    static Set<Character> set = new HashSet<>(Arrays.asList('а', 'о', 'у', 'ы', 'э', 'я', 'ё', 'ю', 'и', 'е',
            'А', 'О', 'У', 'Ы', 'Э', 'Я', 'Ё', 'Ю', 'И', 'Е'));

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        String str = s.nextLine();

        String[] arr = str.split(" ");

        int count;

        Pattern pattern = Pattern.compile("[аоуыэяёюие]",Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE);

        for (String ss: arr) {
            count = 0;
            Matcher matcher = pattern.matcher(ss);
            while (matcher.find()){
                count++;
            }
            System.out.println(ss + ": " + count);
        }

        List<String> a = Arrays.asList(arr.clone());
        a.sort(new Vowels().comparator);

        System.out.println(a);


        System.out.println(

                Arrays.stream(str.split(" ")).map(
                        (q) -> {
                            char character = set.stream().min(
                                    (o1, o2) ->
                            (q.indexOf(o1) == -1) ?
                                    ((q.indexOf(o2) == -1) ? 0 :
                                            1) :
                                    (q.indexOf(o2) == -1 ?
                                            -1 :
                                            Integer.compare(q.indexOf(o1), q.indexOf(o2)))).get();
            return q.replaceFirst(Character.toString(character), Character.toString(Character.toUpperCase(character)));
        }).collect(Collectors.joining(" "))

        );

    }



    Function<String, Integer> count = s -> {
        int c = 0;
        for (int i = 0; i < s.length(); i++) {
            c += set.contains(s.charAt(i)) ? 1 : 0;
        }
        return c;
    };

    Comparator<String> comparator = Comparator.comparingInt(s -> count.apply(s));




}
