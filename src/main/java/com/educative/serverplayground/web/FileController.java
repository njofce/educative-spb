package com.educative.serverplayground.web;

import com.educative.serverplayground.models.FileMetadata;
import com.educative.serverplayground.web.apis.FileApi;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class FileController implements FileApi {

  public FileMetadata getFile(String id) {
    return new FileMetadata(id, "test-file", 100, "contents".getBytes());
  }

  public List<FileMetadata> searchFiles(String name) {
    List<FileMetadata> list = new ArrayList<>();
    list.add(new FileMetadata("id-1", name + "-random1", 100, "contents 1".getBytes()));
    list.add(new FileMetadata("id-2", name + "-random2", 200, "contents 2".getBytes()));
    return list;
  }

  public String saveFile(FileMetadata file) {
    System.out.println("Received the file with ID = " + file.id);
    return "Saved!";
  }

  public String updateFile(FileMetadata file, String id) {
    System.out.println("Will update the file with ID = " + id);
    return "Updated!";
  }

  public String updateFile(String id) {
    System.out.println("Will delete the file with ID = " + id);
    return "Deleted!";
  }
}
