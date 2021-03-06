package ir.maktab.model.repository;

import ir.maktab.model.entity.MultipleChoiceQuestion;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface MultipleChoiceQuestionRepository extends Repository<MultipleChoiceQuestion, Long> {

    MultipleChoiceQuestion save(MultipleChoiceQuestion multipleChoiceQuestion);

    MultipleChoiceQuestion findById(Long id);

    List<MultipleChoiceQuestion> findAll();
}
