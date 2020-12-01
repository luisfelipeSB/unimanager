package pt.iade.unimanage.models;

import java.util.ArrayList;

public interface Statistical {
    
    // Avg
    double getAverage();

    // Max
    double getMax();

    // Min
    double getMin();

    // Histogram
    HistogramSlot[] getHistogram(int nSlots, double gradeRange);

    // Range
    default double getRange() {
        return getMax() - getMin();
    }

    // GroupAvg
    static double getGroupAvg(ArrayList<Statistical> group) {
        double sum = 0;
        for (Statistical stat : group)
            sum += stat.getAverage();
        return  sum/group.size();
    }
}
