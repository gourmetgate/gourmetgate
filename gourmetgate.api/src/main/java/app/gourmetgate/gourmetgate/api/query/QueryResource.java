package app.gourmetgate.gourmetgate.api.query;

import app.gourmetgate.gourmetgate.core.query.QueryService;
import app.gourmetgate.gourmetgate.data.query.QueryResponseDo;
import app.gourmetgate.gourmetgate.data.query.QueryRestrictionDo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;

@Path("query")
public class QueryResource implements IRestResource {

  @POST
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public QueryResponseDo postQuery(QueryRestrictionDo restriction) {
    return BEANS.get(QueryService.class).queryData(restriction);
  }
}
