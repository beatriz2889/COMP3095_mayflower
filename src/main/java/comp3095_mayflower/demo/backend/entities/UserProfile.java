/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the entity class for the userprofile table. All of the columns
 for the user profile table are defined here. The table is joined to the user table so
 that the user id is added as a column in user profile table.The reason for this is so
 that session tracking can be done as the profiles will be using the user session controller,
 which in turn uses the user id to track which user is currently logged into the system.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend.entities;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.*;
import java.util.Date;

@Entity
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userprofileid;
    @Column(unique = true)
    private String firstname;
    @Column(unique = true)
    private String lastname;
    private String email;
    @Column(unique = true)
    private Date dob;
    private String address;
    private String city;
    private String country;
    private String postalcode;
    private boolean defaultbilling;
    private boolean defaultshipping;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public UserProfile(){}


    public UserProfile(String firstname,String lastname,String email, Date dob, String address,String city,String country, String postalcode,boolean defaultbilling, boolean defaultshipping, User user){

        this.firstname=firstname;
        this.lastname=lastname;
        this.email=email;
        this.dob=dob;
        this.address=address;
        this.city=city;
        this.country=country;
        this.postalcode=postalcode;
        this.defaultbilling=defaultbilling;
        this.defaultshipping=defaultshipping;
        this.user=user;
    }

    @Override
    public String toString(){
        return String.format("User Profile[id=%d, firstname='%s', lastname='%s', email='%s', address='%s', date of birth='%s', city='%s', country='%s',postal code='%s',default billing='%s',default shipping='%s']",
                userprofileid,firstname,lastname,email,address,dob,city,country,postalcode,defaultbilling,defaultshipping);
    }

    public int getUserprofileid() {
        return userprofileid;
    }

    public void setUserprofileid(int userprofileid) {
        this.userprofileid = userprofileid;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public boolean isDefaultbilling() {
        return defaultbilling;
    }

    public void setDefaultbilling(boolean defaultbilling) {
        this.defaultbilling = defaultbilling;
    }

    public boolean isDefaultshipping() {
        return defaultshipping;
    }

    public void setDefaultshipping(boolean defaultshipping) {
        this.defaultshipping = defaultshipping;
    }
}
