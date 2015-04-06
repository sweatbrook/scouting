package com.scouting.components;

import java.util.Arrays;
import java.util.List;
import org.apache.tapestry5.BindingConstants;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;

/**
 * Layout component for pages of application tapestry.
 * "context:layout/default.css",
 */
@Import(stylesheet = {"context:layout/default.css", "context:layout/fonts.css"})
public class Layout {

    /**
     * The page title, for the <title> element and the <h1> element.
     */
    @Property
    @Parameter(required = true, defaultPrefix = BindingConstants.LITERAL)
    private String title;

    @Property
    private String pageName;

    @Property
    private List<String> pageNames = Arrays.asList("Home", "TroopCalendar",
//            "BoyScouts", "VarsityScouts", "VentureScouts",
            "About", "Contact");

    @Property
    @Inject
    private Messages messages;
    
    void onActivate() {
        if (pageName == null || pageName.isEmpty()) {
            pageName = "Index";
        }
    }

    public String getPageNameText() {
        return messages.get(pageName);
    }
}
