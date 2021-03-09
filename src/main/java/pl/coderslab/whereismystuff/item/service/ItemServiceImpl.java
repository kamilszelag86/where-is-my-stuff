package pl.coderslab.whereismystuff.item.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.item.repository.ItemRepository;
import pl.coderslab.whereismystuff.user.entity.User;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

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
    public Optional<Item> findById(long itemId) {
        return itemRepository.findById(itemId);
    }

    @Override
    public void create(Item item) {
        itemRepository.save(item);
    }

    @Override
    public void update(Item item) {
        if (itemRepository.existsById(item.getId())) {
            itemRepository.save(item);
        }
    }

    @Override
    public void delete(long itemId) {
        if (itemRepository.existsById(itemId)) {
            itemRepository.deleteById(itemId);
        }
    }

}
