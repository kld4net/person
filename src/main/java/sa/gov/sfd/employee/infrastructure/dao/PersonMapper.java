package sa.gov.sfd.employee.infrastructure.dao;

import org.springframework.jdbc.core.RowMapper;
import sa.gov.sfd.employee.model.PersonModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<PersonModel> {

  @Override
  public PersonModel mapRow(ResultSet resultSet, int i) throws SQLException {
    
    PersonModel model = new PersonModel(resultSet.getString("personFirstName"),
    resultSet.getString("personSecondName"),
    resultSet.getString("personThirdName"),
    resultSet.getString("personFamilyName"),
    Integer.parseInt(resultSet.getString("personSex")),
    Integer.parseInt(resultSet.getString("personStatus")),
    resultSet.getString("personBirthdate"),
    Integer.parseInt(resultSet.getString("personIdType")),
    resultSet.getString("personIdNo"),
    resultSet.getString("personEmail"),
    resultSet.getString("personMobile"),
    resultSet.getString("personAddress"));
    model.setId(resultSet.getLong("id"));

    /*
    PersonModel model = new PersonModel();

    model.setPersonFirstName(resultSet.getString("PersonFirstName"));
    */
    return model;
  }
}
