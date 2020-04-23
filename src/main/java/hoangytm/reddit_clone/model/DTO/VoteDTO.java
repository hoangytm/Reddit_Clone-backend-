package hoangytm.reddit_clone.model.DTO;


import hoangytm.reddit_clone.model.VoteType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PhanHoang
 * 4/23/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteDTO {
    private VoteType voteType;
    private Long postId;
}
