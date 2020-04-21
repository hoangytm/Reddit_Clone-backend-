package hoangytm.reddit_clone.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author PhanHoang
 * 4/21/2020
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ApiResponse {
    private  int code;
    private int status;
    private String message;
    private Object data;

    public ApiResponse(int code, String message) {
        this.code = code;
        this.message = message;
    }
}