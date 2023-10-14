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
    private long id;
    private String address, bnkcd, code;
    private double latitude, longitude;
    @Column(name = "working_hours")
    private String workingHours;

    public ATM(String address, String bnkcd, String code, double latitude, double longitude, String workingHours) {
        this.address = address;
        this.bnkcd = bnkcd;
        this.code = code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.workingHours = workingHours;
    }
}