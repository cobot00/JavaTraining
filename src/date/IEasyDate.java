package date;

public interface IEasyDate {

    int getYear();

    int getMonth();

    int getDay();

    IEasyDate getFirstDayOfThisMonth();

    IEasyDate getLastDayOfThisMonth();

    IEasyDate getAfterMonths(int months);

    boolean equals(Object other);
}