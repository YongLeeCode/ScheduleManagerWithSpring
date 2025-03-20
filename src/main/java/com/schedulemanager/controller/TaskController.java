package com.schedulemanager.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author : yong
 * @packageName : com.schedulemanager.controller
 * @fileName : TaskController
 * @date : 3/20/25
 * @description :
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 3/20/25        yong       최초 생성
 */
@RestController
@RequestMapping("/schedule-manager")
public class TaskController {

    @PostMapping
    public void addNewTask(@RequestBody ) {

    }
}
