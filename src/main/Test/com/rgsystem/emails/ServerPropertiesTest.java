package com.rgsystem.emails;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.Properties;

public class ServerPropertiesTest extends TestCase {
    @Test
    public void should_return_properties(){
        ServerProperties serverProperties=new ServerProperties();
        Properties properties=serverProperties.setServerProperties();

        assertNotNull(properties);
    }
}