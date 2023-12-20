package top.yjx1125.anime.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.yjx1125.anime.pojo.Result;
import top.yjx1125.anime.utils.AliOssUtil;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class FileUploadController   {
    @PostMapping("/upload")
    public Result<String> upload(MultipartFile file) throws Exception {
        //把文件内存存储到本地磁盘上
        String oriFilename = file.getOriginalFilename();
        //保证文件名字唯一
        String filename = UUID.randomUUID().toString()+oriFilename.substring(oriFilename.lastIndexOf('.'));
        //file.transferTo(new File("D:\\Desktop\\files\\"+filename));
        String url = AliOssUtil.uploadFile(filename,file.getInputStream());
        return Result.success(url);
    }
}
