/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the implementation class of the MessagesService class. This is where the
 repository methods are fully defined. These methods will be used in the MessagesController class.
 ***************************************************************************************************/

package comp3095_mayflower.demo.backend;
import comp3095_mayflower.demo.backend.entities.Messages;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.MessagesRepository;
import comp3095_mayflower.demo.backend.services.MessagesService;
import frontend.UserSessionController;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;

public class MessagesServiceImpl implements MessagesService {

    @Autowired
    private MessagesRepository messagesRepository;

    @Override
    public List<Messages> findByRole(String role){

        var it=messagesRepository.findByRole("user");
        var usermessages=new ArrayList<Messages>();
        it.forEach(e->usermessages.add(e));
        return usermessages;

    }

    @Override
    public Messages findByTicketNum(int ticketnum){
        return messagesRepository.findByTicketnum(ticketnum);
    }

    @Override
    public List<Messages> findAllByReplynum(int replynum){ return messagesRepository.findAllByReplynum(replynum); }
}

