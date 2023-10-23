package co.devkh.onlinestore.api.file;

import co.devkh.onlinestore.api.file.web.FileDto;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

public interface FileService {

    Resource downloadByName(String name);
    void deleteAll();
    void deleteByName(String name);
    List<FileDto> findAll();
    FileDto uploadSingle(MultipartFile file);

    List<FileDto> uploadMultiple(List<MultipartFile> files);

    FileDto findByName(String name) throws IOException;


}
