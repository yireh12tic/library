package Contoller;

import Service.LibraryService;
import model.Library;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins= "*", methods ={ RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,
        RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Library")
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping("/all")  //localhost:8080/api/Library/all
    public List<Library> getAll() {
        return libraryService.getAll();
    }
    @GetMapping("/{id}")  //localhost:8080/api/Library/id
    public Optional<Library> getLibrary (@PathVariable("id")int id){
        return libraryService.getLibrary(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Library save(@RequestBody Library library){
        return libraryService.save(library);
    }

}
