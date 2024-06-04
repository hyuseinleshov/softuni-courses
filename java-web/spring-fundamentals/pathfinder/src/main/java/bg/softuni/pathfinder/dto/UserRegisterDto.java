package bg.softuni.pathfinder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserRegisterDto {
    private String username;
    private String fullname;
    private String email;
    private int age;
    private String password;
    private String confirmPassword;
}
