/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package idcard.takehomeidcard;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author STRIX
 */
@Controller
public class controller {
    @RequestMapping("/getdata")
    public String getData(@RequestParam("nama")String text,
                          @RequestParam("tgl")@DateTimeFormat(pattern = "yyyy-MM-dd")Date date,
                          @RequestParam("image") MultipartFile file, Model model)
                          throws IOException{

//          Date date = new Date();
//          SimpleDateFormat myDate = new SimpleDateFormat("dd/MM/yyyy");
//          tanggal = myDate.format(date);
            SimpleDateFormat tanggal = new SimpleDateFormat("EE/MMMM/yyyy");
            
            String newTanggal = tanggal.format(date);
            
            String blob = Base64.encodeBase64String(file.getBytes());
            
            String fotoku = "data:image/jpeg;base64,".concat(blob);
            
            model.addAttribute("nama", text);
            model.addAttribute("tgl", newTanggal);
            model.addAttribute("image",fotoku);
          
//        return text+"<br><h1> ini gambar</h1>"+"<img src='data:image/jpeg;base64,"+blob+"'/><br>"+newTanggal;
          return "output";
    }
}