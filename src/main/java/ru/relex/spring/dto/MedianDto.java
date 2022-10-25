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
public class MedianDto extends ResponseDto{

    @JsonProperty(value = "median")
    private float median;

    public MedianDto(MedianDto medianDto) {
        super();
    }
}
