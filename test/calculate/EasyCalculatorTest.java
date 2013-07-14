package calculate;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.junit.*;

public class EasyCalculatorTest {

    private static void assertThatWrapper(int actual, int expected) {
        assertThat(Integer.valueOf(actual), is(Integer.valueOf(expected)));
    }

    /**
     * 管理用のユーティリティメソッド。
     * 
     * @return
     */
    private IEasyCalculator createInstacne() {
        return new EasyCalculator();
        // return new EasyCalculatorImpl();
    }

    @Test
    public void calculatorSimple() {
        IEasyCalculator target = createInstacne();

        assertThatWrapper(target.calculate("5", "2", Operator.ADD), 7);
        assertThatWrapper(target.calculate("5", "2", Operator.SUBTRACT), 3);
        assertThatWrapper(target.calculate("5", "2", Operator.MULTIPLY), 10);
        assertThatWrapper(target.calculate("5", "2", Operator.DIVIDE), 2);
    }

    @Test
    public void calculatorZeroDivide() {
        IEasyCalculator target = createInstacne();

        try {
            target.calculate("2", "0", Operator.DIVIDE);
            fail("No IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("success");
        } catch (Exception e) {
            fail("No IllegalArgumentException");
        }
    }

    @Test
    public void calculatorIllegalArgs() {
        IEasyCalculator target = createInstacne();

        try {
            target.calculate("", "1", Operator.ADD);
            fail("No IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("success");
        } catch (Exception e) {
            fail("No IllegalArgumentException");
        }

        try {
            target.calculate("2", "a", Operator.ADD);
            fail("No IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("success");
        } catch (Exception e) {
            fail("No IllegalArgumentException");
        }

        try {
            target.calculate(null, "3", Operator.MULTIPLY);
            fail("No IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("success");
        } catch (Exception e) {
            fail("No IllegalArgumentException");
        }

        try {
            target.calculate("2", null, Operator.MULTIPLY);
            fail("No IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            System.out.println("success");
        } catch (Exception e) {
            fail("No IllegalArgumentException");
        }
    }
}