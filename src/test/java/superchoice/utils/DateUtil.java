package superchoice.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DateUtil {

    public static String getPastorFutureDateUsingCurrentDate(int NoOfDays) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        //Number of Days to add
        c.add(Calendar.DAY_OF_MONTH, NoOfDays);
        //Date after adding the days to the given date
        String newDate = sdf.format(c.getTime());
        return newDate.toString();
    }
}
