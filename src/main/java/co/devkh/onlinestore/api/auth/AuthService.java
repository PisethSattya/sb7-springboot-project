package co.devkh.onlinestore.api.auth;

import co.devkh.onlinestore.api.auth.web.LoginDto;
import co.devkh.onlinestore.api.auth.web.RegisterDto;
import co.devkh.onlinestore.api.auth.web.VerifyGenerateCodeDto;
import jakarta.mail.MessagingException;

public interface AuthService {
    void register(RegisterDto registerDto) throws MessagingException;
    void verifyGenerateCode(VerifyGenerateCodeDto verifyGenerateCodeDto);
    void login(LoginDto loginDto);
}
