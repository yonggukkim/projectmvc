import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
	@RequestMapping("/hello") // http://localhost:8080/hello?name=					sk
	public String hello(Model model, @RequestParam(value="name", required=false)String name) {
		model.addAttribute("greeting", "안녕하세요." + name);
		return "hello"; // jsp파일명, spring-mvc.xml의 mvc:jsp prefix가 경로를 잡아줌.. forward
	}
}		
