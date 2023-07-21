package vttp2023.batch3.assessment.paf.bookings.models;

import java.util.List;

import org.bson.Document;

public class ListingDetails {
    private String id;
    private String description;
    private String addressStreet;
    private String addressSuburb;
    private String country;
    private String image;
    private Double price;
    private List<Document> amenities;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getAddressStreet() {
        return addressStreet;
    }
    public void setAddressStreet(String addressStreet) {
        this.addressStreet = addressStreet;
    }
    public String getAddressSuburb() {
        return addressSuburb;
    }
    public void setAddressSuburb(String addressSuburb) {
        this.addressSuburb = addressSuburb;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }


    
    @Override
    public String toString() {
        return "ListingDetails [id=" + id + ", description=" + description + ", addressStreet=" + addressStreet
                + ", addressSuburb=" + addressSuburb + ", country=" + country + ", image=" + image + ", price=" + price
                + ", amenities=" + amenities + "]";
    }
    public List<Document> getAmenities() {
        return amenities;
    }
    public void setAmenities(List<Document> amenities) {
        this.amenities = amenities;
    }

    
}
