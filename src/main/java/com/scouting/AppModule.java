package com.scouting;

import org.apache.tapestry5.SymbolConstants;
import org.apache.tapestry5.ioc.MappedConfiguration;

/**
 *
 * @author Scott Weatbrook
 * @since Mar 15, 2015
 */
public class AppModule {

    public static void contributeApplicationDefaults(MappedConfiguration<String,String> configuration)
  {
    configuration.add(SymbolConstants.SUPPORTED_LOCALES, "en,fr,de");
    configuration.add(SymbolConstants.FILE_CHECK_INTERVAL, "10 m");
    configuration.add(SymbolConstants.HMAC_PASSPHRASE, "&^TTYUJJ&&RRDFF");
  }
}
