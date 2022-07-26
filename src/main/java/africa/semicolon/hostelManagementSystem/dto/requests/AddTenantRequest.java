package africa.semicolon.hostelManagementSystem.dto.requests;

import africa.semicolon.hostelManagementSystem.data.models.Gender;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddTenantRequest {
    private String firstName;
    private String lastName;
    private String dateOfBirth;
    private String email;
    private String phoneNumber;
    private Gender gender;
}
