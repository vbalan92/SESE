package tuwien.at.sese.hotelreservation.api.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import tuwien.at.sese.hotelreservation.model.Room;
import tuwien.at.sese.hotelreservation.model.RoomType;

import java.math.BigDecimal;

/**
 * @author xsk
 */
public class RoomDTO
{
    private Long id;
    private String name;
    private String number;
    private int capacity;
    private BigDecimal pricePerNight;
    private RoomType type;
    private String description;
    private String mainPicture;

    @JsonCreator
    public RoomDTO(final Long id, final String name, final String number, final int capacity,
        final BigDecimal pricePerNight, final RoomType type, final String description, final String mainPicture)
    {
        this.id = id;
        this.name = name;
        this.number = number;
        this.capacity = capacity;
        this.pricePerNight = pricePerNight;
        this.type = type;
        this.description = description;
        this.mainPicture = mainPicture;
    }

    public RoomDTO(final Room room)
    {
        this.id = room.getId();
        this.name = room.getName();
        this.number = room.getNumber();
        this.capacity = room.getCapacity();
        this.pricePerNight = room.getPricePerNight();
        this.type = room.getType();
        this.description = room.getDescription();
        this.mainPicture = room.getMainPicture();
    }

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public String getNumber()
    {
        return number;
    }

    public void setNumber(final String number)
    {
        this.number = number;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public void setCapacity(final int capacity)
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

    public void setType(final RoomType type)
    {
        this.type = type;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(final String description)
    {
        this.description = description;
    }

    public String getMainPicture()
    {
        return mainPicture;
    }

    public void setMainPicture(final String mainPicture)
    {
        this.mainPicture = mainPicture;
    }
}
