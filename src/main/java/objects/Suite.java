package objects;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Suite {

    String name;
    String description;
    int id;
}
