package com.etsesports.registration;

import com.etsesports.game.Game;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;

    @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<Registration> getRegistration() {
        return registrationRepository.findAll();
    }

    public void createRegistration(Registration registration) {
        registrationRepository.save(registration);
    }

    public void deleteRegistration(Long registrationId) {
        registrationRepository.deleteById(registrationId);
    }

    @Transactional
    public void updateRegistration(Long registrationId, String email, String name, String message, Game game){
        Registration registration = registrationRepository.findById(registrationId).orElseThrow(() -> new IllegalStateException("Registration with id " + registrationId + " does not exist"));
        registration.setEmail(email);
        registration.setName(name);
        registration.setMessage(message);
        registration.setGame(game);
    }
}
