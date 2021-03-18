package pl.coderslab.whereismystuff.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.whereismystuff.category.entity.Category;
import pl.coderslab.whereismystuff.user.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByUserOrderByNameAsc(User user);

}
