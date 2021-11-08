package MovieCatalogServiceApplication;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

	@Autowired
	private RestTemplate template;
	
	//@Autowired
	//public WebClient.Builder getWebClientBuilder;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem>   getCatalog(@PathVariable("userId") String userId){
		
	
		  
		
		//get all movie Ids
		//for each movie id call movie info service and get details
		//put them all together
		
//		List<Rating> ratings=Arrays.asList(
//				new Rating("1234",4),
//				new  Rating("5678",3)
//				
//				);
		
		UserRating ratings=template.getForObject("http://movie-rating-service/ratingsdata/user/"+userId, UserRating.class);
		System.out.println(ratings.getUserId());
		
		return  ratings.getRatings().stream().map(rating -> {
		Movie movie=template.getForObject("http://movie-info-service/movies/"+rating.getMovieid(), Movie.class);
		return new CatalogItem(movie.getName(),movie.getName(),rating.getRating());
		   
		 }).collect(Collectors.toList());
		 
		
//		return ratings.stream().map(rating -> {
//			new CatalogItem("titanic","Test",4);
//			}).collect(Collectors.toList());
//		
		
	  //return Collections.singletonList(new CatalogItem("tit","test",4));
	
	}
}
