package zjx.maven.project.wind_player_serve.model;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ThemeData {
    @ExcelProperty("主题ID")
    @ColumnWidth(20)
    private int tid;

    @ExcelProperty("主题名")
    @ColumnWidth(20)
    private String t_themeName;

    @ExcelProperty("上下行背景")
    @ColumnWidth(20)
    private String t_upDownBack;

    @ExcelProperty("主要背景")
    @ColumnWidth(20)
    private String t_mainBack;

    @ExcelProperty("创建者")
    @ColumnWidth(20)
    private String uid;
}

