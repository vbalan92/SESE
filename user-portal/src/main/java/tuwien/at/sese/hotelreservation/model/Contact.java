package tuwien.at.sese.hotelreservation.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * The Class Customer.
 */
@Entity
@Table(name = "contact")
public class Contact extends EntityId implements Serializable
{

    @Column
    private String name;

    @Column
    private String telefonnummer;

    @Column
    private String email;

    @Column(length = 500)
    private String nachricht;


}
