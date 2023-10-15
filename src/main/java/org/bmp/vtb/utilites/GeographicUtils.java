package org.bmp.vtb.utilites;

import org.springframework.stereotype.Component;

@Component
public class GeographicUtils {
    private final int R = 6371;
    private final double P = Math.PI / 180.0;

    public double getDistance(double latFrom, double lonFrom, double latTo, double lonTo) {
        double a = 0.5 - Math.cos((latTo - latFrom) * P) / 2.0 +
                Math.cos(latFrom * P) * Math.cos(latTo * P) * (1 - Math.cos((lonTo - lonFrom) * P)) / 2;
        return 2 * R * Math.asin(Math.sqrt(a));
    }
}
