package tuwien.at.sese.hotelreservation.model;

import tuwien.at.sese.hotelreservation.api.dto.ReservationDTO;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * The Class Reservation.
 */
@Entity
@Table(name = "reservation")
public class Reservation extends EntityId implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Column
    private String discount;

    @Column
    private LocalDate fromDate;

    @Column
    private LocalDate toDate;

    @Column
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "CUSTOMER_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room room;
    
    @Column
    @Enumerated(EnumType.STRING)
    private Status status;

    public Reservation()
    {
    }

    public Reservation(final String discount, final LocalDate fromDate, final LocalDate toDate,
        final BigDecimal price, final Customer customer, final Room room)
    {
        this.discount = discount;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
        this.customer = customer;
        this.room = room;
    }

    public Reservation(final ReservationDTO reservationDTO)
    {
        this.fromDate = reservationDTO.getFromDate();
        this.toDate = reservationDTO.getToDate();
        this.price = reservationDTO.getPrice();
    }

    public String getDiscount()
    {
        return discount;
    }

    public void setDiscount(final String discount)
    {
        this.discount = discount;
    }

    public LocalDate getFromDate()
    {
        return fromDate;
    }

    public void setFromDate(final LocalDate fromDate)
    {
        this.fromDate = fromDate;
    }

    public LocalDate getToDate()
    {
        return toDate;
    }

    public void setToDate(final LocalDate toDate)
    {
        this.toDate = toDate;
    }

    public BigDecimal getPrice()
    {
        return price;
    }

    public void setPrice(final BigDecimal price)
    {
        this.price = price;
    }

    public Customer getCustomer()
    {
        return customer;
    }

    public void setCustomer(final Customer customer)
    {
        this.customer = customer;
    }

    public Room getRoom()
    {
        return room;
    }

    public void setRoom(final Room room)
    {
        this.room = room;
    }

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
    
    
}