/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the entity class for the messages table. All of the columns
 for the messages table are defined here. The table is joined to the user table so
 that the user id is added as a column in the messages table.The reason for this is so
 that session tracking can be done as the messages will be using the user session controller,
 which in turn uses the user id to track which user is currently logged into the system.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend.entities;
import org.springframework.lang.Nullable;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class Messages {

    @Id
    @GeneratedValue
    private int ticketnum;
    private String subject;
    private String username;
    private String message;
    private String firstname;
    private String role;
    private int replynum;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Messages(){}

    public Messages( String subject, String username, String message, String firstname,String role,int replynum,User user){
        this.subject=subject;
        this.username=username;
        this.message=message;
        this.firstname=firstname;
        this.role=role;
        this.replynum=replynum;
        this.user=user;
    }



    public int getTicketnum() {
        return ticketnum;
    }

    public void setTicketnum(int ticketnum) {
        this.ticketnum = ticketnum;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getReplyNum() {
        return replynum;
    }

    public void setReplyNum(int replynum) {
        this.replynum = replynum;
    }
}
