package tuwien.at.sese.hotelreservation.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * @author xsk
 */
public class ReservationDTO
{
    private LocalDate fromDate;
    private LocalDate toDate;
    private BigDecimal price;
    private Long roomId;
    private String customerName;
    private String customerEmail;
    private LocalDate customerDateOfBirth;

    @JsonCreator
    public ReservationDTO(
        @JsonProperty("fromDate") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX") final Date fromDate,
        @JsonProperty("toDate") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX") final Date toDate,
        @JsonProperty("price") final BigDecimal price,
        @JsonProperty("roomId") final Long roomId,
        @JsonProperty("customerName") final String customerName,
        @JsonProperty("customerEmail") final String customerEmail,
        @JsonProperty("customerDateOfBirth") @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSX") final Date customerDateOfBirth)
    {
        this.fromDate = fromDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
        this.toDate = toDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
        this.price = price;
        this.roomId = roomId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerDateOfBirth = customerDateOfBirth.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();;
    }

    public ReservationDTO(final LocalDate fromDate, final LocalDate toDate, final BigDecimal price, final Long id, final String firstName, final String email,
        final LocalDate birtdate)
    {
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.price = price;
        this.roomId = roomId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerDateOfBirth = customerDateOfBirth;

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

    public Long getRoomId()
    {
        return roomId;
    }

    public void setRoomId(final Long roomId)
    {
        this.roomId = roomId;
    }

    public String getCustomerName()
    {
        return customerName;
    }

    public void setCustomerName(final String customerName)
    {
        this.customerName = customerName;
    }

    public String getCustomerEmail()
    {
        return customerEmail;
    }

    public void setCustomerEmail(final String customerEmail)
    {
        this.customerEmail = customerEmail;
    }

    public LocalDate getCustomerDateOfBirth()
    {
        return customerDateOfBirth;
    }

    public void setCustomerDateOfBirth(final LocalDate customerDateOfBirth)
    {
        this.customerDateOfBirth = customerDateOfBirth;
    }
}
