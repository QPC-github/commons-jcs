package org.apache.commons.jcs3.engine.control;

import org.apache.commons.jcs3.JCS;
import org.apache.commons.jcs3.access.CacheAccess;
import org.apache.commons.jcs3.engine.stats.behavior.ICacheStats;

/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

import junit.framework.TestCase;

/**
 */
public class CacheManagerStatsUnitTest
    extends TestCase
{

    /**
     * Just get the stats after putting a couple entries in the cache.
     *
     * @throws Exception
     */
    public void testSimpleGetStats() throws Exception
    {
        final CacheAccess<String, String> cache = JCS.getInstance( "testCache1" );

        // 1 miss, 1 hit, 1 put
        cache.get( "testKey" );
        cache.put( "testKey", "testdata" );
        // should have 4 hits
        cache.get( "testKey" );
        cache.get( "testKey" );
        cache.get( "testKey" );
        cache.get( "testKey" );

        final CompositeCacheManager mgr = CompositeCacheManager.getInstance();
        final String statsString = mgr.getStats();

//        System.out.println( statsString );

        assertTrue( "Should have the cacheName in here.", statsString.indexOf("testCache1") != -1 );
        assertTrue( "Should have the HitCountRam in here.", statsString.indexOf("HitCountRam") != -1 );
        assertTrue( "Should have the 4 in here.", statsString.indexOf("4") != -1 );

        final ICacheStats[] stats = mgr.getStatistics();
        final int statsLen = stats.length;
//        System.out.println( "statsLen = " + statsLen );
        for ( int i = 0; i < statsLen; i++ )
        {
            // TODO finish
        }
    }

}
