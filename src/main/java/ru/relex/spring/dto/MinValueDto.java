package ru.relex.spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MinValueDto extends ResponseDto{

    @JsonProperty(value = "min_value")
    private int min_value;

    public MinValueDto(MinValueDto minValue) {
        super();
    }
}
