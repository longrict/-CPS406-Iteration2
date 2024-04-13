package bugreportapplication.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
// Small class used to return the result of a registration --> successful or
//  not
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
