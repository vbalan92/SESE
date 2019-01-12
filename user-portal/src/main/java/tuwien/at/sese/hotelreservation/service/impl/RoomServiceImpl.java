package tuwien.at.sese.hotelreservation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tuwien.at.sese.hotelreservation.api.dto.RoomDTO;
import tuwien.at.sese.hotelreservation.model.Reservation;
import tuwien.at.sese.hotelreservation.model.Room;
import tuwien.at.sese.hotelreservation.repository.RoomRepository;
import tuwien.at.sese.hotelreservation.service.RoomService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Abbas ULUSOY
 */
@Service
public class RoomServiceImpl implements RoomService
{

    @Autowired
    private RoomRepository repository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Room create(Room room)
    {
        return repository.save(room);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Room delete(Long id)
    {
        Room room = findById(id);
        if (room != null)
        {
            repository.delete(room);
        }
        return room;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<RoomDTO> findAll()
    {
        return repository.findAll().stream()
            .map(room -> new RoomDTO(room))
            .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Room findById(Long id)
    {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Room update(Room room)
    {
        return repository.save(room);
    }

    @Override
    public List<RoomDTO> searchRooms(final LocalDate fromDate, final LocalDate toDate, final Integer capacity,
        BigDecimal fromPrice, BigDecimal toPrice)
    {
        final List<Room> byCapacityGreaterThanEqual = repository.findByCapacityGreaterThanEqual(capacity);
        return byCapacityGreaterThanEqual.stream()
            .filter(room -> isInPriceRange(room, fromPrice, toPrice) && isAvailable(room, fromDate, toDate))
            .map(RoomDTO::new)
            .collect(Collectors.toList());
    }

    private boolean isInPriceRange(final Room room, final BigDecimal fromPrice, final BigDecimal toPrice)
    {
        final BigDecimal from = fromPrice == null ? BigDecimal.ZERO : fromPrice;
        final BigDecimal pricePerNight = room.getPricePerNight();

        return pricePerNight.compareTo(from) >= 0 && (toPrice == null || pricePerNight.compareTo(toPrice) <= 0);
    }

    private boolean isAvailable(final Room room, final LocalDate fromDate, final LocalDate toDate)
    {
        return room.getReservations().stream()
        .noneMatch(reservation -> isReservedInPeriod(reservation, fromDate, toDate));
    }

    private boolean isReservedInPeriod(final Reservation reservation, final LocalDate fromDate, final LocalDate toDate)
    {
        final LocalDate reservationFromDate = reservation.getFromDate();
        final LocalDate reservationToDate = reservation.getToDate();

        final boolean startsInRequestedPeriod =
            (reservationFromDate.isAfter(fromDate) || reservationFromDate.isEqual(fromDate))
                && reservationFromDate.isBefore(toDate);
        final boolean endsInRequestedPeriod =
            reservationToDate.isAfter(fromDate)
                && (reservationToDate.isBefore(toDate) || reservationToDate.isEqual(toDate));
        return startsInRequestedPeriod || endsInRequestedPeriod;
    }
}
