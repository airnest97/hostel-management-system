package africa.semicolon.hostelManagementSystem.data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    private String id;
    private BedSpace[] bedSpaces = new BedSpace[4];
    private HostelName hostelWing;
}
