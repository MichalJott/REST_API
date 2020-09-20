package com.crud.tasks.service;

import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.trello.config.AdminConfig;
import com.crud.tasks.trello.config.CompanyConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {

    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    private CompanyConfig companyConfig;
    @Autowired
    private DbService service;
    @Autowired
    private TaskMapper taskMapper;
    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;

    public String buildTrelloCardEmail(String message) {

        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your tasks");
        functionality.add("Provides connection with Trello Acount");
        functionality.add("Application allows sending tasks to Trello");

        List<TaskDto> tasks = taskMapper.mapToTaskDtoList(service.getAllTasks());
        int quantity = tasks.size();

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "http://localhost:8080/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("preview", "Your task has been created");
        context.setVariable("goodbye", "Have a nice day! " + adminConfig.getAdminName() + ", Best regards");
        context.setVariable("footer", companyConfig.getCompanyName() + "\n" + companyConfig.getCompanyPhone() + "\n" + companyConfig.getCompanyEmail());
        context.setVariable("show_button", false);
        context.setVariable("is_friend", true);
        context.setVariable("application_functionality", functionality);
        context.setVariable("amount_of_tasks", "You have: " + quantity + "tasks on your board.");
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String getTasksReview(String message) {

        Context context = new Context();
        context.setVariable("message", message);
        context.setVariable("tasks_url", "https://github.com/MichalJott/MichalJott.github.io");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("footer", companyConfig.getCompanyName() + "\n" + companyConfig.getCompanyPhone() + "\n" + companyConfig.getCompanyEmail());
        context.setVariable("is_friend", true);
        context.setVariable("review", "Today is : " + LocalDate.now() + " You have: ");

        return templateEngine.process("mail/TasksReview-mail", context);
    }
}
