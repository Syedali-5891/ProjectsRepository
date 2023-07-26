package syed.ali.moviesapp;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus( value = HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 123L;
	
	private String field_name;
	private String field;
	private Object Id;
	
	public MovieNotFoundException(String field_name, String field, Object id) {
		super(field_name+" not founf for "+field+" and value "+id);
		this.field_name = field_name;
		this.field = field;
		Id = id;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getField_name() {
		return field_name;
	}

	public String getField() {
		return field;
	}

	public Object getId() {
		return Id;
	}
}
