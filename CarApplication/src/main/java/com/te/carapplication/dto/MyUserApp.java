package com.te.carapplication.dto;

import java.util.ArrayList;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class MyUserApp implements UserDetails {

	private UserApp userApp;
	
	public MyUserApp(UserApp userApp) {
		this.userApp = userApp;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Roles> roles = userApp.getRoles();
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		for (Roles roles1 : roles) {
			authorities.add(new SimpleGrantedAuthority(roles1.getName()));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return userApp.getPassword();
	}

	@Override
	public String getUsername() {
		return userApp.getUsername();
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
