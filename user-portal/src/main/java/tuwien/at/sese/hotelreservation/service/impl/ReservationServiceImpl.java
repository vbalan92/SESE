package tuwien.at.sese.hotelreservation.service.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tuwien.at.sese.hotelreservation.api.dto.ReservationDTO;
import tuwien.at.sese.hotelreservation.api.dto.ReservationDetailDTO;
import tuwien.at.sese.hotelreservation.api.enums.ReservationStatus;
import tuwien.at.sese.hotelreservation.model.Customer;
import tuwien.at.sese.hotelreservation.model.Reservation;
import tuwien.at.sese.hotelreservation.model.Room;
import tuwien.at.sese.hotelreservation.repository.CustomerRepository;
import tuwien.at.sese.hotelreservation.repository.ReservationRepository;
import tuwien.at.sese.hotelreservation.repository.RoomRepository;
import tuwien.at.sese.hotelreservation.service.CustomerService;
import tuwien.at.sese.hotelreservation.service.ReservationService;

import static java.time.temporal.ChronoUnit.DAYS;

/**
 * @author Abbas ULUSOY
 */
@Service
public class ReservationServiceImpl implements ReservationService
{

    @Autowired
    private ReservationRepository repository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private CustomerService customerService;

    /**
     * {@inheritDoc}
     *
     * @param reservationDTO
     */
    @Override
    public ReservationDTO create(final ReservationDTO reservationDTO)
    {
        validateReservation(reservationDTO);

        final Optional<Customer> existingCustomer = customerRepository.findByEmail(reservationDTO.getCustomerEmail());
        final Customer customer = existingCustomer.isPresent()
            ? existingCustomer.get() : createNewCustomer(reservationDTO);

        final Room room = roomRepository.findById(reservationDTO.getRoomId());

        Reservation reservation = new Reservation(reservationDTO);
        reservation.setCustomer(customer);
        reservation.setRoom(room);
        reservation.setStatus(ReservationStatus.CREATED);
        reservation.setPrice(calculateReservationPrice(room.getPricePerNight(), reservationDTO.getFromDate(),
            reservationDTO.getToDate()));

        final Reservation reservationEntity = repository.save(reservation);
        return new ReservationDetailDTO(reservationEntity);
    }

    private void validateReservation(final ReservationDTO reservationDTO)
    {
        if(reservationDTO.getToDate().isBefore(LocalDate.now())
            || reservationDTO.getToDate().isBefore(reservationDTO.getFromDate()))
        {
            throw new IllegalArgumentException();
        }
    }

    private BigDecimal calculateReservationPrice(final BigDecimal pricePerNight, final LocalDate fromDate,
        final LocalDate toDate)
    {
        final long totalDaysCount = DAYS.between(fromDate, toDate);
        return totalDaysCount == 0 ? pricePerNight : pricePerNight.multiply(BigDecimal.valueOf(totalDaysCount));
    }

    private Customer createNewCustomer(final ReservationDTO reservationDTO)
    {
        return customerService.create(new Customer(reservationDTO.getCustomerEmail(),
            reservationDTO.getCustomerName(),
            reservationDTO.getCustomerDateOfBirth()));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Reservation delete(Long id)
    {
        Reservation reservation = findById(id);
        if (reservation != null)
        {
            repository.delete(reservation);
        }
        return reservation;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Reservation> findAll()
    {
        return repository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Reservation findById(Long id)
    {
        return repository.findById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ReservationDetailDTO update(ReservationDTO reservationDTO)
    {
        final Reservation reservation = repository.findById(reservationDTO.getId());
        if (reservation == null)
        {
            return null;
        }
        reservation.setStatus(reservationDTO.getStatus());

        return new ReservationDetailDTO(repository.save(reservation));
    }
}
