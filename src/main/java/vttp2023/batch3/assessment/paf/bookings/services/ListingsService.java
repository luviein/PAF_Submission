package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2023.batch3.assessment.paf.bookings.models.Bookings;
import vttp2023.batch3.assessment.paf.bookings.models.ListingDetails;
import vttp2023.batch3.assessment.paf.bookings.models.Listings;
import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;
import vttp2023.batch3.assessment.paf.bookings.repositories.SQLRepository;


@Service
public class ListingsService {
	
	@Autowired
	ListingsRepository listingRepo;

	@Autowired
	SQLRepository SQLRepo;

	//TODO: Task 2
	public List<String> getCountry() {
		return listingRepo.getCountry();
	}
	
	//TODO: Task 3
	public List<Listings> getSearchResults(String country) {
		List<Document> retrieved = listingRepo.getSearchResults(country);
		
		List<Listings> list = new LinkedList<>();
		
		for(Document d : retrieved) {
			Listings listings = new Listings();
			Document c = (Document) d.get("address");
			listings.setCountry(c.getString("country"));
			listings.setAccomodates(d.getInteger("accommodates"));
			Document i = (Document) d.get("images");
			listings.setImages(i.getString("picture_url"));
			Document a = (Document) d.get("address");
			listings.setName(a.getString("street"));
			listings.setPrice(d.getDouble("price"));
			listings.setId(d.getString("_id"));
			
			System.out.println("service >>>>>>>>>>>>>"+listings);
			list.add(listings);
		}
		
		// System.out.println("service >>>>>>>>>>>>>"+list);
		return list;


	}
	// * {"_id" :"10108388"},
	// * 
	// * {"address.street":1,
	// * "address.suburb":1,
	// * "address.country":1,
	// * "price":1,
	// * "images.picture_url": 1,
	// * "amenities": 1},

	//TODO: Task 4
	public List<ListingDetails> getListingDetails(String id) {
		List<Document> retrieved = listingRepo.getListingDetails(id);
		List<ListingDetails> list = new LinkedList<>();
		for(Document d : retrieved) {
			ListingDetails listings = new ListingDetails();
			Document c = (Document) d.get("address");
			listings.setCountry(c.getString("country"));
			listings.setAddressSuburb(c.getString("suburb"));
			listings.setAddressStreet(c.getString("street"));
			listings.setId(d.getString("_id"));
			listings.setPrice(d.getDouble("price"));
			Document i = (Document) d.get("images");
			listings.setImage(i.getString("picture_url"));
			listings.setDescription(d.getString("description"));
			listings.setAmenities((List<Document>)d.get("amenities"));


			System.out.println("service >>>>>>>>>>>>>"+listings);
			list.add(listings);
		}
		
		return list;
	}

	//TODO: Task 5
	public Integer findVacancyById (Integer id) {
		return SQLRepo.findVacancyById(id);
	}

	public Boolean insertReservation (Bookings bookings) {
		return SQLRepo.insertReservation(bookings);
	}
}
