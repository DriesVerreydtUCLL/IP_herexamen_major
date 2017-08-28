package domain;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author Dries
 */
public class PlayerValidator implements Validator {

    @Override
    public boolean supports(Class<?> type) {
        return Player.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "required.firstName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "required.lastName");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "playerNumber", "required.playerNumber");
        Player player = (Player) o;
        if(player.getPlayerNumber() < 0 || player.getPlayerNumber() > 99){
            errors.rejectValue("playerNumber", "valid.playerNumber");
        }
        if(player.getGoals() < 0){
            errors.rejectValue("goals", "valid.goals");
        }
    }
    
}
