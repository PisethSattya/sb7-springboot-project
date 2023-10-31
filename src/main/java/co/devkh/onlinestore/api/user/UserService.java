package co.devkh.onlinestore.api.user;

import co.devkh.onlinestore.api.user.web.NewUserDto;
import co.devkh.onlinestore.api.user.web.UpdateUserDto;
import co.devkh.onlinestore.api.user.web.UserDto;
import org.springframework.security.core.Authentication;

public interface UserService {
    /**
     *
     */
    UserDto me(Authentication authentication);

    /**
     * This method is used to create a new user
     * resource into database
     * @param newUserDto is the request data from client
     */
    void createNewUser(NewUserDto newUserDto);

    /**
     * This method is used to update user by uuid
     * @param uuid of User
     * @param updateUserDto is the request data from client for update personal_information
     */
    // Update an existing user by uuid
    void updateByUuid(String uuid, UpdateUserDto updateUserDto);

    // Find users by pagination and filter

    /**
     * This method is used to retrieve resource user by uuid
     * from database
     * @param uuid of User
     * @return UserDto
     */
    // Find a user by UUID
    UserDto findByUuid(String uuid);

    /**
     * This method is used to delete user from database by uuid
     * @param uuid of User
     */
    // Delete a user by UUID (Permanently)
    void deleteByUuid(String uuid);

    /**
     * This method is used to update status(enable or disable)
     * for delete a user(Soft-Delete) by UUID
     * default of 'isDeleted' = false
     * @param uuid of User
     * @param isDeleted of User
     */
    // Update status : 'is_deleted' by UUID
    void updateIsDeletedByUuid(String uuid, Boolean isDeleted);
}
