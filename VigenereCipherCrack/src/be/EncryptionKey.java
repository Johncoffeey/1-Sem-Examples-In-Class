/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Stegger
 */
public class EncryptionKey
{

    private final StringProperty keyProperty;

    public EncryptionKey(String key)
    {
        keyProperty = new SimpleStringProperty(key);
    }

    public final String getEncryptionKey()
    {
        return keyProperty.getValueSafe();
    }

    public final void setEncryptionKey(String key)
    {
        keyProperty.setValue(key);
    }

    public final StringProperty getEncryptionKeyProperty()
    {
        return keyProperty;
    }

    @Override
    public String toString()
    {
        return getEncryptionKey();
    }

}
