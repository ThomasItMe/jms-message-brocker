package thomas.springframework.thomasjms.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

/**
 * @author vvthuy on 1/8/2021
 * @project thomas-jms
 */

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HellWorldMessage implements Serializable {

    static final long serialVersionUID = 6298204830523180483L;

    private UUID id;
    private String message;
}
