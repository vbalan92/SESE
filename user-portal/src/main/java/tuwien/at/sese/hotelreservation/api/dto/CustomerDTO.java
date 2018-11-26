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
    private String postlandschl;
    private String postleitzahl;
    private String bezirk;
    private String strasse;
    private String hausnr;
    private String tuerNr;
    private String ort;

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
        if (customer.getBillAddress() != null)
        {
            createAddresse(customer);
        } else {
        	customer.setBillAddress(new Address());
        	createAddresse(customer);
        }
    }

	private void createAddresse(Customer customer) {
		this.postlandschl = customer.getBillAddress().getPostlandschl();
		this.postleitzahl = customer.getBillAddress().getPostleitzahl();
		this.bezirk = customer.getBillAddress().getBezirk();
		this.strasse = customer.getBillAddress().getStrasse();
		this.hausnr = customer.getBillAddress().getHausnr();
		this.tuerNr = customer.getBillAddress().getTuerNr();
		this.ort = customer.getBillAddress().getOrt();
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

    public String getPostlandschl()
    {
        return postlandschl;
    }

    public void setPostlandschl(final String postlandschl)
    {
        this.postlandschl = postlandschl;
    }

    public String getPostleitzahl()
    {
        return postleitzahl;
    }

    public void setPostleitzahl(final String postleitzahl)
    {
        this.postleitzahl = postleitzahl;
    }

    public String getBezirk()
    {
        return bezirk;
    }

    public void setBezirk(final String bezirk)
    {
        this.bezirk = bezirk;
    }

    public String getStrasse()
    {
        return strasse;
    }

    public void setStrasse(final String strasse)
    {
        this.strasse = strasse;
    }

    public String getHausnr()
    {
        return hausnr;
    }

    public void setHausnr(final String hausnr)
    {
        this.hausnr = hausnr;
    }

    public String getTuerNr()
    {
        return tuerNr;
    }

    public void setTuerNr(final String tuerNr)
    {
        this.tuerNr = tuerNr;
    }

    public String getOrt()
    {
        return ort;
    }

    public void setOrt(final String ort)
    {
        this.ort = ort;
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
    
}
