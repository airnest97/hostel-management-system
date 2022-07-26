package africa.semicolon.hostelManagementSystem.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
    private String firstName;
    private String lastName;
    private Gender gender;
    @Id
    private String email;
    private LocalDateTime dateRegistered = LocalDateTime.now();
}
