package de.twometer.openmirror.source;

import javafx.scene.Parent;

public interface InformationSource {

    Parent load();

    void refresh();

}
