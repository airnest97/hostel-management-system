package africa.semicolon.hostelManagementSystem.dto.requests;

import lombok.Data;

@Data
public class LoginAdminRequest {
    private String email;
    private String password;
}
