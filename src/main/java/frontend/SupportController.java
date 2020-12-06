package frontend;

import comp3095_mayflower.demo.backend.entities.Support;
import comp3095_mayflower.demo.backend.repositories.SupportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class SupportController {

    @Autowired
     private SupportRepository supportRepository;

    @RequestMapping("addComment")
    public String addComment(Support support) {
     supportRepository.save(support);
     return "supportuser";
    }
    @RequestMapping("add")
    public String addCommentAdmin(Support support) {
        supportRepository.save(support);
        return "supportadmin";
    }
















}
