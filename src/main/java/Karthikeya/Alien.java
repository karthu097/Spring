package Karthikeya;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;

@Entity
@Table(name="Karthu_table") // this changes only the name of the table but not the name of the entity
public class Alien {
    @Id
    private int aid;

    @Column(name="alien_name") //for changing the column name we use this anotation
    private String aname;
    @Transient // generally we use this for skipping this column
    private String tech;

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

    @Override

    public String toString() {
            return "Alien{" +
                    "aid=" + aid +
                    ", aname='" + aname + '\'' +
                    ", tech='" + tech + '\'' +
                    '}';
        }

    }

