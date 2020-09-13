package com.crud.tasks.service;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrelloService {


    @Autowired
    private TrelloClient trelloClient;

    private static final String SUBJECT = "Task: New Trello card ";

    public List<TrelloBoardDto> fetchTrelloBoards() {
        return trelloClient.getTrelloBoards();
    }

    public CreatedTrelloCardDto createdTrelloCard(final TrelloCardDto trelloCardDto) {

        CreatedTrelloCardDto newCard = trelloClient.createNewCard(trelloCardDto);
        //ofNullable(newCard).ifPresent(card -> emailService.send(SimpleEmailService.NEW_TRELLO_CARD,new Mail(adminConfig.getAdminMail(), SUBJECT,
        //        "New card: " +card.getName()+ "has been created on your Trello account")));
        return newCard;
    }


}

