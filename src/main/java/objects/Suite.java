package objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Suite {

    String name;
    String description;
    int id;
    int project_id;
    @SerializedName("is_master")
    boolean master;
    @SerializedName("is_baseline")
    boolean baseline;
    @SerializedName("is_completed")
    boolean completed;
    String completed_on;
    String url;
}
