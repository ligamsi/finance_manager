package com.example.financemanager.service;

import com.example.financemanager.dto.CreateUserRequest;
import com.example.financemanager.model.User;
import com.example.financemanager.dto.UserResponse;
import com.example.financemanager.repository.UserRepository;
import com.example.financemanager.exception.DuplicateEmailException;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail()
                ))
                .toList();
    }

    public UserResponse createUser(CreateUserRequest request) {
        if (userRepository.findByEmail(request.email()).isPresent()) {
            throw new DuplicateEmailException(
                    "Пользователь с таким email уже существует"
            );
        }

        User user = new User(
                request.name(),
                request.email()
        );

        User savedUser = userRepository.save(user);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail()
        );
    }
}
