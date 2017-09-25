package chapter1;

/*
  PACKAGE: chapter1
  USER: 84066
  DATE: 2017/9/25
  TIME: 10:00

 */

import edu.princeton.cs.algs4.StdOut;

public class SmartDate {

    private final int month;
    private final int day;
    private final int year;

    private final int DAYS_YEAR = 365;
    private final int DAYS_WEEK = 7;
    private final int WEEKS_FOR_START = 6; // 2000/01/01 -> Sunday

    private final String[] WEEKS = {"Monday", "Tuesday", "Wednesday", "Thursday", "Firday", "Saturday", "Sunday"};
    private int[] DAYS_IN_MONTH = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public SmartDate(int m, int d, int y) {
        month = m;
        day = d;
        year = y;
        assert is_data_valid() : "data is valid.";
    }

    public static void main(String[] args) {
        SmartDate d1 = new SmartDate(1, 1, 2000);
        StdOut.println(d1.dayOfTheWeek());
        SmartDate d2 = new SmartDate(12, 31, 1999);
        StdOut.println(d2.dayOfTheWeek());
        SmartDate d3 = new SmartDate(9, 25, 2017);
        StdOut.println(d3.dayOfTheWeek());
        SmartDate d4 = new SmartDate(2, 29, 2001);
        StdOut.println(d4.is_day_valid());
    }

    public int month() {
        return month;
    }

    public int day() {
        return day;
    }

    public int year() {
        return year;
    }

    private boolean is_leap_year() {
        return (year % 100 != 0 && (year % 4 == 0)) || year % 400 == 0;
    }

    private boolean is_day_valid() {
        if (!is_leap_year() || month != 2) {
            return day > 0 && day <= DAYS_IN_MONTH[month - 1];
        } else {
            return day > 0 && day <= 29;
        }
    }

    private boolean is_month_valid() {
        return month >= 1 && month <= 12;
    }

    private boolean is_data_valid() {
        return is_month_valid() && is_day_valid();
    }

    private int days_to_year() {
        int y = year - 2000;
        return y * DAYS_YEAR + y / 4 - (y - 1) / 100 + (y - 1) / 400;
    }

    private int days_in_year() {
        int d = 0;
        for (int i = 1; i < month; i++) {
            d += DAYS_IN_MONTH[i - 1];
            if (i == 2 && is_leap_year()) d++;
        }
        return d + day - 1;
    }

    private int days_to_data() {
        return days_to_year() + days_in_year();
    }

    public String dayOfTheWeek() {
        int wk = (days_to_data() + WEEKS_FOR_START) % 7;
        if (wk < 0) {
            wk += DAYS_WEEK;
        }
        return WEEKS[wk];
    }

    @Override
    public String toString() {
        return month() + "/" + day() + "/" + year();
    }

    @Override
    public boolean equals(Object x) {
        if (this == x) return true;
        if (x == null) return false;
        if (this.getClass() != x.getClass()) return false;
        SmartDate that = (SmartDate) x;
        return this.day == that.day && this.month == that.month && this.year == that.year;
    }
}
