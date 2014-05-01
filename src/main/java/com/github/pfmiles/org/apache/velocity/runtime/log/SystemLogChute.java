package com.github.pfmiles.org.apache.velocity.runtime.log;

import com.github.pfmiles.org.apache.velocity.runtime.RuntimeServices;

/**
 * @author pf-miles
 * 
 */
public class SystemLogChute implements LogChute {

    public void init(RuntimeServices rs) throws Exception {
    }

    public void log(int level, String message) {
        switch (level) {
        case LogChute.ERROR_ID:
        case LogChute.WARN_ID:
        case LogChute.DEBUG_ID:
            System.err.println(message);
            return;
        case LogChute.INFO_ID:
        case LogChute.TRACE_ID:
        default:
            System.out.println(message);
            return;
        }
    }

    public void log(int level, String message, Throwable t) {
        switch (level) {
        case LogChute.ERROR_ID:
        case LogChute.WARN_ID:
        case LogChute.DEBUG_ID:
            System.err.println(message);
            t.printStackTrace(System.err);
            return;
        case LogChute.INFO_ID:
        case LogChute.TRACE_ID:
        default:
            System.out.println(message);
            t.printStackTrace(System.out);
            return;
        }
    }

    public boolean isLevelEnabled(int level) {
        return true;
    }

}
