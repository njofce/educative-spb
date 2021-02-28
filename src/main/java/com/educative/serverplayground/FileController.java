package com.educative.serverplayground;

import com.educative.serverplayground.remote.FileMetadata;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("file")
public class FileController {

  @GetMapping("/{id}")
  public FileMetadata getFile(@PathVariable(name = "id") String id) {
    return FileMetadata.newBuilder().setId(id).setName("name").setMetadata("some metadata").build();
  }
}
