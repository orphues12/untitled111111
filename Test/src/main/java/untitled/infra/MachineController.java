package untitled.infra;

import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import untitled.domain.*;

@RestController
// @RequestMapping(value="/machines")
@Transactional
public class MachineController {

    @Autowired
    MachineRepository machineRepository;

    @PutMapping("/machines/search/findByName")
    public Object findByName(@RequestBody MachineViewQuery query) {
        return machineRepository.findByName(query.getName());
    }
}
