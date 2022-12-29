package sample.springframework.controllers;

import sample.springframework.domain.Sample;
import sample.springframework.services.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;


@Controller
public class SampleController {
    private SampleService sampleService;
    private static final String REDIRECT_URI="redirect:/sample/show/";
    @Autowired
    public void setSampleService(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @RequestMapping("/")
    public String redirToList(){
    	Sample sample=sampleService.getOrCreateSample();
    	String id =sample.getId().toString();
    	String redirectURI=REDIRECT_URI+id;
    	return redirectURI;
    }
    
    

    @RequestMapping("/sample/show/{id}")
    public String getSample(@PathVariable String id, Model model){
        model.addAttribute("sample", sampleService.getById(Long.valueOf(id)));
        return "sample/show";
    }


}
