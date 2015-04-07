package com.scouting.pages;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import org.apache.tapestry5.annotations.BeginRender;
import org.apache.tapestry5.annotations.Environmental;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.ioc.Messages;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.javascript.JavaScriptSupport;

/**
 *
 * @author sweatbrook
 */
@Import(library = {"context:eventcalendar/codebase/dhtmlxscheduler.js"},
        stylesheet = {"context:eventcalendar/codebase/dhtmlxscheduler.css"})
public class TroopCalendar {

    @Environmental
    private JavaScriptSupport javaScriptSupport;

    @Inject
    private Messages messages;

//    @Property
//    private String troopText;
    @BeginRender
    void loadJSRender() {
        javaScriptSupport.addScript("scheduler.config.multi_day = true");
        javaScriptSupport.addScript(
                "scheduler.config.xml_date = \"%Y-%m-%d %H:%i\";");
        javaScriptSupport.addScript(
                "scheduler.init('scheduler_here', new Date(), \"month\");");
        javaScriptSupport.addScript(
                "scheduler.locale.labels.section_type = \"Type\";");
        javaScriptSupport.addScript("scheduler.config.lightbox.sections = [\n"
                + "            {name: \"description\", height: 200, map_to: \"text\", type: \"textarea\", focus: true},\n"
                + "            {name: \"type\", height: 21, map_to: \"type\", type: \"select\", options: [\n"
                + "                    {key: 1, label: \"Simple\"},\n"
                + "                    {key: 2, label: \"Complex\"},\n"
                + "                    {key: 3, label: \"Unknown\"}\n"
                + "                ]},\n"
                + "            {name: \"time\", height: 72, type: \"time\", map_to: \"auto\"}\n"
                + "        ];");
//        javaScriptSupport.addScript(
//                "scheduler.load(\"data/types.xml\", function () {\n"
//                + "            scheduler.showLightbox(2);\n"
//                + "        });");
    }

    public String getTroopText() {
        return messages.get("troop-text");
    }

    public Format getTroopTextFormat() {
        return new Format() {

            @Override
            public StringBuffer format(Object obj, StringBuffer toAppendTo,
                    FieldPosition pos) {
                String str = (String) obj;
                return new StringBuffer(str);
            }

            @Override
            public Object parseObject(String source, ParsePosition pos) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        };
    }
}
