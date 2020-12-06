package comp3095_mayflower.demo.backend.entities;

import javax.persistence.*;

@Entity

public class Support {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String firstname;
    private String email;

    private String subject;


    private String message;

    public Support(){}

    public Support(String firstname, String email, String subject,String message){

        this.firstname=firstname;
        this.email=email;
        this.subject=subject;
        this.message=message;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSubject() {
        return subject;
    }



    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
