package sa.gov.sfd.employee.domain.person;

import sa.gov.sfd.employee.model.PersonModel;

import java.util.List;

public interface PersonService {
    List<PersonModel> finalAll();

    void insert(PersonModel model);

    PersonModel update(int id, PersonModel model);

    PersonModel findByUsernid(int nid);

    void remove(int id);
}
