package ru.relex.spring.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.xml.bind.annotation.XmlRootElement;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "data")
public class RequestData {

    private String path_file;
    private String operation;
}
