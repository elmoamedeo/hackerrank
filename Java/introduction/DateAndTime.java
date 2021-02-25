package Java.introduction;

import java.io.*;
import java.util.Calendar;

class Result {

    public static String findDay(int month, int day, int year) {
        Calendar calendar = Calendar.getInstance();
        String[] dayOfWeek = {
                "SUNDAY",
                "MONDAY",
                "TUESDAY",
                "WEDNESDAY",
                "THURSDAY",
                "FRIDAY",
                "SATURDAY"
        };

        calendar.set(Calendar.DAY_OF_MONTH, day);
        // -1 bc January starts at index 0
        calendar.set(Calendar.MONTH, month - 1);
        calendar.set(Calendar.YEAR, year);

        // same logic as aplied with month
        return dayOfWeek[calendar.get(Calendar.DAY_OF_WEEK) - 1];
    }
}

public class DateAndTime {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int month = Integer.parseInt(firstMultipleInput[0]);

        int day = Integer.parseInt(firstMultipleInput[1]);

        int year = Integer.parseInt(firstMultipleInput[2]);

        String res = Result.findDay(month, day, year);

        bufferedWriter.write(res);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
