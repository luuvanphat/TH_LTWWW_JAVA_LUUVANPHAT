package iuh.fit.se.bai4cdi;

import iuh.fit.se.bai4cdi.User;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class UserService {
    public User getUser() {
        return new User("Luu Van Phat", "luuvanphat@gmail.com");
    }
}

