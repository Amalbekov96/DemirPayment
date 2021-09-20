package kg.demir.bnk.Security;

import kg.demir.bnk.Service.Impl.UsersServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AuthenticationSuccessEventListener implements ApplicationListener<AuthenticationSuccessEvent> {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private UsersServiceImpl usersService;

    private static Logger LOG = LoggerFactory.getLogger(AuthenticationSuccessEventListener.class);

    @Override
    public void onApplicationEvent(final AuthenticationSuccessEvent au) {
        String user = au.getAuthentication().getName();
        LOG.info("Login successful for user {} ", user);
        usersService.resetAttempts(user);
    }
}
