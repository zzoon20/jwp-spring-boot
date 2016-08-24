package next;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import next.CannotOperateException;
import next.dao.AnswerRepository;
import next.dao.QuestionRepository;
import next.dao.UserRepository;
import next.model.Answer;
import next.model.Question;
import next.model.User;
import next.service.QnaService;


public class QnaServiceTest extends IntegrationTest{
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private QuestionRepository questionRepository;
	@Autowired
	private AnswerRepository answerRepository;
	private QnaService qnaService;
	

	@Before
	public void setUp() throws Exception {
		qnaService = new QnaService(questionRepository, answerRepository);
		
		User admin = new User("admin","password","javajigi","admin@hi.com");
		User user1 = new User("user1","password","lee","lee@hi.com");
		
		userRepository.save(admin);
		userRepository.save(user1);
		
	}

	@Test(expected=CannotOperateException.class)
	public void test_다른사람이쓴_댓글이_존재() throws Exception {
		Question question = new Question(userRepository.findOne("admin"), "제목하나", "글하나");
		questionRepository.save(question);
		answerRepository.save(new Answer(userRepository.findOne("user1"), "의견하나", questionRepository.findOne(1L)));
		
		qnaService.deleteQuestion(1, userRepository.findOne("admin"));
	}
	
	@Test
	public void test_삭제가능() throws Exception {
		Question question = new Question(userRepository.findOne("admin"), "제목둘", "글둘");
		questionRepository.save(question);
		
		qnaService.deleteQuestion(2, userRepository.findOne("admin"));
	}

}
