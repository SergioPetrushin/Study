package ru.study.study.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import ru.study.study.dto.request.filedz.FileDzAddRequest;
import ru.study.study.dto.request.filedz.FileDzRequest;
import ru.study.study.dto.response.filedz.FileDzResponse;
import ru.study.study.service.FileDzService;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@Tag(name = "Управление файлами ДЗ")
public class FileDzController {
    private final FileDzService fileDzService;

    private static final String FILE_DZ_GET = "/api/v1/file-dz/get";
    private static final String FILE_DZ_ADD = "/api/v1/file-dz/add";
    private static final String FILE_DZ_DELETE = "/api/v1/file-dz/delete";

    @Operation(summary = "Получение файла ДЗ")
    @PostMapping(
            value = FILE_DZ_GET,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public FileDzResponse getFileDz(@RequestBody FileDzRequest request) {
        return fileDzService.getFileDz(request);
    }
    @Operation(summary = "Добавление файла ДЗ")
    @PostMapping(
            value = FILE_DZ_ADD,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public FileDzResponse addFileDz(@RequestBody FileDzAddRequest request) {
        return fileDzService.addFileDz(request);
    }
    @Operation(summary = "Удаление файла ДЗ")
    @PostMapping(
            value = FILE_DZ_DELETE,
            consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public String deleteFileDz(@RequestBody FileDzRequest request) {
        fileDzService.deleteFileDz(request);
        return "FileDz успешно удален";
    }
}
