package sa.gov.sfd.employee.domain.workflow;


import sa.gov.sfd.employee.model.Workflow;

import java.util.List;
import java.util.Optional;

public interface WorkflowDao {
  Optional<Workflow> findByIdAndPriority(Long id, int priority);

  Optional<Workflow> findById(long id);

  List<Workflow> findAll();

  void save(Workflow workflow);

  List<Workflow> findByGroupIds(List<Long> groupIds);


}
