package tuwien.at.sese.hotelreservation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tuwien.at.sese.hotelreservation.api.dto.RoomDTO;
import tuwien.at.sese.hotelreservation.model.Room;
import tuwien.at.sese.hotelreservation.service.RoomService;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/**
 * The Class RoomController.
 */
@RestController
@RequestMapping({ "/api/rooms" })
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * Creates the.
     *
     * @param room the room
     * @return the room
     */
    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public Room create(@RequestBody Room room) {
        return roomService.create(room);
    }

    /**
     * Find one.
     *
     * @param id the id
     * @return the room
     */
    @GetMapping(path = {"/{id}"})
    public Room findOne(@PathVariable("id") Long id) {
        return roomService.findById(id);
    }

    /**
     * Update.
     *
     * @param id the id
     * @param room the room
     * @return the room
     */
    @PutMapping(path = {"/{id}"})
    @PreAuthorize("hasRole('ADMIN')")
    public Room update(@PathVariable("id") Long id, @RequestBody Room room) {
        room.setId(id);
        return roomService.update(room);
    }

    /**
     * Delete.
     *
     * @param id the id
     * @return the room
     */
    @DeleteMapping(path ={"/{id}"})
    @PreAuthorize("hasRole('ADMIN')")
    public Room delete(@PathVariable("id") Long id) {
        return roomService.delete(id);
    }

    @GetMapping
    public List<RoomDTO> searchRooms(
         @RequestParam final Long from,
         @RequestParam final Long to,
         @RequestParam(required = false) final BigDecimal fromPrice,
         @RequestParam(required = false) final BigDecimal toPrice,
         @RequestParam final Long capacity)
    {
        LocalDate fromDate = null;
        LocalDate toDate = null;

        if (from != null)
        {
            fromDate = new Date(from).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        if (to != null)
        {
            toDate = new Date(to).toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }

        return roomService.searchRooms(fromDate, toDate, capacity, fromPrice, toPrice);
    }
}