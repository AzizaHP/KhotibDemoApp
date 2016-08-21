package com.motion.lab.khatib.model;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by maaakbar on 8/21/16.
 */
public class Jadwal implements Comparable<Jadwal>, Serializable{
    private Masjid masjid;
    private Date date;

    public Jadwal(Masjid masjid, Date date) {
        this.masjid = masjid;
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public Jadwal setDate(Date date) {
        this.date = date;
        return this;
    }

    public Masjid getMasjid() {
        return masjid;
    }

    public Jadwal setMasjid(Masjid masjid) {
        this.masjid = masjid;
        return this;
    }

    @Override
    public int compareTo(@NonNull Jadwal jadwal) {
        return getDate().compareTo(jadwal.getDate());
    }
}
