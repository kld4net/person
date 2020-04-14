package sa.gov.sfd.employee.domain.person;

import sa.gov.sfd.employee.model.PersonModel;

import java.util.List;

public class PersonServiceImpl implements PersonService {

    final PersonDao dao;

  public PersonServiceImpl(PersonDao dao){
        this.dao = dao;
    }


    @Override
    public List<PersonModel> finalAll(){
        return dao.findAll();
    }

    @Override
    public void insert(PersonModel model) {
        dao.insert(model);
    }

    @Override
    public PersonModel update(int id, PersonModel model){
        return dao.update(id, model);
    }

    @Override
    public PersonModel findByUsernid(int nid){
        return dao.findByUserNid(nid);
    }

  @Override
  public void remove(int id) {
      dao.delete(id);
  }
}
