package hoangytm.reddit_clone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PhanHoang
 * 4/20/2020
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Mail {

    private String from;
    private String to;
    private String subject;
    private String content;
}
