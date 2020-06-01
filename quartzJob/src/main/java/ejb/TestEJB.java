package ejb;

import javax.ejb.Stateless;

@Stateless
public class TestEJB implements TestEJBApi {

    @Override
    public void logTime(String name) {
        System.out.println("Time: " + name + "!");
    }

}
