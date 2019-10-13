package com.example.hyuna.cop_searchengine;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import static junit.framework.TestCase.assertEquals;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DataControllerTest {
    private SearchController dataController;
    @Mock
    private ResultViewInterface resultViewInterface;
    @Mock
    private ResultListInterface dataInterface;

    private InOrder inOrder;


    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        dataController = new SearchController(resultViewInterface, dataInterface);
        inOrder = inOrder(resultViewInterface,dataInterface);

    }

    @Test
    public void Success(){

        when(resultViewInterface.getKeywordText()).thenReturn("good");
        //데이터를 제대로 가져오고 그려지는 로직까지 포함.
        dataController.doSearch(resultViewInterface.getKeywordText());
    }

    @Test
    public void EmptyCallback(){
        //결과값이 null인경우
        when(resultViewInterface.getKeywordText()).thenReturn("dkjflsdjflkjasdlfjalskdfjlkfjla");
        resultViewInterface.showLoading();
        dataInterface = new ResultList(resultViewInterface.getKeywordText());
        ArrayList<SearchReponseItems> resultItems =dataInterface.getAllResultData();
        //가져온 데이터가 0임.
        assertEquals(resultItems.size(), 0);
        resultViewInterface.hideLoading();
        resultViewInterface.showMessage("검색결과가 없습니다. 다시 검색해주세요");
    }

    @Test
    public void EmptyKeyword(){
        //키워드가 ""일 경우
        when(resultViewInterface.getKeywordText()).thenReturn("");
        resultViewInterface.showLoading();
        //데이터를 제대로 가져오는지 확인한다.
        dataController.doSearch(resultViewInterface.getKeywordText());
        resultViewInterface.hideLoading();
        resultViewInterface.showMessage("검색할 키워드가 없습니다. ");
    }
}
