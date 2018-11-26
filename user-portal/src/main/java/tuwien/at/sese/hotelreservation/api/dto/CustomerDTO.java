package tuwien.at.sese.hotelreservation.api.dto;

import tuwien.at.sese.hotelreservation.model.Customer;

import javax.persistence.Column;

/**
 * @author xsk
 */
public class CustomerDTO
{
    private Long id;
    private String customerNumber;
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
        this.id = getId();
        this.customerNumber = getCustomerNumber();
        this.firmenname = getFirmenname();
        this.webadresse = getWebadresse();
        this.fax = getFax();
        this.postlandschl = getPostlandschl();
        this.postleitzahl = getPostleitzahl();
        this.bezirk = getBezirk();
        this.strasse = getStrasse();
        this.hausnr = getHausnr();
        this.tuerNr = getTuerNr();
        this.ort = getOrt();
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
}
