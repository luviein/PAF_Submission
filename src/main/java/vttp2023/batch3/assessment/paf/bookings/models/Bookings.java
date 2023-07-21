package vttp2023.batch3.assessment.paf.bookings.models;

import java.sql.Date;

public class Bookings {
    private String name;
    private String email;
    private Date arrival;
    private Integer stay;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Date getArrival() {
        return arrival;
    }
    public void setArrival(Date arrival) {
        this.arrival = arrival;
    }
    public Integer getStay() {
        return stay;
    }
    public void setStay(Integer stay) {
        this.stay = stay;
    }
    @Override
    public String toString() {
        return "Bookings [name=" + name + ", email=" + email + ", arrival=" + arrival + ", stay=" + stay + "]";
    }

    
    
}
