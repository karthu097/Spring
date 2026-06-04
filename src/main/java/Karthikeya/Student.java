package Karthikeya;

import jakarta.persistence.Entity;//oRM tool
import jakarta.persistence.Id;

@Entity

public class Student {
    @Id // we are trying to say that the rollno is the primary key
    private int rollNo;
    private String sName;
    private int sAge;

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public int getsAge() {
        return sAge;
    }


    public void setsAge(int sAge) {
        this.sAge = sAge;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
    @Override
    public String toString() {
        return "Main{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                '}';
    }

    public static void main (String[] args){



    }
}
