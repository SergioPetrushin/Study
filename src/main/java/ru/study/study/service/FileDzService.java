package ru.study.study.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.filedz.FileDzAddRequest;
import ru.study.study.dto.request.filedz.FileDzRequest;
import ru.study.study.dto.response.filedz.FileDzResponse;
import ru.study.study.service.domain.FileDzDomainService;

@Service
@RequiredArgsConstructor
public class FileDzService {
    private final FileDzDomainService service;

    public FileDzResponse getFileDz(FileDzRequest request){
        return service.getFileDz(request.getFileId());
    }

    public FileDzResponse addFileDz(FileDzAddRequest request){
        var id = service.addFileDz(request);
        return service.getFileDz(id);
    }

    public void deleteFileDz(FileDzRequest request){
        service.deleteFileDz(request.getFileId());
    }

}
