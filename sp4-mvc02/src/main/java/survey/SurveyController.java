package survey;

import java.util.Arrays;
import java.util.List;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping("/survey") // 어떤 페이지를 이동하더라도 이 주소를 사용하겠다.
public class SurveyController {
	@RequestMapping(method=RequestMethod.GET)
	public String form(Model model) {
		List<Question> questions = createQuestions();
		model.addAttribute("questions", questions);
		return "survey/surveyForm";
	}
	
	private List<Question> createQuestions() {
		Question q1 = new Question("당신의 역할은 무엇입니까?", 
				Arrays.asList("서버","프론트","풀스택"));
		Question q2 = new Question("많이 사용하는 개발도구는 무엇입니까?", 
				Arrays.asList("이클립스","인텔리J","서브라임"));
		Question q3 = new Question("하고 싶은 말을 적어주세요.");
		return Arrays.asList(q1,q2,q3); // Arrays.asList하면 리스트로 만들어진다.
	}
	
	@RequestMapping(method=RequestMethod.POST)
		// model.addAttribute("andData", data); 이것과 같은 의미 아래 줄
	public String submit(@ModelAttribute("ansData") AnsweredData data) {
		return "survey/submitted";
	}
}
