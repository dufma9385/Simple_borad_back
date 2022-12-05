package com.minkyeong.studio.controller;

import com.minkyeong.studio.entity.Item;
import com.minkyeong.studio.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    ItemRepository itemRepository;

    @GetMapping(value = "/itemList")
    public List<Item> itemInfo () {
        return itemRepository.findAll();
    }

    @PostMapping("/insert")
    public String insertItem(@RequestBody Item item) {
        try {
            Optional<Item> findName = itemRepository.findByName(item.getName());

            if (!findName.isPresent()) {
                itemRepository.save(item);
                return "저장 성공";
            } else {
                return "같은 이름 존재";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "저장 실패";
        }
    }

    @DeleteMapping("/delete")
    public String deleteItem(Item item) {
        System.out.println(item);
        try {
            Optional<Item> findName = itemRepository.findByName(item.getName());

            if (!findName.isPresent()) {
                return "존재 하지 않는 값";
            } else {
                itemRepository.deleteAllByName(item.getName());
                return "삭제 성공";
            }
        } catch (Exception e) {
            System.out.println(e);
            return "삭제 실패";
        }
    }
}
