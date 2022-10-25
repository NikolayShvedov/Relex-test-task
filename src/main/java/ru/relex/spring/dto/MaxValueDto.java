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
public class MaxValueDto extends ResponseDto{

    @JsonProperty(value = "max_value")
    private int max_value;

    public MaxValueDto(MaxValueDto maxValue) {
        super();
    }
}
