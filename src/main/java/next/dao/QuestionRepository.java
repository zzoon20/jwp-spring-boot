package next.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import next.model.Question;

public interface QuestionRepository extends JpaRepository<Question, Long> {
}
