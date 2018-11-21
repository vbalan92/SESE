package tuwien.at.sese.hotelreservation.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;

/**
 * The Class Room.
 */
@Entity
public class Room extends EntityId implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Column
    private String name;

    @Column
    private String number;

    @Column
    private int capacity;

    @Column(name = "PRICE_PER_NIGHT")
    private BigDecimal pricePerNight;

    @Column
    @Enumerated(EnumType.STRING)
    private RoomType type;

    @Column(length = 500)
    private String description;

    @Column
    private String mainPicture;

    @OneToMany(mappedBy = "room")
    private Collection<Reservation> reservations = new ArrayList<>();

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName()
    {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name)
    {
        this.name = name;
    }

    /**
     * Gets the number.
     *
     * @return the number
     */
    public String getNumber()
    {
        return number;
    }

    /**
     * Sets the number.
     *
     * @param number the new number
     */
    public void setNumber(String number)
    {
        this.number = number;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(int capacity)
    {
        this.capacity = capacity;
    }

    public BigDecimal getPricePerNight()
    {
        return pricePerNight;
    }

    public void setPricePerNight(final BigDecimal pricePerNight)
    {
        this.pricePerNight = pricePerNight;
    }

    public RoomType getType()
    {
        return type;
    }

    public void setType(RoomType type)
    {
        this.type = type;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public String getMainPicture()
    {
        return mainPicture;
    }

    public void setMainPicture(String mainPicture)
    {
        this.mainPicture = mainPicture;
    }

    public Collection<Reservation> getReservations()
    {
        return reservations;
    }

    public void setReservations(final Collection<Reservation> reservations)
    {
        this.reservations = reservations;
    }
}
