package comp3095_mayflower.demo.backend;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class CreditProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int creditid;
    private String cardtype;
    private LocalDateTime expdate;
    private String name;
    private int cardnum;
    private boolean defaultcard;

    @ManyToOne
    private User user;

    public CreditProfile(){}

    public CreditProfile(String cardtype,LocalDateTime expdate,String name,int cardnum,boolean defaultcard){
        this.cardtype=cardtype;
        this.expdate=expdate;
        this.name=name;
        this.cardnum=cardnum;
        this.defaultcard=defaultcard;
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

    public LocalDateTime getExpdate() {
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

    public void setExpdate(LocalDateTime expdate) {
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
