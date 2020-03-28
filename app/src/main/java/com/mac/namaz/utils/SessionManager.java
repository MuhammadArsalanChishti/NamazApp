package com.mac.namaz.utils;
import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {

	private SharedPreferences sharedPreferences;
	private Context mContext;
	
	public SessionManager(Context context)
	{
		mContext = context;
		sharedPreferences = mContext.getSharedPreferences("Adeerpref", Context.MODE_PRIVATE);
	}
	
	public SharedPreferences getSharedPreferences()
	{
		return sharedPreferences;
	}
	
	public void setStringValue(String key, String value)
	{
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }
	
	public void setIntValue(String key, int value)
	{
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }
	
	public void setBooleanValue(String key, boolean value)
	{
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }
	
	public void setFloatValue(String key, float value)
	{
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putFloat(key, value);
        editor.commit();
    }

	public void deletePreferencesForKey(String key)
    {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.commit();
    }
    
    public void clearAllPreferences() 
    {	
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
    
    public int getIntValue(String key)
    {
        return sharedPreferences.getInt(key, 0);
    }
    
    public boolean getBoolValue(String key)
    {
        return sharedPreferences.getBoolean(key, false);
    }
    
    public String getStringValue(String key)
    {
        return sharedPreferences.getString(key, "");
    }
    
    public float getFloatValue(String key)
    {
        return sharedPreferences.getFloat(key, 0);
    }
    
    public boolean containValue(String Key)
    {
    	return sharedPreferences.contains(Key);
    }
}
