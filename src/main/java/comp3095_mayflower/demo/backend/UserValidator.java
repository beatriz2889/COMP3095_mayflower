package comp3095_mayflower.demo.backend;

import org.springframework.core.type.filter.RegexPatternTypeFilter;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements Validator {

    public boolean supports(Class classs){
        return User.class.equals(classs);
    }

    public void validate(Object obj, Errors errors){
        User user=(User)obj;
        if(user.getFirstName().contains("1234567890[^&%$#@!~]*")){
            errors.rejectValue("firstname","Must contain only letters");
        }
        if(user.getLastName().contains(("1234567890[^&%$#@!~]*"))){
            errors.rejectValue("lastname","Must contain only letters");
        }
        String email = "beatriz.morales@georgebrown.ca";
        Pattern pattern = Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}");
        Matcher mat = pattern.matcher(user.getEmail());

        if(!mat.matches()){
            errors.rejectValue("email","Invalid email");
        }
        String password="Passw@rd";
        Pattern passwordPattern=Pattern.compile("(.*[A-Z].*)[^&%$#@!~]*  ");
        Matcher passMatch=passwordPattern.matcher(user.getPassword());
        if (user.getPassword().length()<6 && user.getPassword().length()>12 && !passMatch.matches()){
            errors.rejectValue("password","Password must be between 6-12 characters and contain at least one upper case and special character");
        }

    }
}
