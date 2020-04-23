package hoangytm.reddit_clone.model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author PhanHoang
 * 4/23/2020
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommenstDTO {private Long id;
    private Long postId;
    private Date createdDate;
    private String text;
    private String userName;
}
