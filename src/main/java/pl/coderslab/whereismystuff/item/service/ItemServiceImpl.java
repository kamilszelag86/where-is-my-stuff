package pl.coderslab.whereismystuff.item.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Service;
import pl.coderslab.whereismystuff.category.entity.Category;
import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.item.repository.ItemRepository;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.security.entity.CurrentUser;
import pl.coderslab.whereismystuff.user.entity.User;
import pl.coderslab.whereismystuff.utils.FileUploadUtil;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Override
    public List<Item> findAllByUser(User user) {
        return itemRepository.findAllByUser(user);
    }

    @Override
    public List<Item> findAllByLocation(Location location) {
        return itemRepository.findAllByLocation(location);
    }

    @Override
    public List<Item> findAllByCategory(Category category) {
        return itemRepository.findAllByCategories(category);
    }

    @Override
    public Item findById(long itemId) throws EntityNotFoundException {
        return itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Item create(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item update(Item item) {
        if (itemRepository.existsById(item.getId())) {
            return itemRepository.save(item);
        }
        return null;
    }

    @Override
    public void delete(long itemId) {
        if (itemRepository.existsById(itemId)) {
            itemRepository.deleteById(itemId);
        }
    }

    @Override
    public void setItemImage(Item item, String fileName) {
        itemRepository.setItemImage(item, fileName);
    }

    @Override
    public void setReceiptImage(Item item, String fileName) {
        itemRepository.setReceiptImage(item, fileName);
    }

    @Override
    public void setLocation(List<Item> items, Location location) {
        items.forEach(item -> itemRepository.setLocation(item, location));
    }

    @Override
    public boolean existsByLocation(Location location) {
        return itemRepository.existsByLocation(location);
    }

}
