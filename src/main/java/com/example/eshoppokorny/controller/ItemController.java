package com.example.eshoppokorny.controller;

import com.example.eshoppokorny.dto.AppUserDtoV1;
import com.example.eshoppokorny.dto.InputAppUserDtoV1;
import com.example.eshoppokorny.dto.InputItemDtoV1;
import com.example.eshoppokorny.dto.ItemDtoV1;
import com.example.eshoppokorny.exceptions.ItemException;
import com.example.eshoppokorny.mapper.AppUserMapperV1;
import com.example.eshoppokorny.mapper.ItemMapperV1;
import com.example.eshoppokorny.service.ItemService;
import com.example.eshoppokorny.service.ItemServiceV1;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/products")
public class ItemController {
    private ItemService service;
    @PostMapping()
    public ResponseEntity<ItemDtoV1> createItem(@Valid @RequestBody InputItemDtoV1 inputItem) {
        return new ResponseEntity<>(ItemMapperV1.mapToItemDto(service.createItem(inputItem)), HttpStatus.CREATED);
    }
    @PostMapping("/{id}")
    public ResponseEntity<ItemDtoV1> updateItem(@Valid @RequestBody InputItemDtoV1 inputItem, @PathVariable Long id) throws ItemException {
        return new ResponseEntity<>(ItemMapperV1.mapToItemDto(service.updateItem(inputItem,id)), HttpStatus.OK);
    }
    @DeleteMapping("/id")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) throws ItemException {
        service.deleteItem(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
