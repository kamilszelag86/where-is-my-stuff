package pl.coderslab.whereismystuff.category.service;

import pl.coderslab.whereismystuff.category.entity.Category;
import pl.coderslab.whereismystuff.user.entity.User;

import java.util.List;

public interface CategoryService {

    List<Category> findAllByUser(User user);

    Category findById(long id);

    void save(Category category);

    void update(Category category);

    void delete(long categoryId);

}
