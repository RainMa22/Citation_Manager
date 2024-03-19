package ui.gui;

import model.Citation;
import org.json.JSONObject;

import java.util.Set;

public interface FullGuiCitation {
    JSONObject asJson();

    Set<Citation> getCitations();


    void add(Citation c);

    void remove(Citation c);

}
