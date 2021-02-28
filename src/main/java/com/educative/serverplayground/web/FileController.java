package com.educative.serverplayground.web;

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
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("file")
public class FileController {

  @GetMapping("/{id}")
  public FileMetadata getFile(@PathVariable String id) {
    return new FileMetadata(id, "test-file", 100, "contents".getBytes());
  }

  @GetMapping("/search")
  public List<FileMetadata> searchFiles(@RequestParam(name = "name") String name) {
    return List.of(
        new FileMetadata("id-1", name + "-random1", 100, "contents 1".getBytes()),
        new FileMetadata("id-2", name + "-random2", 200, "contents 2".getBytes()));
  }

  @PostMapping("/save")
  public String saveFile(@RequestBody FileMetadata file) {
    System.out.println("Received the file with ID = " + file.id);
    return "Saved!";
  }

  @PutMapping("/update/{id}")
  public String updateFile(@RequestBody FileMetadata file, @PathVariable String id) {
    System.out.println("Will update the file with ID = " + id);
    return "Updated!";
  }

  @DeleteMapping("/delete/{id}")
  public String updateFile(@PathVariable String id) {
    System.out.println("Will delete the file with ID = " + id);
    return "Deleted!";
  }
}
