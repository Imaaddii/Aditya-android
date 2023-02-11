package com.exobe.Utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class SavedPrefManager(var context: Context) {
    private val preferences: SharedPreferences
    private val editor: SharedPreferences.Editor


    /**
     * Retrieving the value from the preference for the respective key.
     *
     * @param key : Key for which the value is to be retrieved
     * @return return value for the respective key as boolean.
     */
    private fun getBooleanValue(key: String): Boolean {
        return preferences.getBoolean(key, false)
    }

    /**
     * Saving the preference
     *
     * @param key   : Key of the preference.
     * @param value : Value of the preference.
     */
    private fun setBooleanValue(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.commit()
    }

    /**
     * Retrieving the value from the preference for the respective key.
     *
     * @param key : Key for which the value is to be retrieved
     * @return return value for the respective key as string.
     */
    private fun getStringValue(key: String): String? {
        return preferences.getString(key, "")
    }

    /**
     * Saving the preference
     *
     * @param key   : Key of the preference.
     * @param value : Value of the preference.
     */
    private fun setStringValue(key: String, value: String) {
        editor.putString(key, value)
        editor.commit()
    }

    /**
     * Retrieving the value from the preference for the respective key.
     *
     * @param key : Key for which the value is to be retrieved
     * @return return value for the respective key as string.
     */
    private fun getIntValue(key: String): Int {
        return preferences.getInt(key, 0)
    }

    /**
     * Saving the preference
     *
     * @param key   : Key of the preference.
     * @param value : Value of the preference.
     */
    private fun setIntValue(key: String, value: Int) {
        editor.putInt(key, value)
        editor.commit()
    }

    /**
     * Retrieving the value from the preference for the respective key.
     *
     * @param key : Key for which the value is to be retrieved
     * @return return value for the respective key as string.
     */
    fun getLongValue(key: String?): Long {
        return preferences.getLong(key, 0L)
    }

    /**
     * Saving the preference
     *
     * @param key   : Key of the preference.
     * @param value : Value of the preference.
     */
    fun setLongValue(key: String?, value: Long) {
        editor.putLong(key, value)
        editor.commit()
    }

    /**
     * Remove the preference for the particular key
     *
     * @param key : Key for which the preference to be cleared.
     */
    fun removeFromPreference(key: String?) {
        editor.remove(key)
        editor.commit()
    }

    companion object {
        //preferences variables
        const val isLogin = "login"
        const val priceTag = "price_tag"
        const val TOKEN = "token"
        const val USER_TYPE = "USER_TYPE"
        const val TutorialFlag = "TutorialFlag"





        private var instance: SavedPrefManager? = null
        private const val PREF_HIGH_QUALITY = "pref_high_quality"


        fun getInstance(context: Context): SavedPrefManager? {
            if (instance == null) {
                synchronized(SavedPrefManager::class.java) {
                    if (instance == null) {
                        instance = SavedPrefManager(context)
                    }
                }
            }
            return instance
        }


        fun saveStringPreferences(context: Context?, key: String, value: String?): String {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sharedPreferences.edit()
            editor.putString(key, value)
            editor.apply()
            return key
        }

        fun saveIntPreferences(context: Context?, key: String?, value: Int?) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sharedPreferences.edit()
            if (value != null) {
                editor.putInt(key, value)
            }
            editor.apply()
        }

        fun saveFloatPreferences(context: Context?, key: String?, value: Float) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sharedPreferences.edit()
            editor.putFloat(key, value)
            editor.apply()
        }

        /*
  This method is used to get string values from shared preferences.
   */
        fun getStringPreferences(context: Context?, key: String?): String? {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return sharedPreferences.getString(key, "")
        }

        /*
     This method is used to get string values from shared preferences.
      */
        fun getIntPreferences(context: Context?, key: String?): Int {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return sharedPreferences.getInt(key, 0)
        }

        fun savePreferenceBoolean(context: Context?, key: String?, b: Boolean) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sharedPreferences.edit()
            editor.putBoolean(key, b)
            editor.commit()
        }

        /*
      This method is used to get string values from shared preferences.
       */
        fun getBooleanPreferences(context: Context?, key: String?): Boolean {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            return sharedPreferences.getBoolean(key, false)
        }

        /**
         * Removes all the fields from SharedPrefs
         */
        fun clearPrefs(context: Context?) {
            val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor = sharedPreferences.edit()
            editor.clear()
            editor.apply()
        }

    }


    init {
        preferences =
            context.getSharedPreferences("eXobe", Context.MODE_PRIVATE)
        editor = preferences.edit()
    }
}