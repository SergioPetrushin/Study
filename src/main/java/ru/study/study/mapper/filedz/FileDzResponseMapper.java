package ru.study.study.mapper.filedz;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.study.study.dto.response.filedz.FileDzResponse;
import ru.study.study.entity.FileDz;
import ru.study.study.mapper.Mapper;

@Service
@RequiredArgsConstructor
public class FileDzResponseMapper implements Mapper<FileDzResponse, FileDz> {


    @Override
    public FileDzResponse from(FileDz source) {
       return new FileDzResponse()
                .setFileId(source.getId())
                .setName(source.getName())
                .setModified(source.getModified())
                .setDescription(source.getDescription())
                .setCreated(source.getCreated());
    }
}
