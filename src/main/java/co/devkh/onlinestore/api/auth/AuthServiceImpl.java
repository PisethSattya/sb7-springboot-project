package co.devkh.onlinestore.api.auth;

import co.devkh.onlinestore.api.auth.web.LoginDto;
import co.devkh.onlinestore.api.auth.web.RegisterDto;
import co.devkh.onlinestore.api.auth.web.VerifyGenerateCodeDto;
import co.devkh.onlinestore.api.mail.Mail;
import co.devkh.onlinestore.api.mail.MailService;
import co.devkh.onlinestore.api.user.User;
import co.devkh.onlinestore.api.user.UserService;
import co.devkh.onlinestore.api.user.web.NewUserDto;
import co.devkh.onlinestore.util.RandomUtil;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService{
    private final UserService userService;
    private final AuthRepository authRepository;
    private final AuthMapper authMapper;
    private final MailService mailService;

    @Value("${spring.mail.username}")
    private String adminMail;
    @Transactional
    @Override
    public void register(RegisterDto registerDto) throws MessagingException {

        NewUserDto newUserDto = authMapper.mapRegisterDtoToNewUserDto(registerDto);
        userService.createNewUser(newUserDto);

        String verifiedCode = RandomUtil.generateCode();
        System.out.println(verifiedCode);

        // Store verificationCode in database
        authRepository.updateVerifiedCode(registerDto.username(),verifiedCode);

        // Send verifiedCode via email
        Mail<String> verifiedMail = new Mail<>();
        verifiedMail.setSubject("Email Verification");
        verifiedMail.setSender(adminMail);
        verifiedMail.setReceiver(newUserDto.email());
        verifiedMail.setTemplate("auth/verify-mail");
        verifiedMail.setMetaData(verifiedCode);

        mailService.sendMail(verifiedMail);

    }
    @Transactional
    @Override
    public void verifyGenerateCode(VerifyGenerateCodeDto verifyGenerateCodeDto) {
        User verifiedUser = authRepository.findByEmailAndVerifiedCodeAndIsDeletedFalse(verifyGenerateCodeDto.email(),
                verifyGenerateCodeDto.verifiedCode()).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.UNAUTHORIZED,
                        "Verify email has been failed..!"));

        verifiedUser.setIsVerified(true);
        verifiedUser.setVerifiedCode(null);

        authRepository.save(verifiedUser);
    }
    @Override
    public void login(LoginDto loginDto) {

    }
}
