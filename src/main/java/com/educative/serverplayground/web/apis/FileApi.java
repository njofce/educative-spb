package com.educative.serverplayground.web.apis;

import com.educative.serverplayground.models.FileMetadata;
import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("file")
public interface FileApi {

  @GetMapping("/{id}")
  FileMetadata getFile(@PathVariable String id);

  @GetMapping("/search")
  List<FileMetadata> searchFiles(@RequestParam(name = "name") String name);

  @PostMapping("/save")
  String saveFile(@RequestBody FileMetadata file);

  @PutMapping("/update/{id}")
  String updateFile(@RequestBody FileMetadata file, @PathVariable String id);

  @DeleteMapping("/delete/{id}")
  String updateFile(@PathVariable String id);
}
