package Karthikeya;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Karthu_table") // this changes only the name of the table but not the name of the entity
public class Alien {
    @Id
    private int aid;
    private String aname;
    private String tech;
    @ManyToMany
    private List<Laptop> laptops;// here laptop is the complex type

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;}

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", tech='" + tech + '\'' +
                '}';
    }
}
/*
Alien.toString()
    ↓
prints laptops
    ↓
Laptop.toString()                  this leads to StackOverFlow
    ↓
prints aliens
    ↓
Alien.toString()
    ↓
prints laptops
    ↓
Laptop.toString()
    ↓
...
 */





