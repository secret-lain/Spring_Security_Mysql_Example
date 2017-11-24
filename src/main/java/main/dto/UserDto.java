package main.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings("serial")
public class UserDto implements UserDetails {
	private String id;
	private String password;
	private String nickname;
	private List<String> roles;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> grants = new ArrayList<SimpleGrantedAuthority>();
		
		for(String role : roles) {
			grants.add(new SimpleGrantedAuthority(role));
		}	
		
		return grants;
	}
	
	public String getNickname() {
		return nickname;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return id;
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
