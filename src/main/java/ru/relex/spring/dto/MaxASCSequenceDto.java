package ru.relex.spring.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MaxASCSequenceDto extends ResponseDto{

    @JsonProperty(value = "sequences_ASC")
    HashMap<String, ArrayList<Integer>> sequences_ASC;

    public MaxASCSequenceDto(MaxASCSequenceDto maxASCSequenceDto) {
        super();
    }
}
