package ro.ubbcluj.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ro.ubbcluj.dao.MockDAO;
import ro.ubbcluj.domain.Department;
import ro.ubbcluj.service.UserService;

import javax.annotation.Resource;
import java.beans.PropertyEditorSupport;

/**
 * Created by Cosmin on 21-May-17.
 */
@Component
public class DepartmentEditor extends PropertyEditorSupport
{

    @Autowired
    private UserService userService;

    public DepartmentEditor() {
    }

    public DepartmentEditor(UserService userService) {
        this.userService = userService;
    }

    //This will be called when user HTTP Post to server a field bound to DepartmentVO
    @Override
    public void setAsText(String id)
    {
//         this.setValue(userService.getDepartmentById(Integer.parseInt(id))); //todo: make it work ^^
    }
}
