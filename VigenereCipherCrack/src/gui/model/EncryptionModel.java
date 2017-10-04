/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.model;

import be.EncryptionKey;
import bll.IEncrypter;
import bll.LeetSpeakEncrypter;
import bll.PasswordStorage;
import bll.VigenereCipherEncrypter;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Stegger
 */
public class EncryptionModel
{

    private IEncrypter encrypterLogic;
    private PasswordStorage pwStorage;
    private final ObservableList<EncryptionKey> allKeys;

    /**
     * Constructs an EncryptionModel
     *
     * @param encrypter
     */
    public EncryptionModel(IEncrypter encrypter)
    {
        this.encrypterLogic = encrypter;
        pwStorage = new PasswordStorage();
        allKeys = FXCollections.observableArrayList(pwStorage.getEncryptionKeys());
    }

    public ObservableList<EncryptionKey> getAllEncryptionKeys()
    {
        return allKeys;
    }

    public String encrypt(String payLoad, String key)
    {
        return encrypterLogic.encode(payLoad, key);
    }

    public String decrypt(String payLoad, String key)
    {
        return encrypterLogic.decode(payLoad, key);
    }

    public void addPassword(String password)
    {
        EncryptionKey key = new EncryptionKey(password);
        allKeys.add(key);
        pwStorage.storeEncryptionKey(key);
    }

}
