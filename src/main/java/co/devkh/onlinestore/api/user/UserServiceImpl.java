package co.devkh.onlinestore.api.user;

import co.devkh.onlinestore.api.user.web.NewUserDto;
import co.devkh.onlinestore.api.user.web.UpdateUserDto;
import co.devkh.onlinestore.api.user.web.UserDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Transactional
    @Override
    public void createNewUser(NewUserDto newUserDto) {
        // Check username if existed
        if (userRepository.existsByUsernameAndIsDeletedFalse(newUserDto.username())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exists.....!");
        }

        // Check email if existed
        if (userRepository.existsByEmailAndIsDeletedFalse(newUserDto.email())){
            throw new ResponseStatusException(HttpStatus.CONFLICT,"Email already exists");
        }

        User newUser = userMapper.fromNewUserDto(newUserDto);
        newUser.setUuid(UUID.randomUUID().toString());
        newUser.setIsVerified(false);
        newUser.setIsDeleted(false);

        userRepository.save(newUser);
    }

    @Override
    public void updateByUuid(String uuid, UpdateUserDto updateUserDto) {

    }

    @Override
    public UserDto findByUuid(String uuid) {
        User foundUser = userRepository.selectUserByUuidAndIsDeleted(uuid,false).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User UUID = %s doesn't exist in db!",uuid)));
      return userMapper.toUserDto(foundUser);
    }

    @Override
    public void deleteByUuid(String uuid) {

        User foundUser = userRepository.selectUserByUuid(uuid).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("User UUID = %s doesn't exist in db!",uuid)));

        userRepository.delete(foundUser);
    }

    @Transactional
    @Override
    public void updateIsDeletedByUuid(String uuid, Boolean isDeleted) {

        Boolean isFound = userRepository.checkUserByUuid(uuid);
        if (isFound){
            userRepository.updateIsDeletedStatusByUuid(uuid,isDeleted);
            return;
        }
        throw  new ResponseStatusException(HttpStatus.NOT_FOUND,
                String.format("User UUID = %s doesn't exist in db!",uuid));
    }
}
