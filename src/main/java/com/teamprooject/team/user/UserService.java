package com.teamprooject.team.user;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAllUsers();
    User getUserById(String id);
    void deleteUserById(String id);


    User getUserByLoginId(String loginId);
    void deleteUserByLoginId(String loginId);

}
