package comp3095_mayflower.demo.backend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstname;
    private String lastname;
    private String address;
    private String email;
    private String password;
    private String role;

    public User(){}

    public User(String firstname, String lastname, String address, String email, String password,String role){

        this.firstname=firstname;
        this.lastname=lastname;
        this.address=address;
        this.email=email;
        this.password=password;
        this.role=role;
    }

    @Override
    public String toString(){
        return String.format("User[id=%d, firstname='%s', lastname='%s', address='%s', email='%s']",
                id,firstname,lastname,address,email);
    }

    public int getId(){
        return id;
    }

    public String getFirstName(){
        return firstname;
    }

    public String getLastName(){
        return lastname;
    }

    public String getAddress(){
        return address;
    }

    public String getEmail(){
        return email;
    }

    public String getPassword(){return password;}

    public String getRole(){return role;}

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setRole(String role){
        this.role=role;
    }
}
