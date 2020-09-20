package com.crud.tasks.service;

import com.crud.tasks.domain.*;
import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.trello.config.AdminConfig;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TrelloServiceTest {

    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleMailService emailService;

    @Mock
    private AdminConfig adminConfig;

    @Test
    public void shouldFetchTrelloBoard() {
        //Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("id", "name", new ArrayList<>()));
        trelloBoardDtos.add(new TrelloBoardDto("id2", "name2", new ArrayList<>()));

        when(trelloClient.getTrelloBoards()).thenReturn(trelloBoardDtos);

        //When
        List<TrelloBoardDto> trelloBoards = trelloService.fetchTrelloBoards();

        //Then
        assertEquals(2, trelloBoards.size());
    }

    @Test
    public void createdTrelloCardTest() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto();
        TrelloBadgesDto badgesDto = new TrelloBadgesDto(3, new TrelloAttachmentsByTypeDto());
        CreatedTrelloCardDto createdTrelloCardDto = new CreatedTrelloCardDto("id", "name", "shortUrl", badgesDto);

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(createdTrelloCardDto);

        //When
        CreatedTrelloCardDto result = trelloService.createdTrelloCard(trelloCardDto);

        //Then
        assertEquals("id", result.getId());
        assertEquals("name", createdTrelloCardDto.getName());
        assertEquals("shortUrl", createdTrelloCardDto.getShortUrl());
        assertEquals(badgesDto, createdTrelloCardDto.getTrelloBadgesDto());
    }

}