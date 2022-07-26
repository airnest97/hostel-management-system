package africa.semicolon.hostelManagementSystem.dto.responses;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddTenantResponse {
    private String tenantName;
    private String dateRegistered;
    private String addedBy;
}
