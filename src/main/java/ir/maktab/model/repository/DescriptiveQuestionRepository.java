package ir.maktab.model.repository;

import ir.maktab.model.entity.DescriptiveQuestion;
import org.springframework.data.repository.Repository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface DescriptiveQuestionRepository extends Repository<DescriptiveQuestion, Long> {

    DescriptiveQuestion save(DescriptiveQuestion descriptiveQuestion);

    DescriptiveQuestion findById(Long id);

    List<DescriptiveQuestion> findAll();
}
