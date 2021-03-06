package tuwien.at.sese.hotelreservation.repository;

import org.springframework.data.repository.Repository;
import tuwien.at.sese.hotelreservation.model.Room;

import java.util.List;

/**
 * The Interface RoomRepository.
 */
public interface RoomRepository extends Repository<Room, Long> {

    /**
     * Delete.
     *
     * @param room the room
     */
    void delete(Room room);

    /**
     * Find all.
     *
     * @return the list
     */
    List<Room> findAll();

    /**
     * Find one.
     *
     * @param id the id
     * @return the room
     */
    Room findById(Long id);

    /**
     * Save.
     *
     * @param room the room
     * @return the room
     */
    Room save(Room room);

    List<Room> findByCapacityGreaterThanEqual(Integer capacity);
}
