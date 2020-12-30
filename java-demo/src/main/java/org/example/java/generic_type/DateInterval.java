package org.example.java.generic_type;

import java.time.LocalDate;
import java.util.Date;

/**
 * Created by heqingfu on 2020/8/27.
 */
public class DateInterval extends Pair<LocalDate>{

    @Override
    public void setSecond(LocalDate second) {
        if (second.compareTo(getFirst()) >= 0) {
            super.setSecond(second);
        }
    }
    @Override
    public LocalDate getSecond() {
        return  super.getSecond();
    }

}
