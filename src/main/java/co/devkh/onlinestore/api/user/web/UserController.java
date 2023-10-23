package co.devkh.onlinestore.api.user.web;

import co.devkh.onlinestore.api.product.web.IsDeletedDto;
import co.devkh.onlinestore.api.user.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createNewUser(@RequestBody @Valid NewUserDto newUserDto){
        userService.createNewUser(newUserDto);
    }
    @GetMapping("/{uuid}")
    public UserDto findByUuid(@PathVariable String uuid){
        return userService.findByUuid(uuid);
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{uuid}")
    public void deleteByUuid(@PathVariable String uuid){
        userService.deleteByUuid(uuid);
    }
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{uuid}")
    public void updateIsDeletedByUuid(@PathVariable String uuid,
                                      @RequestBody IsDeletedDto isDeletedDto){
        userService.updateIsDeletedByUuid(uuid,isDeletedDto.isDeleted());

    }
}
