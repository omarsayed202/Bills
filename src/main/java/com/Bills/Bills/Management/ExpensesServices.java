package com.Bills.Bills.Management;

import com.Bills.Bills.Items.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfiteServices {
    @Autowired
    ProfiteRepository profiteRepository;
    @Autowired
    ItemRepository itemRepository;
    void LoadProfite(Profite profite)
    {
        profiteRepository.save(profite);
    }


}
