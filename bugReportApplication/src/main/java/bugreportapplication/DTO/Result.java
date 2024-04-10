package bugreportapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Result {
    private String msg;
    private Boolean success;
    
    public Boolean getResult() {
        return success;
    }
    
    public String getMsg() {
        return msg;
    }
}
