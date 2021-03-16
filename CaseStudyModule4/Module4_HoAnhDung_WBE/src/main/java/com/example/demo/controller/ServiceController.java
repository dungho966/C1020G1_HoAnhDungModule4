package com.example.demo.controller;


import com.example.demo.model.Employee;
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
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/service/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("service", serviceService.findById(id));
        return "/service/edit";
    }
    @PostMapping("/service/update")
    public String update(Service service){
        serviceService.save(service);
        return "redirect:/serviceroomlist";
    }

    @GetMapping("/service/{id}/delete")
    public String delete(@PathVariable int id, Model model){
        model.addAttribute("service", serviceService.findById(id));
        return "/service/delete";
    }
    @PostMapping("/service/delete")
    public String delete(@ModelAttribute Service service, RedirectAttributes redirect){
        serviceService.remove(service.getServiceId());
        redirect.addFlashAttribute("success", "Removed Service successfully !!");
        return "redirect:/serviceroomlist";
    }

    @GetMapping("/service/{id}/view")
    public String view(@PathVariable int id, Model model){
        model.addAttribute("service", serviceService.findById(id));
        return "/service/view";
    }

//    ------------------------------------------


    @GetMapping("/servicehouselist")
    public ModelAndView ServiceHouseList (@PageableDefault(size = 5) Pageable pageable){
        return new ModelAndView("/service/houselist" ,"servicehouselist" , serviceService.findAllService(pageable) ) ;
    }

    @GetMapping("/service/housecreate")
    public String CreateHouse(Model model){
        model.addAttribute("service" , new Service()) ;
        return "service/housecreate" ;
    }

    @PostMapping("/service/housesave")
    public String SaveHouse(Service service , RedirectAttributes redirect){
        serviceService.save(service);
        redirect.addFlashAttribute("success" , "add new service successfully") ;
        return "redirect:/servicehouselist" ;
    }

    @GetMapping("/service/{id}/houseedit")
    public String editHouse(@PathVariable int id, Model model){
        model.addAttribute("houseservice", serviceService.findById(id));
        return "/service/houseedit";
    }
    @PostMapping("/service/houseupdate")
    public String UpdateHouse(Service service){
        serviceService.save(service);
        return "redirect:/servicehouselist";
    }

    @GetMapping("/service/{id}/housedelete")
    public String deleteHouse(@PathVariable int id, Model model){
        model.addAttribute("service", serviceService.findById(id));
        return "/service/housedelete";
    }
    @PostMapping("/service/housedelete")
    public String deleteHouse(@ModelAttribute Service service, RedirectAttributes redirect){
        serviceService.remove(service.getServiceId());
        redirect.addFlashAttribute("success", "Removed Service successfully !!");
        return "redirect:/servicehouselist";
    }

    @GetMapping("/service/{id}/houseview")
    public String viewHouse(@PathVariable int id, Model model){
        model.addAttribute("service", serviceService.findById(id));
        return "/service/houseview";
    }


//---------------------------------------------


    @GetMapping("/servicevillalist")
    public ModelAndView ServiceVillaList (@PageableDefault(size = 5) Pageable pageable){
        return new ModelAndView("/service/villalist" ,"servicevillalist" , serviceService.findAllService(pageable) ) ;
    }

    @GetMapping("/service/villacreate")
    public String CreateVilla(Model model){
        model.addAttribute("service" , new Service()) ;
        return "service/villacreate" ;
    }

    @PostMapping("/service/villasave")
    public String SaveVilla(Service service , RedirectAttributes redirect){
        serviceService.save(service);
        redirect.addFlashAttribute("success" , "add new service successfully") ;
        return "redirect:/servicevillalist" ;
    }

    @GetMapping("/service/{id}/villaedit")
    public String editVilla(@PathVariable int id, Model model){
        model.addAttribute("villaservice", serviceService.findById(id));
        return "/service/villaedit";
    }
    @PostMapping("/service/villaupdate")
    public String Updatevilla(Service service){
        serviceService.save(service);
        return "redirect:/servicevillalist";
    }

    @GetMapping("/service/{id}/villadelete")
    public String deleteVilla(@PathVariable int id, Model model){
        model.addAttribute("service", serviceService.findById(id));
        return "/service/villadelete";
    }
    @PostMapping("/service/villadelete")
    public String deleteVilla(@ModelAttribute Service service, RedirectAttributes redirect){
        serviceService.remove(service.getServiceId());
        redirect.addFlashAttribute("success", "Removed Service successfully !!");
        return "redirect:/servicevillalist";
    }

    @GetMapping("/service/{id}/villaview")
    public String viewVilla(@PathVariable int id, Model model){
        model.addAttribute("service", serviceService.findById(id));
        return "/service/villaview";
    }



}
