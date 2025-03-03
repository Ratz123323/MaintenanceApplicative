package com.gildedrose;

class GildedRose {
    public static final String AGED_BRIE = "Aged Brie";
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void updateQuality() {
	    for (Item item : items) {
		    handleItem(item);
	    }
    }
    
    private void handleItem(Item item){
        String name = item.name;
        
        switch (name){
            case AGED_BRIE:
                updateAgedBrie(item);
                break;
            case SULFURAS_HAND_OF_RAGNAROS:
                updateSulfuras(item);
                break;
            case BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT:
                updateConcert(item);
                break;
            default:
                updateDefaultItem(item);
                break;
        }
    }
    
    private void updateAgedBrie(Item item){
        decrementItemSellIn(item);
        if(item.sellIn < 0){
            incrementItemQuality(item, 2);
        } else {
            incrementItemQuality(item, 1);
        }
    }
    
    private void updateSulfuras(Item item){
        // nothing to do
    }
    
    private void updateConcert(Item item){
        if(item.sellIn > 10){
            incrementItemQuality(item, 1);
        } else if(item.sellIn > 5){
            incrementItemQuality(item, 2);
        }else if(item.sellIn > 0){
            incrementItemQuality(item, 3);
        } else {
            item.quality = 0;
        }
        decrementItemSellIn(item);
    }
    
    private void updateDefaultItem(Item item){
        decrementItemSellIn(item);
        if(item.sellIn < 0){
            decrementItemQuality(item);
        }
        decrementItemQuality(item);
    }
    
    
    private void decrementItemQuality(Item item){
        if(item.quality <= 0){
            item.quality = 0;
        } else {
            item.quality -= 1;
        }
    }
    
    private void decrementItemSellIn(Item item){
        item.sellIn -= 1;
    }
    
    private void incrementItemQuality(Item item, int number){
        for(int i = 1; i <= number; i++){
            if(!(item.quality >= 50)){
                item.quality += 1;
            }
        }
    }
}
