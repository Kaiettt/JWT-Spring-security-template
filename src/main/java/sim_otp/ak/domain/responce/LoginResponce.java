package sim_otp.ak.domain.responce;
import org.springframework.http.ResponseCookie;
import sim_otp.ak.common.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LoginResponce {
    private String accessToken;
    private UserLogin user;
    @JsonIgnore
    private ResponseCookie springCookie;
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class UserLogin{
        private long id;
        private String userName;
        private String fullName;
        private Role role;
    }
    
}