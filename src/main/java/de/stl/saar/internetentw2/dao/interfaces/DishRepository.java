package de.stl.saar.internetentw2.dao.interfaces;

import de.stl.saar.internetentw2.dao.entity.DishEntity;
import org.springframework.data.repository.CrudRepository;

public interface DishRepository extends CrudRepository<DishEntity, Long> {

}
