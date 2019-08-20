package com.GregsApp.authentication;

import com.GregsApp.security.CurrentUser;
import com.GregsApp.user.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {

    @GetMapping("/admin")
    @ResponseBody
    public String admin(@AuthenticationPrincipal CurrentUser currentUser) {
        User entityUser = currentUser.getUser();
        return "Hello " + entityUser.getFirstName() + " " + entityUser.getLastName();
    }

}
