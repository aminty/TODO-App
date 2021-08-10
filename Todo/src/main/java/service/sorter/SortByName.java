package service.sorter;

import entity.Activity;

import java.util.Comparator;

public class SortByName implements Comparator<Activity> {
    @Override
    public int compare(Activity o1, Activity o2) {
        return o1.getActivityName().compareTo(o2.getActivityName());
    }
}
