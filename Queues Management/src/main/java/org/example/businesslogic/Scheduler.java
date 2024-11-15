package org.example.businesslogic;

import org.example.model.Server;
import org.example.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
public class Scheduler {
    private final List<Server> servers;
    private Strategy strategy;

    public Scheduler(int maxNoServers, int maxTasksPerServer) {

        this.servers = new ArrayList<>();
        for (int i = 0; i < maxNoServers; i++) {
            this.servers.add(new Server(maxTasksPerServer));
            Thread t = new Thread(servers.get(i));
            t.start();
        }

    }

    public void changeStrategy(SelectionPolicy policy) {
        if (policy == SelectionPolicy.SHORTEST_QUEUE) {
            this.strategy = new ConcreteStrategyQueue();
        }
        if (policy == SelectionPolicy.SHORTEST_TIME) {
            this.strategy = new ConcreteStrategyTime();
        }
    }

    public void dispatchTask(Task t) throws InterruptedException {
        strategy.addTask(this.servers, t);
    }

    public ArrayList<Server> getServers() {
        return (ArrayList<Server>) this.servers;
    }

    public boolean checkEmpty() {
        int size = 0;
        for (Server server : servers) size += server.getNumberOfTasks();

        return size == 0;
    }
}