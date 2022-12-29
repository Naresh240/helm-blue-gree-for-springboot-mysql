package sample.springframework.services;

import sample.springframework.domain.Sample;
import sample.springframework.repositories.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class SampleServiceImpl implements SampleService {

    private SampleRepository sampleRepository;

    @Autowired
    public SampleServiceImpl(SampleRepository sampleRepository) {
        this.sampleRepository = sampleRepository;
       }



    @Override
    public Sample getById(Long id) {
        return sampleRepository.findById(id).orElse(null);
    }

    @Override
    public Sample saveOrUpdate(Sample sample) {
        sampleRepository.save(sample);
        return sample;
    }
    
    @Override
    public Sample getOrCreateSample() {
        Sample sample=new Sample();
    	sample.setDescription("Hello World");
    	sampleRepository.save(sample);
        return sample;
    }


   
}
