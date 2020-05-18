package pe.com.examples.mongoclientapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Client {
    @Id
    private String id;
    private String name;
    private String lastName;
    private Integer age;
    private Date birthDate;
}
