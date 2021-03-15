package pl.coderslab.whereismystuff.item.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.item.repository.ItemRepository;
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
    public List<Item> findAllByTeam(Team team) {
        return itemRepository.findAllByTeam(team);
    }

    @Override
    public Item findById(long itemId) throws EntityNotFoundException {
        return itemRepository.findById(itemId).orElseThrow(EntityNotFoundException::new);
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
