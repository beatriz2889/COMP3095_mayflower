/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the entity class for the creditprofile table. All of the columns
 for the credit profile table are defined here. The table is joined to the user table so
 that the user id is added as a column in credit profile table.The reason for this is so
 that session tracking can be done as the profiles will be using the user session controller,
 which in turn uses the user id to track which user is currently logged into the system.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend.entities;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class CreditProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int creditid;
    private String cardtype;
    private Date expdate;
    private String name;
    private int cardnum;
    private boolean defaultcard;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;


    public CreditProfile(){}

    public CreditProfile(String cardtype,Date expdate,String name,int cardnum,boolean defaultcard, User user){
        this.cardtype=cardtype;
        this.expdate=expdate;
        this.name=name;
        this.cardnum=cardnum;
        this.defaultcard=defaultcard;
        this.user=user;
    }

    @Override
    public String toString(){
        return String.format("Credit Profile[id=%d, cardtype='%s', expdate='%s', name='%s', cardnum='%s', defaultcard='%s']",
                creditid,cardtype,expdate,name,cardnum,defaultcard);
    }

    public int getCreditid() {
        return creditid;
    }

    public String getCardtype() {
        return cardtype;
    }

    public Date getExpdate() {
        return expdate;
    }

    public String getName() {
        return name;
    }

    public int getCardnum() {
        return cardnum;
    }

    public boolean isDefaultcard() {
        return defaultcard;
    }

    public void setCreditid(int creditid) {
        this.creditid = creditid;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public void setExpdate(Date expdate) {
        this.expdate = expdate;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCardnum(int cardnum) {
        this.cardnum = cardnum;
    }

    public void setDefaultcard(boolean defaultcard) {
        this.defaultcard = defaultcard;
    }


}
