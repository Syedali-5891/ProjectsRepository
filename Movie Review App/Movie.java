package syed.ali.moviesapp;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// this annotation tells that this class contains each document collection of movie
@Document(collection = "movies")
@Data
@AllArgsConstructor // it creates constructor which accepts below variables as Arguments
@NoArgsConstructor  // it creates constructor with accepts no argument
public class Movie{

	@Id
	private  ObjectId id;
	private  String imdbId;
	private  String title;
	private  String releaseDate;
	private  String trailerLink;
	private  String poster;
	 //this cause to store only Ids of reviews in to separate collection
	@DocumentReference			// this is called manual reference relationship
	private  List<Review> reviewIds;
	public Movie(ObjectId id, String imdbId, String title, String releaseDate, String trailerLink, String poster,
			List<String> genres, List<String> backdrops, List<Review> reviewIds) {
		super();
		this.id = id;
		this.imdbId = imdbId;
		this.title = title;
		this.releaseDate = releaseDate;
		this.trailerLink = trailerLink;
		this.poster = poster;
		this.reviewIds = reviewIds;
	}
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public String getImdbId() {
		return imdbId;
	}
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
	public String getTrailerLink() {
		return trailerLink;
	}
	public void setTrailerLink(String trailerLink) {
		this.trailerLink = trailerLink;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}
	public List<Review> getReviewIds() {
		return reviewIds;
	}
	public void setReviewIds(List<Review> reviewIds) {
		this.reviewIds = reviewIds;
	}
	@Override
	public String toString() {
		return "Movie [Id=" + id + ", imdbId=" + imdbId + ", title=" + title + ", releaseDate=" + releaseDate
				+ ", trailerLink=" + trailerLink + ", poster=" + poster + ", reviewIds=" + reviewIds + "]";
	}
	
}


