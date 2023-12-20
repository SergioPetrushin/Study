package ru.study.study.service.domain;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.filedz.FileDzAddRequest;
import ru.study.study.dto.response.filedz.FileDzResponse;
import ru.study.study.mapper.filedz.FileDzMapper;
import ru.study.study.mapper.filedz.FileDzResponseMapper;
import ru.study.study.repository.FileDzRepository;

@Service
@RequiredArgsConstructor
public class FileDzDomainService {

    private final FileDzRepository fileDzRepository;
    private final FileDzMapper fileDzMapper;
    private final FileDzResponseMapper fileDzResponseMapper;

    @Transactional
    public FileDzResponse getFileDz(Long id) {
        return fileDzResponseMapper.from(fileDzRepository.getReferenceById(id));
    }

    @Transactional
    public Long addFileDz(FileDzAddRequest request) {
        return fileDzRepository.save(fileDzMapper.from(request)).getId();
    }

    @Transactional
    public void deleteFileDz(Long id) {
        fileDzRepository.deleteById(id);
    }
}