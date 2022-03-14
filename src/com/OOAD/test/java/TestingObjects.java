//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//
package com.OOAD;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.EmptyStackException;
import java.util.Objects;
import java.util.Stack;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.extension.TestWatcher;
import org.junit.jupiter.api.Test;

@DisplayName("Objects")
class TestingObject {
    Music music;
    Wind wind;
    Stringed stringed;
    Players players;
    Instrument instrument;
    Clothing clothing;
    Accessories accessories;

    @DisplayName("Testing Object Instantiation and Inheritance")
    @BeforeEach
    public void setAllObjects()
    {
        music = new CD();
        stringed = new Guitar();
        wind = new Flute();
        clothing = new Hats();
        players = new MP3();
        accessories = new Cables();

    }

    @DisplayName("Testing Music Objects")
    @Test
    public void testMusicInstance() //1
    {
        Assertions.assertEquals(music.getClass(),Music.class);

        music = new Cassette();
    }

    @DisplayName("Testing Wind Objects")
    @Test
    public void testWindInstance() //2
    {
        Assertions.assertEquals(wind.getClass(),Wind.class);
    }

    @DisplayName("Testing Wind Objects")
    @Test
    public void testStringedInstance() //3
    {
        Assertions.assertEquals(stringed.getClass(),Stringed.class);
    }

    @DisplayName("Testing Wind Objects")
    @Test
    public void testClothingInstance() //4
    {
        Assertions.assertEquals(clothing.getClass(),Clothing.class);
    }

    @DisplayName("Testing Player Objects")
    @Test
    public void testPlayerInstance() //4
    {
        Assertions.assertEquals(players.getClass(),Players.class);
    }

    @DisplayName("Testing Wind Objects")
    @Test
    public void testHatInstance() //5
    {
        Assertions.assertEquals(clothing.getClass(),Hats.class);
    }

    @DisplayName("Testing Stringed Electric Variable")
    @Test
    public void testStringedElectricVar() //6
    {
        stringed.isElectric = false;
        Assertions.assertEquals(stringed.isElectric, true);

    }

    @DisplayName("Testing Stringed Tuned Variable")
    @Test
    public void testStringedTunedVar() //7
    {
        stringed.tuned = false;
        Assertions.assertEquals(stringed.tuned, false);

    }

    @DisplayName("Testing Stringed Electric Variable")
    @Test
    public void testWindAdjustedVariable() //8
    {
        wind.adjusted = false;
        Assertions.assertEquals(wind.adjusted, false);

    }

    @DisplayName("Testing Wind Tunable Variable")
    @Test
    public void testTunableVariable() //9
    {
        wind.tunable = true;
        Assertions.assertEquals(stringed.tunable, true);

    }

    @DisplayName("Testing ItemType Enum")
    @Test
    public void testItemType() //10
    {
        Assertions.assertEquals(clothing.itemType, ItemType.HATS);
        Assertions.assertEquals(music.itemType, ItemType.CD);
        Assertions.assertEquals(stringed.itemType, ItemType.GUITAR);
        Assertions.assertEquals(wind.itemType, ItemType.FLUTE);
        Assertions.assertNotEquals(clothing.itemType, ItemType.SHIRTS);

    }

    @DisplayName("Testing Clothing Enum")
    @Test
    public void test() //10
    {
        Assertions.assertEquals(clothing.itemType, ItemType.HATS);


    }
    @DisplayName("Testing Music Enum")
    public void testMusicEnum() //11
    {
        Assertions.assertEquals(music.itemType, ItemType.CD);
    }
    public void testStringedEnum() //12
    {
        Assertions.assertEquals(stringed.itemType, ItemType.GUITAR);
    }

    public void testWindEnum() //13
    {
        Assertions.assertEquals(wind.itemType, ItemType.FLUTE);
    }

    public void testClothingEnumFail() //14
    {
        Assertions.assertNotEquals(clothing.itemType, ItemType.SHIRTS);

    }

    public void testAccessoriesObjects() //15
    {
        Assertions.assertEquals(accessories.getClass(),Accessories.class);
    }

    public void testAccessoriesEnum() //16
    {
        Assertions.assertEquals(accessories.itemType,ItemType.CABLES);
    }


}
