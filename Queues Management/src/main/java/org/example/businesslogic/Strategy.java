package org.example.businesslogic;

import org.example.model.Server;
import org.example.model.Task;

import java.util.List;

public interface Strategy {
    void addTask(List<Server> servers, Task t) throws InterruptedException;
}

