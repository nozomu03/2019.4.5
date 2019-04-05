package hs.kr.dgsw._20190326.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue
    private Long id;

    private String userName;
    private String email;

    @CreationTimestamp
    private LocalDateTime joined;
    @UpdateTimestamp
    private LocalDateTime modified;

    private String location;
    private String fileN;

    public User(String userName, String email, String location, String fileN) {
        this.userName = userName;
        this.email = email;
        this.location = location;
        this.fileN = fileN;
    }
}
