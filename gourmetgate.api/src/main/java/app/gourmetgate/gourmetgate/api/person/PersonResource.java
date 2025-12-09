package app.gourmetgate.gourmetgate.api.person;

import app.gourmetgate.gourmetgate.core.person.PersonService;
import app.gourmetgate.gourmetgate.data.person.PersonDo;
import app.gourmetgate.gourmetgate.data.person.PersonResponse;
import app.gourmetgate.gourmetgate.data.person.PersonRestrictionDo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.api.data.table.MaxResultsHelper;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Path("persons")
public class PersonResource implements IRestResource {

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public PersonResponse getById(@PathParam("id") UUID id) {
    return BEANS.get(PersonService.class)
        .getById(id)
        .map(item -> BEANS.get(PersonResponse.class).withItem(item))
        .orElseGet(PersonResponse::new);
  }

  @POST
  @Path("list")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public PersonResponse list(PersonRestrictionDo restrictions) {
    MaxResultsHelper.ResultLimiter limiter = BEANS.get(MaxResultsHelper.class).limiter(restrictions);
    List<PersonDo> persons = BEANS.get(PersonService.class)
      .list(restrictions, limiter.getQueryLimit())
      .collect(Collectors.toList());
    PersonResponse response = BEANS.get(PersonResponse.class);
    return response.withItems(limiter.limit(persons, response));
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public PersonResponse store(@PathParam("id") UUID id, PersonDo person) {
    return BEANS.get(PersonResponse.class)
        .withItem(BEANS.get(PersonService.class).store(id, person));
  }

  @POST
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public PersonResponse create(PersonDo person) {
    return BEANS.get(PersonResponse.class)
        .withItem(BEANS.get(PersonService.class).create(person));
  }

  @DELETE
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  public void remove(@PathParam("id") UUID id) {
    BEANS.get(PersonService.class).remove(id);
  }
}
