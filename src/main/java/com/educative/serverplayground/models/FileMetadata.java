package com.educative.serverplayground.models;

import java.time.LocalDateTime;

public class FileMetadata {

  public String id;

  public String fileName;

  public long length;

  public byte[] contents;

  public LocalDateTime lastModified;

  public String metadata;

  public FileMetadata() {}

  public FileMetadata(String id, String fileName, long length, byte[] contents) {
    this.id = id;
    this.fileName = fileName;
    this.length = length;
    this.contents = contents;
    lastModified = LocalDateTime.of(2021, 2, 20, 13, 10);
  }
}
