package com.bridgelabz.dao;
import com.bridgelabz.model.*;

public interface LoginDAO{    
       public boolean checkLogin(String userName, String userPassword);
}