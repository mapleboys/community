package com.example.communication.controller;

import cn.ucloud.ufile.exception.UfileFileException;
import com.example.communication.dto.UploadResDto;
import com.example.communication.provider.UcloudProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;

@Controller
public class FileController {
    @Autowired
    UcloudProvider ucloudProvider;

    @PostMapping("/file/upload")
    @ResponseBody
    public Object upload(HttpServletRequest request) throws UfileFileException, IOException {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile multipartFile = multipartRequest.getFile("editormd-image-file");
        InputStream inputStream = multipartFile.getInputStream();
        String fileName = multipartFile.getOriginalFilename();

        UploadResDto uploadResDto = ucloudProvider.uploadFile(inputStream, fileName);

        return uploadResDto;
    }
}
