package org.jitesh.stockquotes.googleservice.services.api;

import org.jitesh.stockquotes.googleservice.beans.GoogleScriptList;

public interface ScriptService {

    GoogleScriptList getScriptList(String scriptName);
}
