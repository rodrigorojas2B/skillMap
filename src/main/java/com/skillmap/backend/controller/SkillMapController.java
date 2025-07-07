package com.skillmap.backend.controller;
import com.skillmap.backend.model.SkillMap;
import com.skillmap.backend.service.SkillMapService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/skillmap")
public class SkillMapController {
    private final SkillMapService skillMapService;
    @Autowired
    public SkillMapController(SkillMapService skillMapService) {
        this.skillMapService = skillMapService;
    }
    @PostMapping
    public ResponseEntity<SkillMap> createSkillMap(@RequestBody SkillMap skillMap) {
        return ResponseEntity.ok(skillMapService.saveSkillMap(skillMap));
    }
}
