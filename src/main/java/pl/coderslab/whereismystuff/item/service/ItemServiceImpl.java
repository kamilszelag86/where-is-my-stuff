package pl.coderslab.whereismystuff.item.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.item.repository.ItemRepository;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.user.entity.User;

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
    public List<Item> findAllByTeam(Team team) {
        return itemRepository.findAllByTeam(team);
    }

    @Override
    public List<Item> findAllByLocation(Location location) {
        return itemRepository.findAllByLocation(location);
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

}
