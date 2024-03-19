package ui.gui;

import org.json.JSONObject;

import java.util.List;

public interface GuiCitation {
    JSONObject asJson();

    List<String> getUserInput();
}
