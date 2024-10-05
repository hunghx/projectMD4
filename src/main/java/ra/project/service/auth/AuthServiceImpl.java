package ra.project.service.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ra.project.config.AppInit;
import ra.project.dao.user.IUserDao;
import ra.project.exception.AuthenticationException;
import ra.project.model.dto.request.FormLogin;
import ra.project.model.dto.request.FormRegister;
import ra.project.model.dto.response.UserLogin;
import ra.project.model.entity.User;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.NoResultException;
import java.io.File;
import java.io.IOException;
import java.util.Date;

@Service
public class AuthServiceImpl implements IAuthService{
    @Autowired
    private IUserDao userDao;
    @Override
    public void register(FormRegister request) {
        // chuyên đổi các thông tin trong quest sang dối tượng entity User
        User user = new User();
        user.setEmail(request.getEmail());
        user.setAddress(request.getAddress());
        user.setPassword(BCrypt.hashpw(request.getPassword(),BCrypt.gensalt(5)));
        user.setPhone(request.getPhone());
        user.setFullName(request.getFullName());
        user.setUsername(request.getUsername());
        user.setStatus(true);
        user.setCreatedAt(new Date());
        user.setUpdateAt(new Date());
        user.setDeleted(false);
        user.setRole(false);
        // upload ảnh và laays đường dâ truy câp
        MultipartFile file = request.getImage();
        String fileName = file.getOriginalFilename();
        try {
            file.transferTo(new File(AppInit.UPLOAD_PATH+fileName));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        user.setAvatar(fileName);
        // lưu lại trong db
        userDao.save(user);
    }

    @Override
    public UserLogin login(FormLogin request) throws AuthenticationException {
        try {
            User user  = userDao.loadUserByUsername(request.getUsername());
            // so sánh mật khẩu
            if(BCrypt.checkpw(request.getPassword(),user.getPassword())){
                // thành công
                return UserLogin.builder()
                        .id(user.getId())
                        .phone(user.getPhone())
                        .email(user.getEmail())
                        .avatar(user.getAvatar())
                        .address(user.getAddress())
                        .fullName(user.getFullName())
                        .role(user.isRole())
                        .status(user.isStatus())
                        .build();
            }
            throw new AuthenticationException("Khong đung majt khau");
        }catch (NoResultException e){
            // username ko tồn tại
            throw new AuthenticationException("Khong tin thay nguoi dung thong qua usename");
        }
    }
}
