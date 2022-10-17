package Contoller;

import Service.AdminService;
import model.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins= "*", methods ={ RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,
        RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping("/all") //localhost:8080/api/Admin/all
    public List<Admin> getAll(){

        return adminService.getAll();
    }
    @GetMapping("/{id}") //localhost:8080/api/Admin/id
    public Optional<Admin> getAdmin(@PathVariable("id") int id){

        return adminService.getAdmin(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin){

        return adminService.save(admin);
    }
}
