package org.bmp.vtb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "atms")
public class ATM {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "atm_id")
    private int id;

    @Column(name = "address")
    private String address;

    @Column(name = "bnkcd")
    private String bnkcd;

    @Column(name = "code")
    private String code;

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "allDay")
    private boolean allDay;

    public ATM(String address, String bnkcd, String code, double latitude, double longitude, boolean allDay) {
        this.address = address;
        this.bnkcd = bnkcd;
        this.code = code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.allDay = allDay;
    }
}