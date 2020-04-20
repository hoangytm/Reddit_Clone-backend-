package hoangytm.reddit_clone.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.*;

/**
 * @author PhanHoang
 * 4/20/2020
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "token")
public class VerificationToken {

    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "token")
    private String token;
    @OneToOne(fetch = LAZY)
    private User user;
    @Column(name = "expiry_date")
    private Date expiryDate;
}
