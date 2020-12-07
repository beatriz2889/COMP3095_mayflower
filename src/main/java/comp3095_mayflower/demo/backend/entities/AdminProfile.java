/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the entity class for the adminprofile table. All of the columns
 for the admin profile table are defined here. The table is joined to the user table so
 that the user id is added as a column in admin profile table.The reason for this is so
 that session tracking can be done as the profiles will be using the user session controller,
 which in turn uses the user id to track which user is currently logged into the system.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend.entities;
import javax.persistence.*;
import java.util.Date;

@Entity
public class AdminProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int adminprofileid;
    private String firstname;
    private String lastname;
    private String email;
    private Date dob;
    private String address;
    private String city;
    private String country;
    private String postalcode;

    @OneToOne
    @JoinColumn(name="user_id")
    private User user;

    public AdminProfile() {

    }

    public AdminProfile(String firstname,String lastname,String email, Date dob, String address,String city,String country, String postalcode,User user) {

        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.dob = dob;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postalcode = postalcode;
        this.user=user;
    }

    public int getAdminprofileid() {
        return adminprofileid;
    }

    public void setAdminprofileid(int adminprofileid) {
        this.adminprofileid = adminprofileid;
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
}
