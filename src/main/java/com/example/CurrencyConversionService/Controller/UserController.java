package com.example.CurrencyConversionService.Controller;

import java.net.URI;
import java.util.List;
import java.util.Locale;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.CurrencyConversionService.Exception.UserNotFoundException;
import com.example.CurrencyConversionService.Service.UserDAOService;
import com.example.CurrencyConversionService.Vo.HelloWorldVo;
import com.example.CurrencyConversionService.Vo.UserVo;

@RestController
@RequestMapping("Currency")
public class UserController {
	@Autowired
	UserDAOService userDAOService;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path="/getConversion/path-variable/{name}")
	public HelloWorldVo getConversion(@PathVariable String name) {
		 System.out.println("----In Controller--------");
		 return new HelloWorldVo(String.format("Hello World %s", name));
	}
	
	@GetMapping(path="/getAllUser")
	public List<UserVo> getAllUser() {
		 System.out.println("----getAllUser--------");
		 return userDAOService.getAllUser();
	}
	
	@GetMapping(path="/reteriveUser/{id}")
	public UserVo reteriveUser(@PathVariable int id) {
		//userList.add(user);
		UserVo userVo = userDAOService.reteriveUser(id);
		
		/*
		 * ControllerLinkBuilder ordersLink = linkTo(methodOn(this.getClass()).g;
		 * 
		 * Resource<UserVo> resource = new Resource<UserVo>(userVo);
		 * 
		 * ControllerLinkBuilder linkTo= lin
		 */
		
		return userDAOService.reteriveUser(id);
		
	}
	
	@PostMapping(path="/saveUser")
	public ResponseEntity<Object> saveUser(@RequestBody UserVo user) {
		UserVo getUser = userDAOService.saveUser(user);
     URI location = ServletUriComponentsBuilder
    		 		.fromCurrentRequest()
    		 		.path("/{id}")
    		 		.buildAndExpand(getUser.getId())
    		 		.toUri();
		return ResponseEntity.created(location).build();

		//return userDAOService.saveUser(user);
		//UserNotFoundException
	}
	
	@DeleteMapping(path="/deleteUser/{id}")
	public UserVo deleteUser(@PathVariable int id) {
		//userList.add(user);
		UserVo userVo = userDAOService.deleteUser(id);
		
		if(userVo == null)
			throw new UserNotFoundException("Data Not Found");
		
		return userVo;
		
	}
	
	@GetMapping(path="/hello-world-internationalized")
	public String helloWorldInternationalized() {
		 System.out.println("----helloWorldInternationalized--------");
		 return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
	}
	
}
