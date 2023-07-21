package vttp2023.batch3.assessment.paf.bookings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vttp2023.batch3.assessment.paf.bookings.models.ListingDetails;
import vttp2023.batch3.assessment.paf.bookings.models.Listings;
import vttp2023.batch3.assessment.paf.bookings.services.ListingsService;

@Controller
@RequestMapping(path = "/landing")
public class ListingsController {
	@Autowired
	ListingsService listingSvc;

	// TODO: Task 2
	@GetMapping()
	public ModelAndView getLanding() {
		ModelAndView mav = new ModelAndView("landingpage");
		mav.addObject("countries", listingSvc.getCountry());

		return mav;
	}

	// TODO: Task 3

	@GetMapping(path = "/search/")
	public ModelAndView getSearchResults(@Valid Listings listings, BindingResult bindingResult,@RequestParam("country") String country,
			@RequestParam("minPriceRange") Integer minPriceRange,
			@RequestParam("maxPriceRange") Integer maxPriceRange,
			HttpSession session
			) {

		if (bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("redirect:/landing");
			return mav;
		}
		List<Listings> list = listingSvc.getSearchResults(country);
		// Set session to save search results
		session.setAttribute("country", country);
		session.setAttribute("minPriceRange", minPriceRange);
		session.setAttribute("maxPriceRange", maxPriceRange);
		

		ModelAndView mav = new ModelAndView("searchresult");
		mav.addObject("search", list);
		mav.addObject("country", country);

		return mav;
	}

	// TODO: Task 4

	@GetMapping(path = "/details/{id}")
	public ModelAndView getListingDetails(@PathVariable("id") String id, HttpSession session) {
		ModelAndView mav = new ModelAndView("listingdetail");
		ListingDetails listingDetails = listingSvc.getListingDetails(id).get(0);
		if (listingDetails == null) {
			ModelAndView mav2 = new ModelAndView("empty");
			return mav2;
		}
		System.out.println("SESSION IN GET SEARCH RESULTS >>>>>>>>"+session.getAttribute("country"));
		session.getAttribute("country");
		session.getAttribute("minPriceRange");
		session.getAttribute("maxPriceRange");

		mav.addObject("details", listingDetails);

		return mav;
	}

	// TODO: Task 5

}
