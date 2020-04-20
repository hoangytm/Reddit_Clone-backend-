package hoangytm.reddit_clone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;

/**
 * @author PhanHoang
 * 4/20/2020
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "id")
    private Long id;
    @NotEmpty
    @Column(name = "text")
    private String text;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post", referencedColumnName = "post_id")
    private Post post;
    @Column(name = "created_date")
    private Date createdDate;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user", referencedColumnName = "user_id")
    private User user;
}