package africa.semicolon.hostelManagementSystem.dto.requests;

import africa.semicolon.hostelManagementSystem.data.models.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterAdminRequest {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;
}
