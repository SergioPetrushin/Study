package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.user.UserAddRequest;
import ru.study.study.dto.request.user.UserRequest;
import ru.study.study.dto.request.usertype.UserTypeRequest;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.dto.response.usertype.UserTypeResponse;
import ru.study.study.service.domain.UserDomainService;
import ru.study.study.service.domain.UserTypeDomainService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserDomainService userDomainService;
    private final UserTypeDomainService userTypeDomainService;


    public UserResponse addUser(UserAddRequest request) {
        var id = userDomainService.addUser(request);
        return  userDomainService.getUser(id);
    }

    public UserResponse getUser(UserRequest request) {

        return  userDomainService.getUser(request.getUserId());
    }
    public UserTypeResponse getUserType(UserTypeRequest request){
        return userTypeDomainService.getUserType(request.getTypeId());
    }

    public List<UserResponse> getAllUser(){
        return userDomainService.getAllUser();
    }

    public void deleteUser(UserRequest request){
        userDomainService.deleteUser(request.getUserId());
    }

    public UserResponse editUser(UserAddRequest request){
        userDomainService.editUser(request);
        return userDomainService.getUser(request.getUserId());
    }
}
