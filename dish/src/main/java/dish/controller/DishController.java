package dish.controller;

import dish.service.DishService;
import domain.model.Dish;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {
    private DishService service;

    public DishController(DishService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Dish> saveDish(@RequestBody Dish dish) {
        return new ResponseEntity<Dish>(
                service.saveDish(dish),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<Void> updateDish(@RequestBody Dish dish) {
        boolean isUpdate = service.updateDish(dish);
        if (isUpdate) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping
    public ResponseEntity<List<Dish>> findAllDish() {
        return new ResponseEntity<List<Dish>>(
                service.findAllDish(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Dish> findDishById(@PathVariable int id) {
        var dish = service.findById(id);
        return new ResponseEntity<Dish>(
                dish.orElse(new Dish()),
                dish.isPresent() ? HttpStatus.OK : HttpStatus.NOT_FOUND
        );
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteDish(@RequestBody Dish dish) {
        boolean isDelete = service.deleteDish(dish);
        if (isDelete) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
