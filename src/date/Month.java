package date;

public enum Month implements Convertable<Integer> {

    JANUARY(1, 31), FEBRUARY(2, 28), MARCH(3, 31), APRIL(4, 30), MAY(5, 31), JUNE(
    6, 30), JULY(7, 31), AUGUST(8, 31), SEPTEMBER(9, 30), OCTOBER(10,
    31), NOVEMBER(11, 30), DECEMBER(12, 31);
    public static final int MONTHS_OF_YEAR = 12;
    private static final EnumConverter<Integer, Month> converter = new EnumConverter<Integer, Month>(
            Month.values());
    private final int month;
    private final int days;
    private final Integer key;

    private Month(int month, int days) {
        this.month = month;
        this.days = days;
        this.key = Integer.valueOf(month);
    }

    public static Month convert(int month) {
        return converter.convert(Integer.valueOf(month));
    }

    public static int getLastDay(int month) {
        Month converted = convert(month);
        return converted.getLastDay();
    }

    public int getMonth() {
        return month;
    }

    public int getLastDay() {
        return days;
    }

    @Override
    public Integer key() {
        return key;
    }
}
