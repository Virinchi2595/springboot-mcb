package com.mcb.assignment.auth;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserDetailService implements UserDetailsService {

  @Value("${auth.username}")
  private String username;

  @Value("${auth.password}")
  private String password;

  @Override
  public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
    return new User(username, new BCryptPasswordEncoder().encode(password), new ArrayList<>());
  }
}
