package africa.semicolon.hostelManagementSystem.data.models;

import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@RequiredArgsConstructor
public class BedSpace implements Comparable<BedSpace> {
    @NonNull
    @Id
    private String id;
    private boolean isEmpty = true;


    @Override
    public int compareTo(BedSpace o) {
        return this.id.compareTo(o.id);
    }
}
