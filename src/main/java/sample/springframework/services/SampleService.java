package sample.springframework.services;

import sample.springframework.domain.Sample;

import java.util.List;


public interface SampleService {

    Sample getById(Long id);
    Sample saveOrUpdate(Sample sample);
    Sample getOrCreateSample();
    
}
