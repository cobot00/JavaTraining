package date;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

public class EasyDateTest {

    @Test
    public void getFirstDayOfThisMonth() {
        for (int i = 1; i < 13; i++) {
            EasyDate target = new EasyDate(2013, i, 2);
            assertThat(target.getFirstDayOfThisMonth(), is(new EasyDate(2013,
                    i, 1)));
        }
    }

    @Test
    public void getLastDayOfThisMonth() {
        for (Month each : Month.values()) {
            EasyDate target = new EasyDate(2013, each.getMonth(), 2);
            assertThat(target.getLastDayOfThisMonth(), is(new EasyDate(2013,
                    each.getMonth(), each.getLastDay())));
        }
    }

    @Test
    public void getAfterMonths() {
        EasyDate target = new EasyDate(2013, 1, 31);

        // 1ヶ月後
        assertThat(target.getAfterMonths(1), is(new EasyDate(2013, 2, 28)));

        // 1ヶ月前
        assertThat(target.getAfterMonths(-1), is(new EasyDate(2012, 12, 31)));

        // 3ヶ月後
        assertThat(target.getAfterMonths(3), is(new EasyDate(2013, 4, 30)));

        // 4ヶ月前
        assertThat(target.getAfterMonths(-4), is(new EasyDate(2012, 9, 30)));

        // 12ヶ月後
        assertThat(target.getAfterMonths(12), is(new EasyDate(2014, 1, 31)));

        // 12ヶ月前
        assertThat(target.getAfterMonths(-12), is(new EasyDate(2012, 1, 31)));

        // 13ヶ月後
        assertThat(target.getAfterMonths(13), is(new EasyDate(2014, 2, 28)));

        // 13ヶ月前
        assertThat(target.getAfterMonths(-13), is(new EasyDate(2011, 12, 31)));

        // 26ヶ月後
        assertThat(target.getAfterMonths(26), is(new EasyDate(2015, 3, 31)));

        // 26ヶ月前
        assertThat(target.getAfterMonths(-26), is(new EasyDate(2010, 11, 30)));
    }

}
