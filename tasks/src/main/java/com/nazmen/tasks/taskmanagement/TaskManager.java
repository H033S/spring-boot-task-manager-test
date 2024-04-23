package com.nazmen.tasks.taskmanagement;

import org.springframework.stereotype.Component;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

@Component
public class TaskManager {

    private static final Queue<Task> taskToPerform = new ConcurrentLinkedDeque<>();
    public static final Queue<Task> completedTasks = new ConcurrentLinkedDeque<>();

    public boolean processTasks(){
        boolean isSuccessfuly = true;

        completedTasks.clear();
        while (!taskToPerform.isEmpty()){

            var eTask = taskToPerform.poll();
            isSuccessfuly =  eTask.process();

            if(!isSuccessfuly){
                taskToPerform.clear();
                break;
            }
        }

        if(isSuccessfuly){
            completedTasks.clear();
            return true;
        }

        taskToPerform.clear();
        while (!completedTasks.isEmpty()){

            var eTask = completedTasks.poll();
            isSuccessfuly =  eTask.revert();

            if(!isSuccessfuly){
                throw new RuntimeException("Not possible rollback");
            }
        }
        return false;
    }


    public void addTask(Task task){
        taskToPerform.add(task);
    }
}
