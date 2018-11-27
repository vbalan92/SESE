package tuwien.at.sese.hotelreservation.api.dto;

import tuwien.at.sese.hotelreservation.model.Address;
import tuwien.at.sese.hotelreservation.model.Customer;

/**
 * @author xsk
 */
public class CustomerDTO
{
    private Long id;
    private String customerNumber;
    private String email;
    private String firstName;
    private String lastName;
    private String firmenname;
    private String webadresse;
    private String fax;
    private Address billAddress;
    private String rabatt;

    public CustomerDTO(Customer customer)
    {
        this.id = customer.getId();
        this.email = customer.getEmail();
        this.firstName = customer.getFirstName();
        this.lastName  =customer.getLastName();
        this.customerNumber = customer.getCustomerNumber();
        this.firmenname = customer.getFirmenname();
        this.webadresse = customer.getWebadresse();
        this.fax = customer.getFax();
        this.rabatt = customer.getRabatt();

        if (customer.getBillAddress() != null)
        {
            this.billAddress = customer.getBillAddress();
        } else {
            this.billAddress = new Address();
        }
    }



    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public String getCustomerNumber()
    {
        return customerNumber;
    }

    public void setCustomerNumber(final String customerNumber)
    {
        this.customerNumber = customerNumber;
    }

    public String getFirmenname()
    {
        return firmenname;
    }

    public void setFirmenname(final String firmenname)
    {
        this.firmenname = firmenname;
    }

    public String getWebadresse()
    {
        return webadresse;
    }

    public void setWebadresse(final String webadresse)
    {
        this.webadresse = webadresse;
    }

    public String getFax()
    {
        return fax;
    }

    public void setFax(final String fax)
    {
        this.fax = fax;
    }

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

    public Address getBillAddress() {
        return billAddress;
    }

    public String getRabatt() {
        return rabatt;
    }

    public void setBillAddress(Address billAddress) {
        this.billAddress = billAddress;
    }

    public void setRabatt(String rabatt) {
        this.rabatt = rabatt;
    }

}
