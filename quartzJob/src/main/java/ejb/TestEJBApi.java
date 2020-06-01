package ejb;

import javax.ejb.Local;

@Local
public interface TestEJBApi {
    void logTime(String name);
}
