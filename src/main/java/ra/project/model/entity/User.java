package ra.project.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;
    @Column(length = 100, unique = true)
    private String username;
    @Column(unique = true)
    private String email;
    @Column(length = 100)
    private String fullName;
    private String password;
    private String avatar;
    @Column(length = 15)
    private String phone;
    private String address;
    private boolean status;
    private boolean role;
//    @Column(columnDefinition = "date")
    private Date createdAt; // datetime
    private Date updateAt;
    private boolean isDeleted;




}
