package org.apache.jcs.auxiliary.remote.server;

import java.rmi.server.RMISocketFactory;
import java.util.Properties;

import org.apache.jcs.auxiliary.remote.behavior.IRemoteCacheConstants;

import junit.framework.TestCase;

/** Unit tests for the factory */
public class RemoteCacheServerFactoryUnitTest
    extends TestCase
{
    /** verify that we get the timeout value */
    public void testConfigureRemoteCacheServerAttributes_timeoutPresent()
    {
        // SETUP
        int timeout = 123245;
        Properties props = new Properties();
        props.put( IRemoteCacheConstants.SOCKET_TIMEOUT_MILLIS, String.valueOf( timeout ) );        
                
        // DO WORK
        RemoteCacheServerAttributes result = RemoteCacheServerFactory.configureRemoteCacheServerAttributes( props );
        
        // VERIFY
        assertEquals( "Wrong timeout", timeout, result.getRmiSocketFactoryTimeoutMillis() );
    }
    
    /** verify that we get the timeout value */
    public void testConfigureRemoteCacheServerAttributes_timeoutNotPresent()
    {
        // SETUP
        Properties props = new Properties();      
                
        // DO WORK
        RemoteCacheServerAttributes result = RemoteCacheServerFactory.configureRemoteCacheServerAttributes( props );
        
        // VERIFY
        assertEquals( "Wrong timeout", RemoteCacheServerAttributes.DEFAULT_RMI_SOCKET_FACTORY_TIMEOUT_MS, result.getRmiSocketFactoryTimeoutMillis() );
    }
        
    /** verify that we get the registryKeepAliveDelayMillis value */
    public void testConfigureRemoteCacheServerAttributes_registryKeepAliveDelayMillisPresent()
    {
        // SETUP
        int registryKeepAliveDelayMillis = 123245;
        Properties props = new Properties();
        props.put( IRemoteCacheConstants.CACHE_SERVER_ATTRIBUTES_PROPERTY_PREFIX + ".registryKeepAliveDelayMillis", String.valueOf( registryKeepAliveDelayMillis ) );        
                
        // DO WORK
        RemoteCacheServerAttributes result = RemoteCacheServerFactory.configureRemoteCacheServerAttributes( props );
        
        // VERIFY
        assertEquals( "Wrong registryKeepAliveDelayMillis", registryKeepAliveDelayMillis, result.getRegistryKeepAliveDelayMillis() );
    }
    
    /** verify that we get the useRegistryKeepAlive value */
    public void testConfigureRemoteCacheServerAttributes_useRegistryKeepAlivePresent()
    {
        // SETUP
        boolean useRegistryKeepAlive = false;
        Properties props = new Properties();
        props.put( IRemoteCacheConstants.CACHE_SERVER_ATTRIBUTES_PROPERTY_PREFIX + ".useRegistryKeepAlive", String.valueOf( useRegistryKeepAlive ) );        
                
        // DO WORK
        RemoteCacheServerAttributes result = RemoteCacheServerFactory.configureRemoteCacheServerAttributes( props );
        
        // VERIFY
        assertEquals( "Wrong useRegistryKeepAlive", useRegistryKeepAlive, result.isUseRegistryKeepAlive() );
    }
    
    /** verify that we get the startRegistry value */
    public void testConfigureRemoteCacheServerAttributes_startRegistryPresent()
    {
        // SETUP
        boolean startRegistry = false;
        Properties props = new Properties();
        props.put( IRemoteCacheConstants.CACHE_SERVER_ATTRIBUTES_PROPERTY_PREFIX + ".startRegistry", String.valueOf( startRegistry ) );        
                
        // DO WORK
        RemoteCacheServerAttributes result = RemoteCacheServerFactory.configureRemoteCacheServerAttributes( props );
        
        // VERIFY
        assertEquals( "Wrong startRegistry", startRegistry, result.isStartRegistry() );
    }
    
    /** verify that we get the registryKeepAliveDelayMillis value */
    public void testConfigureRemoteCacheServerAttributes_rmiSocketFactoryTimeoutMillisPresent()
    {
        // SETUP
        int rmiSocketFactoryTimeoutMillis = 123245;
        Properties props = new Properties();
        props.put( IRemoteCacheConstants.CACHE_SERVER_ATTRIBUTES_PROPERTY_PREFIX + ".rmiSocketFactoryTimeoutMillis", String.valueOf( rmiSocketFactoryTimeoutMillis ) );        
                
        // DO WORK
        RemoteCacheServerAttributes result = RemoteCacheServerFactory.configureRemoteCacheServerAttributes( props );
        
        // VERIFY
        assertEquals( "Wrong rmiSocketFactoryTimeoutMillis", rmiSocketFactoryTimeoutMillis, result.getRmiSocketFactoryTimeoutMillis() );
    }
    
    /** verify that we get the startRegistry value */
    public void testConfigureRemoteCacheServerAttributes_allowClusterGetPresent()
    {
        // SETUP
        boolean allowClusterGet = false;
        Properties props = new Properties();
        props.put( IRemoteCacheConstants.CACHE_SERVER_ATTRIBUTES_PROPERTY_PREFIX + ".allowClusterGet", String.valueOf( allowClusterGet ) );        
                
        // DO WORK
        RemoteCacheServerAttributes result = RemoteCacheServerFactory.configureRemoteCacheServerAttributes( props );
        
        // VERIFY
        assertEquals( "Wrong allowClusterGet", allowClusterGet, result.isAllowClusterGet() );
    }
    
    /** verify that we get the startRegistry value */
    public void testConfigureRemoteCacheServerAttributes_localClusterConsistencyPresent()
    {
        // SETUP
        boolean localClusterConsistency = false;
        Properties props = new Properties();
        props.put( IRemoteCacheConstants.CACHE_SERVER_ATTRIBUTES_PROPERTY_PREFIX + ".localClusterConsistency", String.valueOf( localClusterConsistency ) );        
                
        // DO WORK
        RemoteCacheServerAttributes result = RemoteCacheServerFactory.configureRemoteCacheServerAttributes( props );
        
        // VERIFY
        assertEquals( "Wrong localClusterConsistency", localClusterConsistency, result.isLocalClusterConsistency() );
    }
    
    /** verify that we get the timeout value */
    public void testConfigureObjectSpecificCustomFactory_withProperty()
    {
        // SETUP
        String testValue = "123245";
        Properties props = new Properties();
        props.put( IRemoteCacheConstants.CUSTOM_RMI_SOCKET_FACTORY_PROPERTY_PREFIX, MockRMISocketFactory.class.getName() );        
        props.put( IRemoteCacheConstants.CUSTOM_RMI_SOCKET_FACTORY_PROPERTY_PREFIX + ".testStringProperty", testValue );        
                
        // DO WORK
        RMISocketFactory result = RemoteCacheServerFactory.configureObjectSpecificCustomFactory( props );
        
        // VERIFY
        assertNotNull( "Should have a custom socket factory.", result );
        assertEquals( "Wrong testValue", testValue, ((MockRMISocketFactory)result).getTestStringProperty() );
    }
}
