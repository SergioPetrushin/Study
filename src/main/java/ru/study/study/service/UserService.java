package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.user.UserAddRequest;
import ru.study.study.dto.request.user.UserChangePWDRequest;
import ru.study.study.dto.request.user.UserRequest;
import ru.study.study.dto.request.usertype.UserTypeRequest;
import ru.study.study.dto.response.user.UserResponse;
import ru.study.study.dto.response.usertype.UserTypeResponse;
import ru.study.study.service.domain.UserDomainService;
import ru.study.study.service.domain.UserTypeDomainService;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public String changePWD(UserChangePWDRequest request) {
        String reg = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$";
       Matcher matcher = Pattern.compile(reg).matcher(request.getPassword());
        if(matcher.matches()){
            return userDomainService.changePWD(request);
        } else {
            return "Пароль не подходит. Пароль должен содержать не " +
                    "менее 6 символов, спец символы, большие и маленькие буквы.";
        }
    }
}
