package Tests.FinalProject;

import FinalProject.model.*;
import FinalProject.utils.Validator;
import Tests.AbstractTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;


public class GameTest extends AbstractTest {
    private static Game TEST_GAME;

    @BeforeEach
    public void setUpGame() {
        TEST_GAME = GameTestData.getTestGame();
        for (Player player : TEST_GAME.getPlayers()) {
            String input = "0,0;2,0;1,0;3,0\n9,1;9,2;9,3\n1,2;2,2;3,2\n0,8;0,9\n5,5;6,5\n5,8;6,8\n9,9\n0,5\n9,6\n7,0";
            setInput(input);
            TEST_GAME.initBattleField(player);
        }
    }


    @Test
    public void invalidArgumentsNumber() {
        BattleField battleField = TEST_GAME.getPlayers()[0].getBattleField();
        Assertions.assertThrows(InputMismatchException.class, () -> Validator.validateShipPlace(battleField, ShipType.BATTLESHIP, "fdsdfsd"));
    }

    @Test
    public void shipCountAfterStartingGame() {
        Assertions.assertEquals(10, TEST_GAME.getPlayers()[0].getAliveShipCount());
        Assertions.assertEquals(10, TEST_GAME.getPlayers()[1].getAliveShipCount());
    }

    @Test
    public void missAttack() {
        Assertions.assertEquals("Мимо!", TEST_GAME.getPlayers()[0].attacked(new Coordinate(1, 1, CoordinateState.AVAILABLE)));
        Assertions.assertEquals(10, TEST_GAME.getPlayers()[0].getAliveShipCount());
    }

    @Test
    public void successAttack() {
        Assertions.assertEquals("Попадание!", TEST_GAME.getPlayers()[0].attacked(new Coordinate(0, 0, CoordinateState.AVAILABLE)));
        Assertions.assertEquals(10, TEST_GAME.getPlayers()[0].getAliveShipCount());
        Assertions.assertEquals(TEST_GAME.getPlayers()[0].getBattleField().getSpecificCoordinate(0, 0).getCoordinateState(), CoordinateState.DESTROYED);
    }

    @Test
    public void mortalAttack() {
        Assertions.assertEquals("Утопил!", TEST_GAME.getPlayers()[0].attacked(new Coordinate(7, 0, CoordinateState.AVAILABLE)));
        Assertions.assertEquals(9, TEST_GAME.getPlayers()[0].getAliveShipCount());
        Assertions.assertEquals(TEST_GAME.getPlayers()[0].getBattleField().getSpecificCoordinate(7, 0).getCoordinateState(), CoordinateState.DESTROYED);
    }

}
