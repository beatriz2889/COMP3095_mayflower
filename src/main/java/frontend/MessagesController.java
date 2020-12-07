/**************************************************************************************************
 * Project: <COMP3095_mayflower>
 * Assignment: < assignment #3 >
 * Author(s): <Esther Kim, Beatriz Morales, Alan Pintor, Afsana Bilkis-Ritu>
 * Student Number: <101125413,101159722,101136369,101165654>
 * Date: 2020-12-06
 * Description: This is the controller class for the messages table. All the functions
 (creating a message, reading a message, deleting a message and accessing the client/admin
 inboxes are defined here. The page is also locked to users who have not logged in using the user session controller
 and client users  if the page is for admin users.
 ***************************************************************************************************/

package frontend;

import comp3095_mayflower.demo.backend.entities.Messages;
import comp3095_mayflower.demo.backend.entities.User;
import comp3095_mayflower.demo.backend.repositories.MessagesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MessagesController {


    MessagesRepository messagesRepository;

    @Autowired
    public MessagesController(MessagesRepository messagesRepository){
    this.messagesRepository=messagesRepository; }


    @RequestMapping(value="supportuser",method= RequestMethod.POST)
    public ModelAndView sendMessageFromUser(@RequestParam(value="firstname")String firstname,
                                            @RequestParam(value="username")String username,
                                            @RequestParam(value="subject")String subject,
                                            @RequestParam(value="message")String message) {

        User user=UserSessionController.loggedInUser;
        Messages messages=new Messages(subject,username, message, firstname,"user",0,user);
        messagesRepository.save(messages);
        return new ModelAndView(new RedirectView("dashboard"));

    }

    @GetMapping("/inboxadmin")
    public ModelAndView showAdminInboxPage(Model model){
        User user=UserSessionController.loggedInUser;
        if(user==null||user.getRole().equals("user")){
            return new ModelAndView("login");
        }
        model.addAttribute("usermessages",messagesRepository.findByRole("user"));
        return new ModelAndView("inboxadmin");

    }

    @GetMapping("/inboxuser")
    public ModelAndView showUserInboxPage(Model model){
        User user=UserSessionController.loggedInUser;
        if(user==null){
            return new ModelAndView("login");
        }
        List<Messages> messagesList = messagesRepository.findAllByUser_Id(user.getId());
        List<Messages> replyList = new ArrayList<>();
        messagesList.forEach(message -> {
            List<Messages> messagesByReplyNum = messagesRepository.findAllByReplynum(message.getTicketnum());
            messagesByReplyNum.forEach(reply -> {
                replyList.add(reply);
            });
        });
        model.addAttribute("replylist",replyList);
        return new ModelAndView("inboxuser");
    }

    @GetMapping("messages/delete/{ticketnum}")
    public String deleteMessage(@PathVariable(value="ticketnum")int ticketnum,Model model){

        Messages messages=messagesRepository.findByTicketnum(ticketnum);
        messagesRepository.delete(messages);
        model.addAttribute("usermessages",messagesRepository.findByRole("user"));
        return "inboxadmin";


    }

    @GetMapping("messages/read/{ticketnum}")
    public String readMessage(@PathVariable(value="ticketnum")int ticketnum,Model model){

        Messages messages=messagesRepository.findByTicketnum(ticketnum);
        model.addAttribute("messages",messages);
        return "replytomessage";
    }

    @RequestMapping(value="messages/read/{ticketnum}",method=RequestMethod.POST)
    public String replyToSupportMessage(@RequestParam(value="firstname")String firstname,
                                              @RequestParam(value="username")String username,
                                              @RequestParam(value="subject")String subject,
                                              @RequestParam(value="message")String message,
                                              @RequestParam(value="ticketnum")int ticketnum,Model model) {

        User user = UserSessionController.loggedInUser;
        int replynum =ticketnum;

        Messages messages = new Messages(subject, username, message, firstname, "admin",replynum,user );
        messagesRepository.save(messages);
        model.addAttribute("usermessages",messagesRepository.findByRole("user"));
        return "inboxadmin";
    }

    @GetMapping("message/read/{ticketnum}")
        public String readMessageFromAdmin(@PathVariable(value="ticketnum")int ticketnum,Model model){

        Messages messages=messagesRepository.findByTicketnum(ticketnum);
        model.addAttribute("messages",messages);
        return "readmessage";
    }

    @GetMapping("message/delete/{ticketnum}")
    public String deleteMessageFromAdmin(@PathVariable(value="ticketnum")int ticketnum,Model model){
        User user=UserSessionController.loggedInUser;
        Messages messages=messagesRepository.findByTicketnum(ticketnum);
        messagesRepository.delete(messages);
        List<Messages> messagesList = messagesRepository.findAllByUser_Id(user.getId());
        List<Messages> replyList = new ArrayList<>();
        messagesList.forEach(message -> {
            List<Messages> messagesByReplyNum = messagesRepository.findAllByReplynum(message.getTicketnum());
            messagesByReplyNum.forEach(reply -> {
                replyList.add(reply);
            });
        });
        model.addAttribute("replylist",replyList);
        return "inboxuser";
    }
}
