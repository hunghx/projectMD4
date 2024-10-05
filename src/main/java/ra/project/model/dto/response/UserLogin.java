package ra.project.model.dto.response;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class UserLogin {
    private Long id;
    private String email;
    private String fullName;
    private String avatar;
    private String phone;
    private String address;
    private boolean role;
    private boolean status;
}
