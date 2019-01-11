package tuwien.at.sese.hotelreservation.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import tuwien.at.sese.hotelreservation.api.dto.EventDTO;
import tuwien.at.sese.hotelreservation.api.dto.ReservationDTO;

@Entity
public class Event extends EntityId {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String eventName;
	private LocalDate fromDate;
	private LocalDate toDate;

	@ManyToOne
	@JoinColumn(name = "USER_ID")
	private User user;

	public Event(final String eventName, final LocalDate fromDate, final LocalDate toDate, final User user) {
		this.eventName = eventName;
		this.fromDate = fromDate;
		this.toDate = toDate;
		this.user = user;
	}

	public Event(final EventDTO eventDTO) {
		this.fromDate = eventDTO.getFrom();
		this.toDate = eventDTO.getTo();
		this.eventName = eventDTO.getEventName();
	}

	public String getEventName() {
		return eventName;
	}

	public void setEventName(String eventName) {
		this.eventName = eventName;
	}

	public LocalDate getFromDate() {
		return fromDate;
	}

	public void setFromDate(LocalDate fromDate) {
		this.fromDate = fromDate;
	}

	public LocalDate getToDate() {
		return toDate;
	}

	public void setToDate(LocalDate toDate) {
		this.toDate = toDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
