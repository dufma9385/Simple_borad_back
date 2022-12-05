package com.minkyeong.studio.repository;

import com.minkyeong.studio.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
//    List<Item> findByName(String name);
    Optional<Item> findByName(String name);

    @Transactional
    List<Item> deleteAllByName(String name);
}
