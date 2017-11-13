/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Stegger
 */
public interface IRepository
{

    public void saveState() throws IOException;

    public void loadState() throws IOException;

    public <T> List<T> getAll(Class<T> type);

    public void addObject(Serializable ser);

    public void deleteObject(Serializable ser);

}
