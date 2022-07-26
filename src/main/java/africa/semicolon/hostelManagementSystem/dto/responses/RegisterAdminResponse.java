package africa.semicolon.hostelManagementSystem.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterAdminResponse {
    private String email;
    private String dateCreated;
}
