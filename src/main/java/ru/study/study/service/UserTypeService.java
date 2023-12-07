package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.usertype.UserTypeAddRequest;
import ru.study.study.dto.request.usertype.UserTypeRequest;
import ru.study.study.dto.response.usertype.UserTypeResponse;
import ru.study.study.service.domain.UserTypeDomainService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTypeService {
    private final UserTypeDomainService userTypeDomainService;

    public UserTypeResponse addUserType(UserTypeAddRequest request) {
        var id = userTypeDomainService.addUserType(request);
        return userTypeDomainService.getUserType(id);
    }

    public UserTypeResponse getUserType(UserTypeRequest request) {
        return userTypeDomainService.getUserType(request.getTypeId());
    }

    public List<UserTypeResponse> getAllUserType(){

        return userTypeDomainService.getAllUserType();
    }

    public void deleteUserType(UserTypeRequest request){

        userTypeDomainService.deleteUserType(request.getTypeId());
    }

    public UserTypeResponse editUserType(UserTypeAddRequest request) {
        userTypeDomainService.editUserType(request);
        return userTypeDomainService.getUserType(request.getTypeId());
    }
}
