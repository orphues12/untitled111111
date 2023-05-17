package untitled.domain;

import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import untitled.domain.*;

@RepositoryRestResource(collectionResourceRel = "machines", path = "machines")
public interface MachineRepository
    extends PagingAndSortingRepository<Machine, Long> {
    List<Machine> findByName(String name);
}
