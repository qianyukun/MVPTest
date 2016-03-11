package com.qyk.mvptest.base;

import android.app.Activity;
import android.util.Log;

import java.util.LinkedList;
import java.util.List;

public class ActivityCollector {
      
    public static List<Activity> activities=new LinkedList<>();
      
    public static void addActivity(Activity activity){
          System.out.println("add  "+activity.getComponentName());
        activities.add(activity);  
          
    }  
      
    public static void removeActivity(Activity activity){
        System.out.println("remove  "+activity.getComponentName());
        activities.remove(activity);  
          
    }  
      
    public static void finishAll(){
          
        for(Activity activity:activities){
              
            if(!activity.isFinishing()){
                Log.i("remove all " , activity.getComponentName().toString());
                activity.finish();  
            }
        }
    }

    public void clearStackTop(){
        if (activities!=null && activities.size()>0){
            Activity activity = activities.get(activities.size()-1);
            if(!activity.isFinishing()) {
                activities.remove(activities.size() - 1);
                Log.i("remove all ", activity.getComponentName().toString());
            }
        }
    }
}  