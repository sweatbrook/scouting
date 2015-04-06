package com.scouting.services;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;

/**
 *
 * @author sweatbrook
 */
public class ScoutModule {
    
    public static void contributeApplicationDefaults(MappedConfiguration<String,String> configuration)
    {
        configuration.add(SymbolConstants.PRODUCTION_MODE, "false");
    }
}
