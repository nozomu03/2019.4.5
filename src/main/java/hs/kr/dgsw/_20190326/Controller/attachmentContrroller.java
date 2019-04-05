package hs.kr.dgsw._20190326.Controller;

import hs.kr.dgsw._20190326.Protocol.AttachmentP;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@RestController
public class attachmentContrroller {
    @PostMapping("/attachment")
    public AttachmentP upload(@RequestPart MultipartFile srcFile){
        String destFilename = "D:/tete/"+ LocalDateTime.now().format(DateTimeFormatter.ofPattern("YYYY/MM/DD")) +"/"+ UUID.randomUUID().toString()+"_"+srcFile.getOriginalFilename();
        try{
            File destFile = new File(destFilename);
            destFile.getParentFile().mkdirs();
            srcFile.transferTo(destFile);
            return new AttachmentP(destFilename, srcFile.getOriginalFilename());
        }catch (IOException e) {
            return null;
        }
    }
}
