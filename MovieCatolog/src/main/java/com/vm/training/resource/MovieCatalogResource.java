package com.vm.training.resource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.vm.training.model.CatalogItems;
import com.vm.training.model.Rating;
import com.vm.training.model.Movie;


@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	
	@RequestMapping("/{userId}")
	public List<CatalogItems> getCatalog(@PathVariable("userId") String userId) {
		//1. get all the rated movie ids freom the ratings service
		RestTemplate restTemplate = new RestTemplate();

		List<Rating> ratingsBag = Arrays.asList(
				new Rating("1234",4),
				new Rating("5678",3)				
				);
				
		
		
		//for each movie id retrieved from the previous MS call send it to MovieInfo and get movie details
		return ratingsBag.stream()                                                  //putting the list of items [emptying the bag on a] conveyor belt
				.map(rating -> {
					Movie movie = restTemplate.getForObject("http://localhost:8083/movies/1", Movie.class);
					return new CatalogItems(movie.getMovieName(), "description", rating.getRating());              				   //converting each rating item moving on the conveyor belt TO  catalogitem
   
				})
				.collect(Collectors.toList());                                                                                     //after all the items have been converted put it back into the bag[list]
		
		//put them together and serve the user
		

	}

}