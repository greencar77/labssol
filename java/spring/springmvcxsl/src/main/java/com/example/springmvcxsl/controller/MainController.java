package com.example.springmvcxsl.controller;
 
import com.example.springmvcxsl.model.UserData;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
 
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.dom.DOMSource;
import org.w3c.dom.Document;
 
@Controller
public class MainController {
 
    @GetMapping("/")
    public ModelAndView showForm() throws JAXBException, ParserConfigurationException {
        UserData data = new UserData("", "", false);
        return new ModelAndView("mainView", "userData", convertToSource(data));
    }
 
    @PostMapping("/process")
    public ModelAndView processForm(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email,
            @RequestParam(required = false) String action) throws JAXBException, ParserConfigurationException {
        
        UserData data = new UserData(name, email, false);
        
        if ("disable".equals(action)) {
            data.setDisableSubmit(true);
            data.setMessage("The submit button in Form 2 is now disabled because you clicked 'Disable' in Form 1.");
        } else {
            data.setMessage("Form processed successfully. Name: " + name + ", Email: " + email);
        }
        
        return new ModelAndView("mainView", "userData", convertToSource(data));
    }
 
    private Source convertToSource(UserData data) throws JAXBException, ParserConfigurationException {
        Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        JAXBContext context = JAXBContext.newInstance(UserData.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.marshal(data, document);
        return new DOMSource(document);
    }
}
