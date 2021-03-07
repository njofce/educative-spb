package com.educative.serverplayground.client;

import com.educative.serverplayground.models.FileMetadata;
import com.educative.serverplayground.web.apis.AsyncFileApi;
import com.educative.serverplayground.web.apis.FileApi;
import com.educative.serverplayground.web.apis.FileApiFactory;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/** A sample client that uses the defined APIs by the server */
public class FeignClient {

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    synchronousTest();
    asyncTest();
  }

  private static void synchronousTest() {
    FileApi fileApi = FileApiFactory.getSynchronousFileAPI();

    FileMetadata file1 = fileApi.getFile("file1");
    System.out.println("Loaded from server: " + file1.fileName);
  }

  private static void asyncTest() throws ExecutionException, InterruptedException {
    AsyncFileApi asyncFileAPI = FileApiFactory.getAsyncFileAPI();
    CompletableFuture<FileMetadata> file = asyncFileAPI.getFile("file2");
    String id = file.thenApply(f -> "ID: " + f.id).get();
    System.out.println("Loaded asynchronously the file with id: " + id);
  }
}
