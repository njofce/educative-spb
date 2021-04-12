package com.educative.serverplayground.web;

import com.educative.serverplayground.models.FileMetadata;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "file", description = "File API")
public interface IFileController {

  @Operation(
      summary = "Get file by ID",
      description = "Search file by ID",
      tags = {"file"})
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "file found",
            content = @Content(schema = @Schema(implementation = FileMetadata.class))),
        @ApiResponse(responseCode = "404", description = "file not found")
      })
  @GetMapping("/{id}")
  FileMetadata getFile(@PathVariable String id);

  @Operation(
      summary = "Search files by name",
      description = "Returns a list of file with the specified name",
      tags = {"file"})
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "files found",
            content =
                @Content(
                    array = @ArraySchema(schema = @Schema(implementation = FileMetadata.class)))),
        @ApiResponse(responseCode = "404", description = "no files found with that name")
      })
  @GetMapping("/search")
  List<FileMetadata> searchFiles(@RequestParam(name = "name") String name);

  @Operation(
      summary = "Save file",
      description = "Upload the file with the given metadata",
      tags = {"file"})
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "file saved"),
        @ApiResponse(responseCode = "500", description = "Unknown exception")
      })
  @PostMapping("/save")
  String saveFile(@RequestBody FileMetadata file);

  @Operation(
      summary = "Update file",
      description = "Update the file with the given metadata",
      tags = {"file"})
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "file updated"),
        @ApiResponse(responseCode = "500", description = "Unknown exception")
      })
  @PutMapping("/update/{id}")
  String updateFile(@RequestBody FileMetadata file, @PathVariable String id);

  @Operation(
      summary = "Delete file",
      description = "Delete the file with the given id",
      tags = {"file"})
  @ApiResponses(
      value = {
        @ApiResponse(responseCode = "200", description = "file deleted"),
        @ApiResponse(responseCode = "404", description = "File not found"),
        @ApiResponse(responseCode = "500", description = "Unknown exception")
      })
  @DeleteMapping("/delete/{id}")
  String deleteFile(@PathVariable String id);
}
