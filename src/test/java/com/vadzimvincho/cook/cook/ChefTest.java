package com.vadzimvincho.cook.cook;

import com.vadzimvincho.cook.model.salad.Salad;
import com.vadzimvincho.cook.model.vegetable.Cucumber;
import com.vadzimvincho.cook.model.vegetable.Pepper;
import com.vadzimvincho.cook.model.vegetable.Tomato;
import com.vadzimvincho.cook.model.vegetable.Vegetable;
import com.vadzimvincho.cook.vegetablestorage.VegetableStorage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ChefTest {
    @Mock
    VegetableStorage vegetableStorage;
    @InjectMocks
    Chef chef = new Chef(vegetableStorage);
    static Salad salad;
    static List<Vegetable> vegetableList;

    @BeforeAll
    static void setUp() {
        Tomato testTomato = new Tomato();
        testTomato.setName("tomato-apricot");
        testTomato.setCalories(80);
        testTomato.setWeight(100);
        Cucumber testCucumber = new Cucumber();
        testCucumber.setName("cucumber-blick");
        testCucumber.setCalories(120);
        testCucumber.setWeight(100);
        Pepper testPepper = new Pepper();
        testPepper.setName("pepper-aries");
        testPepper.setCalories(100);
        testPepper.setWeight(80);
        vegetableList = List.of(testTomato, testCucumber, testPepper);
        salad = new Salad("Test salad");
        salad.setVegetables(vegetableList);
    }

    @Test
    void getCalories() {
        assertEquals(280, chef.getCalories(salad));
    }

    @Test
    void getCaloriesNull() {
        assertThrows(NullPointerException.class, () -> chef.getCalories(null));
    }

    @Test
    void getSaladByRecipeTest() {
        Mockito.when(vegetableStorage.getVegetablesByRecipe(Recipe.LIGHT_SALAD))
                .thenReturn(vegetableList);
        Salad salad = chef.cookSaladFromMenu(Recipe.LIGHT_SALAD);
        assertEquals(salad.getVegetables().size(), 3);
        assertIterableEquals(vegetableList, salad.getVegetables());
        assertEquals("LIGHT_SALAD", salad.getName());
    }

    @Test
    void getSaladByChefTest() {
        Mockito.when(vegetableStorage.getVegetablesRandom(3))
                .thenReturn(vegetableList);
        Salad salad = chef.cookSaladByChef(3);
        assertEquals(salad.getVegetables().size(), 3);
        assertIterableEquals(vegetableList, salad.getVegetables());
        assertEquals("SALAD_BY_CHEF", salad.getName());
    }

    @Test
    void sortByNameTest() {
        List<Vegetable> sortedList = chef.sortByName(salad);
        assertEquals("cucumber-blick", sortedList.get(0).getName());
        assertEquals("pepper-aries", sortedList.get(1).getName());
        assertEquals("tomato-apricot", sortedList.get(2).getName());
    }

    @Test
    void sortByCaloriesTest() {
        List<Vegetable> sortedList = chef.sortByCalories(salad);
        assertEquals("tomato-apricot", sortedList.get(0).getName());
        assertEquals("pepper-aries", sortedList.get(1).getName());
        assertEquals("cucumber-blick", sortedList.get(2).getName());
    }

    @ParameterizedTest
    @CsvSource({
            "50,100",
            "100,120",
            "150,200"
    })
    void getVegetableByCaloriesTest(int minCalories, int maxCalories) {
        List<Vegetable> list = chef.getVegetableByCalories(salad, minCalories, maxCalories);
        for (Vegetable vegetable : list) {
            assertTrue(vegetable.getCalories() >= minCalories && vegetable.getCalories() <= maxCalories);
        }
    }
}