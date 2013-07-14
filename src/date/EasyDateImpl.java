package date;

public class EasyDateImpl implements IEasyDate {

    private static final int COEFFICIENT_OF_YEAR = 10000;
    private static final int COEFFICIENT_OF_MONTH = 100;
    private final int year;
    private final Month month;
    private final int day;
    private final int hashCode;

    public EasyDateImpl(int year, int month, int day) {
        Month converted = Month.convert(month);
        if (day > converted.getLastDay()) {
            throw new IllegalArgumentException("day = " + day);
        }

        this.year = year;
        this.month = converted;
        this.day = day;
        this.hashCode = (year * COEFFICIENT_OF_YEAR)
                + (month * COEFFICIENT_OF_MONTH) + day;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month.getMonth();
    }

    public int getDay() {
        return day;
    }

    @Override
    public int hashCode() {
        return hashCode;
    }

    @Override
    public boolean equals(Object other) {
        return (hashCode() == other.hashCode());
    }

    @Override
    public String toString() {
        return getYear() + "/" + getMonth() + "/" + getDay();
    }

    /**
     * この日付の属する月の初日を返します。
     * 
     * 例: 2013/1/5 -> 2013/1/1、2013/2/15 -> 2013/2/1、2013/4/21 -> 2013/4/1
     * 
     * @return
     */
    public IEasyDate getFirstDayOfThisMonth() {
        return new EasyDateImpl(getYear(), getMonth(), 1);
    }

    /**
     * この日付の属する月の末日を返します。 ※閏日は考慮しない
     * 
     * 例: 2013/1/5 -> 2013/1/31、2013/2/15 -> 2013/2/28、2013/4/21 -> 2013/4/30
     * 
     * @return
     */
    public IEasyDate getLastDayOfThisMonth() {
        return new EasyDateImpl(getYear(), getMonth(), Month.getLastDay(getMonth()));
    }

    /**
     * 指定された月数後の日付を生成して返します。 monthsにマイナスの値が渡された場合は指定月分だけ遡った日付を返します。 ※閏日は考慮しない
     * 
     * 3ヶ月後: 2013/1/5 -> 2013/4/5、2013/1/31 -> 2013/4/30、2012/11/29 -> 2013/2/28
     * 2ヶ月前: 2013/1/5 -> 2012/11/5、2013/1/31 -> 2012/11/30、2013/9/30 ->
     * 2013/7/30
     * 
     * @param months
     * @return
     */
    public IEasyDate getAfterMonths(int months) {
        // 12ヶ月を超える値が渡された場合の年の補正
        int yearDiff = months / Month.MONTHS_OF_YEAR;
        final int actualMonthDiff = months - (yearDiff * Month.MONTHS_OF_YEAR);

        // 月の変動に伴う年、月の補正
        int tempMonth = month.getMonth() + actualMonthDiff;
        if (tempMonth < Month.JANUARY.getMonth()) {
            yearDiff--;
            tempMonth = tempMonth + Month.MONTHS_OF_YEAR;
        } else if (tempMonth > Month.DECEMBER.getMonth()) {
            yearDiff++;
            tempMonth = tempMonth - Month.MONTHS_OF_YEAR;
        }
        final int tempYear = getYear() + yearDiff;

        // 月の変動に伴う日の補正
        int tempDay = getDay();
        final int lastDay = Month.getLastDay(tempMonth);
        if (tempDay > lastDay) {
            tempDay = lastDay;
        }

        return new EasyDateImpl(tempYear, tempMonth, tempDay);
    }
}
