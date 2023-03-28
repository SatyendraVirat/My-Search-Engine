package springmvcsearch;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class MyExceptionHandler {
	//Handling Exception in our Spring MVC
		@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
		@ExceptionHandler({NullPointerException.class,NumberFormatException.class})
		public String exceptionHandlerNull(Model m) {
			m.addAttribute("msg","NULL POINTER EXCEPTION");
			System.out.println();
			return "null_page";
			
		}
		
		@ExceptionHandler(value=ArrayIndexOutOfBoundsException.class)
		public String exceptionHandlerArray(Model m) {
			return "null_page";
			
		}
		//Generalize Exception Handler
		@ExceptionHandler(value=Exception.class)
		public String exceptionHandlerGeneral(Model m) {
			m.addAttribute("msg","All Exception Handeler");
			return "null_page";
			
		}
		

}
