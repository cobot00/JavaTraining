package date;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonthConverterTest {

    @Test
    public void convert() {
        for (int i = 0; i < Month.values().length; i++) {
            Month each = Month.values()[i];
            Month target = Month.convert(each.getMonth());

            System.out.println(each+" -> "+target);
            assertEquals(target.getMonth(), each.getMonth());
        }

    }

}
