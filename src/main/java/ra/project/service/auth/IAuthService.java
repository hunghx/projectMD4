package ra.project.service.auth;

import ra.project.exception.AuthenticationException;
import ra.project.model.dto.request.FormLogin;
import ra.project.model.dto.request.FormRegister;
import ra.project.model.dto.response.UserLogin;

public interface IAuthService {
    void register(FormRegister request);
    UserLogin login(FormLogin request) throws AuthenticationException;
}
