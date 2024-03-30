package ru.study.study.dto.inner;

import lombok.Data;
import lombok.experimental.Accessors;
import ru.study.study.utils.Pair;


import java.io.File;
import java.util.Collections;
import java.util.List;

@Data
@Accessors(chain = true)
public class EmailRequest {

    private String subject;
    private String text = "";

    private List<String> to = Collections.emptyList();
    private List<String> cc = Collections.emptyList();
    private List<String> bcc = Collections.emptyList();

    private List<Pair<String, File>> files = Collections.emptyList();

}
