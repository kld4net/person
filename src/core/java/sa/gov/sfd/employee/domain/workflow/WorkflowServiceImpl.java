package sa.gov.sfd.employee.domain.workflow;


import sa.gov.sfd.employee.model.Workflow;

import java.util.List;

public class WorkflowServiceImpl implements WorkflowService {

    private final WorkflowDao dao;

    public WorkflowServiceImpl(WorkflowDao dao) {
        this.dao = dao;
    }

    @Override
    public List<Workflow> findAllWorkflow() {
        return dao.findAll();
    }

    @Override
    public void save(Workflow workflow) {
        dao.save(workflow);
    }

    @Override
    public Workflow findWorkflowById(Long id, int priority) {
        return dao.findByIdAndPriority(id, priority).orElseThrow(IllegalArgumentException::new);
    }

    @Override
    public List<Workflow> findByGroupIds(List<Long> groupIds) {
        return dao.findByGroupIds(groupIds);
    }

}
