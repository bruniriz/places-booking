package br.com.travel.placesbooking.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Place {
    @Id
    private String id;
    private String name;
    private String city;
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
