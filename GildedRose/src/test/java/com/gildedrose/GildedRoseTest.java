package com.gildedrose;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    
    @Test
    void sellInO(){
        Item[] items = new Item[] {new Item("i1", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
    }
    
    @Test
    void qualityO(){
        Item[] items = new Item[] {new Item("i1", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void sellInMinus1(){
        Item[] items = new Item[] {new Item("i2", 2, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
    }
    
    @Test
    void qualityMinus1(){
        Item[] items = new Item[] {new Item("i2", 2, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].quality);
    }
    
    @Test
    void qualitySellInAndPeremption(){
        Item[] items = new Item[] {new Item("i3", 0, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(8, app.items[0].quality);
    }
    
    @Test
    void agedBrieSellIn(){
        Item[] items = new Item[] {new Item("Aged Brie", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
    }
    
    @Test
    void agedBrieQuality(){
        Item[] items = new Item[] {new Item("Aged Brie", 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }
    
    @Test
    void agedBrieQualityMax(){
        Item[] items = new Item[] {new Item("Aged Brie", 10, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void agedBrieSellInNegative(){
        Item[] items = new Item[] {new Item("Aged Brie", -2, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    void sulfurasQuality(){
        Item[] items = new Item[] {new Item(SULFURAS_HAND_OF_RAGNAROS, 10, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }
    
    @Test
    void sulfurasSellIn(){
        Item[] items = new Item[] {new Item(SULFURAS_HAND_OF_RAGNAROS, 10, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(10, app.items[0].sellIn);
    }
    
    @Test
    void concertSellInHigh(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 30, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(11, app.items[0].quality);
    }
    
    @Test
    void concertSellInHighHigh(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 30, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void concertSellInMedium(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 9, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(12, app.items[0].quality);
    }
    
    @Test
    void concertSellInMediumHigh(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 9, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void concertSellInLow(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 3, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(13, app.items[0].quality);
    }
    
    @Test
    void concertSellInLowHigh(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", 3, 49)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void concertSellInExpired(){
        Item[] items = new Item[] {new Item("Backstage passes to a TAFKAL80ETC concert", -1, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
    
    @Test
    void sulfurasSellInNegative(){
        Item[] items = new Item[] {new Item(SULFURAS_HAND_OF_RAGNAROS, -1, 80)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }
    
    @Test
    void anotherTest(){
        Item[] items = new Item[] {new Item("Aged Brie", -1, 50)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }
    
    @Test
    void conjuredQuality(){
        Item[] items = new Item[] {new Item("Conjured", 3, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(8, app.items[0].quality);
    }
    
    @Test
    void conjuredQualitySellIn0(){
        Item[] items = new Item[] {new Item("Conjured", -2, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(6, app.items[0].quality);
    }
    
    @Test
    void sulfurasNot80(){
        Item[] items = new Item[] {new Item(SULFURAS_HAND_OF_RAGNAROS, 10, 10)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }
    

}
