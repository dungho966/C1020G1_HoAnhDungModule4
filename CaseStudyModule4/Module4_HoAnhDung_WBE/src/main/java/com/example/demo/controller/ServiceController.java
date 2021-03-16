package com.example.demo.controller;


import com.example.demo.model.RentType;
import com.example.demo.model.Service;
import com.example.demo.model.ServiceType;
import com.example.demo.service.RentTypeService;
import com.example.demo.service.ServiceService;
import com.example.demo.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ServiceController {
    @Autowired
    private ServiceService serviceService ;

    @Autowired
    private RentTypeService rentTypeService ;

    @Autowired
    private ServiceTypeService serviceTypeService ;

    @ModelAttribute("renttype")
    public Iterable<RentType> rentTypes (Pageable pageable){
        return rentTypeService.findAllRentType(pageable) ;
    }

    @ModelAttribute("servicetype")
    public Iterable<ServiceType> serviceTypes (Pageable pageable){
        return serviceTypeService.findAllServiceType(pageable) ;
    }




    @GetMapping("/serviceroomlist")
    public ModelAndView ServiceList (@PageableDefault(size = 5) Pageable pageable){
        return new ModelAndView("/service/list" ,"servicelist" , serviceService.findAllService(pageable) ) ;
    }

    @GetMapping("/service/create")
    public String Create(Model model){
        model.addAttribute("service" , new Service()) ;
        return "service/create" ;
    }

    @PostMapping("/service/save")
    public String Save(Service service , RedirectAttributes redirect){
        serviceService.save(service);
        redirect.addFlashAttribute("success" , "add new service successfully") ;
        return "redirect:/serviceroomlist" ;
    }


}
