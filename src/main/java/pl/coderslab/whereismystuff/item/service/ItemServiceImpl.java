package pl.coderslab.whereismystuff.item.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.coderslab.whereismystuff.category.entity.Category;
import pl.coderslab.whereismystuff.item.entity.Item;
import pl.coderslab.whereismystuff.item.repository.ItemRepository;
import pl.coderslab.whereismystuff.location.entity.Location;
import pl.coderslab.whereismystuff.team.entity.Team;
import pl.coderslab.whereismystuff.user.entity.User;
import pl.coderslab.whereismystuff.utils.FileUploadUtil;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.io.IOException;
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
    public void delete(Item item) throws IOException {
        if (itemRepository.existsById(item.getId())) {
            if (item.getItemImagePath() != null) {
                FileUploadUtil.deleteFile(item.getItemImagePath());
            }
            if (item.getReceiptImagePath() != null) {
                FileUploadUtil.deleteFile(item.getReceiptImagePath());
            }
            itemRepository.deleteById(item.getId());
        }
    }

    @Override
    public void setItemImage(Item item, MultipartFile multipartFile) throws IOException {
        if (item.getItemImagePath() != null) {
            FileUploadUtil.deleteFile(item.getItemImagePath());
        }
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uploadDir = "item-images/" + item.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        itemRepository.setItemImage(item, fileName);
    }

    @Override
    public void setReceiptImage(Item item, MultipartFile multipartFile) throws IOException {
        if (item.getReceiptImagePath() != null) {
            FileUploadUtil.deleteFile(item.getReceiptImagePath());
        }
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        String uploadDir = "item-images/" + item.getId();
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
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

    @Override
    public long countByTeam(Team team) {
        return itemRepository.countByTeam(team);
    }
}