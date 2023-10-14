package org.bmp.vtb.utilites;

import org.springframework.stereotype.Component;

import java.util.regex.*;

@Component
public class TimeUtils {
    public WorkingTime timeFromString(String time) {
        Pattern pattern = Pattern.compile("(\\d{2}):(\\d{2})-(\\d{2}):(\\d{2})");
        Matcher matcher = pattern.matcher(time);

        if (matcher.matches()) {
            int openHour = Integer.parseInt(matcher.group(1));
            int openMinutes = Integer.parseInt(matcher.group(2));
            int closeHour = Integer.parseInt(matcher.group(3));
            int closeMinutes = Integer.parseInt(matcher.group(4));

            return new WorkingTime(openHour, openMinutes, closeHour, closeMinutes);
        } else {
            // Обработка неверного формата времени
            throw new IllegalArgumentException("Invalid time format: " + time);
        }
    }

    public String getTime(WorkingTime workingTime) {
        // Форматируем рабочее время в формат 'HH:mm-HH:mm'
        return String.format("%02d:%02d-%02d:%02d",
                workingTime.openHour(),
                workingTime.openMinutes(),
                workingTime.closeHour(),
                workingTime.closeMinutes());
    }

    public record WorkingTime(int openHour, int openMinutes, int closeHour, int closeMinutes) {
    }
}
