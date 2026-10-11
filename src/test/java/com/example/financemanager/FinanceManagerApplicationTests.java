package com.example.financemanager;

import com.example.financemanager.model.User;
import com.example.financemanager.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class FinanceManagerApplicationTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    void userRepositoryShouldBeAvailable() {
        assertNotNull(userRepository);
    }

    @Test
    void shouldSaveUserToDatabase() {
        User user = new User("Тестовый пользователь", "test2@mail.ru");

        User savedUser = userRepository.save(user);

        assertNotNull(savedUser.getId());
        assertEquals("Тестовый пользователь", savedUser.getName());
        assertEquals("test2@mail.ru", savedUser.getEmail());
    }

    @Test
    void shouldFindUserByEmail() {
        User user = new User("Иван", "ivan-find@mail.ru");
        userRepository.save(user);

        var foundUser = userRepository.findByEmail("ivan-find@mail.ru");

        assertNotNull(foundUser.orElse(null));
        assertEquals("Иван", foundUser.get().getName());
    }

    @Test
    void shouldFindUserById() {
        User user = new User("Пользователь по ID", "find-by-id@mail.ru");
        User savedUser = userRepository.save(user);

        var foundUser = userRepository.findById(savedUser.getId());

        assertNotNull(foundUser.orElse(null));
        assertEquals("Пользователь по ID", foundUser.get().getName());
    }

    @Test
    void shouldReturnEmptyWhenUserDoesNotExist() {
        var foundUser = userRepository.findById(-1L);

        assertTrue(foundUser.isEmpty());
    }

    @Test
    void shouldDeleteUserById() {
        User user = new User("Пользователь для удаления", "delete-test@example.com");
        User savedUser = userRepository.save(user);

        userRepository.deleteById(savedUser.getId());

        var foundUser = userRepository.findById(savedUser.getId());

        assertTrue(foundUser.isEmpty());
    }
}
