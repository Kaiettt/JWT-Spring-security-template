package sim_otp.ak.config;

import java.util.Collections;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import sim_otp.ak.service.UserService;

@Component("userDetailsService")
public class UserDetailServiceImpl  implements UserDetailsService {
    private UserService userService;
    public UserDetailServiceImpl(UserService userService){
        this.userService = userService;
    }
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        sim_otp.ak.domain.entity.User user = this.userService.getUserByUserName(username);
        if(user == null){
            throw new UsernameNotFoundException("Username/Password not valid");
        }
        User user_detail = new User(
            user.getEmail(),
            user.getPassword(),
            Collections.singletonList(new SimpleGrantedAuthority("ROLE_" + user.getRole().name())));
        return user_detail;
    }
}

