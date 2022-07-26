package africa.semicolon.hostelManagementSystem.data.models;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Admin extends User{
    private String password;
    @DBRef
    private List<Tenant> tenants = new ArrayList<>();
}
