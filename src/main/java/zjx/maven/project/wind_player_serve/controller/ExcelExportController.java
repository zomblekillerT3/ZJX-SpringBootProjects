package zjx.maven.project.wind_player_serve.controller;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import zjx.maven.project.wind_player_serve.service.ThemeService;

import java.io.IOException;

@RestController
public class ExcelExportController {
        @Autowired
        private ThemeService themeService;
        @GetMapping("/export")
        public void get(HttpServletResponse response) throws IOException {
            themeService.export(response);
        }
//    public void exportExcel(HttpServletResponse response) throws IOException {
//        try {   // 设置响应类型
//            response.setContentType("application/vnd.ms-excel");
//            //设置编码格式
//            response.setCharacterEncoding("utf-8");
//            //设置URLEncoder.encode 防止中文乱码
//            String fileName = URLEncoder.encode("主题数据", "UTF-8").replaceAll("\\+", "%20");
//            //设置响应头
//            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
//            // 使用 EasyExcel 写出到响应输出流
//            EasyExcel.write(response.getOutputStream(), ThemeData.class).sheet("主题信息").doWrite(List);
//        } catch (IOException e) {
//            throw new RuntimeException("数据或文件损坏，无法下载");
//        }
//    }



}


