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

    protected User(){}

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

    public String getRole(){return role;}
}
