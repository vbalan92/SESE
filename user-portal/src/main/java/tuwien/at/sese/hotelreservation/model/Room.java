package tuwien.at.sese.hotelreservation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * The Class Room.
 */
@Entity
public class Room extends EntityId implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String name;
	private String number;
	private int capacity;
	private double price;
	private RoomType type;
	private String description;
	private String mainPicture;
	
	@OneToMany(targetEntity = Reservation.class, mappedBy = "room")
    private Collection<Reservation> reservations= new ArrayList<>();
	
	
    /**
     * Gets the name.
     *
     * @return the name
     */
	public String getName() {
		return name;
	}

    /**
     * Sets the name.
     *
     * @param name the new name
     */
	public void setName(String name) {
		this.name = name;
	}

    /**
     * Gets the number.
     *
     * @return the number
     */
	public String getNumber() {
		return number;
	}

    /**
     * Sets the number.
     *
     * @param number the new number
     */
	public void setNumber(String number) {
		this.number = number;
	}

    public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public RoomType getType() {
		return type;
	}

	public void setType(RoomType type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMainPicture() {
		return mainPicture;
	}

	public void setMainPicture(String mainPicture) {
		this.mainPicture = mainPicture;
	}

	/**
     * Gets the price DZ.
     *
     * @return the price DZ
     */
	public double getPriceDZ() {
		return price * 2;
	}

    /**
     * Gets the price tree occupancy.
     *
     * @return the price tree occupancy
     */
	public double getPriceTreeOccupancy() {
		return (price * 3) - ((price * 100) / 20);
	}

    /**
     * Gets the price EZ mit one child.
     *
     * @return the price EZ mit one child
     */
	public double getPriceEZMitOneChild() {
		return price + ((price * 100) / 25);
	}

    /**
     * Gets the price EZ mit two child.
     *
     * @return the price EZ mit two child
     */
	public double getPriceEZMitTwoChild() {
		return price + capacity * ((price * 100) / 25);
	}

    /**
     * Gets the price DZ mit child.
     *
     * @return the price DZ mit child
     */
	public double getPriceDZMitChild() {
		return getPriceDZ() + capacity * ((getPriceDZ() * 100) / 25);
	}
	
}
