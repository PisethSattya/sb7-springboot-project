package co.devkh.onlinestore.api.auth.web;

import co.devkh.onlinestore.api.auth.AuthService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    @Value("${app.base-uri}")
    private String appBaseUri;

    @PostMapping("/token")
    public AuthDto refreshToken(@Valid @RequestBody RefreshTokenDto refreshTokenDto){
       return authService.refreshToken(refreshTokenDto);
    }
    @PostMapping("/login")
    public AuthDto login (@Valid @RequestBody LoginDto loginDto){
        authService.login(loginDto);

        return authService.login(loginDto);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/register")
    public Map<String,String> register(@RequestBody @Valid RegisterDto registerDto) throws MessagingException {
        authService.register(registerDto);
        return Map.of("message","Please check email and verify..!",
                "verifyUri",appBaseUri+"auth/verify?email="+registerDto.email());
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/verifyGenerateCode")
    public Map<String,String> verifyGenerateCode(@RequestBody @Valid VerifyGenerateCodeDto verifyGenerateCodeDto){
        authService.verifyGenerateCode(verifyGenerateCodeDto);
        return Map.of("message","Congratulation! Email has been verified..!");
    }
}
