package Contoller;

import Service.CategoryService;
import model.Category;
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
@RequestMapping("/api/Category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")  //localhost:8080/api/Category/all
    public List<Category> getAll() {
        return categoryService.getAll();
    }
    @GetMapping("/{id}")  //localhost:8080/api/Category/id
    public Optional<Category> getCategory(@PathVariable("id")int id){
        return categoryService.getCategory(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody Category category){
        return categoryService.save(category);
    }

}
