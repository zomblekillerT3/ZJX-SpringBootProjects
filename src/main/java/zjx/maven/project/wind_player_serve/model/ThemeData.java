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
    @ExcelProperty("ID")
    @ColumnWidth(20)
    private Long id;

    @ExcelProperty("主题名")
    @ColumnWidth(20)
    private String themeName;

    @ExcelProperty("图片地址")
    @ColumnWidth(20)
    private String imgAddress;

    @ExcelProperty("上下行背景")
    @ColumnWidth(20)
    private String upDownBack;

    @ExcelProperty("主要背景")
    @ColumnWidth(20)
    private String mainBack;
}

