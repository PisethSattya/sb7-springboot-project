package co.devkh.onlinestore.api.auth;

import co.devkh.onlinestore.api.auth.web.*;
import jakarta.mail.MessagingException;

public interface AuthService {
    AuthDto refreshToken(RefreshTokenDto refreshTokenDto);
    void register(RegisterDto registerDto) throws MessagingException;
    void verifyGenerateCode(VerifyGenerateCodeDto verifyGenerateCodeDto);
    AuthDto login(LoginDto loginDto);
}
