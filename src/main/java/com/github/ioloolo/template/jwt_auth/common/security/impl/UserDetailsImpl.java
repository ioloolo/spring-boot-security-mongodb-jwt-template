package com.github.ioloolo.template.jwt_auth.common.security.impl;

import java.io.Serial;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.github.ioloolo.template.jwt_auth.domain.auth.data.User;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetails {

	@Serial
	private static final long serialVersionUID = 1L;

	private final String id;

	private final String username;

	private final String email;

	@JsonIgnore
	private final String password;

	private final Collection<? extends GrantedAuthority> authorities;

	public static UserDetailsImpl from(User user) {
		List<GrantedAuthority> authorities = user.getRoles().stream()
			.map(role -> new SimpleGrantedAuthority(role.getName().name()))
			.collect(Collectors.toList());

		return UserDetailsImpl.builder()
			.id(user.getId())
			.username(user.getUsername())
			.email(user.getEmail())
			.password(user.getPassword())
			.authorities(authorities)
			.build();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
