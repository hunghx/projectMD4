package ra.project.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class FormRegister {
    private String username;
    private String email;
    private String fullName;
    private String password;
    private String confirmPassword;
    private MultipartFile image;
    private String phone;
    private String address;
}
