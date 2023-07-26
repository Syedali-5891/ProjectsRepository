package syed.ali.moviesapp;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reviewsIds")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {
	@Id
	private Object id;
	private String body;
	
	public Review(String body) {
		super();
		this.body = body;
	}

	
}
