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

    public String getName() {
        return name;
    }

    public String getTelefonnummer() {
        return telefonnummer;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the nachricht.
     *
     * @return the nachricht
     */
    public String getNachricht() {
        return nachricht;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the telefonnummer.
     *
     * @param telefonnummer the new telefonnummer
     */
    public void setTelefonnummer(String telefonnummer) {
        this.telefonnummer = telefonnummer;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Sets the nachricht.
     *
     * @param nachricht the new nachricht
     */
    public void setNachricht(String nachricht) {
        this.nachricht = nachricht;
    }

}
