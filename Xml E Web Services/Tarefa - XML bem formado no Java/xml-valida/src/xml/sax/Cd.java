package xml.sax;

/**
 *
 * @author andre
 */
public class Cd {
    String title, artist, country, company;
    float price;
    int year;

    public String getTitle() {
        return title;
    }

    public String getArtist() {
        return artist;
    }

    public String getCountry() {
        return country;
    }

    public String getCompany() {
        return company;
    }

    public float getPrice() {
        return price;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return title + "\n" + artist + "\n" + country + "\n" + company + "\n" + price + "\n" + year;
    }
}
