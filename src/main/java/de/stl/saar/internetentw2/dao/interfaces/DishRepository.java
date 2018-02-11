package de.stl.saar.internetentw2.dao.interfaces;

import de.stl.saar.internetentw2.dao.entity.DishEntity;
import de.stl.saar.internetentw2.model.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface DishRepository extends CrudRepository<DishEntity, Long> {

}
