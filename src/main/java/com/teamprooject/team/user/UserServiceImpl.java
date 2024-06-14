package com.teamprooject.team.user;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private final MongoTemplate mongoTemplate;
    private final UserRepository userRepository;

    public UserServiceImpl(MongoTemplate mongoTemplate, UserRepository userRepository){
        this.mongoTemplate = mongoTemplate;
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteUserById(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public User getUserByLoginId(String loginId) {
        return userRepository.findByLoginId(loginId);
    }

    @Override
    public void deleteUserByLoginId(String loginId) {
        userRepository.deleteByLoginId(loginId);
    }


    public void mongoInsert() {
        User user1 = new User();
        user1.setName("김태호");
        user1.setLoginId("rlaxogh");
        user1.setPassword("1234");
        user1.setEmail("rlaxogh@naver.com");
        user1.setPhone("01011111111");
        user1.setUserRole(UserRole.ADMIN);


        User user2 = new User();
        user2.setName("황껌딱");
        user2.setLoginId("ghkdtnrud");
        user2.setEmail("ghkdtnrud@gmail.com");
        user2.setPassword("12345");
        user2.setPhone("01022222222");
        user2.setUserRole(UserRole.USER);


        // 몽고DB에 삽입
        mongoTemplate.insert(user1);
        mongoTemplate.insert(user2);


    }


}
