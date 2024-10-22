package zjx.maven.project.wind_player_serve.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserToThemeWeight {
    private String uid;
    private int tid;
    private int uToTNow;
    private int uToTHistory;
}
