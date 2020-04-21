package hoangytm.reddit_clone.model.response;
import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * @author PhanHoang
 * 4/21/2020
 */


@Data
@AllArgsConstructor
public class AuthenticationResponse {
    private String authenticationToken;
    private String username;
}
