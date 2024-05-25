package rpg_lab;

import org.junit.Assert;
import org.junit.Test;

public class AxeTest {

    @Test
    public void weaponAttacksLosesDurability() {
        //Arrange
        Axe axe = new Axe(10, 10);
        Dummy dummy = new Dummy(10, 10);

        //Act
        axe.attack(dummy);

        //Assert
        Assert.assertEquals(9, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class) //Assert
    public void brokenWeaponCanAttack() {
        //Arrange
        Axe axe = new Axe(10, 1);
        Dummy dummy = new Dummy(20, 10);

        //Act
        axe.attack(dummy);
        axe.attack(dummy);
    }

    

}
