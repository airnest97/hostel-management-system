package africa.semicolon.hostelManagementSystem.data.models;

import lombok.*;
import org.springframework.data.annotation.Id;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Tenant extends User {
    private String bedSpaceId;
    private String phoneNumber;
    private String dateOfBirth;
    private BedSpace bedSpace;
}
