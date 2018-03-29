package com.technical.recruitment.platform.security.config;

import com.technical.recruitment.platform.security.dao.UserDAO;
import com.technical.recruitment.platform.security.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class TechnicalRecruitmentPlatformAuthenticationPovider implements AuthenticationProvider{

    @Autowired
    private UserDAO userDAO;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = authentication.getCredentials().toString();
        Optional<UserDTO> userDTOOptional = userDAO.getUserByUserName(userName);

        if(userDTOOptional == null) {
            throw new BadCredentialsException("Username is not valid");
        }
        UserDTO userDTO = userDTOOptional.get();

        if (password.equals(userDTO.getPassword())) {
            List<GrantedAuthority> grantedAuths = new ArrayList<>();
            grantedAuths.add(new SimpleGrantedAuthority(userDTO.getUserRole()));
            return new UsernamePasswordAuthenticationToken(userName, password, grantedAuths);
        } else {
            throw new BadCredentialsException("Password incorrect.");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

}
