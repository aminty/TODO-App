package service.sorter;

import entity.Activity;

import java.util.Comparator;

public class SortByStatus implements Comparator<Activity> {
    @Override
    public int compare(Activity o1, Activity o2) {
        return o1.getStatus().compareTo(o2.getStatus()) ;
    }
}
