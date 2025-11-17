package com.etsesports.etsesports.registration;

import com.etsesports.etsesports.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/registrations")
public class RegistrationController {
    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public List<Registration> getRegistration() {
        return registrationService.getRegistration();
    }

    @PostMapping
    public void createRegistration(@RequestBody Registration registration) {
        registrationService.createRegistration(registration);
    }

    @DeleteMapping(path = "{registrationId}")
    public void deleteRegistration(@PathVariable("registrationId") Long registrationId) {
        registrationService.deleteRegistration(registrationId);
    }

    @PutMapping(path = "{registrationId}")
    public void updateRegistration(@PathVariable("registrationId") Long registrationId,
                                   @RequestParam(required = false) String email,
                                   @RequestParam(required = false) String name,
                                   @RequestParam(required = false) String message,
                                   @RequestParam(required = false) Game game) {
        registrationService.updateRegistration(registrationId, email, name, message, game);
    }
}
