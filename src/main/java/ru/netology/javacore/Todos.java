package ru.netology.javacore;

import java.util.*;
import java.util.stream.Collectors;

public class Todos {
    private Deque<List<String>> stack = new LinkedList<>();
    private List<String> actual = new LinkedList<>();

    public void addTask(String task) {
        if (actual.size() < 8) {
            // Перед выполнением действия сохраняем текущее состояние в стек
            stack.add(actual.stream().collect(Collectors.toList()));
            actual.add(task);
        }
    }

    public void removeTask(String task) {
        if (actual.contains(task)) {
            // Перед выполнением действия сохраняем текущее состояние в стек
            stack.add(actual.stream().collect(Collectors.toList()));
            actual.remove(task);
        }
    }

    public String getAllTasks() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String item : actual) {
            if ((stringBuilder.toString().equals(""))) {
                stringBuilder.append(item);
            } else {
                stringBuilder.append(" ").append(item);
            }
        }
        return stringBuilder.toString();
    }

    public void restoreTask() {
        actual = stack.pollLast();
    }
}
