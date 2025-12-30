package app.gourmetgate.gourmetgate.api.common;

import app.gourmetgate.gourmetgate.core.common.DataValidationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class DataValidationExceptionMapper implements ExceptionMapper<DataValidationException> {

  @Override
  public Response toResponse(DataValidationException exception) {
    return Response.status(Response.Status.BAD_REQUEST)
      .entity(exception.toErrorDo())
      .build();
  }
}
