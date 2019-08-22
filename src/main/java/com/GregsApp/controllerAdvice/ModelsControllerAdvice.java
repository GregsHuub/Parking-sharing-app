package com.GregsApp.controllerAdvice;

import com.GregsApp.nbpCurrencyApi.CurrencyJsonParsingService;
import com.GregsApp.user.User;
import com.GregsApp.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.io.IOException;
import java.security.Principal;
import java.time.LocalDateTime;

@ControllerAdvice
public class ModelsControllerAdvice {

    private final UserRepository userRepository;
    private final CurrencyJsonParsingService currencyJsonParsingService;

    @Autowired
    public ModelsControllerAdvice(UserRepository userRepository, CurrencyJsonParsingService currencyJsonParsingService) {
        this.userRepository = userRepository;
        this.currencyJsonParsingService = currencyJsonParsingService;
    }


    @ModelAttribute("currentUser")
    public User currentUser(Principal principal) throws NullPointerException {
        if (principal != null) {
            SecurityContextHolder.getContext().getAuthentication().getAuthorities();
            return userRepository.findOneByEmail(principal.getName());
        }
        return null;

    }
    @ModelAttribute
    public void nbpRates(Model model) throws IOException {
        model.addAttribute("nbp_eur", currencyJsonParsingService.currencyValueFromNBP("eur"));
        model.addAttribute("nbp_gbp", currencyJsonParsingService.currencyValueFromNBP("gbp"));
        model.addAttribute("nbp_usd", currencyJsonParsingService.currencyValueFromNBP("usd"));
        model.addAttribute("time_now", LocalDateTime.now().withNano(0).withSecond(0).withHour(0));
    }
}
