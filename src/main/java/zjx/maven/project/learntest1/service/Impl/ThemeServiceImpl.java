package zjx.maven.project.learntest1.service.Impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.metadata.style.WriteCellStyle;
import com.alibaba.excel.write.metadata.style.WriteFont;
import com.alibaba.excel.write.style.HorizontalCellStyleStrategy;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zjx.maven.project.learntest1.mapper.ThemeDataMapper;
import zjx.maven.project.learntest1.model.ThemeData;
import zjx.maven.project.learntest1.service.ThemeService;

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
