package com.example.hyuna.cop_searchengine;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class apiTest {

    @Test
    public void ConnectNetworkTest(){

        network network= new network();
        network.connectNetwork("keyword");
        assertNotNull(network.connectNetwork("keyword"));
    }
}
