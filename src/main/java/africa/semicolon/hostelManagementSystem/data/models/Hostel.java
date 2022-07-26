package africa.semicolon.hostelManagementSystem.data.models;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Hostel {
    @NonNull
    private HostelName hostelName;
    private Room[] rooms = new Room[20];
    @NonNull
    private Gender hostelWing;
}
