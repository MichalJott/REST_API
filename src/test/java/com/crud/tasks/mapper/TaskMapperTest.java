package com.crud.tasks.mapper;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TaskMapperTest {
    @Autowired
    private TaskMapper taskMapper;

    @Test
    public void shouldMapToTask() {
        //Given
        TaskDto taskDto = new TaskDto(1L, "titleTask", "ContentTask");

        //When
        Task task = taskMapper.mapToTask(taskDto);

        //Then
        assertEquals(new Long(1L), task.getId());
        assertEquals("titleTask", task.getTitle());
        assertEquals("ContentTask", task.getContent());

    }

    @Test
    public void shouldMapToTaskDto() {
        //Given
        Task task = new Task(1L, "titleTask", "ContentTask");

        //When
        TaskDto taskDto = taskMapper.mapToTaskDto(task);

        //Then
        assertEquals(new Long(1L), task.getId());
        assertEquals("titleTask", task.getTitle());
        assertEquals("ContentTask", task.getContent());
    }

    @Test
    public void shouldMapToTaskDtoList() {
        //Given
        List<Task> tasks = new ArrayList<>();
        tasks.add(new Task(1L, "titleTask", "ContentTask"));
        tasks.add(new Task(2L, "titleTask1", "ContentTask1"));

        //When
        List<TaskDto> taskDtos = taskMapper.mapToTaskDtoList(tasks);

        //Then
        assertEquals(2, taskDtos.size());
        assertEquals(new Long(1L), taskDtos.get(0).getId());
        assertEquals("titleTask", taskDtos.get(0).getTitle());
        assertEquals("ContentTask", taskDtos.get(0).getContent());
        assertEquals(new Long(2L), taskDtos.get(1).getId());
        assertEquals("titleTask1", taskDtos.get(1).getTitle());
        assertEquals("ContentTask1", taskDtos.get(1).getContent());

    }
}