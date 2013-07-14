package fizzbuzz;

import java.util.*;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class FizzBuzzTest {

    private static final String[] RESULTS_SIMPLE = { "1", "2", "Fizz", "4",
            "Buzz", "Fizz", "7", "8", "Fizz", "Buzz", "11", "Fizz", "13", "14",
            "FizzBuzz", "16", "17", "Fizz", "19", "Buzz", "Fizz", "22", "23",
            "Fizz", "Buzz", "26", "Fizz", "28", "29", "FizzBuzz", "31", "32",
            "Fizz", "34", "Buzz", "Fizz", "37", "38", "Fizz", "Buzz" };

    private static final String[] RESULTS_4ENTITY = { "1", "2", "@3", "4",
            "@5", "@6", "7", "8", "@3", "@5", "11", "@6", "13", "14", "@5",
            "16", "17", "@18", "19", "@5", "@3", "22", "23", "@6", "@5", "26",
            "@3", "28", "29", "@6", "31", "32", "@3", "34", "@5", "@18", "37",
            "38", "@3", "@5" };

    private static final String[] RESULTS_1ENTITY = { "1", "2", "3", "4", "5",
            "6", "@7", "8", "9", "10", "11", "12", "13", "@7", "15", "16",
            "17", "18", "19", "20", "@7", "22", "23", "24", "25", "26", "27",
            "@7", "29", "30", "31", "32", "33", "34", "@7", "36", "37", "38",
            "39", "40" };

    /**
     * 管理用のユーティリティメソッド。
     * 
     * @return
     */
    private IFizzBuzz createInstance(List<FizzBuzzEntity> condition) {
        return new FizzBuzz(condition);
        // return new FizzBuzzImpl(condition);
    }

    @Test
    public void executeSimple() {
        List<FizzBuzzEntity> list = new ArrayList<FizzBuzzEntity>();
        list.add(new FizzBuzzEntity(3, "Fizz"));
        list.add(new FizzBuzzEntity(5, "Buzz"));
        list.add(new FizzBuzzEntity(15, "FizzBuzz"));

        execute(list, RESULTS_SIMPLE);
    }

    @Test
    public void execute4Entity() {
        List<FizzBuzzEntity> list = new ArrayList<FizzBuzzEntity>();
        list.add(new FizzBuzzEntity(3, "@3"));
        list.add(new FizzBuzzEntity(5, "@5"));
        list.add(new FizzBuzzEntity(6, "@6"));
        list.add(new FizzBuzzEntity(18, "@18"));

        execute(list, RESULTS_4ENTITY);
    }

    @Test
    public void execute1Entity() {
        List<FizzBuzzEntity> list = new ArrayList<FizzBuzzEntity>();
        list.add(new FizzBuzzEntity(7, "@7"));

        execute(list, RESULTS_1ENTITY);
    }

    private void execute(List<FizzBuzzEntity> condition, String[] expected) {
        IFizzBuzz target = createInstance(condition);

        for (int i = 1; i <= 40; i++) {
            System.out.println("i = " + i + " -> " + target.doFizzBuzz(i));
            assertThat(target.doFizzBuzz(i), is(expected[i - 1]));
        }
    }
}