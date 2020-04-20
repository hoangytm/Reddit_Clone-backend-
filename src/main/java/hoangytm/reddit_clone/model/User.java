package hoangytm.reddit_clone.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

/**
 * @author PhanHoang
 * 4/20/2020
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@Table(name = "user")
@NoArgsConstructor
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userId;
    @NotBlank(message = "Username is required")
    @Column(name = "user_name")
    private String username;
    @NotBlank(message = "Password is required")
    @Column(name = "password")
    private String password;
    @Email
    @NotEmpty(message = "Email is required")
    @Column(name = "email")
    private String email;
    @Column(name = "created")
    private Date created;
    @Column(name = "enabled")
    private boolean enabled;
}
