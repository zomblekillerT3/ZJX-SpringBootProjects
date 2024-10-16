package zjx.maven.project.wind_player_serve.service.Impl;

import com.alibaba.excel.EasyExcel;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjx.maven.project.wind_player_serve.mapper.ThemeDataMapper;
import zjx.maven.project.wind_player_serve.model.ThemeData;
import zjx.maven.project.wind_player_serve.service.ThemeService;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@Service
public class ThemeServiceImpl  implements ThemeService {


        @Autowired
        private ThemeDataMapper themeDataMapper;

        @Override
        public List<ThemeData> getall() {

            return themeDataMapper.getAll();
        }

        @Override
        public void export(HttpServletResponse response) throws IOException {
            OutputStream ops=response.getOutputStream();
            // 设置响应头
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            response.setCharacterEncoding("utf-8");

            String fileName = URLEncoder.encode("主题", "UTF-8").replaceAll("\\+", "%20");
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            EasyExcel.write(ops,ThemeData.class).sheet("主题").doWrite(this::getall);

            ops.flush();
            ops.close();
        }

    }
