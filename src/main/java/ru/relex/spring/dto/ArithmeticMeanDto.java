package ru.relex.spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.xml.bind.annotation.XmlRootElement;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@XmlRootElement(name = "data")
public class ArithmeticMeanDto extends ResponseDto{

    @JsonProperty(value = "arithmetic_mean")
    private float arithmetic_mean;

    public ArithmeticMeanDto(ArithmeticMeanDto arithmeticMeanDto) {
        super();
    }
}
