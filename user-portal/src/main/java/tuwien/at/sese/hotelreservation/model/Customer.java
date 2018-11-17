package tuwien.at.sese.hotelreservation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.AssociationOverride;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * The Class Customer.
 */
@Entity
@Table(name = "customer")
public class Customer extends Person implements Serializable {

	@Column
	private String customerNumber;

	@Column
	private String firmenname;
	@Column
	private String webadresse;
	
	@Column
	private String fax;

	@Embedded
	private Address billAddress;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "CUSTOMERS_RESERVATIONS", joinColumns = @JoinColumn(name = "customer_id"), inverseJoinColumns = @JoinColumn(name = "reservation_id"))
	private Collection<Reservation> reservations = new ArrayList<>();
	
	@OneToOne(targetEntity=Room.class)
    @AssociationOverride(name="room.id", joinColumns=@JoinColumn(name="room_id"))
	private Room room;

	/**
	 * Gets the customer number.
	 *
	 * @return the customer number
	 */
	public String getCustomerNumber() {
		return customerNumber;
	}

	/**
	 * Sets the customer number.
	 *
	 * @param customerNumber
	 *            the new customer number
	 */
	public void setCustomerNumber(String customerNumber) {
		if (this.getId() != null) {
			this.customerNumber = (this.getId() + 1000) + "";
		} 
	}

	/**
	 * Gets the firmenname.
	 *
	 * @return the firmenname
	 */
	public String getFirmenname() {
		return firmenname;
	}

	/**
	 * Sets the firmenname.
	 *
	 * @param firmenname
	 *            the new firmenname
	 */
	public void setFirmenname(String firmenname) {
		this.firmenname = firmenname;
	}

	/**
	 * Gets the webadresse.
	 *
	 * @return the webadresse
	 */
	public String getWebadresse() {
		return webadresse;
	}

	/**
	 * Sets the webadresse.
	 *
	 * @param webadresse
	 *            the new webadresse
	 */
	public void setWebadresse(String webadresse) {
		this.webadresse = webadresse;
	}

	/**
	 * Gets the bill address.
	 *
	 * @return the bill address
	 */
	public Address getBillAddress() {
		return billAddress;
	}

	/**
	 * Sets the bill address.
	 *
	 * @param billAddress
	 *            the new bill address
	 */
	public void setBillAddress(Address billAddress) {
		this.billAddress = billAddress;
	}

	/**
	 * Gets the reservations.
	 *
	 * @return the reservations
	 */
	public Collection<Reservation> getReservations() {
		return reservations;
	}

	/**
	 * Sets the reservations.
	 *
	 * @param reservations
	 *            the new reservations
	 */
	public void setReservations(Collection<Reservation> reservations) {
		this.reservations = reservations;
	}

	/**
	 * @return
	 */
	public String getFax() { return fax; }

	/**
	 * @param fax
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}

	/**
	 * @return room
	 */
	public Room getRoom() { return room;
	}

	/**
	 * @param room
	 */
	public void setRoom(Room room) {
		this.room = room;
	}
	
	
	
	
}
