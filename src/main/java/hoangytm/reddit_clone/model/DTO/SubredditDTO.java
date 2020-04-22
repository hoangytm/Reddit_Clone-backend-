package hoangytm.reddit_clone.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PhanHoang
 * 4/21/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SubredditDTO {
    private Long id;
    private String name;
    private String description;
    private Integer postCount;
}
