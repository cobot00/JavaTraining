package date;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class EasyDateTest {

    /**
     * assertThatのユーティリティラッパーメソッド。
     * 
     * @param actual
     * @param expected
     */
    private static void assertThatWrapper(IEasyDate actual, IEasyDate expected) {
        assertThat(actual, is(expected));
    }

    /**
     * 管理用のユーティリティメソッド。
     * 
     * @return
     */
    private IEasyDate createInstance(int year, int month, int day) {
        return new EasyDate(year, month, day);
        // return new EasyDateImpl(year, month, day);
    }

    @Test
    public void getFirstDayOfThisMonth() {
        for (int i = 1; i < 13; i++) {
            IEasyDate target = createInstance(2013, i, 2);
            assertThatWrapper(target.getFirstDayOfThisMonth(), new EasyDate(
                    2013, i, 1));
        }
    }

    @Test
    public void getLastDayOfThisMonth() {
        for (Month each : Month.values()) {
            IEasyDate target = createInstance(2013, each.getMonth(), 2);
            assertThatWrapper(target.getLastDayOfThisMonth(), new EasyDate(
                    2013, each.getMonth(), each.getLastDay()));
        }
    }

    @Test
    public void getAfterMonths() {
        IEasyDate target = createInstance(2013, 1, 31);

        // 1ヶ月後
        assertThatWrapper(target.getAfterMonths(1), createInstance(2013, 2, 28));

        // 1ヶ月前
        assertThatWrapper(target.getAfterMonths(-1),
                createInstance(2012, 12, 31));

        // 3ヶ月後
        assertThatWrapper(target.getAfterMonths(3), createInstance(2013, 4, 30));

        // 4ヶ月前
        assertThatWrapper(target.getAfterMonths(-4),
                createInstance(2012, 9, 30));

        // 12ヶ月後
        assertThatWrapper(target.getAfterMonths(12),
                createInstance(2014, 1, 31));

        // 12ヶ月前
        assertThatWrapper(target.getAfterMonths(-12),
                createInstance(2012, 1, 31));

        // 13ヶ月後
        assertThatWrapper(target.getAfterMonths(13),
                createInstance(2014, 2, 28));

        // 13ヶ月前
        assertThatWrapper(target.getAfterMonths(-13),
                createInstance(2011, 12, 31));

        // 26ヶ月後
        assertThatWrapper(target.getAfterMonths(26),
                createInstance(2015, 3, 31));

        // 26ヶ月前
        assertThatWrapper(target.getAfterMonths(-26),
                createInstance(2010, 11, 30));
    }

}
