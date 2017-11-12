package com.org.cf.controller;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.org.cf.dao.SubmitConsentDAO;
import com.org.cf.exception.ConsentErrorResponse;
import com.org.cf.exception.ConsentException;
import com.org.cf.model.ConsentManager;
import com.org.cf.model.Country;
import com.org.cf.model.DataOwnerPage;
import com.org.cf.service.SubmitConsentService;
import com.org.cf.service.SubmitConsentImpl;
import com.org.cf.service.MailService;

//@Controller
@RestController
@CrossOrigin(origins="http://172.25.78.37:8010/")
public class ConcentController {
	
	@Autowired
	MailService mailService;
	
	@Autowired
	SubmitConsentService service;
		
	public MailService getMailService() {
		return mailService;
	}

	public void setMailService(MailService mailService) {
		this.mailService = mailService;
	}
	
	@RequestMapping(value="/submitConsent",method=RequestMethod.POST)
	public String submitConsent(@RequestBody DataOwnerPage owner)throws SQLException {
		System.out.println("1111111111111111111111111");
		
		//CountryService service= new CountryService();
		return service.saveStandOut(owner);
		
		//return "redirect:/dataOwner";
	}
	
	@RequestMapping(value="/",method=RequestMethod.GET)
	public ModelAndView index(){
		ModelAndView view = new ModelAndView("loginForm");
		return view;
	}
	
	@RequestMapping(value="/consentStatus",method=RequestMethod.GET)
	public ModelAndView consentStatus(){
		
		ModelAndView view = new ModelAndView("ErrorLink");
		return view;
	}
	

	@RequestMapping(value="/sendmail", method=RequestMethod.GET)
	public ResponseEntity<ConsentErrorResponse> home(Locale locale , Model model,HttpServletRequest request,HttpServletResponse rsponse) throws Exception{
		
		System.out.println("Location Is:"+locale);
		System.out.println("IP Address Is:"+request.getRemoteAddr());
		
		ConsentErrorResponse error = new ConsentErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		error.setMessageLink("ConsentConfirmationLink");

		
		/*ConsentManager cm = new ConsentManager();
		cm.setRole("Admin");
		cm.setJuridection("fr");
		cm.setConsentType("email");
		cm.setEmail("prabhashmishra101@gmail.com");*/
		
		 Map<String, String> result = new HashMap();

		    Enumeration headerNames = request.getHeaderNames();
		    while (headerNames.hasMoreElements()) {
		        String key = (String) headerNames.nextElement();
		        String value = request.getHeader(key);
		        result.put(key, value);
		    }

		    for (String name: result.keySet()){

	            String key =name.toString();
	            String value = result.get(name).toString();  
	            System.out.println(key + " " + value);  


	} 
		    
		    String customerName="Prabhash";
			String recipantEmail="prabhashmishra101@gmail.com";
			
			try{
				mailService.sendMail("mumbainights101@gmail.com", recipantEmail , "Welcome To Fashioniesta Fashion Store", "Hello"+ " "+customerName+ "\n\n"+ "You Have been successfully registered with Fashioniesta.com."+"\n\n"+"Thanks,"+"\n"+"Team Fashioniesta.");
			}catch(Exception e){
				System.out.println("After Sending Mail");
				throw new ConsentException("Error Occured While sending mail");
			}
			
			
				
				return  new ResponseEntity<ConsentErrorResponse>(error, HttpStatus.OK);
							
	}
	
	@ExceptionHandler(ConsentException.class)
	public ResponseEntity<ConsentErrorResponse> exceptionHandler(Exception ex) {
		ConsentErrorResponse error = new ConsentErrorResponse();
		error.setErrorCode(HttpStatus.PRECONDITION_FAILED.value());
		//String uri=ServletUriComponentsBuilder.fromCurrentContextPath().path("/my/additional/path").build().toUriString();
		
		
		
		//Link link = new Link(uri);
		error.setMessageLink("ConsentConfirmationLink");
		return new ResponseEntity<ConsentErrorResponse>(error, HttpStatus.OK);
	}

	

	
		
		
}