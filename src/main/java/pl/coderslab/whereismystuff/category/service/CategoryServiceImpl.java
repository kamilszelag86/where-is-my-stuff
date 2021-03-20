package pl.coderslab.whereismystuff.category.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.whereismystuff.category.entity.Category;
import pl.coderslab.whereismystuff.category.repository.CategoryRepository;
import pl.coderslab.whereismystuff.user.entity.User;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<Category> findAllByUser(User user) {
        return categoryRepository.findAllByUserOrderByNameAsc(user);
    }

    @Override
    public Category findById(long id) throws EntityNotFoundException {
        return categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public void update(Category category) {
        if (categoryRepository.existsById(category.getId())) {
            categoryRepository.save(category);
        }
    }

    @Override
    public void save(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void delete(long categoryId) {
        if (categoryRepository.existsById(categoryId)) {
            categoryRepository.clearCategory(categoryId);
            categoryRepository.deleteById(categoryId);
        }
    }

}
