package tuwien.at.sese.hotelreservation.api.dto;

import tuwien.at.sese.hotelreservation.model.Reservation;
import tuwien.at.sese.hotelreservation.model.RoomType;

import java.math.BigDecimal;
import java.util.Date;

import javax.net.ssl.SSLEngineResult.Status;

/**
 * @author xsk
 */
public class ReservationDetailDTO extends ReservationDTO {
	private String roomNumber;
	private String roomName;
	private RoomType roomType;
	private String roomMainPicture;

	public ReservationDetailDTO(final Date fromDate, final Date toDate, final BigDecimal price, final Long roomId, final Long id,
			final String customerName, final String customerEmail, final Date customerDateOfBirth,
			final String roomNumber, final String roomName, final RoomType roomType, final String roomMainPicture,
			final String status) {
		super(fromDate, toDate, price, roomId, id, customerName, customerEmail, customerDateOfBirth, status);
		this.roomNumber = roomNumber;
		this.roomName = roomName;
		this.roomType = roomType;
		this.roomMainPicture = roomMainPicture;
	}

	public ReservationDetailDTO(final Reservation reservation) {
		super(reservation.getFromDate(), reservation.getToDate(), reservation.getPrice(), reservation.getRoom().getId(), reservation.getId(),
				reservation.getCustomer().getFirstName(), reservation.getCustomer().getEmail(),
				reservation.getCustomer().getBirtdate(), reservation.getStatus().name());
		this.roomName = reservation.getRoom().getName();
		this.roomType = reservation.getRoom().getType();
		this.roomNumber = reservation.getRoom().getNumber();
		this.roomMainPicture = reservation.getRoom().getMainPicture();

	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(final String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(final String roomName) {
		this.roomName = roomName;
	}

	public RoomType getRoomType() {
		return roomType;
	}

	public void setRoomType(final RoomType roomType) {
		this.roomType = roomType;
	}

	public String getRoomMainPicture() {
		return roomMainPicture;
	}

	public void setRoomMainPicture(final String roomMainPicture) {
		this.roomMainPicture = roomMainPicture;
	}
}
