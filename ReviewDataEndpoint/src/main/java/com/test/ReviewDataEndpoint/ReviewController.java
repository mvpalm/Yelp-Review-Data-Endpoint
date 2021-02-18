package com.test.ReviewDataEndpoint;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ReviewController {
	//Note: this will need to be changed if I refresh the API key.
	private final String API_KEY = "id9Y8qnHCVwq5XvKTXrtXQNefdle4dg4JTZuomhA-7dk8J0ub-2MUnuwrfHeAhzg-z90qxbK7DBDPheFW0ljzt8xd_QRhtyTcjynPsxulqt9r2ThO5WRJ1qZ4tQtYHYx";
	
	@Autowired
	RestTemplate restTemplate;

	@GetMapping("/")
	public String reviews() {
		HttpHeaders headers = new HttpHeaders();
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.setBearerAuth(API_KEY);
		HttpEntity <String> entity = new HttpEntity<String>(headers);
		
		//Ideally, I would get the restaurant id by searching for it via the business match API, but restTemplate.exchange doesn't seem to play nice with Lists or arrays.
//		String businessURL = "https://api.yelp.com/v3/businesses/matches?name=Lucrezia Italian Ristorante&address1=302 S Main St&city=Crown Point&state=IN&country=US";
//		ResponseEntity<BusinessList> businesses = restTemplate.exchange(businessURL, HttpMethod.GET, entity, BusinessList.class);
//		String restaurantId = businesses.getBody().businesses[0].getId();
		String restaurantId = "MFgvgB07_TteUC3Zzep-xQ";
		String reviewURL = String.format("https://api.yelp.com/v3/businesses/%s/reviews", restaurantId);
		return restTemplate.exchange(reviewURL, HttpMethod.GET, entity, String.class).getBody();
	}
}
