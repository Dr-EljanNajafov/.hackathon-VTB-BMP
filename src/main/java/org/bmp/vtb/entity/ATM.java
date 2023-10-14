package org.bmp.vtb.entity;

import jakarta.persistence.*;


@Entity
@Table(schema = "data", name = "atms")
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

    public ATM() {
    }

    public ATM(String address, String bnkcd, String code, double latitude, double longitude, boolean allDay) {
        this.address = address;
        this.bnkcd = bnkcd;
        this.code = code;
        this.latitude = latitude;
        this.longitude = longitude;
        this.allDay = allDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBnkcd() {
        return bnkcd;
    }

    public void setBnkcd(String bnkcd) {
        this.bnkcd = bnkcd;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public boolean isAllDay() {
        return allDay;
    }

    public void setAllDay(boolean allDay) {
        this.allDay = allDay;
    }

    @Override
    public String toString() {
        return "ATM{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", bnkcd='" + bnkcd + '\'' +
                ", code='" + code + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", allDay=" + allDay +
                '}';
    }
}

