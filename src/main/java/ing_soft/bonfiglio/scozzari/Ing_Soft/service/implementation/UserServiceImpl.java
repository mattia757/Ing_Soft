package ing_soft.bonfiglio.scozzari.Ing_Soft.service.implementation;

import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.Mapper.UserMapper;
import ing_soft.bonfiglio.scozzari.Ing_Soft.dto.inputDTO.UserDTO;
import ing_soft.bonfiglio.scozzari.Ing_Soft.exception.UserNotFoundException;
import ing_soft.bonfiglio.scozzari.Ing_Soft.model.User;
import ing_soft.bonfiglio.scozzari.Ing_Soft.repo.UserRepo;
import ing_soft.bonfiglio.scozzari.Ing_Soft.service.interfaces.UserService;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    private final UserMapper userMapper;

    @Override
    public Optional<UserDTO> getUserById(Long idUserNotFound) throws UserNotFoundException {
        Optional<User> tempUser = userRepo.getUserById(idUserNotFound);
        if(tempUser.isPresent()){
            return Optional.of(userMapper.apply(tempUser.get()));
        }
        else {
            throw new UserNotFoundException("User not found!");
        }
    }

    @Override
    public Optional<UserDTO> getUserByUsername(String UsermameUserNotFound) throws UserNotFoundException {
        Optional<User> tempUser = userRepo.getUserByUsername(UsermameUserNotFound);
        if(tempUser.isPresent()){
            return Optional.of(userMapper.apply(tempUser.get()));
        }
        else {
            throw new UserNotFoundException("User not found!");
        }
    }
}
