package untitled.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.springframework.context.ApplicationContext;
import untitled.TestApplication;
import untitled.domain.MachineAdded;

@Entity
@Table(name = "Machine_table")
@Data
public class Machine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String model;

    private String code;

    private String remark;

    @PostPersist
    public void onPostPersist() {
        MachineAdded machineAdded = new MachineAdded(this);
        machineAdded.publishAfterCommit();
    }

    public static MachineRepository repository() {
        MachineRepository machineRepository = applicationContext()
            .getBean(MachineRepository.class);
        return machineRepository;
    }

    public static ApplicationContext applicationContext() {
        return TestApplication.applicationContext;
    }
}
