package com.motion.lab.khatib.model;

import java.io.Serializable;

/**
 * Created by maaakbar on 8/21/16.
 */
public class Masjid implements Serializable{
    private String name, address;
    private String officerName, officerMail, officerPhone;

    public Masjid(String name, String address, String officerName, String officerMail, String officerPhone) {
        this.name = name;
        this.address = address;
        this.officerName = officerName;
        this.officerMail = officerMail;
        this.officerPhone = officerPhone;
    }

    public String getName() {
        return name;
    }

    public Masjid setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Masjid setAddress(String address) {
        this.address = address;
        return this;
    }

    public String getOfficerName() {
        return officerName;
    }

    public Masjid setOfficerName(String officerName) {
        this.officerName = officerName;
        return this;
    }

    public String getOfficerMail() {
        return officerMail;
    }

    public Masjid setOfficerMail(String officerMail) {
        this.officerMail = officerMail;
        return this;
    }

    public String getOfficerPhone() {
        return officerPhone;
    }

    public Masjid setOfficerPhone(String officerPhone) {
        this.officerPhone = officerPhone;
        return this;
    }
}
