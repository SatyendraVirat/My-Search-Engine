package springmvcsearch;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.view.RedirectView;
@Controller
public class SearchController {
	
	
	@RequestMapping("/user/{userId}/{userName}")
	public String getUserDetail(@PathVariable("userId")int userId,@PathVariable("userName")String userName) {
		System.out.println(userId);
		System.out.println(userName);
		return "home";
	}
	
	@RequestMapping("/home")
	public String home() {
		System.out.println("Welcome to Home Page  >>>");
//		String str=null;
//		System.out.println(str.length());
		return "home";
	}
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("querybox") String query) {
		
		String url="https://www.google.com/search?q="+query;
		
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(url);
        if(query.isBlank()) {
        	redirectView.setUrl("redirect:/search");
			return redirectView;
		}
        return redirectView;
		
	}
//	//Handling Exception in our Spring MVC
//	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler({NullPointerException.class,NumberFormatException.class})
//	public String exceptionHandlerNull(Model m) {
//		m.addAttribute("msg","NULL POINTER EXCEPTION");
//		System.out.println();
//		return "null_page";
//		
//	}
//	
//	@ExceptionHandler(value=ArrayIndexOutOfBoundsException.class)
//	public String exceptionHandlerArray(Model m) {
//		return "null_page";
//		
//	}
//	//Generalize Exception Handler
//	@ExceptionHandler(value=Exception.class)
//	public String exceptionHandlerGeneral(Model m) {
//		m.addAttribute("msg","All Exception Handeler");
//		return "null_page";
//		
//	}
//	
	

}
