package manager;

import models.BoardDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public interface HelperBoards extends HelperBase{

    By buttonCreateBoard = By.xpath("//span[text()='Create new board']");

    By fieldBoardTitle = By.xpath("//input[@data-testid='create-board-title-input']");

    By buttonCreate = By.xpath("//button[@data-testid='create-board-submit-button']");

    By buttonBoards = By.xpath("//a[@data-testid='open-boards-link']");

    By boardNameDisplay = By.xpath("//h1[@data-testid='board-name-display']");

    By buttonDots = By.xpath("//button[@aria-label='Show menu']");

    By buttonCloseBoard = By.xpath("//a[@class='board-menu-navigation-item-link board-menu-navigation-item-link-v2 js-close-board']");

    By buttonClose = By.xpath("//input[@value='Close']");

    By buttonPermanentlyDeleteBoard = By.xpath("//button[@data-testid='close-board-delete-board-button']");

    By buttonDelete = By.xpath("//button[@data-testid='close-board-delete-board-confirm-button']");

    By buttonBoard = By.xpath("//button[@data-testid='view-switcher-button-more']");

    By messageDeleteBoard = By.xpath("//span[text()='Board deleted.']");

    By buttonLogOut = By.xpath("//button/span[text()='Log out']");

    By buttonLogOutSubmit = By.id("logout-submit");
    default void createBoard(BoardDTO board){ // !!!!!1
        click(buttonCreateBoard);
        type(fieldBoardTitle, board.getBoardTitle());
        //pause(3);
        //click(buttonCreate);
        clickWait_elementIsClickable(buttonCreate, 5);
    }

    default void clickButtonBoards(){
        click(buttonBoards);
    }

    default String isTextInElementPresent_boardNameDisplay(){
        return isTextInElementPresent(boardNameDisplay);
    }
    default void clickButtonBoardWithTitle(String boardTitle){
        String xPathBoard = "//div[@title='"+boardTitle+"']";
        System.out.println(xPathBoard);
        click(By.xpath(xPathBoard));
    }

    default void deleteBoard(){  //!!!!!!!!
//        pause(3);
//        click(buttonDots);
        clickWait_elementLocated(buttonDots, 5);
        //pause(3);
        click(buttonCloseBoard);
        click(buttonClose);
        click(buttonPermanentlyDeleteBoard);
        click(buttonDelete);
    }



    default  boolean isElementPresent_buttonBoard(){
        return isElementPresent(buttonBoard);
    }

    default boolean isElementVisible_messageDeleteBoard(){
        return isElementVisible(messageDeleteBoard, 5);
    }

    default void clickButtonLogOut(){
        click(buttonLogOut);
    }

    default void clickButtonLogOutSubmit(){
        click(buttonLogOutSubmit);
    }

    default boolean isElementPresent_buttonLogOut(){
        return isElementPresent(buttonLogOut);
    }
}
