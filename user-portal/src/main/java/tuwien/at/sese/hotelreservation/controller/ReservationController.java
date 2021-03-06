package tuwien.at.sese.hotelreservation.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tuwien.at.sese.hotelreservation.api.dto.ReservationDTO;
import tuwien.at.sese.hotelreservation.api.dto.ReservationDetailDTO;
import tuwien.at.sese.hotelreservation.model.Reservation;
import tuwien.at.sese.hotelreservation.service.ReservationService;

/**
 * The Class ReservationController.
 */
@RestController
@RequestMapping({"/api/reservations"})
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    /**
     * Creates the.
     *
     * @param reservationDTO the reservationDTO
     * @return the reservationDTO
     */
    @PostMapping
    public ReservationDTO create(@RequestBody ReservationDTO reservationDTO){

        return reservationService.create(reservationDTO);
    }

    /**
     * Find one.
     *
     * @param id the id
     * @return the reservation
     */
    @GetMapping(path = {"/{id}"})
    public Reservation findOne(@PathVariable("id") Long id){
        return reservationService.findById(id);
    }

    /**
     * Update.
     *
     * @param id the id
     * @param reservation the reservation
     * @return the reservation
     */
    @PutMapping(path = {"/{id}"})
    @PreAuthorize("hasRole('ADMIN')")
    public ReservationDetailDTO update(@PathVariable("id") Long id, @RequestBody ReservationDTO reservation)
    {
        return reservationService.update(reservation);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @return the reservation
     */
    @DeleteMapping(path ={"/{id}"})
    public Reservation delete(@PathVariable("id") Long id) {
        return reservationService.delete(id);
    }

    /**
     * Find all.
     *
     * @return the list
     */
    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public List<ReservationDetailDTO> findAll(){
        return reservationService.findAll().stream()
            .map(ReservationDetailDTO::new)
            .collect(Collectors.toList());
    }
}