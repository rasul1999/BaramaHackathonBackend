package com.hackathon.rest.controller;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackathon.error.UserNotFoundException;
import com.hackathon.model.LoginSession;
import com.hackathon.model.LoginUser;
import com.hackathon.model.Session;
import com.hackathon.model.User;
import com.hackathon.repository.LoginSessionRepository;
import com.hackathon.repository.UserRepository;

@RestController
@RequestMapping("/login")
public class LoginRestController {

	private Logger logger=Logger.getLogger(getClass().getName());
	
	@PostConstruct
	public void doFirst() {
		byte[] array = new byte[7]; // length is bounded by 7
	    new Random().nextBytes(array);
	    String generatedString = new String(array, Charset.forName("UTF-8"));
	    logger.info(">>Token:"+generatedString);
		
	}
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private LoginSessionRepository loginSessionRepo;
	
	//post request from front-end
	//for login
	@PostMapping(value="/send")
	public String userToken(@RequestBody LoginUser loginUser) {
		boolean authenticated=false;
		boolean tokenFound=false;
		
		LoginSession userToken=null;
		
		User user=userRepo.findByEmail(loginUser.getEmail());
		if(user!=null) {
			if(user.getPassword().equals(passwordEncoder.encode(loginUser.getPassword()))) {
				authenticated=true;
			}
			else {
				authenticated=false;
				throw new UserNotFoundException("Email or Password invalid!");
			}
		}
		else {
			authenticated=false;
			throw new UserNotFoundException("Email or Password invalid!");
		}
		
		
		if(authenticated) {
			String token=Session.getNewToken();
			Iterable<LoginSession> loginSessions=loginSessionRepo.findAll();
			Iterator it=loginSessions.iterator();
			
			List<LoginSession> loginSessionList = new ArrayList<>();
			
			while(it.hasNext()) {
				loginSessionList.add((LoginSession) it.next());
			}
			
			for(LoginSession check:loginSessionList) {
				if(token.equals(check.getSessionKey())) {
					token=Session.getNewToken();
					logger.info(">>New Token created: ");
					tokenFound=true;
				}
			}
			
		    userToken=new LoginSession();
		    userToken.setEmail(user.getEmail());
		    userToken.setSessionKey(token);
		    loginSessionRepo.save(userToken);
		}
		
		return userToken.getSessionKey();
	}

	
}
