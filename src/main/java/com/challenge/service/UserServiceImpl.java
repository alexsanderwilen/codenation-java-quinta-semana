package com.challenge.service;

import com.challenge.entity.User;
import com.challenge.repository.UserRepository;
import com.challenge.service.interfaces.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserServiceInterface {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Optional<User> findById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> findByAccelerationName(String name) {
        return userRepository.findByAccelerationName(name);
    }

    @Override
    public List<User> findByCompanyId(Long companyId) {
        return userRepository.findByCompanyId(companyId);
    }

    @Override
    public User save(User object) {
        if(object.getId() == null){
            User user = new User();
            user.setFullName(object.getFullName());
            user.setNickname(object.getNickname());
            user.setEmail(object.getEmail());
            user.setPassword(object.getPassword());
            user.setCreatedAt(LocalDateTime.now());
            return userRepository.save(user);
        }

        return userRepository.save(object);
    }
}
