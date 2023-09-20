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
    public Optional<UserDTO> findByEmail(String email) {
        Optional<User> user = userRepo.getUserByEmail(email);
        if(user.isPresent()){
            return Optional.of(userMapper.apply(user.get()));
        }
        else {
            try {
                throw new UserNotFoundException("User not found with EMAIL: " + email);
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @Override
    public Optional<Boolean> insert(User user){
        Optional<User> utente = userRepo.getUserByEmail(user.getEmail());
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
    public Optional<Boolean> delete(String email){
        Optional<User> utente = userRepo.getUserByEmail(email);
        if(!utente.isPresent()){
            try {
                throw new UserNotFoundException("User not found with EMAIL: " + email);
            } catch (UserNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            userRepo.deleteById(Long.valueOf(email));
            return Optional.of(true);
        }
    }
}
