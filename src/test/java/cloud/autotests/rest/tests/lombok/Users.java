package cloud.autotests.rest.tests.lombok;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Users {
    private Integer id;
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String job;
}
