package tuwien.at.sese.hotelreservation.application.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import tuwien.at.sese.hotelreservation.model.Address;
import tuwien.at.sese.hotelreservation.model.Contact;
import tuwien.at.sese.hotelreservation.model.Customer;
import tuwien.at.sese.hotelreservation.model.Event;
import tuwien.at.sese.hotelreservation.model.Reservation;
import tuwien.at.sese.hotelreservation.model.Room;
import tuwien.at.sese.hotelreservation.model.RoomType;
import tuwien.at.sese.hotelreservation.model.User;

/**
 * The Class ITUTIL.
 */
public class ITUtil {

    /**
     * Creates the dummy customer.
     *
     * @return the customer
     */
    public static Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Abbas");
        customer.setLastName("Ulusoy");
        customer.setEmail("ab@c.com");
        customer.setFirmenname("Firme");
        customer.setCustomerNumber("0001");
        customer.setBillAddress(createDummyAddress());
       
        return customer;
    }

    /**
     * Creates the dummy address.
     *
     * @return the address
     */
    public static Address createDummyAddress() {
        Address address = new Address();
        address.setBezirk("1100");
        address.setHausnr("XXX Strasse");
        address.setHausnr("2");
        address.setPostleitzahl("1100");
        address.setTuerNr("34");
        return address;

    }

    /**
     * Creates the dummy reservation.
     *
     * @return the reservation
     */
    public static Reservation createDummyReservation(Room room) {
        Reservation reservation = new Reservation();
        LocalDate date = LocalDate.now();

        reservation.setFromDate(date);
        reservation.setToDate(date.plusDays(10));
        reservation.setDiscount("5");
        reservation.setRoom(room);
        
        return reservation;
    }
    
    /**
     * Creates the dummy event.
     *
     * @return the event
     */
    public static Event createDummyEvent(User user) {
        Event event = new Event();
        LocalDate date = LocalDate.now();

        event.setFromDate(date);
        event.setToDate(date.plusDays(10));
        event.setEventName("URLAUB");
        event.setUser(user);
        
        return event;
    }

    /**
     * Creates the dummy reservation.
     *
     * @return the reservation
     */
    public static Contact createDummyContact() {
        Contact contact = new Contact();
        contact.setEmail("abbas@email.com");
        contact.setName("abbas");
        contact.setNachricht("fsdfsdfsdfdfs hello "
                + "fsdfsdfsdfdfs hellofsdfsdfsdfdfs hellofsdfsdfsdfdfs hellofsdfsdfsdfdfs hellofsdfsdfsdfdfs hello"
                + "fsdfsdfsdfdfs hellofsdfsdfsdfdfs hellofsdfsdfsdfdfs hello" + "fsdfsdfsdfdfs hellofsdfsdfsdfdfs hello"
                + "fsdfsdfsdfdfs hellofsdfsdfsdfdfs hello" + "");
        return contact;
    }

    /**
     * Creates the dummy room.
     *
     * @return the room
     */
    public static Room createDummyRoom() {
        Room room = new Room();
        room.setCapacity(4);
        room.setName("Room1");
        room.setNumber("100");
        room.setPricePerNight(BigDecimal.valueOf(100));
        room.setDescription("description descriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescription");
        room.setType(RoomType.EZ);
        return room;
    }

    /**
     * Creates the dummy rooms.
     *
     * @return the list
     */
    public static List<Room> createDummyRooms() {
        List<Room> rooms = new ArrayList<>();
        Room room = new Room();
        for (int i = 100; i < 150; i = i + 2) {
            room.setCapacity(4);
            room.setName("Room::" + i);
            room.setNumber("" + i);
            room.setPricePerNight(BigDecimal.valueOf(i));
            room.setDescription("description descriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescriptiondescription");
            rooms.add(room);
            if(i<120) {
            room.setType(RoomType.DZ);
            } else if(i> 120 && i < 130) {
            	room.setType(RoomType.EZ);
            }else {
            	room.setType(RoomType.VIP);
            }
        }
        return rooms;
    }

}
