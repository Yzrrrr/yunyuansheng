package com.example.progressservice.controller;

import com.example.progressservice.entity.Progress;
import com.example.progressservice.repository.ProgressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@RestController
public class ProgressController {

    @Autowired
    private ProgressRepository repository;

    // 获取所有进度记录
    @GetMapping("/all")
    public List<Progress> all() {
        return repository.findAll();
    }

    // 根据 ID 获取单条记录
    @GetMapping("/{id}")
    public Optional<Progress> getById(@PathVariable Long id) {
        return repository.findById(id);
    }

    // 添加新进度记录
    @PostMapping("/add")
    @Transactional  // ⭐添加事务注解，确保提交
    public Progress add(@RequestBody Progress progress) {
        return repository.save(progress);
    }

    // 更新进度记录
    @PutMapping("/update/{id}")
    @Transactional
    public Progress update(@PathVariable Long id, @RequestBody Progress newProgress) {
        return repository.findById(id)
                .map(progress -> {
                    progress.setProjectName(newProgress.getProjectName());
                    progress.setStage(newProgress.getStage());
                    progress.setStatus(newProgress.getStatus());
                    progress.setDate(newProgress.getDate());
                    return repository.save(progress);
                })
                .orElseGet(() -> {
                    newProgress.setId(id);
                    return repository.save(newProgress);
                });
    }

    // 删除进度记录
    @DeleteMapping("/delete/{id}")
    @Transactional
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }
}