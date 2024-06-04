package bg.softuni.pathfinder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AuthResponseDto {
    private String accessToken;
    private String tokenType = "Bearer ";
}
