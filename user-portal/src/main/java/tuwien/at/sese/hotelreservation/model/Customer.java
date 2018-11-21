package tuwien.at.sese.hotelreservation.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;

/**
 * The Class Customer.
 */
@Entity
@Table(name = "customer")
public class Customer extends Person implements Serializable
{

    @Column
    private String customerNumber;

    @Column
    private String firmenname;

    @Column
    private String webadresse;

    @Column
    private String fax;

    @Embedded
    private Address billAddress;

    @OneToMany(mappedBy = "customer", cascade = {CascadeType.ALL})
    private Collection<Reservation> reservations = new ArrayList<>();

    public Customer()
    {

    }

    public Customer(final String email, final String name, final LocalDate dateOfBirth)
    {
        this.setEmail(email);
        this.setFirstName(name);
        this.setBirtdate(dateOfBirth);
    }

    /**
     * Gets the customer number.
     *
     * @return the customer number
     */
    public String getCustomerNumber()
    {
        return customerNumber;
    }

    /**
     * Sets the customer number.
     *
     * @param customerNumber the new customer number
     */
    public void setCustomerNumber(String customerNumber)
    {
        if (this.getId() != null)
        {
            this.customerNumber = (this.getId() + 1000) + "";
        }
    }

    /**
     * Gets the firmenname.
     *
     * @return the firmenname
     */
    public String getFirmenname()
    {
        return firmenname;
    }

    /**
     * Sets the firmenname.
     *
     * @param firmenname the new firmenname
     */
    public void setFirmenname(String firmenname)
    {
        this.firmenname = firmenname;
    }

    /**
     * Gets the webadresse.
     *
     * @return the webadresse
     */
    public String getWebadresse()
    {
        return webadresse;
    }

    /**
     * Sets the webadresse.
     *
     * @param webadresse the new webadresse
     */
    public void setWebadresse(String webadresse)
    {
        this.webadresse = webadresse;
    }

    /**
     * Gets the bill address.
     *
     * @return the bill address
     */
    public Address getBillAddress()
    {
        return billAddress;
    }

    /**
     * Sets the bill address.
     *
     * @param billAddress the new bill address
     */
    public void setBillAddress(Address billAddress)
    {
        this.billAddress = billAddress;
    }

    /**
     * Gets the reservations.
     *
     * @return the reservations
     */
    public Collection<Reservation> getReservations()
    {
        return reservations;
    }

    /**
     * Sets the reservations.
     *
     * @param reservations the new reservations
     */
    public void setReservations(Collection<Reservation> reservations)
    {
        this.reservations = reservations;
    }

    /**
     * @return
     */
    public String getFax()
    {
        return fax;
    }

    /**
     * @param fax
     */
    public void setFax(String fax)
    {
        this.fax = fax;
    }
}
