/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the messages service class. The repository methods are defined here again so
 they can be used in the MessagesServiceImpl class.
 ***************************************************************************************************/


package comp3095_mayflower.demo.backend.services;
import comp3095_mayflower.demo.backend.entities.Messages;
import java.util.List;

public interface MessagesService {

    List<Messages> findByRole(String role);
    Messages findByTicketNum(int ticketnum);
    List<Messages> findAllByReplynum(int replynum);
   // Iterable<Messages>findAllByReplyNum(int replynum);
}
