package ir.maktab.model.repository;

import ir.maktab.model.entity.Question;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface QuestionRepository extends Repository<Question,Integer> {

    Question save(Question question);

    List<Question> findAll();
}
