package Contoller;

import Service.ScoreService;
import model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins= "*", methods ={ RequestMethod.GET, RequestMethod.POST,RequestMethod.PUT,
        RequestMethod.DELETE})
@RestController
@RequestMapping("/api/Score")
public class ScoreController {
    @Autowired
    private ScoreService scoreService;

    @GetMapping("/all")  //localhost:8080/api/Score/all
    public List<Score> getAll() {
        return scoreService.getAll();
    }
    @GetMapping("/{id}")  //localhost:8080/api/Score/id
    public Optional<Score> getScore (@PathVariable("id")int id){
        return scoreService.getScore(id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score){
        return scoreService.save(score);
    }
}
