package pt.iade.unimanage.models;

// Can work with individual students and whole units
public class StatisticResult {
    
    private double average;
    private double max;
    private double min;
    private double range;

    public StatisticResult(double average, double max, double min, double range) {
        this.average = average;
        this.max = max;
        this.min = min;
        this.range = range;
    }

    public double getAverage() { return average; }

    public double getMax() { return max; }

    public double getMin() { return min; }

    public double getRange() { return range; }


}
