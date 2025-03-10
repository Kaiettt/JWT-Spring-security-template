package sim_otp.ak.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.persistence.EntityExistsException;

import org.springframework.http.HttpHeaders;

import sim_otp.ak.config.ApiMessage;
import sim_otp.ak.domain.request.LoginDTO;
import sim_otp.ak.domain.responce.LoginResponce;
import sim_otp.ak.service.AuthenicationService;

import org.springframework.security.core.Authentication;

import sim_otp.ak.common.Common;
@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationManagerBuilder authenticationManagerBuilder;
    private final AuthenicationService authenicationService;
    public AuthController( AuthenicationService authenicationService,AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.authenticationManagerBuilder = authenticationManagerBuilder;
        this.authenicationService = authenicationService;
     
    }
    @PostMapping("/login")
    @ApiMessage("Login succesfully")
    public ResponseEntity<LoginResponce> login(@RequestBody LoginDTO loginDto) {
        // Nạp input gồm username/password vào Security
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword());

        // xác thực người dùng => cần viết hàm loadUserByUsername
        Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        LoginResponce loginResponce = this.authenicationService.handleLoginResponce(authentication,loginDto.getUsername());
        
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,loginResponce.getSpringCookie().toString()).body(loginResponce);
    }

    @GetMapping("/refresh")
  @ApiMessage("Get Access Token")
  public ResponseEntity<LoginResponce> getAccessToken( @CookieValue(name = "refresh-token", defaultValue = "") String refresh_token)throws EntityExistsException {
    if(refresh_token == null || refresh_token.isEmpty()){
      throw new EntityExistsException(Common.REFRESH_TOKEN_NOT_FOUND);
    }
    LoginResponce loginResponce = this.authenicationService.getAccessToken(refresh_token);
        return ResponseEntity.ok().header(HttpHeaders.SET_COOKIE,loginResponce.getSpringCookie().toString()).body(loginResponce);
  }
}
