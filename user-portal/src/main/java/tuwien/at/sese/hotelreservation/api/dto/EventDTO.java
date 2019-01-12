package tuwien.at.sese.hotelreservation.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import tuwien.at.sese.hotelreservation.model.Event;
import tuwien.at.sese.hotelreservation.model.Room;
import tuwien.at.sese.hotelreservation.model.RoomType;
import tuwien.at.sese.hotelreservation.model.User;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * @author xsk
 */
public class EventDTO {
	private Long id;
	private String eventName;
	private String name;
	private String username;
	private String email;
	private LocalDate from;
	private LocalDate to;
	private Long userId;

	@JsonCreator
	public EventDTO(@JsonProperty("id") final Long id, @JsonProperty("eventName")final String eventName,@JsonProperty("name") final String name,
			@JsonProperty("username") final String username, @JsonProperty("userId") final Long userId,@JsonProperty("email") final String email,
			@JsonProperty("from") @JsonFormat(shape = JsonFormat.Shape.STRING,
			pattern = "yyyy-MM-dd") final LocalDate from, @JsonProperty("to") @JsonFormat(shape = JsonFormat.Shape.STRING,
			pattern = "yyyy-MM-dd") final LocalDate to) {
		this.id = id;
		this.eventName = eventName;
		this.userId = userId;
		this.name = name;
		this.username = username;
		this.email = email;
		this.from = from;
		this.to = to;
	}

	public EventDTO(final Event event) {
		this.id = event.getId();
		this.eventName = event.getEventName();
		if (event.getUser() != null) {
			User user = event.getUser();
			this.username = user.getUsername();
			this.email = user.getEmail();
			this.userId = user.getId();
			this.name = user.getName();
		}
		this.from = event.getFromDate();
		this.to = event.getToDate();
	}

	public Long getId() {
		return id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFrom() {
		return from;
	}

	public void setFrom(LocalDate from) {
		this.from = from;
	}

	public LocalDate getTo() {
		return to;
	}

	public void setTo(LocalDate to) {
		this.to = to;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
}
