package co.wfd2;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LoggableEntity {

	public String objToLog() {
		ObjectMapper mapper = new ObjectMapper();

		try {
			return mapper.writeValueAsString(this);

		} catch (JsonProcessingException e) {
			return (String.format("Error mapping Object %s to JSON", this.getClass()));
		}
	}
}
