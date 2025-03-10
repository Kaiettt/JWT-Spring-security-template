package sim_otp.ak.domain.request;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sim_otp.ak.common.Role;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserCreateRequest {
    private String name; 
    private String email;
    private String password; 
    private Role role;
}
