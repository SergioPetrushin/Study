package ru.study.study.mapper.filedz;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.request.filedz.FileDzAddRequest;
import ru.study.study.entity.FileDz;
import ru.study.study.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class FileDzMapper implements Mapper<FileDz, FileDzAddRequest> {
    @Override
    public FileDz from(FileDzAddRequest source) {
        return new FileDz()
                .setId(source.getFileId())
                .setName(source.getName())
                .setDescription(source.getDescription());
    }
}
