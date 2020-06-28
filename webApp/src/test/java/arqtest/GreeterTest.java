/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package arqtest;

import arqtest.PhraseBuilder;
import arqtest.Greeter;
import javax.inject.Inject;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 *
 * @author andre
 */
@RunWith(Arquillian.class)
public class GreeterTest {
       
    public GreeterTest() {
    }

    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
            .addClasses(Greeter.class, PhraseBuilder.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }
    
    @Inject
    Greeter arqTestBean;
    
    @Test
    public void testSomeMethod() {
        Assert.assertEquals("Hello, Earthling!", 
                            arqTestBean.createGreeting("Earthling"));
//        arqTestBean.greet(System.out, "Earthling");
    }
    
}
