package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.Mapper.UserMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.UserDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.exception.UserAlreadyExistException;
import ing_soft.bonfiglio.scozzari.Ing_Soft.exception.UserNotFoundException;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.UserRepo;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserMapper userMapper;

    @Override
    public Optional<UserDTO> findById(Long id) {
        Optional<User> user = userRepo.getUserById(id);
        if(user.isPresent()){
            return Optional.of(userMapper.apply(user.get()));
        }
        else {
            try {
                throw new UserNotFoundException("User not found with ID: " + id);
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Optional<UserDTO> findByUsername(String username) {
        Optional<User> user = userRepo.getUserByUsername(username);
        if(user.isPresent()){
            return Optional.of(userMapper.apply(user.get()));
        }
        else {
            try {
                throw new UserNotFoundException("User not found with username: " + username);
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Optional<UserDTO> findByEmail(String email) {
        Optional<User> user = userRepo.getUserByEmail(email);
        if(user.isPresent()){
            return Optional.of(userMapper.apply(user.get()));
        }
        else {
            try {
                throw new UserNotFoundException("User not found with email: " + email);
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Optional<UserDTO> findByCodiceFiscale(String codiceFiscale) {
        Optional<User> user = userRepo.getUserByCodiceFiscale(codiceFiscale);
        if(user.isPresent()){
            return Optional.of(userMapper.apply(user.get()));
        }
        else {
            try {
                throw new UserNotFoundException("User not found with Codice Fiscale: " + codiceFiscale);
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Optional<Boolean> insert(User user){
        Optional<User> utente = userRepo.getUserByUsername(user.getUsername());
        if(utente.isPresent()){
            try {
                throw new UserAlreadyExistException("User Already Exist!");
            } catch (UserAlreadyExistException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            userRepo.save(user);
            return Optional.of(true);
        }
    }

    @Override
    public Optional<Boolean> delete(Long id){
        Optional<User> utente = userRepo.getUserById(id);
        if(!utente.isPresent()){
            try {
                throw new UserNotFoundException("User notfound with ID: " + id);
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            userRepo.deleteById(id);
            return Optional.of(true);
        }
    }
}
