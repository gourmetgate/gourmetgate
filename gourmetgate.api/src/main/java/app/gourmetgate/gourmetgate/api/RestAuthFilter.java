package app.gourmetgate.gourmetgate.api;

import app.gourmetgate.gourmetgate.core.auth.GourmetgateCredentialVerifier;
import app.gourmetgate.gourmetgate.core.auth.GourmetgateTokenVerifier;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.server.commons.authentication.BearerAuthAccessController;
import org.eclipse.scout.rt.server.commons.authentication.DevelopmentAccessController;
import org.eclipse.scout.rt.server.commons.authentication.FormBasedAccessController;

import java.io.IOException;

/**
 * <h3>{@link RestAuthFilter}</h3>
 */
public class RestAuthFilter implements Filter {

  private DevelopmentAccessController m_developmentAccessController;
  private BearerAuthAccessController m_bearerAuthAccessController;

  @Override
  public void init(FilterConfig filterConfig) {
    m_developmentAccessController = BEANS.get(DevelopmentAccessController.class)
      .init(new DevelopmentAccessController.DevelopmentAuthConfig()
        .withPutPrincipalOnSession(false)
        .withEnabled(true)
      );
    m_bearerAuthAccessController = BEANS.get(BearerAuthAccessController.class).init(
      new BearerAuthAccessController.HttpBearerAuthConfig()
        .withEnabled(true)
        .withTokenVerifier(BEANS.get(GourmetgateTokenVerifier.class))
    );
  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    final HttpServletRequest req = (HttpServletRequest) request;
    final HttpServletResponse resp = (HttpServletResponse) response;
    if (m_bearerAuthAccessController.handle(req, resp, chain)) {
      return;
    }
    if (m_developmentAccessController.handle(req, resp, chain)) {
      return;
    }

    resp.sendError(HttpServletResponse.SC_FORBIDDEN);
  }

  @Override
  public void destroy() {
    m_developmentAccessController.destroy();
    m_bearerAuthAccessController.destroy();
  }
}
