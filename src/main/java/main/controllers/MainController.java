package main.controllers;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import main.dto.UserDto;

@Controller
public class MainController {
	
	@RequestMapping("/index")
	public ModelAndView main() {
		ModelAndView mav = new ModelAndView("index");
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if(null != authentication && null != mav) { //TODO ajax라면?
			Object principal = authentication.getPrincipal();
			if(principal instanceof UserDto) {
				UserDto user = (UserDto)principal;
				if(null != user) {
					mav.addObject("username", user.getUsername());
					mav.addObject("nickname", user.getNickname());
				}
			}
		}
		
		return mav;
	}
	
	@RequestMapping("/login")
	public ModelAndView login(
			@RequestParam(value="error", required=false)String error) {
		ModelAndView mav = new ModelAndView("index");
		
		if(null != error) {
			mav.addObject("msg", "로그인 실패");
		}
		
		return mav;
	}

}
