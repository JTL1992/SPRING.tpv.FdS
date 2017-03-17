package api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import api.exceptions.AlreadyExistUserFieldException;
import api.exceptions.InvalidUserFieldException;
import api.exceptions.NotFoundUserIdException;
import controllers.UserController;
import entities.users.Role;
import wrappers.UserForEditListWrapper;
import wrappers.UserForEditWrapper;
import wrappers.UserWrapper;

@RestController
@RequestMapping(Uris.VERSION)
public class UserResource {

    private UserController userController;

    @Autowired
    public void setUserController(UserController userController) {
        this.userController = userController;
    }

    @RequestMapping(value = Uris.USERS, method = RequestMethod.POST)
    public void userRegistration(@RequestBody UserWrapper userWrapper) throws InvalidUserFieldException, AlreadyExistUserFieldException {
        validateField(userWrapper.getUsername(), "username");
        if (!this.userController.registration(userWrapper, Role.MANAGER)) {
            throw new AlreadyExistUserFieldException();
        }
    }

    @RequestMapping(value = Uris.CUSTOMERS, method = RequestMethod.POST)
    public void customerRegistration(@RequestBody UserWrapper userWrapper)
            throws InvalidUserFieldException, AlreadyExistUserFieldException {
        validateField(userWrapper.getUsername(), "username");
        if (!this.userController.registration(userWrapper, Role.CUSTOMER)) {
            throw new AlreadyExistUserFieldException();
        }
    }
    
    @RequestMapping(value = Uris.USERS, method = RequestMethod.GET)
    public UserForEditListWrapper getAllUsers() {
        //TODO use instead of mock: this.userController.findAll();
        List<UserForEditWrapper> list = new ArrayList<UserForEditWrapper>();
        list.add(new UserForEditWrapper(66000000, "Prueba", true, "Calle prueba", "12345678Z", "prueba@mail.com", "25/10/2008"));
        return new UserForEditListWrapper(list);
    }
    
    @RequestMapping(value = Uris.USERS, method = RequestMethod.PUT)
    public String updateUser(@RequestBody UserForEditWrapper userWrapper)
            throws InvalidUserFieldException, NotFoundUserIdException {
        validateField(userWrapper.getUsername(), "username");
        //TODO use: this.userController.updateUser(userWrapper);
        return "update llamado";
    }
    
    @RequestMapping(value = Uris.USERS, method = RequestMethod.DELETE)
    public String deleteUser(@RequestBody long mobile)
            throws InvalidUserFieldException, NotFoundUserIdException {
        //TODO use: this.userController.deleteUser(mobile);
        return "delete llamado";
    }

    private void validateField(String field, String msg) throws InvalidUserFieldException {
        if (field == null || field.isEmpty()) {
            throw new InvalidUserFieldException(msg);
        }
    }

}
