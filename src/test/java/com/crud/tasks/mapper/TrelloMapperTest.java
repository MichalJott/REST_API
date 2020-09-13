package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrelloMapperTest {

    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void shouldMapToBoards() {
        //Given
        List<TrelloBoardDto> trelloBoardDtos = new ArrayList<>();
        trelloBoardDtos.add(new TrelloBoardDto("test_id", "test_board", new ArrayList<>()));
        trelloBoardDtos.add(new TrelloBoardDto("test_id2", "test_board2", new ArrayList<>()));

        //When
        List<TrelloBoard> result = trelloMapper.mapToBoards(trelloBoardDtos);

        //Then
        assertEquals(2, result.size());
        assertEquals("test_id", result.get(0).getId());
        assertEquals("test_board", result.get(0).getName());
        assertEquals(0, result.get(0).getLists().size());
        assertEquals("test_id2", result.get(1).getId());
        assertEquals("test_board2", result.get(1).getName());
        assertEquals(0, result.get(1).getLists().size());
    }

    @Test
    public void shouldMapToBoardsDto() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("test_id", "test_board", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("test_id2", "test_board2", new ArrayList<>()));

        //When
        List<TrelloBoardDto> result = trelloMapper.mapToBoardsDto(trelloBoards);

        //Then
        assertEquals(2, result.size());
        assertEquals("test_id", result.get(0).getId());
        assertEquals("test_board", result.get(0).getName());
        assertEquals(0, result.get(0).getLists().size());
        assertEquals("test_id2", result.get(1).getId());
        assertEquals("test_board2", result.get(1).getName());
        assertEquals(0, result.get(1).getLists().size());
    }

    @Test
    public void shouldMapToList() {
        //Given
        List<TrelloListDto> trelloListDtos = new ArrayList<>();
        trelloListDtos.add(new TrelloListDto("test_id", "Test task",  true));
        trelloListDtos.add(new TrelloListDto("test_id2", "Test task2",  false));


        //When
        List<TrelloList> result = trelloMapper.mapToList(trelloListDtos);

        //Then
        assertEquals(2, result.size());
        assertEquals("test_id", result.get(0).getId());
        assertEquals("Test task", result.get(0).getName());
        assertEquals(true, result.get(0).isClosed());
        assertEquals("test_id2", result.get(1).getId());
        assertEquals("Test task2", result.get(1).getName());
        assertEquals(false, result.get(1).isClosed());
    }

    @Test
    public void shouldMapToListDto() {
        //Given
        List<TrelloList> trelloLists = new ArrayList<>();
        trelloLists.add(new TrelloList("test_id", "Test task",  true));
        trelloLists.add(new TrelloList("test_id2", "Test task2",  false));


        //When
        List<TrelloListDto> result = trelloMapper.mapToListDto(trelloLists);

        //Then
        assertEquals(2, result.size());
        assertEquals("test_id", result.get(0).getId());
        assertEquals("Test task", result.get(0).getName());
        assertEquals(true, result.get(0).isClosed());
        assertEquals("test_id2", result.get(1).getId());
        assertEquals("Test task2", result.get(1).getName());
        assertEquals(false, result.get(1).isClosed());
    }

    @Test
    public void shouldMapToCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto(
                "Test task",
                "Test Description",
                "top",
                "test_id"
        );

        //When
        TrelloCard result = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals("Test task", result.getName());
        assertEquals("Test Description", result.getDescription());
        assertEquals("top", result.getPos());
        assertEquals("test_id", result.getListId());
    }

    @Test
    public void shouldMapToCardDto() {
        //Given
        TrelloCard trelloCard = new TrelloCard(
                "Test task",
                "Test Description",
                "top",
                "test_id"
        );

        //When
        TrelloCardDto result = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals("Test task", result.getName());
        assertEquals("Test Description", result.getDescription());
        assertEquals("top", result.getPos());
        assertEquals("test_id", result.getListId());
    }
}