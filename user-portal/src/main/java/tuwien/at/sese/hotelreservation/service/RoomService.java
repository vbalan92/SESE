package tuwien.at.sese.hotelreservation.service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import tuwien.at.sese.hotelreservation.api.dto.RoomDTO;
import tuwien.at.sese.hotelreservation.model.Room;

/**
 * The interface RoomService.
 */
public interface RoomService {

    /**
     * Creates the.
     *
     * @param Room the room
     * @return the room
     */
    Room create(Room Room);

    /**
     * Delete.
     *
     * @param id the id
     * @return the room
     * 
     */
    Room delete(Long id);

    /**
     * Find all.
     *
     * @return the list
     */
    List<RoomDTO> findAll();

    /**
     * Find by id.
     *
     * @param id the id
     * @return the room
     */
    Room findById(Long id);

    /**
     * Update.
     *
     * @param room the room
     * @return the room
     */
    Room update(Room room);

    List<RoomDTO> searchRooms(LocalDate fromDate, LocalDate toDate, Long capacity, BigDecimal fromPrice, BigDecimal toPrice);
}
