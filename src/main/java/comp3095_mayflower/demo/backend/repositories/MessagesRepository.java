/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the repository for our messages table. It is a CRUD repository, so it has built in
 functionality for creating, finding and deleting messages. There are four custom methods defined here:
 findByRole,findByTicketNum,findAllByUser_Id and findAllByReplyNum, which will be used in the
 messages controller.
 ***************************************************************************************************/


package comp3095_mayflower.demo.backend.repositories;
import comp3095_mayflower.demo.backend.entities.Messages;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MessagesRepository extends CrudRepository<Messages,Integer> {

    List<Messages> findByRole(String role);
    Messages findByTicketnum(int ticketnum);
    List<Messages> findAllByUser_Id(int id);
    List<Messages> findAllByReplynum(int replynum);
}
