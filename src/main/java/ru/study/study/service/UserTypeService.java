package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.usertype.UserTypeRequest;
import ru.study.study.dto.response.usertype.UserTypeResponse;
import ru.study.study.service.domain.UserTypeDomainService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserTypeService {
    private UserTypeDomainService userTypeDomainService;

    public UserTypeResponse addUserType(UserTypeRequest request) {
        var id = userTypeDomainService.addUserType(request);
        return userTypeDomainService.getUserType(id);
    }

    public UserTypeResponse getUserType(UserTypeRequest request) {
        return userTypeDomainService.getUserType(request.getTypeId());
    }

    public List<UserTypeResponse> getAllUserType(){
        return userTypeDomainService.getAllUserType();
        //Тут есть вопросы, правильно ли сделано???
    }

    public void deleteUserType(UserTypeRequest request){
        //тут вообще не ясно, что писать
    }
}
