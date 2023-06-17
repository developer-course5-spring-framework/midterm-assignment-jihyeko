package com.ohgiraffers.midtermassignmentjihyeko.controller;

import com.ohgiraffers.midtermassignmentjihyeko.model.dto.FileDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class FileUploadController {
    @PostMapping("multi-file")
    public void multiFileUpload(@RequestParam List<MultipartFile> multiFiles,
                                  String multiFileDescription, @RequestParam String fileName, Model model) {
        System.out.println("multiFiles : " + multiFiles);
        System.out.println("multiFileDescription : " + multiFileDescription);
        /* 파일을 저장할 경로 설정 */
        String root = "src/main/resources/static";
        System.out.println("root = " + root);
        String filePath = root + "/uploadFiles";

        File dir = new File(filePath);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        List<FileDTO> files = new ArrayList<>();
        try {
            for(MultipartFile file : multiFiles) {
                /* 파일명 변경 처리 */
                String originFileName = file.getOriginalFilename();
                String ext = originFileName.substring(originFileName.lastIndexOf("."));
                String savedName = fileName.replace(" ", "-") + ext;
                /* 파일에 관한 정보 추출 후 보관 */
                files.add(new FileDTO(originFileName, savedName, filePath,
                        multiFileDescription));
                /* 파일을 저장 */
                file.transferTo(new File(filePath + "/" + savedName));
            }
            model.addAttribute("fileUploadMessage", "파일 업로드 성공!");
        } catch (Exception e) {
            e.printStackTrace();
            /* 실패 시 이전에 저장 된 파일 삭제 */
            for(FileDTO file : files) {
                new File(filePath + "/" + file.getSavedName()).delete();
            }
            model.addAttribute("fileUploadMessage", "파일 업로드 실패!!");
        }
    }
}
