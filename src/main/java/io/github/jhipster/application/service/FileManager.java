package io.github.jhipster.application.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

public interface FileManager {

    String addFile(MultipartFile file, String fileName);

    InputStream getFile(String fileName);

}
