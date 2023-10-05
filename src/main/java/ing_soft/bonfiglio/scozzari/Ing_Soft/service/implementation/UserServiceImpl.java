package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.exception.UserNotFoundException;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.UserRepository;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void updateUserPassword(Long id, String newPassword) throws UserNotFoundException {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User userModified = user.get();
            String encodedPassword = passwordEncoder.encode(newPassword);
            userModified.setPassword(encodedPassword);
            userRepository.save(userModified);
        }
        else {
            throw new UserNotFoundException("User not found!");
        }
    }

    @Override
    public Optional<User> getUserByUsername(String username) throws UserNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        if (user.isPresent()) {
            return user;
        }
        else {
            throw new UserNotFoundException("User with username: " + username + " not found!");
        }
    }
}
