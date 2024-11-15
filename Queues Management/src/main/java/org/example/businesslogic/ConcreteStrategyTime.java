package org.example.businesslogic;

import org.example.model.Server;
import org.example.model.Task;

import java.util.List;

public class ConcreteStrategyTime implements Strategy {
    @Override
    public void addTask(List<Server> servers, Task task) {
        int min = servers.get(0).getWaitingPeriod();
        for (int i = 1; i < servers.size(); i++)
            if (min > servers.get(i).getWaitingPeriod())
                min = servers.get(i).getWaitingPeriod();

        for (Server server : servers)
            if (min == server.getWaitingPeriod()) {
                task.setWaitTime(min + task.getProcessingTime());
                server.addTask(task);
                break;
            }
    }
}