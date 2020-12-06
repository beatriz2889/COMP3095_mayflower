package comp3095_mayflower.demo.backend.services;

import comp3095_mayflower.demo.backend.entities.Support;
import comp3095_mayflower.demo.backend.entities.User;

import java.util.List;

public interface SupportService {

    Support findByFirstname(String firstname);
    List getAllUsers();
}
