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
            // 设置响应类型
            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
            //设置编码格式
            response.setCharacterEncoding("utf-8");
            //设置URLEncoder.encode 防止中文乱码
            String fileName = URLEncoder.encode("主题", "UTF-8").replaceAll("\\+", "%20");
            //设置响应头
            response.setHeader("Content-disposition", "attachment;filename*=utf-8''" + fileName + ".xlsx");
            // 使用 EasyExcel 写出到响应输出流
            EasyExcel.write(ops,ThemeData.class).sheet("主题").doWrite(this::getall);
            ops.flush();
            ops.close();
        }
    /*
     新增数据
     */
    @Override
    public ThemeData insert(ThemeData themeData) {
    themeDataMapper.insert(themeData);
    return themeData;
    }
    /*
     删除数据
     */
    @Override
    public String deleteByTid(int tid, String creator) {
         themeDataMapper.deleteByTid(tid, creator);
         return ("成功删除"+ creator +","+tid);
    }
    /*
    通过id查询数据
     */
    @Override
    public ThemeData getThemeDataByTid(int id) {
        return themeDataMapper.getThemeDataByTid(id);
    }

}
