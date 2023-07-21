package vttp2023.batch3.assessment.paf.bookings;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp2023.batch3.assessment.paf.bookings.models.Listings;
import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;
import vttp2023.batch3.assessment.paf.bookings.services.ListingsService;

@SpringBootApplication
public class BookingsApplication {

	@Autowired
	ListingsRepository listingRepo;

	@Autowired
	ListingsService listingSvc;
	public static void main(String[] args) {
		SpringApplication.run(BookingsApplication.class, args);
	}

	// @Override
	// public void run(String... args) throws Exception {
	// 	// List<Document> search = listingRepo.getSearchResults("Australia");
	// 	// for(Document d : search) {
	// 	// 	System.out.println(d);
	// 	// }

	// 	System.out.println("CMD LINE RUNNER >>>>>>>>>>>>>"+listingSvc.findVacancyById("95560"));
	// }
}
