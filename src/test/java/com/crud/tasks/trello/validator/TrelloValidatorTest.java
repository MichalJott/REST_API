package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class TrelloValidatorTest {
    @Autowired
    TrelloValidator trelloValidator;

    @Test
    public void validateTrelloBoardsTest() {
        //Given
        List<TrelloBoard> trelloBoards = new ArrayList<>();
        trelloBoards.add(new TrelloBoard("id", "name", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("id2", "name2", new ArrayList<>()));
        trelloBoards.add(new TrelloBoard("id3", "test", new ArrayList<>()));

        //When
        List<TrelloBoard> result = trelloValidator.validateTrelloBoards(trelloBoards);

        //Then
        assertEquals(2, result.size());
    }
}