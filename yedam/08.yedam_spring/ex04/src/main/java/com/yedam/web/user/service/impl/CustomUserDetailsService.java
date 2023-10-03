package com.yedam.web.user.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.yedam.web.user.mapper.UserMapper;
import com.yedam.web.user.service.CustomUser;
import com.yedam.web.user.service.MemberVO;

@Component("userDetailsService")
public class CustomUserDetailsService implements UserDetailsService{
	
	@Autowired
	UserMapper userMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MemberVO vo = userMapper.getMemeber(username);
		return vo == null ? null : new CustomUser(vo);
	}
}
