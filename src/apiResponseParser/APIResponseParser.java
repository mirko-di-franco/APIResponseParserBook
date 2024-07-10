package apiResponseParser;

public class APIResponseParser {

	 public static Book parse(String response) {
	        Book book = new Book();
			String endRule = "<";
			
			
			// Extract and set the title
			String startRule = "<title>";		
			String title = parse(response, startRule, endRule); 
			System.out.println("title: " + title);
		    book.setTitle(title);
		    
		    
		    // Extract and set the author
			startRule = "<name>";
			String author = parse(response, startRule, endRule);
			System.out.println("author: " + author);
			book.setAuthor(author);
			
			
			// Extract and set the publication year
			startRule = "<original_publication_year type=\"integer\">";
			String publicationYear = parse(response, startRule, endRule);
			System.out.println("publicationYear: " + publicationYear);
			book.setPublicationYear(Integer.parseInt(publicationYear));
			
			
			// Extract and set the average rating
			startRule = "<average_rating>";
			String averageRating = parse(response, startRule, endRule);
			System.out.println("averageRating: " + averageRating);
			book.setAverageRating(Double.parseDouble(averageRating));
			
			
			// Extract and set the ratings count, removing commas
			startRule = "<ratings_count type=\"integer\">";
			String ratingsCount = parse(response, startRule, endRule);
			System.out.println("ratingsCount: " + ratingsCount);	
			book.setRatingsCount(Integer.parseInt(ratingsCount.replaceAll(",", "")));
			
			
			// Extract and set the image URL
			startRule = "<image_url>";
			String imageUrl = parse(response, startRule, endRule);
			System.out.println("imageUrl: " + imageUrl);
			book.setImageUrl(imageUrl);	
			
			return book;
	     }
	 
	 
	 // Helper method to parse a substring between startRule and endRule
	 private static String parse(String response, String startRule, String endRule){
      response = response.substring(response.indexOf(startRule) + startRule.length());
      
      return response.substring(0, response.indexOf(endRule));
     }
	

	public static void main(String[] args) {
		
		// Example XML response
		String response = "<work>" + 
             "<id type=\"integer\">2361393</id>" +
             "<books_count type=\"integer\">813</books_count>" +
             "<ratings_count type=\"integer\">1,16,315</ratings_count>" + 
             "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
             "<original_publication_year type=\"integer\">1854</original_publication_year>" +
				"<original_publication_month type=\"integer\" nil=\"true\"/>" +
				"<original_publication_day type=\"integer\" nil=\"true\"/>" +
				"<average_rating>3.79</average_rating>" +
				"<best_book type=\"Book\">" +
					"<id type=\"integer\">16902</id>" +
					"<title>Walden</title>" + 
					"<author>" +
						"<id type=\"integer\">10264</id>" + 
						"<name>Henry David Thoreau</name>" + 
					"</author>" +
					"<image_url>" + 
						"http://images.gr-assets.com/books/1465675526m/16902.jpg" +
					"</image_url>" +
					"<small_image_url>" + 
						"http://images.gr-assets.com/books/1465675526s/16902.jpg" +
					"</small_image_url>" +
				"</best_book>" +
			"</work>";

		
		// Parse the response and print the extracted information
		APIResponseParser.parse(response);
		
	}
}
