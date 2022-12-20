package dish.service;

import dish.repository.DishRepository;
import domain.model.Dish;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DishService {
    private DishRepository repository;

    public DishService(DishRepository repository) {
        this.repository = repository;
    }

    public Dish saveDish(Dish dish) {
        return repository.save(dish);
    }

    public boolean updateDish(Dish dish) {
        var rsl = findById(dish.getId());
        if (rsl.isPresent()) {
            repository.save(dish);
            return true;
        } else {
            return false;
        }
    }

    public List<Dish> findAllDish() {
        List<Dish> rsl = new ArrayList<>();
        repository.findAll().forEach(rsl::add);
        return rsl;
    }

    public Optional<Dish> findById(int id) {
        return repository.findById(id);
    }

    public boolean deleteDish(Dish dish) {
        var rsl = findById(dish.getId());
        if (rsl.isPresent()) {
            repository.delete(dish);
            return true;
        } else {
            return false;
        }
    }
}