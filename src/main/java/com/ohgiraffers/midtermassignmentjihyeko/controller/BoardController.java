package com.ohgiraffers.midtermassignmentjihyeko.controller;

import com.ohgiraffers.midtermassignmentjihyeko.model.dao.MemberDAO;
import com.ohgiraffers.midtermassignmentjihyeko.model.dto.FileDTO;
import com.ohgiraffers.midtermassignmentjihyeko.model.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class BoardController {
    @PostMapping("/regist")
    public String registBoard(@RequestParam String title, @RequestParam String content, @RequestParam List<MultipartFile> multiFiles,
                              String multiFileDescription, @RequestParam String fileName, Model model) {
        MemberDAO memberDAO = new MemberDAO();
        MemberDTO member = memberDAO.getMemberBySequence(1);

        if (title != null && content != null) {
            model.addAttribute("title", title);
            model.addAttribute("content", content);
            model.addAttribute("writer", member.getNickname());
            model.addAttribute("resultMessage", "게시글 업로드 성공!");
        } else {
            model.addAttribute("resultMessage", "게시글 업로드 실패!");
        }

        FileUploadController fileUploadController = new FileUploadController();
        fileUploadController.multiFileUpload(multiFiles, multiFileDescription, fileName, model);

        return "result";
    }
}
