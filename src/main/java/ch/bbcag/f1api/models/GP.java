package ch.bbcag.f1api.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class GP {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id = 0;

    private int year;
    @ManyToOne
    @JoinColumn(name = "drivers_id")
    private Drivers drivers;

    private String gp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public Drivers getDrivers() {
        return drivers;
    }

    public void setDrivers(Drivers drivers) {
        this.drivers = drivers;
    }

    public String getGp() {
        return gp;
    }

    public void setGp(String gp) {
        this.gp = gp;
    }
}
