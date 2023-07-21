package vttp2023.batch3.assessment.paf.bookings.models;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;


public class Listings {
    @NotNull(message="Country must not be null")
    @NotEmpty(message="Country must not be empty")
    private String country;

    @Min(value=1, message="Value should be more than 1")
    @Max(value=10, message="Value should not be more than 10")
    private Integer accomodates;

    @Min(value =1, message="Value should be more than 1")
    @Max(value=10_000, message="Maximum value is 10000")
    private Double price;

    private String images;

    private String name;
    
    private String id;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getAccomodates() {
        return accomodates;
    }

    public void setAccomodates(Integer accomodates) {
        this.accomodates = accomodates;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Listings [country=" + country + ", accomodates=" + accomodates + ", price=" + price + ", images="
                + images + ", name=" + name + ", id=" + id + "]";
    }

    
    
    
}
