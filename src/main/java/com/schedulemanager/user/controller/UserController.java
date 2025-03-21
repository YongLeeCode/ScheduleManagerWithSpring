package com.schedulemanager.user.controller;

import com.schedulemanager.user.dto.UserRequestDto;
import com.schedulemanager.user.dto.UserResponseDto;
import com.schedulemanager.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * @author : yong
 * @packageName : com.schedulemanager.user.controller
 * @fileName : UserController
 * @date : 3/21/25
 * @description : Controller of User domain
 */
@RestController
@RequestMapping("schedule-manager/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping
    public void register(@RequestBody UserRequestDto dto) {
        userService.save(dto);
    }

    @GetMapping("/{id}")
    public UserResponseDto findUserById(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable long id, @RequestParam String password, @RequestBody UserRequestDto dto) {
        userService.updateUser(id, password, dto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id, @RequestParam String password) {
        userService.deleteUser(id, password);
    }
}
