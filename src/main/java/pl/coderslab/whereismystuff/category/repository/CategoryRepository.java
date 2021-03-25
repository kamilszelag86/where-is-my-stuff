package pl.coderslab.whereismystuff.category.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.coderslab.whereismystuff.category.entity.Category;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.user.entity.User;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CategoryRepository extends JpaRepository<Category, Long> {

    List<Category> findAllByTeamOrderByNameAsc(Team team);

    List<Category> findAllByUserOrderByNameAsc(User user);

    @Modifying
    @Query(nativeQuery = true, value = "DELETE FROM project.items_categories WHERE categories_id = :categoryId")
    void clearCategory(long categoryId);

}
