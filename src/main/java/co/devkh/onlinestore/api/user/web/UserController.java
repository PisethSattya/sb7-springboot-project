package co.devkh.onlinestore.api.user.web;

import co.devkh.onlinestore.api.product.web.IsDeletedDto;
import co.devkh.onlinestore.api.user.UserService;
import co.devkh.onlinestore.security.CustomUserDetails;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @GetMapping("/me")
    public UserDto me(Authentication authentication){

        return userService.me(authentication);
    }

    @ResponseStatus(HttpStatus.OK)
    @PatchMapping("/{uuid}")
    public void updateByUuid(@PathVariable String uuid,
                             @RequestBody @Valid UpdateUserDto updateUserDto){
        userService.updateByUuid(uuid,updateUserDto);
    }

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
                                      @RequestBody @Valid IsDeletedDto isDeletedDto){
        userService.updateIsDeletedByUuid(uuid,isDeletedDto.isDeleted());

    }
}
