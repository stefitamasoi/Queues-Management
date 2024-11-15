package org.example.businesslogic;

import org.example.model.Server;
import org.example.model.Task;

import java.util.List;

public class ConcreteStrategyQueue implements Strategy {
    @Override
    public void addTask(List<Server> servers, Task task) {
        int min = servers.get(0).getNumberOfTasks();
        for (int i = 1; i < servers.size(); i++)
            if (min > servers.get(i).getNumberOfTasks())
                min = servers.get(i).getNumberOfTasks();

        for (Server server : servers)
            if (min == server.getNumberOfTasks()) {
                server.addTask(task);
                break;
            }

    }
}