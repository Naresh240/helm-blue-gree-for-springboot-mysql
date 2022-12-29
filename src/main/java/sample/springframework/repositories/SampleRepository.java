package sample.springframework.repositories;

import sample.springframework.domain.Sample;
import org.springframework.data.repository.CrudRepository;

public interface SampleRepository extends CrudRepository<Sample, Long> {
}
