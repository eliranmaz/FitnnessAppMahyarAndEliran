package models;

public class Day {
    private String dayName;

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public Day(String dayName) {
        this.dayName = dayName;
    }
}
