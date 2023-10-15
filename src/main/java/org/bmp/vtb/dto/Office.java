package org.bmp.vtb.dto;

import lombok.Data;

@Data
public class Office {
    private long id;
    private double latitude, longitude;

    public Office(org.bmp.vtb.entity.Office office) {
        this.id = office.getId();
        this.latitude = office.getLatitude();
        this.longitude = office.getLongitude();
    }
}
