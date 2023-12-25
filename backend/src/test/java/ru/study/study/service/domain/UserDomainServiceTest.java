package ru.study.study.service.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.study.study.dto.request.user.UserAddRequest;
import ru.study.study.dto.request.user.UserChangePWDRequest;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.dto.response.userstatus.UserStatusResponse;
import ru.study.study.entity.user.User;
import ru.study.study.entity.user.UserType;
import ru.study.study.mapper.user.UserMapper;
import ru.study.study.mapper.user.UserMerger;
import ru.study.study.mapper.user.UserResponseMapper;
import ru.study.study.repository.UserRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserDomainServiceTest {
    @Mock
    private UserRepository repository;
    @Mock
    private UserMapper userMapper;
    @Mock
    private UserResponseMapper userResponseMapper;
    @Mock
    private UserMerger userMerger;

    @InjectMocks
    private UserDomainService service;
    private static final Long ID = 1L;
    private static final String LOGIN = "login";
    private static final String PWD = "pwd";
    private static final String NAME = "name";
    private static final LocalDateTime CREATED = LocalDateTime.now();
    private static final LocalDateTime MODIFIED = LocalDateTime.now().plusMinutes(2);



    @Test
    void addUserTest() {

        when(userMapper.from((UserAddRequest) any())).thenReturn(getUser());
        when(repository.save(any())).thenReturn(getUser());

        var result = service.addUser(new UserAddRequest());

        assertEquals(ID, result);

        verify(userMapper).from((UserAddRequest) any());
        verify(repository).save(any());
        verifyNoMoreInteractions(repository, userMapper, userMerger, userResponseMapper);
    }

    @Test
    void getUserTest() {

        when(userResponseMapper.from((User) any())).thenReturn(getUserResponse());
        when(repository.findById(any())).thenReturn(Optional.of(getUser()));

        var result = service.getUser(ID);

        assertEquals(ID, result.getUserId());
        assertEquals(LOGIN, result.getLogin());
        assertEquals(NAME, result.getFullName());
        assertEquals(ID, result.getStatus().getUserStatusId());

        verify(userResponseMapper).from((User) any());
        verify(repository).findById(any());
        verifyNoMoreInteractions(repository, userMapper, userMerger, userResponseMapper);
    }



    @Test
    void getUserTest2() {

        when(repository.findById(any())).thenReturn(Optional.empty());


        assertThrows(NoSuchElementException.class, () ->  service.getUser(ID));


        verify(repository).findById(any());
        verifyNoMoreInteractions(repository, userMapper, userMerger, userResponseMapper);
    }

    @Test
    void getAllUserTest() {

        when(userResponseMapper.from((List<User>) any())).thenReturn(List.of(getUserResponse(),getUserResponse(),getUserResponse()));
        when(repository.findAll()).thenReturn(List.of(getUser(),getUser(),getUser()));

        var results = service.getAllUser();

        for(var result : results){
            assertEquals(ID, result.getUserId());
            assertEquals(LOGIN, result.getLogin());
            assertEquals(NAME, result.getFullName());
            assertEquals(ID, result.getStatus().getUserStatusId());
        }

        verify(repository).findAll();
        verify(userResponseMapper).from((List<User>) any());
        verifyNoMoreInteractions(repository, userMapper, userMerger, userResponseMapper);
    }

    @Test
    void deleteUserTest() {

        service.deleteUser(ID);

        verify(repository).deleteById(ID);
        verifyNoMoreInteractions(repository, userMapper, userMerger, userResponseMapper);
    }

    @Test
    void editUserTest() {

        when(repository.getReferenceById(any())).thenReturn(getUser());
        when(userMerger.merge(any(),any())).thenReturn(getUser());
        when(repository.save(any())).thenReturn(getUser());

        service.editUser(new UserAddRequest());

        verify(repository).getReferenceById(any());
        verify(repository).save(any());
        verify(userMerger).merge(any(),any());
        verifyNoMoreInteractions(repository, userMapper, userMerger, userResponseMapper);

    }


    @Test
    void changePWDTest1() {
    when(repository.findUserByLogin(any())).thenReturn(Optional.of(getUser()));



    var result = service.changePWD(getUserChangePWDRequest());
        assertEquals("Пароль успешно изменен", result);
        verify(repository).findUserByLogin(any());
        verify(repository).save(any());
        verifyNoMoreInteractions(repository);
    }

    @Test
    void changePWDTest2() {
        when(repository.findUserByLogin(any())).thenReturn(Optional.empty());

        var request = getUserChangePWDRequest();

        assertThrows(RuntimeException.class, () -> service.changePWD(request));

        verify(repository).findUserByLogin(any());
        verifyNoMoreInteractions(repository);
    }

    private UserChangePWDRequest getUserChangePWDRequest() {
        return new UserChangePWDRequest()
                .setLogin("test123")
                .setPassword("asd132");
    }


    private User getUser(){
        return new User()
                .setId(ID)
                .setType(new UserType(ID))
                .setLogin(LOGIN)
                .setPassword(PWD)
                .setFullName(NAME)
                .setCreated(CREATED)
                .setModified(MODIFIED);
    }

    private UserResponse getUserResponse() {

        return new UserResponse()
                .setUserId(ID)
                .setStatus(new UserStatusResponse().setUserStatusId(ID))
                .setLogin(LOGIN)
                .setFullName(NAME);
    }
}
