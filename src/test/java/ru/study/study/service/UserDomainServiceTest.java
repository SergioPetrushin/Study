package ru.study.study.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.repository.UserRepository;
import ru.study.study.service.domain.UserDomainService;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UserDomainServiceTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserDomainService service;
    private static final Long ID = 1L;

    @Test
    void addUserTest() {
        when(userRepository.save(any())).thenReturn(ID);
    }

    @Test
    void getUserTest() {

    }

    @Test
    void getAllUserTest() {

    }

    @Test
    void deleteUserTest() {

    }

    @Test
    void editUserTest() {

    }
}
