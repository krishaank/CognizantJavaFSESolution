package com.example;

import static org.mockito.Mockito.*; 
import org.junit.jupiter.api.Test; 
import org.mockito.Mockito; 
 
public class MyServiceTest { 
    @Test 
    public void testVerifyInteraction() { 
        ExternalApi mockApi = Mockito.mock(ExternalApi.class); 
        MyService service = new MyService(mockApi); 
        
        // Call the method that interacts with the mock
        service.fetchData(); 
        
        // Verify that the specific method on the mock was called
        verify(mockApi).getData(); 
    } 
}
