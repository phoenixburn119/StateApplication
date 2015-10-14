package ctec.stateapplication.model;

import android.app.Application;

/**
 * @author Adam Kinzer
 * @version 1.1 10/14/2015
 */
public class AndroidSaveState
{
    private String userName;
    private int age;
    private boolean isTired;

    public AndroidSaveState()
    {
        username = "default";
        age = -0;
        isTired = false;
    }

    public String getUsername()
    {
        return userName;
    }

    public int getAge()
    {
        return age;
    }

    public boolean getIsTired()
    {
        return isTired;
    }

    public void setUsername(String userName)
    {
        this.userName = userName;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setIsTired(boolean isTired)
    {
        this.isTired = isTired;
    }
}
