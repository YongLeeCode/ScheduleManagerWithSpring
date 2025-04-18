package com.schedulemanager.user.controller;

import com.schedulemanager.user.dto.UserRequestDto;
import com.schedulemanager.user.dto.UserResponseDto;
import com.schedulemanager.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Long> register(@Valid @RequestBody UserRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(dto));
    }

    @GetMapping("/{id}")
    public UserResponseDto findUserById(@PathVariable long id) {
        return userService.findUserById(id);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<String> update(@PathVariable long id, @RequestParam String password, @RequestBody UserRequestDto dto) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.updateUser(id, password, dto) + "회원의 정보가 정상적으로 수정되었습니다.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable long id, @RequestParam String password) {
        return ResponseEntity.status(HttpStatus.OK).body(userService.deleteUser(id, password) + "회원님이 탈퇴 완료하셨습니다.");
    }
}
