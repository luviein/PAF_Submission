package vttp2023.batch3.assessment.paf.bookings.repositories;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import vttp2023.batch3.assessment.paf.bookings.models.Listings;

@Repository
public class ListingsRepository {

	@Autowired
	MongoTemplate template;

	// TODO: Task 2
	/*
	 * db.listings.distinct("address.country")
	 */

	public List<String> getCountry() {
		return template.findDistinct(new Query(), "address.country", "listings", String.class);
	}

	// TODO: Task 3

	/*
	 * db.getCollection("listings").find(
	 * {"address.country" :"Australia", "accommodates": 2},
	 * {"address.street":1, "price":1, "images.picture_url": 1, "accommodates": 1,
	 * "address.country" : 1},{price: {$gte:100}}, {price: {$lt:800}}
	 * ).sort({price:-1})
	 */

	public List<Document> getSearchResults(String country) {
		Query query = Query.query(

				Criteria.where("address.country").is(country)

		)
				.with(Sort.by(Sort.Direction.DESC, "price"));

		query.fields()
				.include("address.country", "accommodates", "price", "images.picture_url", "address.street", "_id");

		return template.find(query, Document.class, "listings");

	}

	// TODO: Task 4

	/*
	 * db.getCollection("listings").find(
	 * 
	 * {"_id" :"10108388"},
	 * 
	 * {"address.street":1,
	 * "address.suburb":1,
	 * "address.country":1,
	 * "price":1,
	 * "images.picture_url": 1,
	 * "amenities": 1},
	 * 
	 * 
	 * )
	 */

	public List<Document> getListingDetails(String id) {
		Query query = Query.query(

				Criteria.where("_id").is(id)

		);

		query.fields()
				.include(
				 "price", 
				 "images.picture_url", 
				 "address.street", 
				 "address.suburb",
				 "address.country",
				 "amenities",
				 "description");

		return template.find(query, Document.class, "listings");
	}

	// TODO: Task 5

}
