package com.example.gateway.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class GuestDetailService implements UserDetailsService {

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    return new User("hophanminh", "hophanminh", new ArrayList<>());
  }
}
